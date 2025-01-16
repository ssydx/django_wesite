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
</div>
</template>

<style scoped lang="scss">
div.leftNav {
    display: flex;
    flex-flow: row nowrap;
    align-items: center;
    gap: 0 2rem;
    > * {
        flex: 0 0 auto;
    }
    > img {
        height: 2em;
        display: block;
    }
}
</style>