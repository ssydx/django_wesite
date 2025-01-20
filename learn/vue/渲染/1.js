function renderer(domString, container) {
    container.innerHTML = domString;
}
renderer('<h1>一级标题</h1>', document.querySelector('#div1'));



const { effect, ref } = VueReactivity;
const cnt = ref(1);
effect(() => {
    renderer(`<h2>${cnt.value}</h2>`, document.querySelector('#div2'));
});
setTimeout(() => {
    cnt.value++;
},1000); 


