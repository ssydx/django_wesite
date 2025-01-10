<script setup>
import { ref } from 'vue';
import vbind from './属性绑定.vue';
import von from './事件绑定.vue';
import vmodel from './表单绑定.vue';
import vslot from './插槽绑定.vue';
const val1 = ref(89);
const val2 = ref(0);
const html = ref('<button>按钮</button>')
const items = ref([
    {id:1,name:'a'},
    {id:2,name:'b'},
    {id:3,name:'c'},
]);
const comps = {
    vbind,
    von,
    vmodel,
    vslot,
};
const curcomp = ref('vbind');
</script>

<template>
<h1>特殊属性</h1>
<button class="tab-pane" v-for="(_,comp) in comps" :key="comp" @click="curcomp = comp">{{ comp }}</button>
<component :is="comps[curcomp]" class="tab-content"></component>



</template>

<style>
.tab-pane {
    margin: 1rem;
    padding: 0.5rem;
    border-radius: 30% 0%;
    background-color: aqua;
    border: none;
    font-size: 1.5rem;
}
.tab-content {
    border-top: 3px solid grey;
}
</style>