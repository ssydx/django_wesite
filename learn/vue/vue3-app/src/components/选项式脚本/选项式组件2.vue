
<script>
export default {
    // 组件名称
    name: 'optionsComponent2',
    // 从父组件接收的属性
    props:['fatherval'],
    // 从祖先组件接收的属性
    inject: ['sendtograndson2'],
}
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