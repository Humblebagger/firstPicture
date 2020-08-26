function getClass(obj)      {
    return document.getElementsByClassName(obj);
}
function ajax(option){
    option=option||{};
    option.type=(option.type||'GET').toUpperCase();
    option.dataType=option.dataType||'json';
    var params=formateParams(option.data);
    var xmlhttp;
    //创建异步对象
    if(window.XMLHttpRequest){
        xmlhttp=new XMLHttpRequest();
    }else{
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    //设置请求方式和请求地址
    if (option.type == 'GET'){
        xmlhttp.open('GET',option.url+"?"+params,true);
        xmlhttp.send();
    }else if(option.type == 'POST'){
        xmlhttp.open('POST',option.url,true);
        xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xmlhttp.send(params);
    }
    //监听状态变化
    xmlhttp.onreadystatechange=function () {
        if(xmlhttp.readyState == 4){
            if(xmlhttp.status >= 200 && xmlhttp.status <=300 || xmlhttp.status == 304){
                option.success && option.success(xmlhttp.responseText,xmlhttp.responseXML);
            }else{
                option.error && option.error(xmlhttp.status);
            }
        }
    }
}
function formateParams(data) {
    data = data || {}; // 如果没有传参, 为了添加随机因子,必须自己创建一个对象
    var res = [];
    for(var key in data){
        // 在URL中是不可以出现中文的, 如果出现了中文需要转码
        // 可以调用encodeURIComponent方法
        // URL中只可以出现字母/数字/下划线/ASCII码
        res.push(encodeURIComponent(key)+"="+encodeURIComponent(data[key])); // [userName=lnj, userPwd=123456];
    }
    return res.join("&"); // userName=lnj&userPwd=123456
}

