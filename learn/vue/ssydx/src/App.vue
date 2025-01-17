<script setup>
import vNav from './components/vNav.vue';
import vLeftAside from './components/vLeftAside.vue';
import vMain from './components/vMain.vue';

import { ref } from 'vue';
const navData = ref({
    leftNavData: {
        img: `<svg t="1737093902208" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg"><path d="M592.795141 942.076152 592.795141 686.385702 432.057273 686.385702l0 256.372995c-5.02341 0.258896-9.030677 0.647753-13.038968 0.647753-75.894528 0-151.827941 0.040932-227.727585 0-26.079982 0-43.617403-16.727986-43.733037-44.430932-0.527003-105.19997-0.366344-210.486922 0.116657-315.686892 0-5.547343 4.213975-12.641925 8.465812-16.428158 68.686359-60.686151 137.733944-120.984469 206.664873-181.329858 45.884027-40.168862 91.729168-80.340793 137.612171-120.467699 3.565199-3.097548 7.213285-6.106068 11.703553-9.939373 27.377534 23.916712 54.633295 47.699372 81.849146 71.526033 89.782839 78.580706 179.449022 157.332305 269.476431 235.612159 9.679453 8.383948 13.809517 16.898879 13.727653 30.446429-0.565888 99.871615-0.406253 199.778023-0.200568 299.602565 0.037862 18.152429-4.213975 33.936927-19.321044 43.959188-5.467525 3.64911-12.392238 6.79373-18.668175 6.835685-80.551594 0.429789-161.103188 0.210801-241.609757 0.169869C596.199681 943.277514 594.978876 942.717765 592.795141 942.076152L592.795141 942.076152zM713.76426 234.18567c0-42.192961-0.039909-81.158415 0-120.084982 0.037862-24.858154 5.627161-30.79333 28.995381-30.835286 36.287461 0 72.573899-0.040932 108.86136 0.041956 18.711154 0.047072 25.186635 7.052626 25.230638 28.085662 0.083911 83.307358 0.282433 166.663834-0.24457 249.971192-0.081864 12.859889 3.321652 21.1149 12.834306 29.287023 39.774889 33.978882 78.772065 68.901253 117.974925 103.609753 19.23304 17.033955 19.721157 25.329898 3.521197 45.591361-9.797134 12.300141-19.393699 24.816199-29.278837 37.075407-12.147668 15.178701-22.193465 16.126282-36.730553 3.221368-139.192156-123.352399-278.385335-246.787686-417.621493-370.181017-4.818749-4.256954-9.758248-8.432043-15.391549-13.33675-31.302937 27.702945-62.36642 55.099922-93.348038 82.579787C305.578674 379.341654 192.588273 479.506958 79.596849 579.63133c-15.307637 13.589506-24.821315 12.777001-37.699624-3.225461-10.656711-13.289678-21.262256-26.66736-31.751145-40.079834-12.231579-15.656585-11.743462-25.765827 3.037173-38.9675 63.054081-56.042387 126.274962-111.870904 189.450816-167.782308 84.193541-74.5366 168.470993-148.983149 252.626671-223.647663 38.187741-33.849946 75.366502-33.849946 113.639177 0.257873 45.235251 40.297798 90.597391 80.429821 135.910413 120.597659C706.96132 228.681306 709.227943 230.441393 713.76426 234.18567L713.76426 234.18567zM713.76426 234.18567" p-id="4292"></path></svg>`,
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
    fontSize: '1rem',
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