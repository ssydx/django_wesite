// 抽象追踪和触发类
let activeEffect;
// obj => keys => effectsSet
const objKeysEffectsMap = new WeakMap();
const data = { text: 'hello world'};
function track(target, key) { 
    if (!activeEffect) {
        return
    };
    // 获取对象对应的属性
    let keyEffectsMap = objKeysEffectsMap.get(target);
    if (!keyEffectsMap) {
        objKeysEffectsMap.set(target,keyEffectsMap = new Map())
    }
    // 获取属性对应的副作用集
    let effectsSet = keyEffectsMap.get(key);
    if (!effectsSet) {
        keyEffectsMap.set(key, (effectsSet = new Set()))
    }
    // 添加副作用函数
    effectsSet.add(activeEffect);
}
function trigger(target, key) {
    // 获取对象对应的属性
    const keyEffectsMap = objKeysEffectsMap.get(target);
    if (!keyEffectsMap) {
        return
    };
    // 获取属性对应的副作用集
    const effectsSet = keyEffectsMap.get(key);
    if (!effectsSet) {
        return
    }
    // 依次触发副作用
    effectsSet.forEach(fn => fn());
}
const obj = new Proxy(data, {
    get(target, key) {
        track(target, key);
        return target[key];
    },
    set(target,key,newVal) {
        target[key] = newVal;
        trigger(target, key);
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