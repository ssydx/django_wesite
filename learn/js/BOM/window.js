console.log(this);
console.log(self);
console.log(window.innerHeight);
console.log(window.innerWidth);
console.log(window.outerHeight);
console.log(window.outerWidth);
// window.prompt('请输入：');
// window.confirm('一条提示');
console.log(document.querySelector('table').style.borderLeft);
console.log(getComputedStyle(document.querySelector('table')).borderLeft);
let starttime = Date.now();
console.log(starttime);
const oncetime = setTimeout(function() {
    let endtime = Date.now();
    console.log(endtime);
    console.log(endtime - starttime);
},1000);
const cycletime = setInterval(function () {
    console.log('hello');
}, 500);
console.log(oncetime);
console.log(cycletime);
setTimeout(() => {
    clearInterval(cycletime);
},3000);
