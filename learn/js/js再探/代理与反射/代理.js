const target = { 
    name: 'ssydx',
};
const handler = {};
const proxy = new Proxy(target, handler);
console.log(target);
console.log(proxy);
console.log(target == proxy);
const trt1 = {
    name: 'ssydx',
};
const p1 = new Proxy(trt1,{
    // 首参指原对象，二参为访问的属性，尾参为代理对象自身
    get(target, prop, receiver) {
        console.log('hello world');
        console.log(target);
        console.log(prop);
        console.log(receiver);
        return target[prop];
    }
});
console.log(p1.name);


const p2 = new Proxy(trt1,{
    // 首参指原对象，二参为访问的属性，尾参为代理对象自身
    get(target, prop, receiver) {
        console.log('获取',target,'的',prop,'属性');
        return Reflect.get(target,prop,receiver);
    },
    set(target, prop, newVal, receiver) {
        console.log('设置',target,'的',prop,'属性值为',newVal);
        return Reflect.set(target, prop, newVal, receiver);
    },
    has(target, prop) {
        console.log('判断',prop,'是否为',target,'的属性');
        return Reflect.has(target, prop);
    },
    deleteProperty(target, prop) {
        console.log('删除',target,'的',prop,'属性');
        return Reflect.deleteProperty(target,prop);
    }
});
p2.name;
p2['name'];
p2.name = 'zhangsan';
p2['name'] = 'lisi';
'name' in p2;
delete p2.name;



