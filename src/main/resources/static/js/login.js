window.onload=function () {
    getClass("right")[0].onclick = function () {
        window.location.href='register.html';
    };
    getClass("left")[0].onclick = function () {
        window.location.href='login.html';
    };
    getClass("login-input")[0].onclick=function () {
        getClass("login-prompt")[0].innerText="";
    };


}

