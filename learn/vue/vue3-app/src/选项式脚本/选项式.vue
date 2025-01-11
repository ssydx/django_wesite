<script>
// 载入组件
import optionsComponent1 from './选项式组件1.vue';
import optionsComponent2 from './选项式组件2.vue';
import hooks from './钩子.vue';
import model from './自定义表单.vue';
import evt from './自定义事件.vue';
import wtc from './侦听.vue';
import chaos from './混合API.vue';
export default {
    // 组件名称
    name: 'options',
    // 注册组件
    components: {
        optionsComponent1,
        optionsComponent2,
        hooks,
        model,
        evt,
        wtc,
        chaos,
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
            message1: '请输入1',
            message2: '请输入2',
            message3: '请输入3',
            fs: 1,
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
    <h2>钩子</h2>
    <!-- 使用组件 -->
    <!-- <hooks fatherval="gcgl" :class="class2"></hooks> -->
    <hr>


    <h2>自定义表单</h2>
    <!-- 使用组件 -->
    <model v-model="message1" v-model:value="message2" v-model:val="message3"></model>
    <!-- 本质是如下，事件名限定为update:形式，这也是无法修改为其他形式的原因 -->
    <!-- <model :modelValue="message" @update:modelValue="newValue => message = newValue"></model> -->
    <div>父组件：{{ message1 }}</div>
    <div>父组件：{{ message2 }}</div>
    <div>父组件：{{ message3 }}</div>
    <hr>


    <h2>自定义事件</h2>
    <div :style="{fontSize: fs + 'rem'}">示例文本</div>
    <evt @enlarge="fs += 0.1" @smaller="fs -= 0.1" @print="(val,val1,val2) => console.log(val,val1,val2)"></evt>
    <hr>


    <h2>侦听</h2>
    <wtc></wtc>
    <hr>


    <h2>混合</h2>
    <!-- 使用组件 -->
    <!-- <chaos fatherval1="gcgl" fatherval2="tmgc" :class="class2">
        默认插槽
        <template v-slot:header>头部插槽</template>
    </chaos> -->
    <hr>
</template>

<style>

</style>