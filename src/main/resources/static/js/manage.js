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
    success(isInputs[1],"添加成功","添加失败");
    success(isInputs[2],"修改成功","修改失败");
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
    //判断数据格式
    getClass("changeUploadTimes")[0].onchange=function () {
        if (isNaN(this.value)){
            getClass("change-uploadTimesPrompt")[0].innerText="数据类型错误！！！";
        }else{
            getClass("change-uploadTimesPrompt")[0].innerText="";
        }
    }
    getClass("changeUploadTimes")[0].onblur=function () {
        var data=getClass("change-uploadTimesPrompt")[0].innerText;
        var obj2=document.getElementById("submit");
        if(data!=""){
            obj2.setAttribute("disabled",true);
        }else{
            obj2.removeAttribute("disabled");
        }
    }
    //判断用户名是否存在
    function isConfirm(obj,obj1,obj2){
        obj.onblur=function () {
            ajax({
                url:"verification",
                type:"post",
                data:{userName:this.value},
                success:function (data) {
                    obj1.innerText=data;
                    if(data!="用户名可用" && data!=""){
                        obj2.setAttribute("disabled",true);
                    }else{
                        obj2.removeAttribute("disabled");
                    }
                },
                error:function (data) {
                    console.log(data);
                }
            })
        }
    }
    //编辑
    var alters=getClass("common")[0].getElementsByClassName("alter");
    for (let i = 0; i < alters.length; i++) {
        alters[i].onclick=function () {
            var alter=this.parentNode.parentNode;
            document.getElementsByName("id")[0].value=alter.getElementsByTagName("td")[0].innerText;
            var obj=getClass("change-common")[0];
            obj.style.display="block";
            getClass("change-confirmPrompt")[0].innerHTML="";
            getClass("change-uploadTimesPrompt")[0].innerHTML="";
            var content=alter.getElementsByTagName("td");
            var inputs=obj.getElementsByClassName("change-input");
            var sexs=document.getElementById("selectSex").getElementsByTagName("option");
            var i=0;
            for (let j = 0; j <= inputs.length; j++) {
                var val=(content[j+2].innerText)==null?null:content[j+2].innerText;
                if(j==1){
                    if(val=="男"){
                        sexs[0].selected="selected";
                    }else if(val=="女"){
                        sexs[1].selected="selected";
                    }else if(val=="保密"){
                        sexs[2].selected="selected";
                    }
                }else{
                    inputs[i].getElementsByTagName("input")[0].value=val;
                    i++;
                }
            }
            isConfirm(getClass("changeUser")[0],getClass("change-confirmPrompt")[0],document.getElementById("submit"));
        }
    }
    getClass("change-common-close")[0].onclick=function () {
        getClass("change-common")[0].style.display="none";
    }
    //增加
    getClass("common-add")[0].onclick=function () {
        getClass("add-common")[0].style.display="block";
        getClass("add-confirmPrompt")[0].innerText="";
        var inputs=getClass("add-common-msg")[0].getElementsByTagName("input");
        for (let i = 0; i < 3; i++) {
            inputs[i].value="";
        }
        isConfirm(getClass("addUser")[0],getClass("add-confirmPrompt")[0],document.getElementById("addSubmit"));
    }
    getClass("add-common-close")[0].onclick=function () {
        getClass("add-common")[0].style.display="none";
    }
    //分页
    getClass("pagination-input")[0].onkeydown=function (event) {
        if (event.keyCode == 13) {
            getClass("pageForm")[0].submit();
        }
        this.onblur = function () {
            getClass("pageForm")[0].submit();
        }
    }
}
