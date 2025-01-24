// 当前副作用函数
let activeEffect;
// 对象 -> 属性 -> 副作用
const objsKeysEffects = new WeakMap();
// 追踪函数
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
// 触发函数
function trigger(target, key) {
    console.log('开始触发');
    const keysEffects = objsKeysEffects.get(target);
    if (!keysEffects) {
        console.log('对象',obj,'暂无属性存在副作用函数集合');
        console.log('停止触发');
        return;
    }
    const effects = keysEffects.get(key);
    if (!effects) {
        console.log('对象',obj,'的',key,'属性暂不存在副作用函数集合');
        console.log('停止触发');
        return;
    }
    console.log('复制一份副作用函数集合，避免在遍历集合时因先删后加造成的无限循环');
    const effectsToRun = new Set(effects);
    effectsToRun.forEach(fn => {
        if (fn !== activeEffect) {  
            console.log('触发副作用函数',fn);
            fn();
        };
    });
    console.log('触发结束');
};
// 响应函数
function reactive(data = {}) {
    console.log('将',data,'代理为响应式数据');
    return new Proxy(data,{
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
};
// 清理旧副作用函数
function cleanUp(effectFn) {
    console.log('开始清理');
    console.log('遍历当前副作用函数',effectFn,'的副作用函数集合之数组',effectFn.deps,'，从每个副作用函数集合中删除当前副作用函数');
    for (let i=1; i<effectFn.deps.length; i++) {
        effectFn.deps[i].delete(effectFn);
    }
    console.log('将当前副作用函数的副作用函数集合之数组清空');
    effectFn.deps.length = 0;
    console.log('清理结束');
}
// 副作用栈，处理当前副作用执行后无法将activeEffect回退到执行前一值的问题
// 例如副作用嵌套，或者单层副作用
const activeEffectStack = [];
// 副作用函数
function effect(fn, options={}) {
    const effectFn = () => {
        cleanUp(effectFn);
        activeEffect = effectFn;
        activeEffectStack.push(effectFn);
        fn();
        activeEffectStack.pop();
        activeEffect = activeEffectStack[activeEffectStack.length - 1];
    }
    console.log('设置当前副作用函数的"副作用函数集合之数组"');
    effectFn.deps = [];
    effectFn();
}





export {
    reactive,
    effect,
}

