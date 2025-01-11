<script>
import vbind from './属性绑定.vue';
import von from './事件绑定.vue';
import vmodel from './表单绑定.vue';
import vslot from './插槽绑定.vue';
export default {
    components: {
        vbind,
        von,
        vmodel,
        vslot,
    },
    data() {
        return {
            curcomp: 'vbind',
            comps: ['vbind','von','vmodel','vslot']
        }
    }
}
</script>

<template>
<h1>特殊属性</h1>
<button class="tab-pane" v-for="comp in comps" :key="comp" @click="curcomp = comp">{{ comp }}</button>
<!-- 虽然is可以使用字符串，但必须是在选项式中进行注册之后 -->
<component :is="curcomp" class="tab-content"></component>
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