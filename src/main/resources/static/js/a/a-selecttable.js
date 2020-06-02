function getXHR(){
    var xmlHttp;
    try {
        xmlHttp=new XMLHttpRequest();
    }catch(e)
    {
        try{
            xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
        }
        catch(e)
        {
            try{
                xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
            }
            catch(e)
            {
                alert("你的浏览器不支持ajax");
                return false;
            }

        }

    }
    return xmlHttp;
}
function selectbooktable() {
    var xhr=getXHR();
    //2.注册状态变化监听器
    xhr.onreadystatechange=function(){
        if(xhr.readyState==4)
        {
            if(xhr.status==200)
            {
                var result=xhr.responseText;
                edittda1(result);
            }
        }
    }
    //3.建立与服务器的连接
    xhr.open("POST","BookTableServlet",true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send();
}

function selectordertable() {
    var xhr=getXHR();
    //2.注册状态变化监听器
    xhr.onreadystatechange=function(){
        if(xhr.readyState==4)
        {
            if(xhr.status==200)
            {
                var result=xhr.responseText;
                edittda3(result);
            }
        }
    }
    //3.建立与服务器的连接
    xhr.open("POST","OrderTableServlet",true);
    xhr.setRequestHeader("Content-Type", "application/json");
    var array = [{"userid":sessionStorage["userid"]}];
    var data=JSON.stringify(array);
    xhr.send(data);
}

function selecttaketable() {
    var xhr=getXHR();
    //2.注册状态变化监听器
    xhr.onreadystatechange=function(){
        if(xhr.readyState==4)
        {
            if(xhr.status==200)
            {
                var result=xhr.responseText;
                edittda4(result);
            }
        }
    }
    //3.建立与服务器的连接
    xhr.open("POST","TakeTableServlet",true);
    xhr.setRequestHeader("Content-Type", "application/json");
    var array = [{"userid":sessionStorage["userid"]}];
    var data=JSON.stringify(array);
    xhr.send(data);
}