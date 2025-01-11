<script setup>
import { ref } from 'vue';
const val1 = ref(20);
const val2 = ref(18);
const items = ref([
    {id:1,name:'a'},
    {id:2,name:'b'},
    {id:3,name:'c'},
]);
</script>

<template>
<div>
    <h1>v-slot</h1>
<div>
    <!-- 默认插槽，带数据 -->
    <slot user-name="lisi" :user-age="val1"></slot>
</div>
<header>
    <!-- 具名插槽 -->
    <slot name="header"></slot>
</header>
<main>
    <!-- 具名插槽，带数据，其他名称不能与name相同 -->
    <slot name="main" :name1="'wangwu'" :age="val2"></slot>
</main>
<footer>
    <!-- 具名插槽 -->
    <slot name="footer"></slot>
</footer>
<!-- 同名插槽 -->
<ul>
    <li v-for="item in items" :key="item.id">
        <slot name="ls" :item="item"></slot>
    </li>
</ul>
<!-- 上述同名插槽等价于 -->
<slot name="same" :data="{id:1,name:'zhangsan'}"></slot>
<slot name="same" :data="{id:2,name:'lisi'}"></slot>
<slot name="same" :data="{id:3,name:'wangwu'}"></slot>
</div>

</template>

<style>

</style>