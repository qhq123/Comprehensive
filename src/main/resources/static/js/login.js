function login() {
    var username = document.getElementById("username");
    var pass = document.getElementById("password");
    if (username.value == "") {
        alert("请输入用户名");
    } else if (pass.value  == "") {
        alert("请输入密码");
    } else
    {
        var xhr=getXHR();
        //2.注册状态变化监听器
        xhr.onreadystatechange=function(){
            if(xhr.readyState==4)
            {
                if(xhr.status==200)
                {
                    var response=xhr.responseText;
                    var obj = eval('(' + response + ')');
                    var type = obj[0].type;
                    var userid = obj[0].userid;
                    if(type=="wp") {
                        alert("请输入正确密码！");
                        $("#password").val('');
                    }
                    else if(type=="wu") {
                        alert("用户名不存在！请重新输入");
                        $("#username").val('');
                        $("#password").val('');
                    }
                    else
                    {
                        sessionStorage['userid'] = userid;
                        alert("欢迎用户:"+sessionStorage['userid'])
                        if(type=="a")window.location.href="a";
                        if(type=="b")window.location.href="b";
                        if(type=="c")window.location.href="c";
                    }
                }
            }
        }
        //3.建立与服务器的连接
        xhr.open("POST","UserServlet",true);
        xhr.setRequestHeader("Content-Type", "application/json");
        var array = [{"userid":username.value,"pass":pass.value}];
        var data=JSON.stringify(array);
        xhr.send(data);
    }
}
