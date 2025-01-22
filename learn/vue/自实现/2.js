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



function effect(fn, options={}) {
    activeEffect = effect;
    fn();
}

function effect(fn, options={}) {
    const effectFn = () => {
        activeEffect = effectFn;
        fn();
    }
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
console.log(objsKeysEffects);


