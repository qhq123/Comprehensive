function re1()
{
    window.location.href = "a";
}

function queryServer(i) {
    var divShow = $(".content").children('.list');
    //索引对应的div块显示
    $(".nav li").eq(i).addClass('selected').siblings('li').removeClass('selected');
    $(divShow[i]).show();
    //索引对应的div块的同胞隐藏
    $(divShow[i]).siblings('.list').hide();
}
$().ready(function () {
    $("#successbooknum").text(sessionStorage["successbooknum"]);
    $("#successtitle").text(sessionStorage["successtitle"]);
    $("#successbookcount").text("数量："+sessionStorage["successbookcount"]);
    $("#successtprice").text("总额："+sessionStorage["successtprice"]);
})
