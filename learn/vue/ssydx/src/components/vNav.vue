<script setup>
import vLeftNav from './vLeftNav.vue';
import vRightNav from './vRightNav.vue';
import { defineProps,ref } from 'vue';

const navData = defineProps({
    navSelfData: {
        type: Object,
        default() {
            return {
                navHeight: 3,
            }
        },
    },
    leftNavData: {
        type: Object,
        default() {
            return {
                img: '/src/assets/home-icon.svg',
                other: null,
            }
        },
    },
    rightNavData: {
        typeof: Object,
        default() {
            return {
                list: [
                    {title:'编程',link:'#'},
                    {title:'动漫',link:'#'},
                    {title:'小说',link:'#'},
                    {title:'文学',link:'#'},
                    {title:'其他',link:'#'},
                ],
                other: null,
            }
        },
    },
});
const height = ref(navData.navSelfData.navHeight + 'rem');
</script>

<template>
<nav class="nav">
    <vLeftNav :nav-img="navData.leftNavData.img" :nav-other="navData.leftNavData.other"></vLeftNav>
    <vRightNav :nav-list="navData.rightNavData.list" :nav-other="navData.rightNavData.other"></vRightNav>
</nav>
</template>

<style scoped lang="scss">
nav.nav {
    /* 位置 */
    position: sticky;
    top: 0;
    z-index: 1000;
    /* 尺寸 */
    margin: 0 0 1rem;
    padding: 0.5rem 1rem;
    width: 100%;
    height: v-bind(height);
    /* 外观 */
    background-color: var(--bg-color);
    color: var(--tt-color);
    border-radius: 0 0 0.25rem 0.25rem;
    box-shadow: 0 0 0.75rem -0.25rem var(--tt-color);
    /* 字体 */
    font-size: calc(1rem + (v-bind(height) - 3rem) / 4);
    line-height: 1;
    /* 布局 */
    display: flex;
    flex-flow: row nowrap;
    align-items: center;
    justify-content: space-between;
    gap: 0 3rem;
    > * {
        flex: 1 0 auto;
        height: v-bind(height);
    };
}
</style>

