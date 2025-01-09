<script>
// 载入组件
import optionsComponent1 from './选项式组件1.vue';
import optionsComponent2 from './选项式组件2.vue';
import optionsComponent4 from './选项式组件4.vue';
import optionsComponent5 from './选项式组件5.vue';
export default {
    // 组件名称
    name: 'options',
    // 注册组件
    components: {
        optionsComponent1,
        optionsComponent2,
        optionsComponent4,
        optionsComponent5,
    },
    // 从主js文件接收的属性
    props: {
        // 限制属性类型
        fatherName: String,
        // 限制属性类型并提供默认值
        fatherAge: {
            type: Number,
            default: 52,
        },
        // 限制属性类型并声明不可省略
        fatherSex: {
            type: String,
            required: true,
        },
    },
    // 组件属性
    data() {
        return {
            peoNum: 43,
            sendtograndson1: 'hello,ssydx',
            sendtograndson3: 123456,
            class2: 'c2',
        }
    },
    // 提供属性，当前组件不可用
    provide() {
        return {
            // 静态属性值
            sendtograndson2: 'hi,ssydx',
            // 动态属性值
            sendtograndson3responive:this.sendtograndson3,
        }
    }
}
</script>

<template>
    <h1>父组件</h1>
    <!-- 从主js文件接收的属性1 -->
    <div>{{ fatherName }}</div>
    <!-- 从主js文件接收的属性2 -->
    <div>{{ fatherAge }}</div>
    <!-- 从主js文件接收的属性3 -->
    <div>{{ fatherSex }}</div>
    <hr>
    <h2>子组件1</h2>
    <!-- 使用组件 -->
    <!-- 前三项是层传，最后一项用于继承 -->
    <optionsComponent1 fatherval1="gcgl" :fatherval2="peoNum" :fathervalforgrandson="sendtograndson1" class="c1"></optionsComponent1>
    <hr>
    <h2>子组件2</h2>
    <!-- 使用组件 -->
    <optionsComponent2 fatherval="gcgl" :class="class2"></optionsComponent2>
    <h2>子组件3</h2>
    <!-- 使用组件 -->
    <!-- <optionsComponent4 fatherval="gcgl" :class="class2"></optionsComponent4> -->
    <h2>子组件4</h2>
    <!-- 使用组件 -->
    <optionsComponent5 fatherval1="gcgl" fatherval2="tmgc" :class="class2">
        默认插槽
        <template v-slot:header>头部插槽</template>
    </optionsComponent5>
    <hr>
</template>

<style>

</style>