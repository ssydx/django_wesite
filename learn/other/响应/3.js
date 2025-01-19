// 抽象追踪和触发类
let activeEffect;
// 对象=》属性=》副作用
const bucket = new WeakMap();
const data = { text: 'hello world'};
function track(target, key) { 
    if (!activeEffect) {
        return
    };
    let depsMap = bucket.get(target);
    if (!depsMap) {
        bucket.set(target,depsMap = new Map())
    }
    let deps = depsMap.get(key);
    if (!deps) {
        depsMap.set(key, (deps = new Set()))
    }
    deps.add(activeEffect);
}
function trigger(target, key) {
    const depsMap = bucket.get(target);
    if (!depsMap) {
        return
    };
    const effects = depsMap.get(key);
    if (!effects) {
        return
    }
    effects.forEach(fn => fn());
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