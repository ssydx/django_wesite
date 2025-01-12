<script setup>
import vLeftNav from './vLeftNav.vue';
import vRightNav from './vRightNav.vue';
import { defineProps } from 'vue';
const navData = defineProps({
    navCoreData: {
        type: Object,
        required: true,
    },
    navOtherData: {
        type: Object,
        required: false,
    },
});

</script>

<template>
<nav>
    <vLeftNav :nav-img="navData.navCoreData.navImg" :nav-other="navData.navOtherData.navLeft"></vLeftNav>
    <vRightNav :nav-list="navData.navCoreData.navList" :nav-other="navData.navOtherData.navRight"></vRightNav>
</nav>
</template>

<style scoped>
nav {
    margin: 0;
    padding: 0.5rem;
    display: flex;
    flex-flow: row nowrap;
    align-items: center;
    justify-content: space-between;
    background-color: darkgrey;
    box-shadow: 1px 1px 0.5rem black;
    position: sticky;
    top: 0;
    height: 48px;
    z-index: 1000;
}
</style>

