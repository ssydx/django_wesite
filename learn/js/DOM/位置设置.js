const tb = document.getElementById('tb1');
console.log(tb);
console.log(' ');

console.log(tb.clientTop);
console.log(tb.clientLeft);
console.log(tb.clientHeight);
console.log(tb.clientWidth);
console.log(' ');

console.log(tb.offsetTop);
console.log(tb.offsetLeft);
console.log(tb.offsetHeight);
console.log(tb.offsetWidth);
console.log(' ');

console.log(tb.scrollTop);
console.log(tb.scrollLeft);
console.log(tb.scrollHeight);
console.log(tb.scrollWidth);
console.log(' ');

console.log(tb.getBoundingClientRect());
console.log(tb.getBoundingClientRect().y);
console.log(tb.getBoundingClientRect().x);
console.log(tb.getBoundingClientRect().top);
console.log(tb.getBoundingClientRect().left);
console.log(tb.getBoundingClientRect().bottom);
console.log(tb.getBoundingClientRect().right);
console.log(tb.getBoundingClientRect().height);
console.log(tb.getBoundingClientRect().width);
console.log(' ');

console.log(tb.getClientRects());