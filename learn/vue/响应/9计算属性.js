let activeEffect;
const effectStack = [];
// 对象=》属性=》副作用
const bucket = new WeakMap();
const data = { foo: 1, bar: 2 };
function track(target, key) {
    // 没有副作用函数则直接返回
    if (!activeEffect) {
        return
    };
    // 获得当前对象的 属性=》副作用 数据结构（此处为字典）
    let depsMap = bucket.get(target);
    // 没有则新建
    if (!depsMap) {
        bucket.set(target,(depsMap = new Map()))
    }
    // 获得当前对象当前属性的 副作用 数据结构（此处为集合）
    let deps = depsMap.get(key);
    // 没有则新建
    if (!deps) {
        depsMap.set(key, (deps = new Set()))
    }
    // 将活动副作用 添加为当前对象当前属性的副作用
    deps.add(activeEffect);
    // 将该副作用集加入该函数的依赖集，目的是处理函数有时是属性的副作用函数，有时则不是：典型的如：根据条件决定是否获得某属性的值，如果某次获取了那么该函数会成为该属性的副作用函数，但若之后函数不再获取，其仍然作为副作用函数，造成在别处访问属性值时仍然触发该函数，解决方式是每次函数执行前都先从各个对象属性的依副作用集中删除，之后再执行，根据实际是否访问属性决定是否作为对应属性的副作用函数
    activeEffect.deps.push(deps);
}
function trigger(target, key) {
    // 获得当前对象的 属性=》副作用 数据结构（此处为字典）
    const depsMap = bucket.get(target);
    // 没有则返回
    if (!depsMap) {
        return
    };
    // 获得当前对象当前属性的 副作用 数据结构（此处为集合）
    const effects = depsMap.get(key);
    // 没有则返回
    if (!effects) {
        return
    }
    // 依次执行每个副作用
    const effectToRun = new Set();
    effects.forEach(effectFn => {
        // 避免执行副作用函数时候触发，造成无限递归调用
        if (effectFn !== activeEffect) {
            effectToRun.add(effectFn);
        }
    })
    effectToRun.forEach(effectFn => {
        if (effectFn.options.scheduler) {
            effectFn.options.scheduler(effectFn);
        } else {
            effectFn();
        }
    });
}
const obj = new Proxy(data, {
    get(target, key) {
        // 添加副作用：即访问当前对象属性的函数应被视为当前对象的副作用函数
        track(target, key);
        return target[key];
    },
    set(target,key,newVal) {
        target[key] = newVal;
        // 触发副作用：即设置当前对象属性会触发所有相关副作用函数
        trigger(target, key);
        return true;
    }
})
function cleanUp(effectFn) {
    for (let i=0; i< effectFn.deps.length; i++) {
        const deps = effectFn.deps[i]
        deps.delete(effectFn);
    }
    effectFn.deps.length = 0;
}
function effect(fn, options = {}) {
    const effectFn = () => {
        // 清空依赖集
        cleanUp(effectFn);
        activeEffect = effectFn;
        effectStack.push(effectFn);
        const res = fn();
        effectStack.pop();
        activeEffect = effectStack[effectStack.length - 1];
        return res;
    }
    effectFn.options = options;
    effectFn.deps = [];
    // 如果设置延后执行则副作用函数并不执行，否则才执行
    if (!options.lazy) {
        effectFn();
    }
    return effectFn;
}



function computed(getter) {
    let value;
    let dirty = true;
    const effectFn = effect(getter, 
        { 
            lazy:true, 
            scheduler() {
                // 每次调度器被触发就说明其依赖的值已被更新，声明值为旧
                dirty = true;
                // 解决计算属性作为依赖项时无法响应的问题，强制建立计算属性的响应性
                trigger(obj, 'value');
            }
        }
    );
    const obj = {
        get value() {
            // 如果旧数据已过期则重新执行副作用函数获取最新值
            if (dirty) {
                value = effectFn();
                console.log('执行');
                // 标示值非旧
                dirty = false;
            }
            // 强制
            track(obj, 'value');
            return value;
        }
    }
    return obj;
}
const sumRes = computed(() => obj.foo + obj.bar);
// 第一次执行副作用
console.log(sumRes.value);
obj.foo++;
console.log(sumRes.value);

