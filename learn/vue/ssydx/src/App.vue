<script setup>
import vNav from './components/vNav.vue';
import vLeftAside from './components/vLeftAside.vue';
import vMain from './components/vMain.vue';

import { ref } from 'vue';
const navData = ref({
    leftNavData: {
        img: '/src/assets/home-icon.svg',
    }, 
    rightNavData: {
        list: [
            {
                type:'dropdown', 
                title:'编程', 
                dropdownList:[
                    {title:'前端', link: '', type: 'group'},
                    {title:'HTML', link: '#', type: 'item'},
                    {title:'CSS', link: '#', type: 'item'},
                    {title:'JavaScript', link: '#', type: 'item'},
                    {title:'后端', link: '', type: 'group'},
                    {title:'PHP', link: '#', type: 'item'},
                    {title:'ASP', link: '#', type: 'item'},
                    {title:'JAVA', link: '#', type: 'item'},
                    {title:'Python', link: '#', type: 'item'},
                    {title:'框架', link: '', type: 'group'},
                    {title:'Bootstrap', link: '#', type: 'item'},
                    {title:'Vue', link: '#', type: 'item'},
                    {title:'Node.js', link: '#', type: 'item'},
                    {title:'Django', link: '#', type: 'item'},
                ],
            },
            {
                type:'dropdown',
                title:'动漫',
                dropdownList:[
                    {title:'漫画', link: '', type: 'group'},
                    {title:'搞笑', link: '#', type: 'item'},
                    {title:'热血', link: '#', type: 'item'},
                    {title:'异世界', link: '#', type: 'item'},
                    {title:'恋爱', link: '#', type: 'item'},
                    {title:'动画', link: '', type: 'group'},
                    {title:'搞笑', link: '#', type: 'item'},
                    {title:'热血', link: '#', type: 'item'},
                    {title:'日常', link: '#', type: 'item'},
                    {title:'恋爱', link: '#', type: 'item'},
                ]
            },
            {
                type:'dropdown',
                title:'小说',
                dropdownList:[
                    {title:'玄幻', link: '#', type: 'item'},
                    {title:'都市', link: '#', type: 'item'},
                    {title:'穿越', link: '#', type: 'item'},
                    {title:'日常', link: '#', type: 'item'},
                ]
            },
            {type:'link',title:'文学',link:'#'},
            {type:'link',title:'其他',link:'#'},
        ],
        other: null,
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
    footer: {id:'-1', author:'ssydx',address: '中国北京', timeUpdate: '2025/01/01'},
});

const navStyle = ref({
    fontSize: '10rem',
})

</script>


<template>
    <vNav :left-nav-data="navData.leftNavData" :right-nav-data="navData.rightNavData" :style="navStyle">
    </vNav>
    <vLeftAside :aside-list="asideLeftData.asideList">
    </vLeftAside>
    <vMain :main-data="mainData">
    </vMain>
</template>

<style scoped>

</style>