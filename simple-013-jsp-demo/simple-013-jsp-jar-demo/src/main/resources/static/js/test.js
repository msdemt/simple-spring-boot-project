function alertAjaxTest (method, url) {
    // 1. 创建 XMLHttpRequest 对象
    let xmlHttp;
    if (window.XMLHttpRequest) {
        xmlHttp = new XMLHttpRequest();
    } else {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    console.log(xmlHttp);
    // 2. 发送 ajax 请求
    xmlHttp.open(method, url, true);
    xmlHttp.send();
    // 3. 处理服务器响应
    xmlHttp.onreadystatechange = function () {
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
            let t = xmlHttp.responseText;
            alert(t);
        }
    }
}