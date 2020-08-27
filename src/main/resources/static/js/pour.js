onload = function () {
    var wf = new WaterF();
    wf.init();
}
//想要改变窗口时实时刷新，可以写上下边的代码↓↓↓↓
// onresize = function(){
//     var wf = new WaterF();
//     wf.init();
// }
class WaterF {
    constructor() {
        this.clientW = document.documentElement.clientWidth;
        this.abox = document.querySelectorAll(".box");
        this.cont = document.querySelector(".cont");

    }

    init() {
        // 根据屏幕的宽度 / 任意一个结构的宽度，得到一行最大能放几个
        this.maxNum = parseInt(this.clientW / this.abox[0].offsetWidth);
        // 根据一行能放置的个数 * 任意一张图片的宽度，得到了大框的真正的宽
        this.cont.style.width = this.maxNum * this.abox[0].offsetWidth + "px";

        // 完善布局之后，开始区分第一行和后面的行
        this.firstLine();
        this.otherLine();
    }

    firstLine() {
        // 第一行，获取所有元素的高度放在一个数组中，准备获取最小值
        this.heightArr = [];
        for (var i = 0; i < this.maxNum; i++) {
            this.heightArr.push(this.abox[i].offsetHeight);
        }
    }

    otherLine() {
        // 需要拿到后面行的所有元素
        for (var i = this.maxNum; i < this.abox.length; i++) {
            // 在拿到后面行的元素的时候，获取第一个行的最小值和最小值所在的索引
            // var min = Math.min(...this.heightArr);
            var min = getMin(this.heightArr);
            var minIndex = this.heightArr.indexOf(min);
            // 设置定位
            this.abox[i].style.position = "absolute";
            // 根据最小值设置top
            this.abox[i].style.top = min + "px";
            // 根据最小值的索引设置left
            this.abox[i].style.left = minIndex * this.abox[0].offsetWidth + "px";
            // 修改最小值为，原来的数据+当前新放置元素的高度
            this.heightArr[minIndex] = this.heightArr[minIndex] + this.abox[i].offsetHeight;
            // 剩下的交给循环
        }
    }
}

function getMin(arr) {
    var myarr = [];
    for (var j = 0; j < arr.length; j++) {
        myarr.push(arr[j]);
    }
    return myarr.sort((a, b) => a - b)[0];
}
//无缝滚动
var oDiv = document.getElementById('ban');
var oUl = oDiv.getElementsByTagName('ul')[0];
var aLi = oUl.getElementsByTagName('li');

oUl.innerHTML = oUl.innerHTML + oUl.innerHTML;
oUl.style.width = aLi[0].offsetWidth * aLi.length + 'px';

function move() {
    if (oUl.offsetLeft < -oUl.offsetWidth / 2) {
        oUl.style.left = '0';
    }
    if (oUl.offsetLeft > 0) {
        oUl.style.left = -oUl.offsetLeft / 2 + 'px';
    }
    oUl.style.left = oUl.offsetLeft - 1 + 'px';
}

var timer = setInterval(move, 20);
oDiv.onmouseover = function () {
    clearInterval(timer);
};

oDiv.onmouseout = function () {
    timer = setInterval(move, 20);
};