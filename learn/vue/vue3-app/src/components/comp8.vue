<script setup>
import { ref } from 'vue';


const props = defineProps(['age']);
const val = ref(props.age);
val.value = val.value + 20;
console.log(val.value);
console.log(props.age);


</script>

<template>
  <div>{{ age }}</div>
</template>

<style></style>