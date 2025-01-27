// 父对象
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
// 子对象
function Sub(instAttr_sup) {
    // 调用父类的构造函数，实现了对父构造函数的传参，同时避免了将父对象的实例属性方法转为子对象的原型属性方法
    Sup.call(this,instAttr_sup);
    this.instAttr2 = ['instAttr2',];
    this.instFunc2 = function() {
        return 'hello instFunc2';
    }
}
Sub.prototype.protoAttr2 = ['protoAttr2',];
Sub.prototype.protoFunc2 = function() {
    return 'hello protoFunc2';
}
const sub1 = new Sub('instAttr_sup');
console.log(sub1);
// 问题在于丢失了继承关系，即无法继承父类的原型属性方法





