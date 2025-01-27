class Sup {
    constructor(instAttr1) {
        // 实例属性
        this.instAttr1 = [instAttr1,]
        // 实例方法
        this.instFunc1 = function() {
            return 'instFunc1';
        }
    }
    // 原型方法
    protoFunc1() {
        return 'protoFunc1';
    }
    // 静态方法
    static clsFunc1() {
        return 'clsFunc1';
    }
}
// 静态属性
Sup.clsAttr1 = ['clsAttr1'];
// 原型属性
Sup.prototype.protoAttr1 = ['protoAttr1'];
const sup1 = new Sup('instAttr1');
console.log(sup1);

class Sub extends Sup {
    constructor(instAttr2,instAttr1) {
        // 调用父类构造函数
        super(instAttr1);
        this.instAttr2 = [instAttr2,];
        this.instFunc2 = function() {
            return 'instFunc2';
        }
    }
    // 原型方法
    protoFunc2() {
        return 'protoFunc2';
    }
    // 静态方法
    static clsFunc2() {
        const fun = super.clsFunc1();
        return fun + 'clsFunc2';
    }
}
Sub.clsAttr2 = ['clsAttr2'];
Sub.prototype.protoAttr2 = ['protoAttr2'];
const sub1 = new Sub('instAttr2','instAttr1');
console.log(sub1);