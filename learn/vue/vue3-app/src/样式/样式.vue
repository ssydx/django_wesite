<script setup>
import styson from './子样式.vue'
</script>
<template>
<h1>样式相关</h1>
<div class="cc1 cc2 cc3">主组件</div>
<styson></styson>
</template>

<style>
.cc1 {
    color: aqua;
}
.cc2 {
    background-color: green;
}
.cc3 {
    padding-left: 2rem;
}
</style>