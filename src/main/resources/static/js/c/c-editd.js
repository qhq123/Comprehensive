function edittdc1(result) {
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
    document.getElementById("c1table").innerHTML=html1;//动态写入html代码
}

function edittdc2(result)
{
    var obj = eval('(' + result + ')');
    var html1 ="<thead>\n" +
        "    <tr>\n" +
        "        <th>缺书单号</th>\n" +
        "        <th>书号</th>\n" +
        "        <th>缺书数量</th>\n" +
        "        <th>缺书状态</th>\n" +
        "    </tr>\n" +
        "    </thead>";
    for (i = 0; i < obj.length; i++) {
        var statu=obj[i].statu;
        if(statu==0)
        {
            var lackid=obj[i].lackid;
            var bookid=obj[i].bookid;
            var lackcount=obj[i].lackcount;
            var lidbid=lackid+'-'+bookid+'-'+lackcount;
            var stastr="";
            if(statu==0)stastr="                    <td><button type = \"button\" class=\"bttn-fill bttn-sm bttn-default\" " +
                "onClick=\"confirmlack('"+lidbid+"')\">确认处理</button></td>\n";
            else if(statu==1)stastr="<td style=\"color: #890b10\">未确认处理</button>";
            html1+= "<tr>\n" +
                "                    <td>"+lackid+"</td>\n" +
                "                    <td>"+bookid+"</td>\n" +
                "                    <td>"+lackcount+"</td>\n" +
                stastr +
                "                </tr>";
        }
    }
    document.getElementById("c2table").innerHTML=html1;//动态写入html代码
}

function edittdc3(result) {
    var obj = eval('(' + result + ')');
    var html1 ="<thead>\n" +
        "                <tr>\n" +
        "                    <th>进书编号</th>\n" +
        "                    <th>书号</th>\n" +
        "                    <th>采购人</th>\n" +
        "                    <th>采购日期</th>\n" +
        "                    <th>采购总数</th>\n" +
        "                    <th>采购总额</th>\n" +
        "                </tr>\n" +
        "                </thead>\n";
    for (i = 0; i < obj.length; i++) {
        var inid=obj[i].inid;
        var bookid=obj[i].bookid;
        var inerid=obj[i].inerid;
        var indate=obj[i].indate;
        var incount=obj[i].incount;
        var inprice=obj[i].inprice;
        html1+= "                <tr>\n" +
            "                    <td>"+inid+"</td>\n" +
            "                    <td>"+bookid+"</td>\n" +
            "                    <td>"+inerid+"</td>\n" +
            "                    <td>"+indate+"</td>\n" +
            "                    <td>"+incount+"</td>\n" +
            "                    <td>"+inprice+"</td>\n" +
            "                </tr>\n";

    }
    document.getElementById("c3table").innerHTML=html1;//动态写入html代码
}