<script setup>
import { defineProps } from 'vue';
const props = defineProps({
    link: {
        type: String,
        default: '#',
    },
})
</script>
<template>
<a class="v-link" :href="link">
    <slot></slot>
</a>
</template>
<style scoped lang="scss">
a.v-link {
    box-sizing: border-box;
    display: inline-block !important;
    margin: 0 !important;
    padding: 0.5em !important;
    text-decoration: none !important;
    border-radius: 0.5em;
    height: 2em;
    line-height: 1;
    width: 100%;
    color: black !important;
    &:hover {
        background-color: aquamarine;
    }
}
</style>