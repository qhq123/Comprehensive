function a2clean()
{
    $("#a2num").val('');
    $("#a2count").val('');
}
function a2buybook()
{
    var num = document.getElementById("a2num");
    var count = document.getElementById("a2count");
    if (num.value == "") {
        alert("请输入书号");
    } else if (count.value  == "") {
        alert("请输入数量");
    }
    else{
        var xhr = getXHR();
        //2.注册状态变化监听器
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4) {
                if (xhr.status == 200) {
                    var response = xhr.responseText;
                    var obj = eval('(' + response + ')');
                    var statu = obj[0].statu;
                    var tprice=obj[0].tprice;
                    var title=obj[0].title;
                    if(statu=="wn")
                    {
                        alert("不存在此书号！请重新输入");
                        $("#a2num").val('');
                    }
                    else if(statu=="wc1")
                    {
                        alert("数量输入不规范！请重新输入");
                        $("#a2count").val('');
                    }
                    else if(statu=="wc2")
                    {
                        alert("不允许输入非正数！");
                        $("#a2count").val('');
                    }
                    else if(statu=="t")
                    {
                        sessionStorage["successbooknum"]= num.value;
                        sessionStorage["successtitle"]=title;
                        sessionStorage["successbookcount"]=count.value;
                        sessionStorage["successtprice"]=tprice;
                        window.location.href = "a2success";
                    }
                }
            }
        }
    }
    //3.建立与服务器的连接
    xhr.open("POST", "DoOrderServlet", true);
    xhr.setRequestHeader("Content-Type", "application/json");
    var array = [{"booknum": num.value, "ordernum":sessionStorage['userid'],"count": count.value}];
    var data = JSON.stringify(array);
    xhr.send(data);
}