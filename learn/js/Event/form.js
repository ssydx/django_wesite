document.querySelector('form').onreset = function(evt) {
    console.log(this);
    console.log(evt);
    console.log(evt.type);
}
document.querySelector('form').onsubmit = function(evt) {
    console.log(this);
    console.log(evt);
    console.log(evt.type);
}
document.querySelector('[type="search"]').onsearch = function(evt) {
    console.log(this);
    console.log(evt);
    console.log(evt.type);
}
document.querySelector('textarea').oninput = function(evt) {
    console.log(this);
    console.log(evt);
    console.log(evt.type);
}
document.querySelector('[type="text"]').onselect = function(evt) {
    console.log(this);
    console.log(evt);
    console.log(evt.type);
}