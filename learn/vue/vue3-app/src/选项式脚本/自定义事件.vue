<script>
export default {
    // 作用只是规范及父组件进行事件绑定时提示，如果没有声明$emit()中的事件名，会发出警告，但不影响实际执行
    emits: ['enlarge','print','changeson'],
    data() {
        return {
            val1: 123,
            val2: 'abc',
        }
    }
}
</script>
    
<template>
<div>
    <button @click="$emit('enlarge')">放大文字</button>
    <button @click="$emit('smaller')">缩小文字</button>
    <button @click="$emit('print', '1', val1, val2)">打印子组件数据</button>
</div>
</template>

<style>

</style>

