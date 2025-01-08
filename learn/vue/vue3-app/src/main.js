// 载入样式表
import './assets/main.css'
// 载入创建应用的函数
import { createApp } from 'vue'
// // 载入组件
// import App from './App.vue'
// // 创建一个基于指定组件的应用并挂载到指定容器上
// createApp(App).mount('#app')

// 载入组件
import App from './components/选项式.vue';
// 创建一个基于指定组件的应用并挂载到指定容器上
createApp(App).mount('#app')
