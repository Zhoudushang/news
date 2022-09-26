window.onload=function (){
    // 找标签
    let fistUl = document.getElementById('fistUl');
    let myLi = fistUl.children ;  // 获取子标签。是一个数组~！
    let enter = function () {
        let _this = this;    // 储存当前标签
        let  ul = _this.getElementsByTagName("ul")[0];  // 找子标签
        if( !ul ){   // 如果 ul 不存在
            return null ;  // 终止函数运行
        }
        // 显示标签
        ul.className = "subNav show";
    };
    let leave = function (){
        let _this = this;    // 储存当前标签
        let  ul = _this.getElementsByTagName("ul")[0];  // 找子标签
        if( !ul ){   // 如果 ul 不存在
            return null ;  // 终止函数运行
        }
        // 隐藏标签
        ul.className = "subNav";
    };
    console.info( myLi );
    // 利用循环，给每个子标签 li 添加事件
    for(let i=0 ; i <= myLi.length-1 ; i++){
        myLi[i].addEventListener("mouseenter", enter );
        myLi[i].addEventListener("mouseleave", leave);
    };
}
