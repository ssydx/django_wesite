
// 本质是对原型链继承的包装，相当于Object.create(proto,props)无第二参数
function TempObj(o) {
    function F() {};
    F.prototype = o;
    return new F();
}
const obj = {
    name:'zhangsan',
    age:24,
}
const obj_sub = TempObj(obj);
console.log(obj_sub);
function Sup(instAttr) {
    this.instAttr1 = ['instAttr1',];
    this.instAttr_sup = instAttr;
    this.instFunc1 = function() {
        return 'hello instFunc1';
    }
}
Sup.prototype.protoAttr1 = ['protoAttr1',];
Sup.prototype.protoFunc1 = function() {
    return 'hello protoFunc1';
}
const Sub = TempObj(new Sup());
console.log(Sub);

function TempObj_con(o) {
    function F() {
        // 本质是Object.getPrototypeOf(o).constructor.call(this);
        o.constructor.call(this);
    };
    F.prototype = o;
    return new F();
}
console.log(TempObj_con(new Sup()));


console.log(Object.create(Object,{
    gender: {
        writable: true,
        configurable: true,
        value: "male",
        enumerable: true,
    },
}));
console.log(Object.create(new Object(),{
    gender: {
        writable: true,
        configurable: true,
        value: "male",
        enumerable: true,
    },
}));
console.log(Object.create(Object.prototype,{
    gender: {
        writable: true,
        configurable: true,
        value: "male",
        enumerable: true,
    },
}));
console.log(Object.create(obj,{
    gender: {
        writable: true,
        configurable: true,
        value: "male",
        enumerable: true,
    },
}));


