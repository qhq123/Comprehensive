function doin() {
    var xhr=getXHR();
    var bookid=document.getElementById("c3num");
    var count=document.getElementById("c3count");
    //2.注册状态变化监听器
    if (bookid.value == "") {
        alert("请输入书号");
    } else if (count.value  == "") {
        alert("请输入数量");
    }
    else
    {
        xhr.onreadystatechange=function(){
            if(xhr.readyState==4)
            {
                if(xhr.status==200)
                {
                    var response=xhr.responseText;
                    var obj = eval('(' + response + ')');
                    var statu = obj[0].statu;
                    if(statu=="wn")
                    {
                        alert("不存在此书号！请重新输入");
                        $("#c3num").val('');
                    }
                    else if(statu=="wc1")
                    {
                        alert("数量输入不规范！请重新输入");
                        $("#c3count").val('');
                    }
                    else if(statu=="wc2")
                    {
                        alert("不允许输入非正数！");
                        $("#c3count").val('');
                    }
                    else if(statu=="t")
                    {
                        alert("书号"+bookid.value+"已生成进书单")
                        refreshc3();
                    }
                }
            }
        }
    }
    //3.建立与服务器的连接
    xhr.open("POST","DoInServlet",true);
    xhr.setRequestHeader("Content-Type", "application/json");
    var array = [{"bookid":bookid.value,"count":count.value,"inerid":sessionStorage['userid']}];
    var data=JSON.stringify(array);
    xhr.send(data);
}
function confirmlack(lidbid)
{
    var xhr=getXHR();
    //2.注册状态变化监听器
    var lb = lidbid.split("-");
    var lackid=lb[0];
    var bookid=lb[1];
    var lackcount=lb[2];
    xhr.onreadystatechange=function(){
        if(xhr.readyState==4)
        {
            if(xhr.status==200)
            {
                var response=xhr.responseText;
                var obj = eval('(' + response + ')');
                var statu = obj[0].statu;
                if(statu=="ok")
                {
                    alert("缺书单"+lackid+"已确认领书")
                    refreshc2();
                }
            }
        }
    }
    //3.建立与服务器的连接
    xhr.open("POST","ConfirmLackServlet",true);
    xhr.setRequestHeader("Content-Type", "application/json");
    var array = [{"lackid":lackid,"bookid":bookid,"lackcount":lackcount}];
    var data=JSON.stringify(array);
    xhr.send(data);
}