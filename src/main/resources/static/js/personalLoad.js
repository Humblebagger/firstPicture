window.onload = function() {
    /*
        分析 :
            1.获取itemBox的宽度
            2.获取item的宽度
            3.求出列数   itemBox的宽度 / item的宽度
            4.求出间距   (总宽度 - 元素个数* 元素宽度) /  (列数 - 1)
            5.实现瀑布流布局
            6.滚动页面时 加载数据
    */
    // 0.获取元素
    var itemBox = document.getElementsByClassName('showDownload')[0];
    var items = document.getElementsByClassName('item');
    if(items.length!=0){
        // 1.获取itemBox的宽度
        var itemBoxWidth = itemBox.offsetWidth-25;
        // 2.获取item的宽度
        var itemWidth = items[0].offsetWidth;
        // 写一段  调试一段
        // 3.求出列数   itemBox的宽度 / item的宽度
        var column = parseInt(itemBoxWidth / itemWidth);
        // 4.求出间距   (总宽度 - 元素个数* 元素宽度) /  (列数 - 1)
        var distance = (itemBoxWidth - column * itemWidth) / (column - 1);
        // 5.实现瀑布流布局   预编译
        // 5.1 定义一个数组 存放每列高度
        var arr = [];
        waterFull();
        function waterFull() {
            //遍历item数组  给每一个元素指定位置  使其实现瀑布流布局
            for (var i = 0; i < items.length; i++) {
                if (i < column) {
                    //强调  强调  强调  属性值必须是字符串
                    // 第一行的left = (元素宽度 + 间距) * （列数 - 1)
                    items[i].style.left = (itemWidth + distance) * i + 'px';
                    arr[i] = items[i].offsetHeight;
                } else {
                    //找到最小高度的列以及他的索引  对象封装多个属性
                    var minH = getMin(arr).minH;
                    var minI = getMin(arr).minI;
                    //最小高度列 的left = (元素宽度 + 间距） * 索引
                    items[i].style.left = (itemWidth + distance) * minI + 'px';
                    //top = minH + 间距
                    items[i].style.top = minH + distance + 'px';
                    //更新 列的高度  = 原来的高度 + 新元素的高度 + 间距
                    arr[minI] = minH + distance + items[i].offsetHeight;
                }
            }
        }

        // 获取最小列的索引和高度  代码不规范 亲人泪两行
        function getMin(arr) {
            var obj = {};  //花括号 表示对象   obj {minH: 20, minI:2}
            obj.minH = arr[0]; // 对象.属性名 = 属性值   最小高度
            obj.minI = 0;
            for (var i = 1; i < arr.length; i++) {  //循环从第二个开始
                if (obj.minH > arr[i]) {
                    obj.minH = arr[i];
                    obj.minI = i;
                }
            }
            return obj;
        }
    }

}