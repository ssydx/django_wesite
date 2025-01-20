// 实现基本的响应
// 使用集合以便自动去重，副作用集合
const bucket = new Set();
// 源对象
const data = { text: 'hello world'};
// 代理对象
const obj = new Proxy(data, {
    // 拦截访问
    get(target, key) {
        // 追踪副作用函数，此处副作用函数被固定
        bucket.add(effect);
        return target[key];
    },
    // 拦截设置
    set(target,key,newVal) {
        target[key] = newVal
        // 设置后触发每一个副作用函数
        bucket.forEach(fn => fn());
        return true;
    }
})
function effect() {
    document.body.innerText = obj.text;
}
effect();
setTimeout(() => {
    obj.text = 'hello vue3';
},1000);

// 只能响应一个指定的副作用函数