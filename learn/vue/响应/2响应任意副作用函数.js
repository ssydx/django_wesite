// 解决副作用函数的不可更改问题
// 存储当前副作用函数
let activeEffect;
const effectsBucket = new Set();
const data = { text: 'hello world'};
const obj = new Proxy(data, {
    get(target, key) {
        if (activeEffect) {
            effectsBucket.add(activeEffect);
        }
        return target[key];
    },
    set(target,key,newVal) {
        target[key] = newVal;
        effectsBucket.forEach(fn => fn());
        return true;
    }
})
// 利用函数包装，执行副作用函数时会将副作用函数添加到副作用函数集
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

// 访问任意属性（甚至不存在的属性）也会触发所有副作用函数，即无法区分属性与副作用函数的关系