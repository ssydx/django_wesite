<script setup>
import { ref } from 'vue';
const val = ref('');
const txt = ref('');
const chkval = ref(true);
const chk = ref(true);
const pickedval = ref('One1');
const picked = ref('One');
const sltval = ref('1');
const slt = ref('1');

</script>

<template>
<div>
<h1>v-model</h1>
<!-- 输入框 -->
<label for="id1">{{ val }}</label>
<input type="search" id="id1" :value="val" @input="val = $event.target.value">
<hr>
<label for="id2">{{ txt }}</label>
<input type="search" id="id2" v-model="txt">
<hr>
<!-- 复选框 -->
<label for="id3" v-if="chkval">标签</label>
<input type="checkbox" id="id3" :checked="chkval" @click="chkval = $event.target.checked">
<hr>
<label for="id4" v-if="chk">标签</label>
<input type="checkbox" id="id4" v-model="chk">
<hr>
<!-- 单选框 -->
<input type="radio" id="one1" value="One1" :checked="pickedval === 'One1'" @change="pickedval = $event.target.value">
<label for="one1">One1</label>
<input type="radio" id="two1" value="Two1" :checked="pickedval === 'Two1'" @change="pickedval = $event.target.value">
<label for="two1">Two1</label>
<span>{{ pickedval }}</span>
<hr>
<input type="radio" id="one" value="One" v-model="picked">
<label for="one">One</label>
<input type="radio" id="two" value="Two" v-model="picked">
<label for="two">Two</label>
<span>{{ picked }}</span>
<hr>
<label for="id7">{{ sltval }}</label>
<select id="id7" :value="sltval" @change="sltval = $event.target.value">
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
</select>
<hr>
<label for="id8">{{ slt }}</label>
<select id="id8" v-model="slt">
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
</select>
</div>

</template>

<style>
.div1 {
    background-color: blue;
}
.div2 {
    padding-left: 2rem;
}
#div1 {
    color: red;
}
</style>