 window.onload = function(){

     //滚动置顶
     var naver = document.getElementById('naver');
	 var stick = document.getElementById('stick');
	 window.onscroll = function () {  //鼠标滚动事件
	     //被卷去的距离大于200显示小火箭，否则隐藏
	     //2.显示隐藏小火箭
	     if(scroll().top>200){
	        naver.style.display = "block";
			 
	     }else{
	      naver.style.display = "none";
	     }
	     //每次移动滚动条的时候都给leader赋值，模拟leader获取距离顶部的距离
	     leader = scroll().top;
	 }
	 //3.缓动跳转到页面最顶端（利用我们的缓动动画）
	 var timer1 = null;
	 var target1 = 0; //目标位置
	 var leader = 0; //移动元素当前的位置
	stick.onclick = function () {
	     //技术点：window.scrollTo(0,0);
	     //要用定时器，先清定时器
	     clearInterval(timer1);
	     timer1 = setInterval(function () {
	         //获取步长
	         var step = (target1-leader)/10;
	         //二次处理步长
	         step = step>0?Math.ceil(step):Math.floor(step);
	         leader = leader +step;
	         //屏幕(页面)滚动
	         window.scrollTo(0,leader);  //屏幕(页面)滚动到某个位置
	         //清除定时器
	         if(leader === 0){
	             clearInterval(timer1);
	         }
	     },25);
	 }
	         //第一个轮播图        
            // 获取节点，变量声明
            var banner      = document.querySelector('.banner'),
                btn_left    = document.querySelector('.btn_left'),
                btn_right   = document.querySelector('.btn_right'),
                track       = document.querySelector('.track'),
                list_items  = banner.querySelectorAll('div'),
                listArr     = [],
                index       = 0,
                trackHtml   = '',
                tracks,
                timer;
            // 初始化
            function init(){
                // 根据图片高度自适应
                banner.style.height = list_items[0].offsetHeight + 'px';
                // 生成track坐标点元素
                for(var i = 0, len = list_items.length; i < len; i ++){
                    listArr.push(list_items[i].className)
                    trackHtml += '<span></span>'
                }
                track.innerHTML = trackHtml;
                // 获取坐标点元素
                tracks = track.querySelectorAll('span');
                tracks[0].setAttribute('class', 'focus');
                play();
            }
            // 切换动画 target=1 下一张 target=-1 上一张
            function move(target){
                list_items.forEach((item, i) => {
                    item.setAttribute('class', listArr[i])
                });
                // 计算index下标值
                index = (index + listArr.length + target) % listArr.length;
                tracks.forEach((item, i) => {
                    item.setAttribute('class', '')
                });
                tracks[index].setAttribute('class', 'focus')
            }
            // 下一张
            function next(){
                listArr.unshift(listArr[listArr.length - 1]);
			   listArr.pop();
                move(1)
            }
            // 上一张
            function previous(){
                listArr.push(listArr[0]);
			   listArr.shift();
              	move(-1)
            }
            // 自动轮播
            function play(){
            	timer = setInterval(next, 4000);
            }
            // 下一张绑定点击事件
            btn_right.onclick = function(){
                clearInterval(timer);
                next();
                play();
            };
            // 上一张绑定点击事件
            btn_left.onclick = function(){
                clearInterval(timer);
                previous();
                play();
            };
            // track绑定点击事件
           track.addEventListener('mousemove', function(e){
                var e = e || window.e,
                    //标准浏览器用ev.target，IE浏览器用event.srcElement
                    target = e.target || e.srcElement,
                    n = 0;
                if(target.className !== 'track'){
                    clearInterval(timer);
                    for(var i = 0, len = tracks.length; i < len; i ++){
                        tracks[i].setAttribute('class', '')
                        if(tracks[i] === target){
                            n = i;
                            tracks[i].setAttribute('class', 'focus');
                        }
                    }
                    // 向右滑动
                    if(n-index >= 0){
                        for(var i = 0; i < n-index; i ++){
                            setTimeout(next, 160*i);
                        }
                    }
                    // 向左滑动
                    else{
                        for(var i = 0; i < index-n; i ++){
                            setTimeout(previous, 160*i);
                        }
                    }
                    play();
                }
            })
            init();
	//第二个轮播图		
			var oD = document.getElementById('contain');
			var aBtn = oD.getElementsByTagName('li');
			var aDiv =document.getElementsByClassName('magic');
			for (var i = 0; i < aBtn.length; i++) {
				aBtn[i].index = i;
				aBtn[i].onclick = function() {
					//this当前发生事件的元素
					//alert(this.value);
					for (var i = 0; i < aBtn.length; i++) {
						aBtn[i].className = '';
						aDiv[i].style.display = 'none';
					}
					this.className = 'active';
					//alert(this.index);
					aDiv[this.index].style.display = 'block';
				};
			}
        }
		//封装兼容的scrollTop(获取滚动卷起的高度)
		function scroll(){  
		    return {  
		        "top": window.pageYOffset || document.body.scrollTop || document.documentElement.scrollTop,  
		        "left": window.pageXOffset || document.body.scrollLeft || document.documentElement.scrollLeft  
		    }  
		}
 $(function () {
     //滚动条未开始滚动时首先调用一下来判断当前是否有图片映入眼帘
     startLoad();
     $(window).scroll(function () {
         //滚动条滚动后触发事件
         startLoad();
     });

     function startLoad() {
         $("img").not('[data-isLoaded]').each(function () {
             //每一个没有加载过的<img>标签执行该函数
             var $item = $(this);
             if (isLoad($item)) {
                 LoadImg($item);
             }
             ;
         });
     };

     function isLoad(item) {//判断图片是否到达可视区域
         var top = $(window).scrollTop() + $(window).innerHeight();
         return item.offset().top <= top;
     }

     function LoadImg(item) {
         //延迟1s加载图片，该延迟是否设置取决于你
         setTimeout(function () {
             //替换src的属性值加载图片
             item.attr("src", item.attr("data-src"));
             //标记图片是否被加载，防止重复加载图片
             item.attr("data-isLoaded", 1);
         }, 1000);
     };
 });
