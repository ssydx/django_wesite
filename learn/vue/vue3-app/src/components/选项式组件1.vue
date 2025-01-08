<script>
export default {
    // 组件名称
    name: 'optionsComponent1',
    // 从父组件接收的属性
    props:['fatherval1','fatherval2'],
    // 组件属性
    data: function() {
        return {
            stuClass: this.fatherval1 + ': ' + this.fatherval2 ,
            stuName: 'zhangsan',
            stuAge: 20,
            stuHobbies: ['novel','manga','program'],
            stuScore: {
                math: 89,
                chinese: 92,
                english: 74,
            },
        }
    },
    // 计算属性
    computed: {
        // 只读计算属性
        getScoreLevel: function() {
            let scoreCnt = 0;
            for (const item in this.stuScore) {
                scoreCnt += this.stuScore[item];
            }
            if (scoreCnt > 250) {
                return 'excellent';
            } else if (scoreCnt > 200) {
                return 'good';
            } else {
                return 'bad';
            }
        },
        // 可读可写属性，即getter + setter
        getSetAge: {
            get() {
                return this.stuAge + '岁';
            },
            set(newval) {
                if (typeof newval === 'number') {
                    this.stuAge = newval;
                } else {
                    console.warn('数据类型错误');
                }
            }
        },
        // 嵌套计算属性
        getAssess() {
            return this.stuName + '获得了 ' + this.getScoreLevel + ' 的评价';
        }

    },
    methods: {
        greeting() {
            console.log('hello world');
        },
        hasHobbies(hobby) {
            if (this.stuHobbies.includes(hobby)) {
                return '拥有此属性';
            } else {
                return '没有此属性';
            }
        },
        updateName: function(evt) {
            this.stuName = evt.target.value;
        },
    },
}
</script>

<template>
    <p>选项式组件1</p>
    <h2>属性类</h2>
    <!-- 组件自身的属性1 -->
    <div>{{ stuName }}</div>
    <!-- 组件自身的属性2 -->
    <div>{{ stuHobbies[1] }}</div>
    <!-- 组件自身的属性3 -->
    <div>{{ stuScore.math }}</div>
    <!-- 从父组件接收的属性1 -->
    <div>{{ fatherval1 }}</div>
    <!-- 从父组件接收的属性1 -->
    <div>{{ fatherval2 }}</div>
    <!-- 组件自身的属性4，但该属性由来自父组件的属性组合而成 -->
    <div>{{ stuClass }}</div>
    <h2>方法类</h2>
    <!-- 只读计算属性 -->
    <div>{{ getScoreLevel }}</div>
    <!-- 可读可写计算属性 -->
    <div>{{ getSetAge=18 }}</div>
    <div>{{ getSetAge='123' }}</div>
    <div>{{ getSetAge }}</div>
    <!-- 嵌套计算属性 -->
    <div>{{ getAssess }}</div>
    <!-- 方法1 -->
    <div v-if="greeting()"></div>
    <!-- 方法2 -->
    <div>{{ hasHobbies('novel') }}</div>
    <!-- 方法3 -->
    <input type="text" @change="updateName($event)">
</template>

<style>

</style>