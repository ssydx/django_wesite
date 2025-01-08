
<script setup>

</script>

<template>
  <div>
    <slot :count="1">123</slot>
  </div>
  <header>
    <slot name="header" class="class1"></slot>
  </header>
  <main>
    <slot name="main"></slot>
  </main>
  <footer>
    <slot name="footer"></slot>
  </footer>
</template>

<style></style>