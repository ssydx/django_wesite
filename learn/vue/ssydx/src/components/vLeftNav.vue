<script setup>
import { defineProps } from 'vue';
const navLeftData = defineProps({
    navImg: {
        type: String,
        required: true,
    },
    navOther: null,
});
</script>

<template>
<div class="leftNav">
    <img :src="navLeftData.navImg" alt="首页" width="24px">
    <div v-if="typeof navLeftData.navOther !== 'object'">{{ navLeftData.navOther }}</div>
    <ul v-else-if="navLeftData.navOther instanceof Array">
        <li v-for="item in navLeftData.navOther">
            <a :href="item.link">{{ item.title }}</a>
        </li>
    </ul>
</div>
</template>

<style scoped lang="scss">
div.leftNav {
    display: flex;
    flex-flow: row nowrap;
    align-items: center;
    justify-content: flex-start;
    gap: 0 1rem;
    > * {
        flex: 0 0 auto;
    }
    > img {
        display: block;
    }
    > ul {
        display: flex;
        flex-flow: row nowrap;
        align-items: center;
        justify-content: flex-start;
        gap: 0 0.5rem;
        > li {
            flex: 0 0 auto;
            > a:hover {
                font-weight: 900;
            }
        }
    }
}
</style>