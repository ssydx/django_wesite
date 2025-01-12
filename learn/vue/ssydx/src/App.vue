<script setup>
import vNav from './components/vNav.vue';
import vLeftAside from './components/vLeftAside.vue';
import vMain from './components/vMain.vue';

import { ref } from 'vue';
const navData = ref({
    navCoreData: {
        navImg: '/src/assets/home-icon.svg',
        navList: [
            {title:'编程',link:'#'},
            {title:'动漫',link:'#'},
            {title:'小说',link:'#'},
            {title:'文学',link:'#'},
            {title:'其他',link:'#'},
        ],
    },
    navOtherData: {
        navLeft: '',
        navRight: '',
    },
});
const asideLeftData = ref({
    asideList: [
            {title:'Python',link:'#',isGroup:true},
            {title:'注释',link:'#',isGroup:false},
            {title:'数据类型',link:'#',isGroup:false},
            {title:'类型转换',link:'#',isGroup:false},
            {title:'操作符',link:'#',isGroup:false},
            {title:'关键字',link:'#',isGroup:false},
            {title:'变量',link:'#',isGroup:false},
            {title:'语句',link:'#',isGroup:false},
            {title:'内置变量',link:'#',isGroup:false},
            {title:'内置函数',link:'#',isGroup:false},
            {title:'函数',link:'#',isGroup:false},
            {title:'类',link:'#',isGroup:false},
            {title:'HTML',link:'#',isGroup:true},
            {title:'标签',link:'#',isGroup:false},
            {title:'属性',link:'#',isGroup:false},
            {title:'事件',link:'#',isGroup:false},
        ],
});
const mainData = ref({
    header: {id:'1', title:'HTML简介',subtitle: '这是文章简介！'},
    sections: [
        {
            id:'section1', 
            title:'标题1', 
            subtitle:'在Vue项目中引入Bootstrap框架的方法有以下几种：1、使用Bootstrap CDN，2、安装Bootstrap包并在项目中引用，3、使用BootstrapVue插件。 每种方法都有',
            content:[
                "如果提供全部四个参数值，将按上左(top-left)、上右(top-right)、下右(bottom-right)、下左(bottom-left)的顺序作用于四个角。如果提供三个参数值，第一个用于上左(top-left)，第二个用于上右(top-right)、下左(bottom-left)，第三个用于下右(bottom-right)。如果提供两个参数值，第一个用于上左(top-left)、下右(bottom-right)，第二个用于上右(top-right)、下左(bottom-left)。如果只提供一个参数值，将用于全部的于四个角。",
                "对于行内元素或表格单元格，你可以使用 vertical-align 属性来调整文本的垂直对齐方式。注意，vertical-align 对非表格单元格的块级元素不起作用。",
                "Bootstrap-Vue是Vue.js的一个开源工具包，它可以让你在应用程序中使用Bootstrap的本地组件，而不需要使用jQuery。 这个库一直在更新，以支持最新的vue.js功能，并提供与新版本Bootstrap的兼容性。",
            ]
        },
        {
            id:'section2', 
            title:'标题2', 
            subtitle:'在Vue项目中引入Bootstrap框架的方法有以下几种：1、使用Bootstrap CDN，2、安装Bootstrap包并在项目中引用，3、使用BootstrapVue插件。 每种方法都有',
            content:[
                "如果提供全部四个参数值，将按上左(top-left)、上右(top-right)、下右(bottom-right)、下左(bottom-left)的顺序作用于四个角。如果提供三个参数值，第一个用于上左(top-left)，第二个用于上右(top-right)、下左(bottom-left)，第三个用于下右(bottom-right)。如果提供两个参数值，第一个用于上左(top-left)、下右(bottom-right)，第二个用于上右(top-right)、下左(bottom-left)。如果只提供一个参数值，将用于全部的于四个角。",
                "对于行内元素或表格单元格，你可以使用 vertical-align 属性来调整文本的垂直对齐方式。注意，vertical-align 对非表格单元格的块级元素不起作用。",
                "Bootstrap-Vue是Vue.js的一个开源工具包，它可以让你在应用程序中使用Bootstrap的本地组件，而不需要使用jQuery。 这个库一直在更新，以支持最新的vue.js功能，并提供与新版本Bootstrap的兼容性。",
            ]
        },
        {
            id:'section3', 
            title:'标题3', 
            subtitle:'在Vue项目中引入Bootstrap框架的方法有以下几种：1、使用Bootstrap CDN，2、安装Bootstrap包并在项目中引用，3、使用BootstrapVue插件。 每种方法都有',
            content:[
                "如果提供全部四个参数值，将按上左(top-left)、上右(top-right)、下右(bottom-right)、下左(bottom-left)的顺序作用于四个角。如果提供三个参数值，第一个用于上左(top-left)，第二个用于上右(top-right)、下左(bottom-left)，第三个用于下右(bottom-right)。如果提供两个参数值，第一个用于上左(top-left)、下右(bottom-right)，第二个用于上右(top-right)、下左(bottom-left)。如果只提供一个参数值，将用于全部的于四个角。",
                "对于行内元素或表格单元格，你可以使用 vertical-align 属性来调整文本的垂直对齐方式。注意，vertical-align 对非表格单元格的块级元素不起作用。",
                "Bootstrap-Vue是Vue.js的一个开源工具包，它可以让你在应用程序中使用Bootstrap的本地组件，而不需要使用jQuery。 这个库一直在更新，以支持最新的vue.js功能，并提供与新版本Bootstrap的兼容性。",
            ]
        },
        {
            id:'section4', 
            title:'标题4', 
            subtitle:'在Vue项目中引入Bootstrap框架的方法有以下几种：1、使用Bootstrap CDN，2、安装Bootstrap包并在项目中引用，3、使用BootstrapVue插件。 每种方法都有',
            content:[
                "如果提供全部四个参数值，将按上左(top-left)、上右(top-right)、下右(bottom-right)、下左(bottom-left)的顺序作用于四个角。如果提供三个参数值，第一个用于上左(top-left)，第二个用于上右(top-right)、下左(bottom-left)，第三个用于下右(bottom-right)。如果提供两个参数值，第一个用于上左(top-left)、下右(bottom-right)，第二个用于上右(top-right)、下左(bottom-left)。如果只提供一个参数值，将用于全部的于四个角。",
                "对于行内元素或表格单元格，你可以使用 vertical-align 属性来调整文本的垂直对齐方式。注意，vertical-align 对非表格单元格的块级元素不起作用。",
                "Bootstrap-Vue是Vue.js的一个开源工具包，它可以让你在应用程序中使用Bootstrap的本地组件，而不需要使用jQuery。 这个库一直在更新，以支持最新的vue.js功能，并提供与新版本Bootstrap的兼容性。",
            ]
        },
        {
            id:'section5', 
            title:'标题5',
            content:[
                "如果提供全部四个参数值，将按上左(top-left)、上右(top-right)、下右(bottom-right)、下左(bottom-left)的顺序作用于四个角。如果提供三个参数值，第一个用于上左(top-left)，第二个用于上右(top-right)、下左(bottom-left)，第三个用于下右(bottom-right)。如果提供两个参数值，第一个用于上左(top-left)、下右(bottom-right)，第二个用于上右(top-right)、下左(bottom-left)。如果只提供一个参数值，将用于全部的于四个角。",
                "对于行内元素或表格单元格，你可以使用 vertical-align 属性来调整文本的垂直对齐方式。注意，vertical-align 对非表格单元格的块级元素不起作用。",
                "Bootstrap-Vue是Vue.js的一个开源工具包，它可以让你在应用程序中使用Bootstrap的本地组件，而不需要使用jQuery。 这个库一直在更新，以支持最新的vue.js功能，并提供与新版本Bootstrap的兼容性。",
            ]
        },
    ],
    footer: {id:'-1', author:'ssydx'},
}
);
</script>


<template>
    <vNav :nav-core-data="navData.navCoreData" :nav-other-data="navData.navOtherData"></vNav>
    <vLeftAside :aside-list="asideLeftData.asideList"></vLeftAside>
    <vMain :main-data="mainData"></vMain>
    
</template>

<style scoped>

</style>