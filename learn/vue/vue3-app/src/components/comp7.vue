<script setup>
import { defineProps } from 'vue';
defineProps({
  name: String,
  age: {
    type:Number,
    default:20,
  },
  note: [String,Number],
})



</script>

<template>
  <div>{{ name }}: {{ age }} -- {{ note }}</div>
</template>

<style></style>