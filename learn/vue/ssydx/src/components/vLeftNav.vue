<script setup>
import { defineProps } from 'vue';
const navLeftData = defineProps({
    navImg: {
        type: String,
        required: true,
    },
    navOther: {

    },
});
</script>

<template>
<div>
    <img :src="navLeftData.navImg" alt="首页" width="24px">
    <div v-if="navLeftData.navOther">{{ navLeftData.navOther }}</div>
</div>
</template>

<style scoped>
div {
    flex: 1 0 auto;
}
</style>