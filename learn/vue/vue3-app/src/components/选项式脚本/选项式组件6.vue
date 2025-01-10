<!-- 自定义事件 -->
<script>

</script>

<template>
    <!-- 作为选项式的子组件 -->
    <!-- 层传 -->
    <div>{{ fatherval }}</div>
    <!-- 透传 -->
    <div v-bind="$attrs">{{ sendtograndson2 }}</div>
</template>

<style>

</style>