// window.onload=function () {
//     function checkUname() {
//         let result = true;
//         let uname = document.getElementById("uname");
//         if (uname.length > 6) {
//             document.getElementById("unameTip").classList.remove("hidden");
//             result = false;
//         }
//         return result;
//     }
//
//     function chekPass() {
//         let result = true;
//         let pass = document.getElementById("pass");
//         if (pass.length < 3 || repass.length < 3) {
//             document.getElementById("passTip").classList.remove("hidden");
//             result = false;
//         }
//         return result;
//     }
//
//     function chekrePass() {
//         let result = true;
//         let pass = document.getElementById("pass");
//         let repass = document.getElementById("repass");
//         if (pass != repass) {
//             document.getElementById("passTip").classList.remove("hidden");
//             document.getElementById("repassTip").classList.remove("hidden");
//             result = false;
//         }
//         return result;
//     }
//
//     function doSubmit() {
//         if (checkUname() && chekPass() && chekrePass()) {
//             document.getElementById("myform").submit
//         }
//     }
//
//     let dianji = document.getElementById("myform");
//     dianji.addEventListener("click", function () {
//         doSubmit();
//     })
//
// }