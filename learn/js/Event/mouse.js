document.querySelector('h1').onmousedown = function(evt) {
    console.log(this);
    console.log(evt);
    console.log(evt.type);
}
document.querySelector('h1').onmouseup = function(evt) {
    console.log(this);
    console.log(evt);
    console.log(evt.type);
}
document.querySelector('h1').onclick = function(evt) {
    console.log(this);
    console.log(evt);
    console.log(evt.type);
}
document.querySelector('h1').ondblclick = function(evt) {
    console.log(this);
    console.log(evt);
    console.log(evt.type);
}
document.querySelector('h1').oncontextmenu = function(evt) {
    console.log(this);
    console.log(evt);
    console.log(evt.type);
}
document.querySelector('.div1').onmouseenter = function(evt) {
    console.log(this);
    console.log(evt);
    console.log(evt.type);
}
document.querySelector('.div1').onmouseleave = function(evt) {
    console.log(this);
    console.log(evt);
    console.log(evt.type);
}

// document.querySelector('.div2').onmouseover = function(evt) {
//     console.log(this);
//     console.log(evt);
//     console.log(evt.type);
// }
// document.querySelector('.div2').onmouseout = function(evt) {
//     console.log(this);
//     console.log(evt);
//     console.log(evt.type);
// }

// document.querySelector('.div2').onmousemove = function(evt) {
//     console.log(this);
//     console.log(evt);
//     console.log(evt.type);
// }

