window.onload=function(){
    var userName=localStorage.getItem("userName");
    getClass("forget-userName")[0].value=userName;
    ajax({
            url:"queryProblemPassword",
            type:"post",
            data:{userName:userName},
            success:function (data) {
            getClass("forget-problem")[0].value=data;
        },
            error:function (data) {
            console.log(data);
        }
    })
    localStorage.removeItem("userName");
    getClass("forget-userName")[0].onblur=function () {
        ajax({
            url:"queryProblem",
            type:"post",
            data:{userName:this.value},
            success:function (data) {
                getClass("forget-problem")[0].value=data;
            },
            error:function (data) {
                console.log(data);
            }
        })
    }
}