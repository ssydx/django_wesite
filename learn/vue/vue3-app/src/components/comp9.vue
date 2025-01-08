<script setup>
defineEmits(['evt1']);



</script>

<template>
  <button @click="$emit('evt1',1)">按钮</button>
</template>

<style></style>