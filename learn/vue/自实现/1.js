const data = { name:'ssydx',gender:'male',age:25 };
let activeEffect;
const objsKeysEffects = new WeakMap();
function track(target, key) {
    console.log('开始追踪');
    if (!activeEffect) {
        console.log('当前访问属性的不是副作用函数');
        return;
    }
    let keysEffects = objsKeysEffects.get(target);
    if (!keysEffects) {
        console.log('新建对象',target,'的属性副作用函数字典');
        objsKeysEffects.set(target, (keysEffects = new Map()));
    }
    let effects = keysEffects.get(key);
    if (!effects) {
        console.log('新建对象',target,'的',key,'属性的副作用函数集合');
        keysEffects.set(key, (effects = new Set()));
    }
    console.log('将',activeEffect,'加入副作用函数集合');
    effects.add(activeEffect);
    console.log('将',target,'对象的',key,'属性的',effects,'副作用函数集合加入',activeEffect,'副作用函数集合之数组');
    activeEffect.deps.push(effects);
    console.log('追踪结束');
};
function trigger(target, key) {
    console.log('开始触发');
    const keysEffects = objsKeysEffects.get(target);
    if (!keysEffects) {
        return;
    }
    const effects = keysEffects.get(key);
    if (!effects) {
        return;
    }
    effects.forEach(fn => fn());
    console.log('触发结束');
};



const obj = new Proxy(data,{
    get(target, key) {
        track(target, key);
        return target[key];
    },
    set(target, key, newValue) {
        target[key] = newValue;
        trigger(target, key);
        return true;
    },
})


function cleanUp(effectFn) {
    console.log('遍历当前副作用函数的副作用函数集合之数组',effectFn.deps,'，从每个副作用函数集合中删除当前副作用函数');
    for (let i=1; i<effectFn.deps.length; i++) {
        effectFn.deps[i].delete(effectFn);
    }
    console.log('将当前副作用函数的副作用函数集合之数组清空');
    effectFn.deps.length = 0;
}

function effect(fn, options={}) {
    const effectFn = () => {
        cleanUp(effectFn);
        activeEffect = effectFn;
        fn();
    }
    console.log('设置当前副作用函数的"副作用函数集合之数组"');
    effectFn.deps = [];
    effectFn();
}

effect(()=>{
    console.log('不访问属性的副作用函数，无意义');
});
effect(()=>{
    console.log(obj.name);
});
effect(()=>{
    console.log(obj.age);
});
effect(()=>{
    console.log(obj.gender);
});
obj.name = 'zhangsan';


