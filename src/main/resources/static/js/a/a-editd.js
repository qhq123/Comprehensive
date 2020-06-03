function edittda1(result) {
    var obj = eval('(' + result + ')');
    var numarray=["a0101","a0102","b0101","b0102","b0201","b0202","c0101","c0102","c0201","c0202","c0301","c0302","d0101","d0102","d0201","d0202",
        "d0301","d0302","e0101","e0102", "e0201","e0202","e0301","e0302","f0101","f0102","g0101","g0102","g0201","g0202","g0301","g0302", "h0101",
        "h0102","h0201","h0202","h0301","h0302","i0101","i0102","i0201","i0202","i0301","i0302", "j0101","j0102","j0201","j0202","j0301","j0302",
        "k0101","k0102","k0201","k0202","k0301","k0302","l0101","l0102","l0201","l0202","l0301","l0302"];
    for (i = 0; i < numarray.length; i++) {
        var num=numarray[i];
        //selectbook(num);
        var title=obj[i].title;
        var writer=obj[i].writer;
        var date=obj[i].date;
        var press=obj[i].press;
        var price=obj[i].price;
        var description=obj[i].description;
        var fun="tobuy('"+num+"')";
        html1 ="<tr>\n" +
            //"<tr>\n" +
            //"<td>\n" +
            //"<table border=\"0\" align=\"center\">\n" +
            "                                <td><img src=\"../images/book/"+num+".png\" height=\"210.5\" width=\"214.5\"></td>\n" +
            "                                <td valign=\"top\">\n" +
            "                                    <table border=\"0\" >\n" +
            "                                        <tr>\n" +
            "                                            <td width=\"250\" ><span style=\"color: blue; font-size:large;\">"+title+"</span></td>\n" +
            "                                        </tr>\n" +
            "                                        <tr valign=\"top\">\n" +
            "                                            <td ><span style=\"color: #dc143c; font-size: medium; \">单价"+price+"</span>\n" +
            "                                        </tr>\n" +
            "                                        <tr>\n" +
            "                                            <td ><span style=\"color: blue; \">"+writer+"</span><span style=\"color: #a9a9a9; \">/"+date+"/</span><span\n" +
            "                                                    style=\"color: blue; \">"+press+"</span></td>\n" +
            "                                        </tr>\n" +
            "                                        <tr>\n" +
            "                                            <td><span style=\"color: blue; \">图书编号："+num+"</span></td>\n" +
            "                                        </tr>\n" +
            "                                        <table border=\"0\" width=\"725\">\n" +
            "                                            <tr>\n" +
            "                                                <td>"+description+"</td>\n" +
            "                                            </tr>\n" +
            "                                        </table>\n" +
            "                                        <table border=\"0\">\n" +
            "                                            <tr>\n" +
            "                                                <!--<td bgcolor=\"#dc143c\" width=\"120\" align=\"center\"><font color=\"#f0ffff\">加入购物车</font></td>-->\n" +
            "                                                <td bgcolor=\"#dc143c\" align=\"center\" width=\"80\" height=\"30\"><a href=\"#\" onclick=\""+fun+"\">购买</a></td>\n" +
            "                                            </tr>\n" +
            "                                        </table>\n" +
            "                                    </table>\n" +
            "                                </td>\n" +
            "                            </tr>\n";
        //"</table>" +
        //"</td>" +
        //"</tr>\n" ;
        document.getElementById(num).innerHTML=html1;//动态写入html代码
    }

}

function tobuy(num) {
    $("#a2num").val(num);
    queryServer(1);
}

function edittda3(result)
{
    var obj = eval('(' + result + ')');
    html1 ="";
    for (i = 0; i < obj.length; i++) {
        var orderid=obj[i].orderid;
        var bookid=obj[i].bookid;
        var buydate=obj[i].buydate;
        var buyerid=obj[i].buyerid
        var count=obj[i].count;
        var tprice=obj[i].tprice;
        html1+="<div class=\"plan plan3\">\n" +
            "                <div class=\"header\">"+""+"</div>\n" +
            "                <ul>\n" +
            "                    <li><b>订购单号</b> "+orderid+"</li>\n"+
            "                    <li><b>书号</b> "+bookid+"</li>\n" +
            "                    <li><b>订购日期</b> "+buydate+"</li>\n" +
            "                    <li><b>订购者编号</b> "+buyerid+"</li>\n" +
            "                    <li><b>数量</b> "+count+"</li>\n" +
            "                    <li><b>总额</b> "+tprice+"</li>\n" +
            "                </ul>\n" +
            "            </div>";

    }
    if (html1=="")
        html1= "                <div>"+""+"</div>\n" +
            "                <ul>\n" +
            "                    <h2>暂无已订书单！</h2>\n"
    "                </ul>\n";
    document.getElementById("fdw-pricing-table1").innerHTML=html1;//动态写入html代码
}

function edittda4(result)
{
    var obj = eval('(' + result + ')');
    html1 ="";
    for (i = 0; i < obj.length; i++) {
        var statu=obj[i].statu;
        if(statu==0)
        {
            var takeid=obj[i].takeid;
            var buyerid=obj[i].buyerid;
            var takedate=obj[i].takedate;
            var buyid=obj[i].buyid;
            var buydate=obj[i].buydate;
            var sellerid=obj[i].sellerid;
            html1+="<div class=\"plan plan3\">\n" +
                "                <div class=\"header\">"+""+"</div>\n" +
                "                <ul>\n" +
                "                    <li><b>领书单号</b> "+takeid+"</li>\n"+
                "                    <li><b>订购者编号</b> "+buyerid+"</li>\n" +
                "                    <li><b>领书日期</b> "+takedate+"</li>\n" +
                "                    <li><b>购书单号</b> "+buyid+"</li>\n" +
                "                    <li><b>购书日期</b> "+buydate+"</li>\n" +
                "                    <li><b>经办人</b> "+sellerid+"</li>\n" +
                "                </ul>\n" +
                "            </div>";
        }

    }
    if (html1=="")
        html1= "                <div>"+""+"</div>\n" +
            "                <ul>\n" +
            "                    <h2>暂无未领书单！</h2>\n"
            "                </ul>\n";
    document.getElementById("fdw-pricing-table2").innerHTML=html1;//动态写入html代码
}