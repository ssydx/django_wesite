<script setup>
import vbind from './属性绑定.vue';
import von from './事件绑定.vue';

</script>

<template>
<div class="order1">
    <vbind></vbind>
</div>
<div class="order">
    <von></von>
</div>


</template>

<style>
body {
    background-color: white;
    color: black;
}
.order1 {
    display: none;
}
</style>