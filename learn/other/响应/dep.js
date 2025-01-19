export default class Dep {
    constructor() {
        this.subs = [];
    }
    // 新增
    addSub(sub) {
        this.subs.push(sub);
    }
    // 删除
    removeSub(sub) {
        remove(this.subs.sub);
    }
    // 加入依赖追踪数组
    depend() {
        if (window.target) {
            this.addSub(window.target);
        }
    }
    // 通知每个依赖项
    notify() {
        const subs = this.subs.slice();
        for (let i=0,l=subs.length; i<l; i++) {
            subs[i].update();
        }
    }
}
function remove(arr,item) {
    if (arr.length) {
        const index = arr.indexOf(item);
        if (index > -1) {
            return arr.splice(index, 1);
        }
    }
}