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
function Sub() {
    this.instAttr2 = ['instAttr2',];
    this.instFunc2 = function() {
        return 'hello instFunc2';
    }
}
// 先继承再设置原型属性方法
Sub.prototype = new Sup('instAttr_sup');
Sub.prototype.protoAttr2 = ['protoAttr2',];
Sub.prototype.protoFunc2 = function() {
    return 'hello protoFunc2';
}
const sub1 = new Sub();
const sub2 = new Sub();
console.log(sub1);
console.log(sub1.instAttr1);
// 由于继承了Sup的实例，所以实例属性方法被视为原型属性方法，因此此处虽然是父对象的实例属性，却是子对象的原型属性，修改会导致其他实例也同步修改
sub2.instAttr1.forEach(item => console.log(item));
sub1.instAttr1.push('js');
sub2.instAttr1.forEach(item => console.log(item));
// 另一问题是在实例化子类时只能对子类的构造函数传参，无法对父类的构造函数传参，父类的传参只能在Sub.prototype = new Sup();中进行，极大限制了继承的灵活性



