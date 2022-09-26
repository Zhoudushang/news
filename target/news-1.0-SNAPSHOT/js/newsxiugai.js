window.onload=function (){
    let zt = document.getElementById("zt");
    let jd = document.getElementById("jd");
    let span = zt.getElementsByTagName("span");
    let removeOn = function(){
        for(let i=0; i <= span.length-1 ; i++){
            span[i].className = "";  // 去掉 class
        }
    };
    for( let  i = 0 ; i <= span.length-1 ; i+=1){
        span[i].addEventListener("click",function(){
            // 去掉所有 span 的 class
            removeOn();
            // 找当前标题，更改它的颜色
            jd.style.marginTop =-500*(i)+"px";
            this.className = "on";
            console.info(i);
        });
    }
}
