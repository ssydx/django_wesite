import { reactive,effect } from './基本响应.js';
const data = { name:'ssydx',gender:'male',age:25,bool:true };
const obj = reactive(data);
// effect(()=>{
//     console.log('不访问属性的副作用函数');
// });
effect(()=>{
    console.log(obj.name);
});
effect(()=>{
    // obj.age++;
    obj.age = obj.age + 1;
});
// effect(()=>{
//     document.querySelector('#div1').innerHTML = obj.bool ? obj.name : 'none';
// })
// setTimeout(()=>{
//     obj.name = 'zhangsan';
// },1000);
// setTimeout(()=>{
//     obj.bool = false;
// },2000);
// setTimeout(()=>{
//     obj.name = 'lisi';
// },3000);


// obj.gender = 'female';
// obj.name = 'zhangsan';
// obj.age++;