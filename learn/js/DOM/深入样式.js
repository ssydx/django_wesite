const tb = document.getElementById('tb1');
console.log(tb.style);
console.log(tb.style.backgroundColor);
document.getElementById("searchbox1").style.caretColor = "red";
document.querySelector('.c').style.captionSide = "bottom";
document.querySelector('[href="cywl.png"]').style.cursor = "progress";
document.querySelector('img').style.cursor = "crosshair";
document.querySelector('img').style.filter = "grayscale(50%) contrast(50%) brightness(50%) blur(0.5px) hue-rotate(180deg) saturate(300%)";
tb.style.fontSize = '1.2rem';
console.log(tb.style.cssText);
console.log(tb.style[0]);
console.log(tb.style.item(0));
console.log(tb.style.length);



console.log(document.styleSheets);
