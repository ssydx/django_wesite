// 载入样式表
import './assets/main.css'
// 载入创建应用的函数
import { createApp } from 'vue'

// 载入组件
import App from './App.vue';
import optional from './选项式脚本/选项式.vue';
import composed from './组合式脚本/组合式.vue';
import temp from './模板/模板.vue';
import NSFC from './非单文件组件/1.vue';
import sty from './样式/样式.vue';
const tag = 1;
let app;
if (tag == 1) {
    // 创建一个基于指定组件的应用且附带有初始参数
    app = createApp(optional, {
        fatherName: 'ssydx',
        fatherSex: 'male',
    });
    
} else if (tag == 2) {
    app = createApp(composed, {
        // fatherName: 'ssydx',
        // fatherSex: 'male',
    });
} else if (tag == 3) {
    app = createApp(temp);
} else if (tag == 4) {
    app = createApp(NSFC);
} else if (tag == 5) {
    app = createApp(sty);
} else {
    // 创建一个基于指定组件的应用
    app = createApp(App);
}
// 挂载到指定容器上
app.mount('#app');


console.log(app.version);
console.log(app.config);


