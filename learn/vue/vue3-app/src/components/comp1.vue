<script setup>
import { ref } from 'vue'

const count = ref(0)
</script>

<template>
    <button @click="count++">点击了 {{ count }} 次</button>
</template>