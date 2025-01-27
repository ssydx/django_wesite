

function TempObj(o) {
    function F() {};
    F.prototype = o;
    return new F();
}
function create(origin) {
    let clone = TempObj(origin);
    clone.func = function() {
        console.log('hello');
    }
    return clone;
}
const obj = {
    name:'zhangsan',
    age:24,
}

create(obj).func();

