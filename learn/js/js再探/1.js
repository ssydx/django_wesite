
// 原型是Object.prototype
const o1 = { name:'ssydx' };
console.log(o1);
// 原型是{}，该空对象的原型才是Object.prototype
const o2 = Object.create({},
    {
        name: {
            value: 'ssydx',
            writable: true,
            enumerable: true,
            configurable: true,
        }
    }
);
console.log(o2);
// 原型是Object.prototype
const o3 = new Object({ name:'ssydx' });
console.log(o3);

console.log(Object.getOwnPropertyDescriptors(o1));
console.log(Object.getOwnPropertyDescriptors(o2));
console.log(Object.getOwnPropertyDescriptors(o3));

console.log(Object.keys('abc'));
console.log(Object.values('abc'));
console.log(Object.entries('abc'));

console.log(Object.keys(['a','b',1]));
console.log(Object.values(['a','b',1]));
console.log(Object.entries(['a','b',1]));

console.log(Object.keys({ name:'ssydx',age:26 }));
console.log(Object.values({ name:'ssydx',age:26 }));
console.log(Object.entries({ name:'ssydx',age:26 }));

console.log(null);
console.log(undefined);
console.log(null == undefined);



