<script setup>
import { ref } from 'vue';
const cls = ref('div1');
const attr = ref('id');
const val = ref('div1');
const dict = ref({
    class: 'div1',
    id: 'div1',
});
// 注意此处的操作
const arr = ref([cls.value,'div2']);
const bool1 = ref(true);
const idt = ref('div1');
const styval = ref('green');
const sty = ref({
    backgroundColor: 'yellow',
})
</script>

<template>
<h1>v-bind</h1>
<!-- 基础绑定 -->
<div class="div1">静态属性</div>
<div :[attr]="val">动态属性</div>
<div :class="cls">动态属性值</div>
<!-- 默认的引号用来包裹表达式，内部再加引号用于表名其为字符串而不是变量 -->
<div :[attr]="'div1'">动态属性名</div>
<div :class="cls" :id="idt">多属性赋值1</div>
<div :=dict>多属性赋值2</div>
<div :='{ id:idt,class:cls }'>多属性赋值3</div>
<div :class="dict.class" :[attr]="dict.id">多属性赋值4</div>
<div :class="arr[0]">列表赋值</div>
<div :class=arr>列表赋值</div>
<!-- 类的高级绑定 -->
<!-- 列表元素，无引号的被视为变量，有引号的被视为字符串 -->
<div :class="[cls,'div2']">类的列表赋值</div>
<!-- 字典的键，有无引号都被视为字符串；值可以为字符串或变量 -->
<div :class="{div1: bool1,'div2': false}">类的对象赋值</div>
<!-- 样式的高级绑定 -->
<!-- 列表元素，无引号的被视为变量，有引号的被视为字符串 -->
<div :style="[sty,'color: green']">样式的列表赋值</div>
<!-- 字典的键，有无引号都被视为字符串；值可以为字符串或变量 -->
<div :style="{color: 'yellow','backgroundColor': styval}">样式的对象赋值</div>
<!-- 修饰符 -->

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