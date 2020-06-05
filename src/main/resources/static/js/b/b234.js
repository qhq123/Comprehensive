function dotake(oidbidcou)
{
    var date = new Date();
    var month=date.getMonth()+1;
    if(month<10)month='0'+month;
    var day=date.getDay();
    if(day<10)day='0'+day;
    var obc = oidbidcou.split("-");
    var word = prompt("请输入领书日期（格式yyyyMMdd）",date.getFullYear()+month+day);
    if (word) {
        if(word==undefined)
            alert("请输入领书日期！")
        else
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
                        var statu = obj[0].statu;
                        if(statu=="wd")alert("日期格式不正确！示例：20000101");
                        else if(statu=="lack")alert("库存不足无法领书！请生成缺书单通知采购人员");
                        else if(statu=="ok")
                        {
                            alert("订单"+obc[0]+"已生成领书单！");
                            refreshb2();
                        }
                    }
                }
            }
            //3.建立与服务器的连接
            xhr.open("POST","DoTakeServlet",true);
            xhr.setRequestHeader("Content-Type", "application/json");
            var array = [{"orderid":obc[0],"sellerid":sessionStorage['userid'],"takedate":word,"bookid":obc[1],"count":obc[2]}];
            var data=JSON.stringify(array);
            xhr.send(data);
        }
    } else {

    }
}

function dolack() {
    var xhr=getXHR();
    var bookid=document.getElementById("b3num");
    var count=document.getElementById("b3count");
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
                        alert("书号"+bookid.value+"已生成缺书单")
                        refreshb3();
                    }
                }
            }
        }
    }
    //3.建立与服务器的连接
    xhr.open("POST","DoLackServlet",true);
    xhr.setRequestHeader("Content-Type", "application/json");
    var array = [{"bookid":bookid.value,"count":count.value}];
    var data=JSON.stringify(array);
    xhr.send(data);
}
function confirmtake(tidbid)
{
    var xhr=getXHR();
    //2.注册状态变化监听器
    var tb = tidbid.split("-");
    var takeid=tb[0];
    var buyid=tb[1];
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
                    alert("领书单"+takeid+"已确认领书")
                    refreshb4();
                }
            }
        }
    }
    //3.建立与服务器的连接
    xhr.open("POST","ConfirmTakeServlet",true);
    xhr.setRequestHeader("Content-Type", "application/json");
    var array = [{"buyid":buyid}];
    var data=JSON.stringify(array);
    xhr.send(data);
}