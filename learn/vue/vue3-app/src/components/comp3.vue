<template>
  <div class="alert-box">
    <strong style="font-size: 24px;">Error!</strong>
    <div><slot /></div>
  </div>
</template>

<style scoped>
.alert-box {
  border: 1px solid rgb(200,0,0);
  background: red;
  border-radius: 5px;
  padding: 5px;
  margin: 5px;
  display:flex;
  flex-direction: column;
  row-gap: 1rem;

}
.alert-box * {
  color: white;
}
</style>