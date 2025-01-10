<!-- 混入组合式API初探 -->
<script>
import { ref } from 'vue';
export default {
    // 组件名称
    name: 'optionsComponent5',
    // 从父组件接收的属性
    props:['fatherval1','fatherval2'],
    // 从祖先组件接收的属性
    inject: ['sendtograndson2'],
    // 混入组合式API
    setup(props,context) {
        const newfatherval1 = 'zy: ' + props.fatherval1;
        const newfatherval2 = ref('yx: ' + props.fatherval1);
        console.log(context.attrs);
        console.log(context.slots);
        console.log(context.slots.default);
        console.log(context.emit);
        const setval = ref(10);
        function print() {
            console.log('hello world');
        };
        return {
            newfatherval1,
            newfatherval2,
            setval,
            print,
        }
    }
}
</script>

<template>
    <!-- 作为选项式的子组件 -->

    <div>{{ fatherval1 }}</div>
    <div>{{ fatherval2 }}</div>
    <div>{{ newfatherval1 }}</div>
    <div>{{ newfatherval2 }}</div>
    <div>{{ setval }}</div>
    <div v-if="print()"></div>

    <div v-bind="$attrs">{{ sendtograndson2 }}</div>
    <header>
        <slot name="header"></slot>
    </header>
    <div>
        <slot></slot>
    </div>
</template>

<style>

</style>