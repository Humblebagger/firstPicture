window.onload=function () {
    getClass("personal-text")[0].onblur=function () {
        ajax({
            url:"verification",
            type:"post",
            data:{userName:this.value},
            success:function (data) {
                getClass("changeUser")[0].innerText=data;
            },
            error:function (data) {
                console.log(data);
            }
        })
    }

    var list1 = new Array("北京市","天津市","河北省","山西省","内蒙古","辽宁省","吉林省","黑龙江省","上海市","江苏省","浙江省","安徽省","福建省","江西省","山东省","河南省","湖北省","湖南省","广东省","广西自治区","海南省","重庆市","四川省","贵州省","云南省","西藏自治区","陕西省","甘肃省","青海省","宁夏回族自治区","新疆维吾尔自治区","香港特别行政区","澳门特别行政区","台湾省","其它");
    var list2 = new Array;
    list2[list2.length] = new Array("北京", "东城区", "西城区", "崇文区", "宣武区", "朝阳区", "丰台区", "石景山区", " 海淀区（中关村）", "门头沟区", "房山区", "通州区", "顺义区", "昌平区", "大兴区", "怀柔区", "平谷区", "密云县", "延庆县", " 其他");
    list2[list2.length] = new Array("和平区", "河东区", "河西区", "南开区", "红桥区", "塘沽区", "汉沽区", "大港区","西青区", "津南区", "武清区", "蓟县", "宁河县", "静海县", "其他");
    list2[list2.length] = new Array("石家庄市", "张家口市", "承德市", "秦皇岛市", "唐山市", "廊坊市", "衡水市","沧州市", "邢台市", "邯郸市", "保定市", "其他");
    list2[list2.length] = new Array("太原市", "朔州市", "大同市", "长治市", "晋城市", "忻州市", "晋中市", "临汾市","吕梁市", "运城市", "其他");
    list2[list2.length] = new Array("呼和浩特市", "包头市", "赤峰市", "呼伦贝尔市", "鄂尔多斯市", "乌兰察布市","巴彦淖尔市", "兴安盟", "阿拉善盟", "锡林郭勒盟", "其他");
    list2[list2.length] = new Array("沈阳市", "朝阳市", "阜新市", "铁岭市", "抚顺市", "丹东市", "本溪市", "辽阳市","鞍山市", "大连市", "营口市", "盘锦市", "锦州市", "葫芦岛市", "其他");
    list2[list2.length] = new Array("长春市", "白城市", "吉林市", "四平市", "辽源市", "通化市", "白山市", "延边朝鲜族自治州", "其他");
    list2[list2.length] = new Array("哈尔滨市", "七台河市", "黑河市", "大庆市", "齐齐哈尔市", "伊春市", "佳木斯市","双鸭山市", "鸡西市", "大兴安岭地区(加格达奇)", "牡丹江", "鹤岗市", "绥化市　", "其他");
    list2[list2.length] = new Array("黄浦区", "卢湾区", "徐汇区", "长宁区", "静安区", "普陀区", "闸北区", "虹口区","杨浦区", "闵行区", "宝山区", "嘉定区", "浦东新区", "金山区", "松江区", "青浦区", "南汇区", "奉贤区", "崇明县", "其他");
    list2[list2.length] = new Array("南京市", "徐州市", "连云港市", "宿迁市", "淮安市", "盐城市", "扬州市", "泰州市","南通市", "镇江市", "常州市", "无锡市", "苏州市", "其他");
    list2[list2.length] = new Array("杭州市", "湖州市", "嘉兴市", "舟山市", "宁波市", "绍兴市", "衢州市", "金华市","台州市", "温州市", "丽水市", "其他");
    list2[list2.length] = new Array("合肥市", "宿州市", "淮北市", "亳州市", "阜阳市", "蚌埠市", "淮南市", "滁州市","马鞍山市", "芜湖市", "铜陵市", "安庆市", "黄山市", "六安市", "巢湖市", "池州市", "宣城市", "其他");
    list2[list2.length] = new Array("福州市", "南平市", "莆田市", "三明市", "泉州市", "厦门市", "漳州市", "龙岩市", "宁德市", "其他");
    list2[list2.length] = new Array("南昌市", "九江市", "景德镇市", "鹰潭市", "新余市", "萍乡市", "赣州市", "上饶市","抚州市", "宜春市", "吉安市", "其他");
    list2[list2.length] = new Array("济南市", "聊城市", "德州市", "东营市", "淄博市", "潍坊市", "烟台市", "威海市","青岛市", "日照市", "临沂市", "枣庄市", "济宁市", "泰安市", "莱芜市", "滨州市", "菏泽市", "其他");
    list2[list2.length] = new Array("郑州市", "三门峡市", "洛阳市", "焦作市", "新乡市", "鹤壁市", "安阳市", "濮阳市","开封市", "商丘市", "许昌市", "漯河市", "平顶山市", "南阳市", "信阳市", "周口市", "驻马店市", "其他");
    list2[list2.length] = new Array("武汉市", "十堰市", "襄樊市", "荆门市", "孝感市", "黄冈市", "鄂州市", "黄石市","咸宁市", "荆州市", "宜昌市", "随州市", "恩施土家族苗族自治州", "仙桃市", "天门市", "潜江市", "神农架林区", "其他");
    list2[list2.length] = new Array("长沙市", "张家界市", "常德市", "益阳市", "岳阳市", "株洲市", "湘潭市", "衡阳市","郴州市", "永州市", "邵阳市", "怀化市", "娄底市", "湘西土家族苗族自治州", "其他");
    list2[list2.length] = new Array("广州市", "清远市市", "韶关市", "河源市", "梅州市", "潮州市", "汕头市", "揭阳市","汕尾市", " 惠州市", "东莞市", "深圳市", "珠海市", "中山市", "江门市", "佛山市", "肇庆市", "云浮市","阳江市", "茂名市", "湛江市", " 其他");
    list2[list2.length] = new Array("南宁市", "桂林市", "柳州市", "梧州市", "贵港市", "玉林市", "钦州市", "北海市","防城港市", "崇左市", "百色市", "河池市", "来宾市", "贺州市", "其他");
    list2[list2.length] = new Array("海口市", "三亚市", "其他");
    list2[list2.length] = new Array("渝中区", "大渡口区", "江北区", "沙坪坝区", "九龙坡区", "南岸区", "北碚区","万盛区", "双桥区", "渝北区", "巴南区", "万州区", "涪陵区", "黔江区", "长寿区", "合川市", "永川市","江津市", "南川市", "綦江县", "潼南县", "铜梁县", "大足县", "璧山县", "垫江县", "武隆县", "丰都县","城口县", "开县", "巫溪县", "巫山县", "奉节县", "云阳县", "忠县", "石柱土家族自治县", "彭水苗族土家族自治县","酉阳土家族苗族自治县", "秀山土家族苗族自治县", "其他");
    list2[list2.length] = new Array("成都市", "广元市", "绵阳市", "德阳市", "南充市", "广安市", "遂宁市","内江市", "乐山市", "自贡市", "泸州市", "宜宾市", "攀枝花市", "巴中市", "资阳市", "眉山市", "雅安","阿坝藏族羌族自治州", "甘孜藏族自治州", "凉山彝族自治州县", "其他");
    list2[list2.length] = new Array("贵阳市", "六盘水市", "遵义市", "安顺市", "毕节地区", "铜仁地区","黔东南苗族侗族自治州", "黔南布依族苗族自治州", "黔西南布依族苗族自治州", "其他");
    list2[list2.length] = new Array("昆明市", "曲靖市", "玉溪市", "保山市", "昭通市", "丽江市", "普洱市","临沧市", "宁德市", "德宏傣族景颇族自治州", "怒江傈僳族自治州", "楚雄彝族自治州", "红河哈尼族彝族自治州","文山壮族苗族自治州", "大理白族自治州", "迪庆藏族自治州", "西双版纳傣族自治州", "其他");
    list2[list2.length] = new Array("拉萨市", "那曲地区", "昌都地区", "林芝地区", "山南地区", "日喀则地区", "阿里地区", "其他");
    list2[list2.length] = new Array("西安市", "延安市", "铜川市", "渭南市", "咸阳市", "宝鸡市", "汉中市", "安康市", "商洛市", "其他");
    list2[list2.length] = new Array("兰州市 ", "嘉峪关市", "金昌市", "白银市", "天水市", "武威市", "酒泉市","张掖市", "庆阳市", "平凉市", "定西市", "陇南市", "临夏回族自治州", "甘南藏族自治州", "其他");
    list2[list2.length] = new Array("西宁市", "海东地区", "海北藏族自治州", "黄南藏族自治州", "玉树藏族自治州","海南藏族自治州", "果洛藏族自治州", "海西蒙古族藏族自治州", "其他");
    list2[list2.length] = new Array("银川市", "石嘴山市", "吴忠市", "固原市", "中卫市", "其他");
    list2[list2.length] = new Array("乌鲁木齐市", "克拉玛依市", "喀什地区", "阿克苏地区", "和田地区", "吐鲁番地区","哈密地区", "塔城地区", "阿勒泰地区", "克孜勒苏柯尔克孜自治州", "博尔塔拉蒙古自治州","昌吉回族自治州伊犁哈萨克自治州", "巴音郭楞蒙古自治州", "河子市", "阿拉尔市", "五家渠市", "图木舒克市", "其他");
    list2[list2.length] = new Array("香港", "其他");
    list2[list2.length] = new Array("澳门", "其他");
    list2[list2.length] = new Array("台湾", "其他");
    list2[list2.length] = new Array( "其他");

    var ddlProvince = document.getElementById("province");
    var ddlCity = document.getElementById("city");
    for(var i =0;i<list1.length; i++) {
        var option = document.createElement("option");
        option.appendChild(document.createTextNode(list1[i]));
        option.value = list1[i];
        ddlProvince.appendChild(option);
        var selectedProvince=getClass("select-province")[0].getElementsByTagName("option")[0].value;
        selectprovince(indexof(list1, selectedProvince));
    }
    function indexof(obj,value) {
        var k=0;
        for(;k<obj.length;k++)
        {
            if(obj[k] == value)
                return k;
        }
        return k;
    }
    function selectprovince(index) {
        if(index!=-1){
            ddlCity.options.length = 0;//clear
            var list2element = list2[index];
            for(var i =0;i<list2element.length; i++){
                var option = document.createElement("option");
                option.appendChild(document.createTextNode(list2element[i]));
                option.value = list2element[i];
                ddlCity.appendChild(option);
            }
        }
    }
    getClass("select-province")[0].onchange=function () {
        selectprovince(indexof(list1,this.value));
    };
    var sexs=getClass("personal-sex");
    for (let i = 0; i <sexs.length ; i++) {
        sexs[i].onclick=function () {
            for (let j = 0; j < sexs.length; j++) {
                sexs[j].checked=false;
            }
            this.checked=true;
        }
    }
    if(getClass("personalSex")[0].innerText=="男"){
        sexs[1].checked=true;
    }else if(getClass("personalSex")[0].innerText=="女"){
        sexs[2].checked=true;
    }else{
        sexs[0].checked=true;
    }

    // 获取所需要操作的对象
    var Box=getClass("headPicture")[0];
    var floatBox = getClass("selectBox")[0];
    var bigBox=getClass("bigPicture-back")[0];
    var bigImage = bigBox.getElementsByTagName("img")[0];
    //获取上传文件的信息
    var files=getClass("file");
    for (let i = 0; i < files.length; i++) {
        files[i].onchange=function() {
            getClass("personalHead")[0].style.display="block";
            if(this.files) {
                //读取图片数据
                var f = this.files[0];
                var reader = new FileReader();
                reader.onload = function (e) {
                    var data = e.target.result;
                    //加载图片获取图片真实宽度和高度
                    var image = new Image();
                    image.src = data;
                    image.onload = function () {
                        var width = image.width;
                        var height = image.height;
                        getClass("showPic")[0].style.width="auto";
                        bigImage.style.width="auto";
                        getClass("showPic")[0].style.height="auto";
                        bigImage.style.height="auto";
                        getClass("headPicture")[0].style.lineHeight=0;
                        if (width > height) {
                            getClass("showPic")[0].style.width=100+"%";
                            bigImage.style.width=100+"%";
                            getClass("headPicture")[0].style.lineHeight=270+"px";
                        }else if(width < height){
                            getClass("showPic")[0].style.height=100+"%";
                            bigImage.style.height=100+"%";
                        }else{
                            getClass("showPic")[0].style.width=100+"%";
                            bigImage.style.width=100+"%";
                            getClass("showPic")[0].style.height=100+"%";
                            bigImage.style.height=100+"%";
                        }
                        getImage(data);
                    };
                    getClass("showPic")[0].src = data;
                    bigImage.src = data;
                };
                reader.readAsDataURL(f);
            }
        }
    }
    var clone=[{x:33,y:30},{xx:183,yy:180}];
    // 鼠标在对象上移动触发的事件
    floatBox.onmousedown = function(e){
        var event = e || window.event;
        var left = event.clientX - floatBox.offsetLeft;
        var top = event.clientY - floatBox.offsetTop;
        floatBox.onmousemove=function (event) {
            event=event||window.event;
            //获取元素移动后的位置
            var x=event.clientX-left;
            var y=event.clientY-top;
            // 计算可移动位置的大小， 保证元素不会超过可移动范围
            // 此处就是父元素的宽度减去子元素宽度
            var width = Box.clientWidth - floatBox.offsetWidth;
            var height = Box.clientHeight - floatBox.offsetHeight;
            // min方法保证不会超过右边界，max保证不会超过左边界
            x = Math.min(Math.max(0, x), width);
            y = Math.min(Math.max(0, y), height);
            //给元素及时定位
            floatBox.style.left=x+"px";
            floatBox.style.top=y+"px";
            bigBox.style.marginLeft=-x+"px";
            bigBox.style.marginTop=-y+"px";
            clone = [{x:x,y:y-28},{xx:x+150,yy:y+122}];//x y为要裁剪的左上角的坐标，xx yy为右下角的坐标
            drawRect();
        };
        floatBox.onmouseup=function(){
            floatBox.onmousemove=null;
            floatBox.onmouseup=null;
        };
    }
    var canvas = document.createElement("canvas");// 创建canvas对象
    var ctx = canvas.getContext('2d');
    var later = document.querySelector(".later");
    // 创建图片
    var getImage = function(b64){
        // 创建图片对象
        var image = new Image();
        image.src = `${b64}`;
        image.onload = function(){
            // 获取原图宽高
            var height =getClass("showPic")[0].offsetHeight;
            var width =getClass("showPic")[0].offsetWidth;
            //设置canvas大小与原图宽高一致
            canvas.height = 270;
            canvas.width = 220;
            // 在canvas绘制图片
            ctx.drawImage(this,0, 0,width,height);
            // 截图：
            drawRect();
        }
    };

    // 绘制截图矩阵
    var drawRect = function (){
        // 截图宽度
        var w = clone[1].xx - clone[0].x;
        // 截图高度
        var h = clone[1].yy - clone[0].y;
        // 获取截图区域内容,截图区域的像素点矩阵
        var cutImage = ctx.getImageData(clone[0].x,clone[0].y,w,h);
        // 裁剪后的base64数据
        var newImage = createNewCanvas(cutImage,w,h);
        later.src = newImage;
        // console.log(details_img);// 裁剪后的base64数据
    };
    //创建新的空白canvas画布将矩阵渲染截图
    var createNewCanvas = function (content,width,height){
        var nCanvas = document.createElement('canvas');
        var nCtx = nCanvas.getContext('2d');
        nCanvas.width = width;
        nCanvas.height = height;
        nCtx.putImageData(content,0,0);// 将画布上指定矩形的像素数据，通过 putImageData() 方法将图像数据放回画布
        return nCanvas.toDataURL('image/png');
    }
    getClass("personalHead-save")[0].onclick=function () {
        ajax({
            url:"upload",
            type:"post",
            data:{name:later.src},
            success:function (data) {
                if(data!=null){
                    getClass("headPhoto")[0].src="http://qdma85cm1.bkt.clouddn.com/"+data;
                }
            },
            error:function (data) {
                console.log(data);
            }
        })
        getClass("personalHead-close")[0].click();

    }
    getClass("personalHead-close")[0].onclick=function () {
        getClass("personalHead")[0].style.display="none";
    }
}