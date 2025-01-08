<!-- 必须以该种形式导出，不可合并到setup中，避免继承父组件调用时设置的属性 -->
<script>
export default {
  inheritAttrs: false
}
</script>
<script setup>

</script>

<template>
  <div>
    <div class="class1" v-bind="$attrs">123567</div>
    <div id="id1" v-bind="$attrs">123567</div>
    <div class="class3">123567</div>
  </div>
</template>

<style></style>