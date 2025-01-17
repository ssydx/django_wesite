<script setup>
import vLeftNav from './vLeftNav.vue';
import vRightNav from './vRightNav.vue';
import { defineProps } from 'vue';
const navData = defineProps({
    leftNavData: {
        type: Object,
        default() {
            return {
                img: '/src/assets/home-icon.svg',
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
</script>

<template>
<nav class="nav">
    <slot name="LTL"></slot>
    <slot name="L">
        <vLeftNav :nav-img="navData.leftNavData.img"></vLeftNav>
    </slot>
    <slot></slot>
    <slot name="R">
        <vRightNav :nav-list="navData.rightNavData.list" :nav-other="navData.rightNavData.other"></vRightNav>
    </slot>
    <slot name="RTR"></slot>
</nav>
</template>

<style scoped lang="scss">
nav.nav {
    /* 位置 */
    position: sticky;
    top: 0;
    z-index: 1000;
    /* 字体 */
    font-size: 1rem;
    /* 尺寸 */
    margin: 0;
    padding: 0 1em;
    width: 100%;
    height: 3em;
    /* 外观 */
    background-color: var(--bg-color);
    color: var(--tt-color);
    border-radius: 0 0 0.1em 0.1em;
    box-shadow: 0 0 0.5em -0.25em var(--tt-color);
    /* 布局 */
    display: flex;
    flex-flow: row nowrap;
    align-items: center;
    justify-content: space-between;
    gap: 0 3em;
    > * {
        flex: 0 0 auto;
    };
}
</style>

