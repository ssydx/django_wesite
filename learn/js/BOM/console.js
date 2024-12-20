console.log('日志信息:下面是默认展开的消息组');
console.group();
console.assert(1 == 2);
console.error('错误信息');
console.info('提示信息');
console.warn('警告信息');
console.groupEnd();
console.log('日志信息:下面是默认收起的消息组');
console.groupCollapsed();
for (let i = 0; i < 5; i++) {
    console.count("调用：");
}
console.groupEnd();
console.groupCollapsed();
console.log(document.querySelector('img'));
console.table(document.querySelector('img'));
console.groupEnd();
console.clear();
console.time();
const frag = document.createDocumentFragment();
for (let i = 0; i < 1000; i++) {
    frag.appendChild(document.createComment('新增注释'));
}
document.body.appendChild(frag);
console.timeEnd();

const oncetime = setTimeout(function() {
    
},1000);
console.trace(oncetime);