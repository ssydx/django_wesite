class Sup {
    constructor() {
        // 实例属性
        this.instAttr1 = ['instAttr1',]
        // 实例方法
        this.instFunc1 = function() {
            return 'instFunc1';
        }
    }
    // 实例属性，无法自行初始化
    instAttr2 = 'instAttr2';
    // 静态属性
    static clsAttr1 = ['clsAttr1'];
    // 实例方法，不推荐
    instFunc2 = function() {
        return 'instFunc2';
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
Sup.clsAttr2 = 'clsAttr2';
// 静态方法
Sup.clsFunc2 = function() {
    return 'clsFunc2';
}
// 原型属性，只能采用这种方式定义
Sup.prototype.protoAttr1 = ['protoAttr1'];
Sup.prototype.protoAttr2 = 'protoAttr2';
// 原型方法
Sup.prototype.protoFunc2 = function() {
    return 'protoFunc2';
}
const sup1 = new Sup();
console.log(sup1);