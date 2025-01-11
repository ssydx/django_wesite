<script>
export default {
  data() {
    return {
      val: 'ssydx',
      arr: [1,2,3],
    }
  },
  watch: {
    val(newval,oldval) {
      console.log(oldval);
      console.log(newval);
    },
    arr: {
      handler(newval,oldval) {
        console.log(oldval);
        console.log(newval);
      },
      deep: true,
      immediate: true,
    }
  }
};
</script>

<template>
  <div>
    <input type="text" v-model="val">
    <div>{{ val }}</div>
    <button @click="arr.push('a')">按钮</button>
    <div>{{ arr }}</div>
  </div>
</template>



<style scoped>

</style>