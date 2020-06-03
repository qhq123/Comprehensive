function affirm(oidbidcou)
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
