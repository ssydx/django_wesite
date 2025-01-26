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
// 保留了继承关系，虽然父对象的实例属性方法被继承为原型属性方法，但会被Sub盗用的构造函数屏蔽
Sub.prototype = new Sup();
Sub.prototype.protoAttr2 = ['protoAttr2',];
Sub.prototype.protoFunc2 = function() {
    return 'hello protoFunc2';
}
const sub1 = new Sub('instAttr_sup');
const sub2 = new Sub('instAttr_sub');
console.log(sub1);
console.log(sub2);
sub2.instAttr1.forEach(item => console.log(item));
// 修改的是盗用的实例属性instAttr1，原型上的同名属性已被屏蔽
sub1.instAttr1.push('js');
sub2.instAttr1.forEach(item => console.log(item));




