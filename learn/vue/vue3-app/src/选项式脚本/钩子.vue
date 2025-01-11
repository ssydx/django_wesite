<!-- 钩子初探 -->
<script>
export default {
    // 组件名称
    name: 'optionsComponent4',
    // 从父组件接收的属性
    props:['fatherval'],
    // 组件属性
    data() {
        return {
            a: 1,
            b: 2,
        }
    },
    // 从祖先组件接收的属性
    inject: ['sendtograndson2'],
    // 组件方法
    methods: {
        print() {
            console.log(this);
        },
        add() {
            this.a++;
        },
        fetchData() {
            return new Promise((resolve) => {
                setTimeout(() => {
                    resolve(5);
                }, 1000);
            });
        }
    },
    // 钩子
    beforeCreate() {
        // 
        console.group('beforeCreate');
        console.log('this', this);
        console.log('this.$options', this.$options);
        console.log('this.$props', this.$props);
        console.log('this.$attrs', this.$attrs);
        console.log('this.$data', this.$data);
        console.log('this.$el', this.$el);
        console.groupEnd();
    },
    created() {
        console.group('created');
        console.log('this', this);
        console.log('this.$options', this.$options);
        console.log('this.$props', this.$props);
        console.log('this.$attrs', this.$attrs);
        console.log('this.$data', this.$data);
        console.log('this.$el', this.$el);
        console.groupEnd();
        this.fetchData().then(data => {
            this.b = data;
            console.log('Initial data fetched:', data);
        });
    },
    beforeMount() {
        console.group('beforeMount');
        console.log('this', this);
        console.log('this.$options', this.$options);
        console.log('this.$props', this.$props);
        console.log('this.$attrs', this.$attrs);
        console.log('this.$data', this.$data);
        console.log('this.$el', this.$el);
        console.groupEnd();
    },
    mounted() {
        console.group('mounted');
        console.log('this', this);
        console.log('this.$options', this.$options);
        console.log('this.$props', this.$props);
        console.log('this.$attrs', this.$attrs);
        console.log('this.$data', this.$data);
        console.log('this.$el', this.$el);
        console.groupEnd();
        this.intervalId = setInterval(() => {
            this.add();
        }, 10000);
    },
    beforeUpdate() {
        console.group('beforeUpdate');
        console.log('this', this);
        console.log('this.$options', this.$options);
        console.log('this.$props', this.$props);
        console.log('this.$attrs', this.$attrs);
        console.log('this.$data', this.$data);
        console.log('this.$el', this.$el);
        console.groupEnd();
    },
    updated() {
        console.group('updated');
        console.log('this', this);
        console.log('this.$options', this.$options);
        console.log('this.$props', this.$props);
        console.log('this.$attrs', this.$attrs);
        console.log('this.$data', this.$data);
        console.log('this.$el', this.$el);
        console.groupEnd();
    },
    beforeUnmount() {
        console.log('beforeUnmount');
    },
    unmounted() {
        console.log('unmounted');
    },
    // errorCaptured(err, vm, info) {
    //     console.error('ErrorCaptured:', err, vm, info);
    //     return false; // 返回 true 表示继续向上传播，false 则阻止传播
    // }
}
</script>

<template>
    <!-- 作为选项式的子组件 -->
    <!-- 层传 -->
    <div>{{ fatherval }}</div>
    <!-- 透传 -->
    <div v-bind="$attrs">{{ sendtograndson2 }}</div>
    <!-- 属性 -->
    <div>{{ a }}</div>
    <!-- 属性 -->
    <div>{{ b }}</div>
    <!-- 方法 -->
    <div v-if="print()"></div>
    <!-- 方法 -->
    <button @click="add">增加</button>
</template>

<style>

</style>