document.querySelector('button').onfocus = function(evt) {
    console.log(this);
    console.log(evt);
    console.log(evt.type);
}
document.querySelector('button').onblur = function(evt) {
    console.log(this);
    console.log(evt);
    console.log(evt.type);
}