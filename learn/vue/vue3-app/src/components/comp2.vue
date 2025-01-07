<script setup>
defineProps(['title'])
defineEmits(['enlarge-text'])
</script>

<template>
  <h4>{{ title }}</h4>
  <!-- 使父组件可以监听enlarge-text事件 -->
  <button @click="$emit('enlarge-text')">放大文字</button>
</template>