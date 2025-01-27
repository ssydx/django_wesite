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
// 解决重复调用父对象构造函数的问题，即实例化父对象作为子对象原型时会调用一次父对象的构造器，尽管 父对象的实例属性方法被作为子类的原型属性方法的问题 会被盗用构造器屏蔽，但依然未根本解决问题
// 其次同时解决原型的constructor丢失问题，即重写子对象原型后原型的construtor不再存在
function inherit(sub,sup) {
    // 获取原型
    let prototype = Object.create(sup.prototype);
    // 设置原型的构造器
    prototype.constructor = sub;
    // 设置构造器的原型
    sub.prototype = prototype;
}
inherit(Sub,Sup);
Sub.prototype.protoAttr2 = ['protoAttr2',];
Sub.prototype.protoFunc2 = function() {
    return 'hello protoFunc2';
}
const sub1 = new Sub('instAttr_sup');
const sub2 = new Sub('instAttr_sub');
console.log(sub1);
console.log(sub2);
sub2.instAttr1.forEach(item => console.log(item));
sub1.instAttr1.push('js');
sub2.instAttr1.forEach(item => console.log(item));




