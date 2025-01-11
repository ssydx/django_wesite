<script setup>
import { ref } from 'vue';
const show1 = ref(true);
const show2 = ref(true);
const items = ref(['a','b','c','d']);
function add(str) {
    items.value.push(str);
}
function del() {
    items.value.pop();
}
function ins(str) {
    items.value.splice(1,0,str);
}
function rem() {
    items.value.splice(2,1);
}
const open = ref(false);

</script>

<template>
<h1>内置组件</h1>

<button @click="show1 = !show1">Toggle</button>
<Transition>
  <p v-if="show1">hello</p>
</Transition>
<hr>
<input type="checkbox" class="translab">
<div class="trans">world</div>
<hr>
<button @click="show2 = !show2">Toggle</button>
<Transition name="fade">
    <p v-if="show2">段落</p>
</Transition>
<hr>
<button @click="add('123')">尾插</button>
<button @click="del()">尾删</button>
<button @click="ins('abc')">插入</button>
<button @click="rem()">删除</button>
<TransitionGroup name="list" tag="ul">
  <li v-for="item in items" :key="item">
    {{ item }}
  </li>
</TransitionGroup>
<button @click="open = true">Open Modal</button>

<Teleport to="body">
  <div v-if="open" class="modal">
    <p>Hello from the modal!</p>
    <button @click="open = false">Close</button>
  </div>
</Teleport>

</template>


<style scoped>
h1 {
    text-align: center;
    border-bottom: 3px solid gray;
    margin-bottom: 1rem;
}

.v-enter-active,
.v-leave-active {
  transition: opacity 0.5s ease;
}
.v-enter-from,
.v-leave-to {
  opacity: 0;
}

.trans {
    transition: opacity 0.5s ease;
}
.translab:checked ~ .trans {
    opacity: 0;
}

.fade-enter-active {
    transition: opacity 0.5s ease;
}
.fade-leave-active {
    transition: opacity 3s cubic-bezier(0.075, 0.82, 0.165, 1);
}
.fade-enter-from {
    opacity: 0.3;
}
.fade-leave-to {
    opacity: 0;
}

.list-move,
.list-enter-active,
.list-leave-active {
  transition: all 3s ease;
}
.list-enter-from,
.list-leave-to {
  opacity: 0;
  transform: translateX(100px);
}
.modal {
  position: fixed;
  z-index: 999;
  top: 20%;
  left: 50%;
  width: 300px;
  margin-left: -150px;
  background-color: white;
  box-shadow: 1px 1px 1px grey;
  border: 1px solid black;
  border-radius: 10px;
  padding: 10px;
}
</style>