
let activeEffect;
// key => effectsSet
const keyEffectsMap = new Map();
const data = { text: 'hello world'};
function track(key) { 
    // 如果副作用函数不存在则直接返回
    if (!activeEffect) {
        return
    };
    // 获取当前属性的副作用函数集，不存在则新建
    let effectsSet = keyEffectsMap.get(key);
    if (!effectsSet) {
        keyEffectsMap.set(key, (effectsSet = new Set()))
    }
    // 将当前副作用函数添加到当前属性的副作用函数集
    effectsSet.add(activeEffect);
}
function trigger(key) {
    // 获取当前属性的副作用函数集，不存在则返回
    const effectsSet = keyEffectsMap.get(key);
    if (!effectsSet) {
        return
    }
    // 依次触发当前属性的每个副作用函数
    effectsSet.forEach(fn => fn());
}
const obj = new Proxy(data, {
    get(target, key) {
        track(key);
        return target[key];
    },
    set(target,key,newVal) {
        target[key] = newVal;
        trigger(key);
    }
})
function effect(fn) {
    activeEffect = fn;
    fn();
}
effect(() => {
    document.body.innerText = obj.text;
});
setTimeout(() => {
    obj.text = 'hello vue3';
},1000);