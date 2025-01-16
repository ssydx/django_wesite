<script setup>
import { defineProps,defineAsyncComponent } from 'vue';
const navRightData = defineProps({
    navList: {
        type: Array,
        default() {
            return [
                {
                    type:'dropdown', 
                    title:'链接组1', 
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
                {type:'link',title:'链接2',link:'#'},
                {type:'link',title:'链接3',link:'#'},
                {type:'link',title:'链接4',link:'#'},
                {
                    type:'dropdown',
                    title:'链接组5',
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

            ];
        },
    },
});
const resolveCompnent = function(item) {
    if (item.type === 'link') {
        return 'a';
    } else if (item.type === 'dropdown') {
        return defineAsyncComponent(() =>
        import('./vDropdown.vue'));
    }
};
const getProps = function(item) {
    if (item.type === 'link') {
        return {
            href: item.link,
        }
    } else if (item.type === 'dropdown') {
        return {
            dropdownName: item.title,
            dropdownList: item.dropdownList
        }
    }
}
</script>

<template>
<ul>
    <li v-for="navitem in navRightData.navList" :key="navitem.title">
        <component :is="resolveCompnent(navitem)" :="getProps(navitem)">{{ navitem.title }}</component>
    </li>
</ul>
</template>

<style scoped lang="scss">
ul {
    display: flex;
    flex-flow: row nowrap;
    align-items: center;
    justify-content: flex-start;
    > li {
        flex: 0 0 auto;
        > * {
            padding: 0 0.5rem;
        }
    }
}

</style>