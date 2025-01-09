<script setup>
import { ref } from 'vue';
const val1 = ref('0');
const evt = ref('focus');
function evt1() {
    // 需要访问value进行解包，仅顶层元素在模板中时可以自动解包
    val1.value++;
}
function evt2() {
    // 需要访问value进行解包，仅顶层元素在模板中时可以自动解包
    val1.value--;
}
function print1(evt) {
    console.log(evt);
    console.log(evt.target);
}
function print2(evt) {
    console.log(evt);
}
</script>

<template>
<h1>v-on</h1>
<button v-on:click="evt1">按钮值为：{{ val1 }}</button>
<button @click="val1++">按钮值为：{{ val1 }}</button>

<!-- 修饰符 -->
<button v-on:click.once="evt2()">按钮值为：{{ val1 }}</button>
<!-- 显式传递$event -->
<button @click.ctrl="print1($event)">打印1</button>
<!-- 隐式传递$event -->
<button @click="print2">打印2</button>
<button @click="console.log($event)">打印3</button>
<!-- 动态事件类型 -->
<button @[evt]="console.log($event)">打印4</button>
</template>

<style>
.div1 {
    background-color: blue;
}
.div2 {
    padding-left: 2rem;
}
#div1 {
    color: red;
}
</style>