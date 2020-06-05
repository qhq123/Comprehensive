function edittdb1(result) {
    var obj = eval('(' + result + ')');
    var html1 ="<thead>\n" +
        "                <tr>\n" +
        "                    <th>书号</th>\n" +
        "                    <th>书名</th>\n" +
        "                    <th>库存</th>\n" +
        "                </tr>\n" +
        "                </thead>\n";
    for (i = 0; i < obj.length; i++) {
        var booknum=obj[i].booknum;
        var title=obj[i].title;
        var count=obj[i].count;
        html1+= "                <tr>\n" +
            "                    <td>"+booknum+"</td>\n" +
            "                    <td>"+title+"</td>\n" +
            "                    <td>"+count+"</td>\n" +
            "                </tr>\n";

    }
    document.getElementById("b1table").innerHTML=html1;//动态写入html代码
}

function edittdb2(result) {
    var obj = eval('(' + result + ')');
    var html1 ="<thead>\n" +
        "    <tr>\n" +
        "        <th>购书单号</th>\n" +
        "        <th>书号</th>\n" +
        "        <th>购书日期</th>\n" +
        "        <th>订购者编号</th>\n" +
        "        <th>数量</th>\n" +
        "        <th>总额</th>\n" +
        "        <th>订单状态</th>\n" +
        "    </tr>\n" +
        "    </thead>";
    for (i = 0; i < obj.length; i++) {
        var statu=obj[i].statu;
        if(statu==0||statu==1)
        {
            var orderid=obj[i].orderid;
            var bookid=obj[i].bookid;
            var buydate=obj[i].buydate;
            var buyerid=obj[i].buyerid;
            var count=obj[i].count;
            var tprice=obj[i].tprice;
            var stastr="";
            var oidbidcou=orderid+'-'+bookid+'-'+count;
            if(statu==0)stastr="                    <td><button type = \"button\" class=\"bttn-fill bttn-sm bttn-default\" " +
                "onClick=\"dotake('"+oidbidcou+"')\">未处理</button></td>\n";
            else if(statu==1)stastr="<td style=\"color: #890b10\">未确认领书</button>";
                html1+= "<tr>\n" +
                    "                    <td>"+orderid+"</td>\n" +
                    "                    <td>"+bookid+"</td>\n" +
                    "                    <td>"+buydate+"</td>\n" +
                    "                    <td>"+buyerid+"</td>\n" +
                    "                    <td>"+count+"</td>\n" +
                    "                    <td>"+tprice+"</td>\n" +
                    stastr +
                    "                </tr>";
        }
    }
    document.getElementById("b2table").innerHTML=html1;//动态写入html代码
}

function edittdb3(result)
{
    var obj = eval('(' + result + ')');
    var html1 ="<thead>\n" +
        "                <tr>\n" +
        "                    <th>缺书单号</th>\n" +
        "                    <th>书号</th>\n" +
        "                    <th>缺书数量</th>\n" +
        "                </tr>\n" +
        "                </thead>\n";
    for (i = 0; i < obj.length; i++) {
        var Lackid=obj[i].lackid;
        var bookid=obj[i].bookid;
        var lackcount=obj[i].lackcount;
        var statu=obj[i].statu;
        if(statu==1)html1+="";
        else if(statu==0)
            html1+= "                <tr>\n" +
            "                    <td>"+Lackid+"</td>\n" +
            "                    <td>"+bookid+"</td>\n" +
            "                    <td>"+lackcount+"</td>\n" +
            "                </tr>\n";

    }
    document.getElementById("b3table").innerHTML=html1;//动态写入html代码
}

function edittdb4(result)
{
    var obj = eval('(' + result + ')');
    var html1 ="<thead>\n" +
        "    <tr>\n" +
        "        <th>领书单号</th>\n" +
        "        <th>订购者编号</th>\n" +
        "        <th>领书日期</th>\n" +
        "        <th>购书单号</th>\n" +
        "        <th>购书日期</th>\n" +
        "        <th>经办人</th>\n" +
        "        <th>领书状态</th>\n" +
        "    </tr>\n" +
        "    </thead>";
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
            var tidbid=takeid+'-'+buyid;
            var stastr="";
            if(statu==0)stastr="                    <td><button type = \"button\" class=\"bttn-fill bttn-sm bttn-default\" " +
                "onClick=\"confirmtake('"+tidbid+"')\">确认领书</button></td>\n";
            else if(statu==1)stastr="<td style=\"color: #890b10\">未确认领书</button>";
            html1+= "<tr>\n" +
                "                    <td>"+takeid+"</td>\n" +
                "                    <td>"+buyerid+"</td>\n" +
                "                    <td>"+takedate+"</td>\n" +
                "                    <td>"+buyid+"</td>\n" +
                "                    <td>"+buydate+"</td>\n" +
                "                    <td>"+sellerid+"</td>\n" +
                stastr +
                "                </tr>";
        }
    }
    document.getElementById("b4table").innerHTML=html1;//动态写入html代码
}