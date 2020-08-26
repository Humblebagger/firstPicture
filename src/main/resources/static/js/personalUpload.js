window.onload=function () {
    document.getElementById("uploadFile").onchange=function () {
        if(this.files) {
            //读取图片数据
            var f = this.files[0];
            var reader = new FileReader();
            reader.onload = function (e) {
                var obj = e.target.result;
                ajax({
                    url:"uploadPicture",
                    type:"post",
                    data:{name:obj},
                    success:function (data) {
                        var obj=getClass("common-over")[0];
                        obj.innerHTML="<img src=\"../img/confirm.png\" alt=\"\">"+"上传成功";
                        obj.style.display="block";
                        setTimeout(function () {
                            obj.style.display="none";
                        },1000);
                    },
                    error:function (data) {
                        console.log(data);
                    }
                })
            };
            reader.readAsDataURL(f);
        }
    }
}