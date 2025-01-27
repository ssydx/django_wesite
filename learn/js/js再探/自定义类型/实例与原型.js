// 创建新数据类型，构造函数本质是创造了新数据类型，就像Array一样的新对象类型
function Sup(instAttr2) {
    this.instAttr1 = ['instAttr1',];
    this.instAttr2 = instAttr2;
    this.instFunc1 = function() {
        return 'hello instFunc1';
    }
}
Sup.prototype.protoAttr1 = ['protoAttr1',];
Sup.prototype.protoAttr2 = 'protoAttr2';
Sup.prototype.protoFunc1 = function() {
    return 'hello protoFunc1';
}
const sup1 = new Sup('instAttr2');
console.log(sup1);
console.log(sup1.instAttr1);
console.log(sup1.instAttr2);
console.log(sup1.protoAttr1);
console.log(sup1.protoAttr2);
console.log('sup1的自有（实例）属性',Object.getOwnPropertyNames(sup1));
console.log('sup1的原型',Object.getPrototypeOf(sup1));
console.log('protoAttr1是否为自有（实例）属性：',sup1.hasOwnProperty('protoAttr1'));
for (const key in sup1) {
    if (!sup1.hasOwnProperty(key)) {
        console.log('sup1的原型属性',key);
    }
}
// 它并未修改原型属性，但会遮蔽同名原型属性，此后的访问将首先访问到该同名实例属性，除非获取原型后再访问，或是删除该属性
sup1.protoAttr1 = 'ssydx';
// 此处只能访问同名实例属性
console.log(sup1.protoAttr1);
// 实例只能通过getPrototypeOf获取原型，进而获取原型属性
console.log(Object.getPrototypeOf(sup1).protoAttr1);
// 构造函数则自带prototype属性指向原型，进而获取原型属性
console.log(Sup.prototype.protoAttr1);
// 删除同名实例属性后访问原属性
delete sup1.protoAttr1;
console.log(sup1.protoAttr1);

const sup2 = new Sup('instAttr2');
// 为什么实例属性会显示false，因为引用类型比较的是地址
console.log(sup2.instAttr1 === sup1.instAttr1);
// 为什么实例属性会显示true，因为基本类型比较的是值
console.log(sup2.instAttr2 === sup1.instAttr2);
console.log(sup2.instFunc1 === sup1.instFunc1);