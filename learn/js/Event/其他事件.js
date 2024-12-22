document.querySelector('details').ontoggle = function(evt) {
    console.log(this);
    console.log(evt);
    console.log(evt.type);
}
