<script setup>
import { ref } from 'vue';
const val1 = ref(89);
const val2 = ref(0);
const html = ref('<button>按钮</button>')
const items = ref([
    {id:1,name:'a'},
    {id:2,name:'b'},
    {id:3,name:'c'},
]);
</script>

<template>
<h1>v-other</h1>
<div v-show="val1">段落</div>
<div v-show="val2">段落</div>
<div v-html="html"></div>
<div v-text="html"></div>

</template>

<style>

</style>