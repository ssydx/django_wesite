const evt1 = document.createEvent('Event');
console.log(evt1);
const evt2 = new Event('Event');
console.log(evt2);
const evt3 = new UIEvent('select');
console.log(evt3);
const evt4 = new MouseEvent('click');
console.log(evt4);
document.querySelector('#btn1').onmousedown = function(evt) {
    console.log(this);
    console.log(evt);
    console.log(evt.button);
    console.log(evt.target);
}
document.querySelector('#text1').oninput = function(evt) {
    console.log(this);
    console.log(evt);
    console.log(evt.data);
}