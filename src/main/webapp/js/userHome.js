window.onload=function (){
    //找标签
    let one = document.getElementById("one");
    let span = one.getElementsByTagName("span");
    let san = document.getElementById("san");
    let removeOn = function(){
        for(let i=0; i <= span.length-1 ; i++){
            span[i].className = "";  // 去掉 class
        }
    };
// 2、添加事件
    for( let  i = 0 ; i <= span.length-1 ; i+=1){
        span[i].addEventListener("click",function(){
            // 去掉所有 span 的 class
            removeOn();
            // 找当前标题，更改它的颜色
            san.style.marginTop =-300*(i)+"px";
            this.className = "on";
            console.info(i);
        });
    }


}
//找标签
