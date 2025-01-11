<script setup>
import { ref } from 'vue';
const sty1 = ref('32px');
const sty2 = ref('900');
const stys = ref({
    fontSize: 32,
    fontWeight: 900,
})
</script>
<template>
<div class="cc1 cc2">子组件1</div>
<div :class="$style.cc3">123</div>
<div :class="mycls.cc3">123</div>
<div class="cc4">123</div>
<div class="cc5">123</div>
</template>

<style>
.cc1 {
    color: red;
}
</style>
<style scoped>
.cc2 {
    background-color: blue;
}
</style>
<style module>
.cc3 {
    border: 5px solid yellow;
}
</style>
<style module="mycls">
.cc3 {
    border: 5px solid green;
}
</style>
<style>
.cc4 {
    font-size: v-bind('sty1');
    font-weight: v-bind(sty2);
}
.cc5 {
    font-size: v-bind('stys.fontSize + "px"');
    font-weight: v-bind('stys.fontWeight');
}
</style>