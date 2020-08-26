window.onload=function () {
    function up(obj){
        obj.style.display="block";
    }
    function down(obj){
        obj.style.display="none";
    }
    //成功弹窗
    function over(text) {
        var obj=getClass("common-over")[0];
        obj.innerHTML="<img src=\"../img/confirm.png\" alt=\"\">"+text;
        obj.style.display="block";
        setTimeout(function () {
            obj.style.display="none";
        },1000);
    }
    function success(obj,suc,err) {
        if(obj.innerHTML == ""){
        }else if(obj.innerText){
            over(suc);
            obj.innerHTML = "";
        }else{
            over(err);
            obj.innerHTML = "";
        }
    }
    var isInputs=getClass("isInput");
    success(isInputs[0],"删除成功","删除失败");
    //更多
    var addDropdown=getClass("add-dropdown")[0];
    getClass("add")[0].onmouseover=function(){
        up(addDropdown);
        addDropdown.onmouseover=function () {
            up(addDropdown);
            addDropdown.onmouseleave=function () {
                down(addDropdown);
            }
        };
        getClass("add")[0].onmouseleave=function(){
            down(addDropdown);
        }
    };

    //分页
    getClass("pagination-input")[0].onkeydown=function (event) {
        if(event.keyCode==13){
            getClass("pageForm")[0].submit();
        }
        this.onblur=function () {
            getClass("pageForm")[0].submit();
        }
    }
}