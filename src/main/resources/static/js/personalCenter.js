window.onload=function () {
    var image = new Image();
    image.src = getClass("backGround-img")[0].src;
    image.onload = function () {
        var width = image.width;
        var height = image.height;
        if (width > height) {
            getClass("backGround-img")[0].style.width=100+"%";
            getClass("backGround-img")[0].style.marginTop=-15+"%";
        }else if(width < height){
            getClass("backGround-img")[0].style.marginLeft=-15+"%";
            getClass("backGround-img")[0].style.height=100+"%";
        }else{
            getClass("backGround-img")[0].style.width=100+"%";
            getClass("backGround-img")[0].style.height=100+"%";
        }
    };
    getClass("backFile")[0].onchange=function () {
        if (this.files) {
            //读取图片数据
            var f=this.files[0];
            var reader = new FileReader();
            reader.onload = function (e) {
                var data = e.target.result;
                getClass("backGround-img")[0].src =data;
                getClass("backFile")[0].value=data;
            };
            reader.readAsDataURL(f);
        }
    }
}