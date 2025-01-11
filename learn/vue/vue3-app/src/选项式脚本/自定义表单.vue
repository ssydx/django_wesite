<script>
export default {
  props: ['modelValue','value'],
};
</script>

<template>
  <div>
    <!-- 借用以下方式可以实现v-model直接绑定 -->
    <input type="text" :value="modelValue" @input="$emit('update:modelValue', $event.target.value)">
    <div>子组件：{{ modelValue }}</div>
    <!-- 如果修改了值变量的名称那么父组件中也需要显式声明绑定的变量 -->
     <!-- update:形式不可更改，否则无法在父组件使用v-model -->
    <input type="text" :value="value" @change="$emit('update:value', $event.target.value)">
    <div>子组件：{{ value }}</div>
    <input type="text" :value="val" @change="$emit('update:val', $event.target.value)">
  </div>
</template>



<style scoped>

</style>