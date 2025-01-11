<script setup>
import { ref } from 'vue';
const val1 = ref(89);
const items = ref([
    {id:1,name:'a'},
    {id:2,name:'b'},
    {id:3,name:'c'},
]);
</script>

<template>
<h1>v-state</h1>
<div v-if="val1 >= 90">优秀</div>
<div v-else-if="val1 >= 80">良好</div>
<div v-else-if="val1 >= 60">及格</div>
<div v-else>不及格</div>
<hr>
<ul>
    <li v-for="item in items">{{ item.name }}</li>
</ul>

</template>

<style>

</style>