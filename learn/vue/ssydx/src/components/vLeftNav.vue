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
    <img :src="navLeftData.navImg" alt="首页">
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
    gap: 0 2rem;
    > * {
        flex: 0 0 auto;
    }
    > img {
        height: calc(1.5rem + (100% - 3rem) / 2);
        display: block;
    }
    > ul {
        height: 100%;
        display: flex;
        flex-flow: row nowrap;
        align-items: center;
        justify-content: flex-start;
        > li {
            flex: 0 0 auto;
            height: 100%;
            > * {
                padding: 0 0.5rem;
            }
        }
    }
}
</style>