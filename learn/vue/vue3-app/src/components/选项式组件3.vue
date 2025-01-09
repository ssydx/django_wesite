
<script>
export default {
    // 组件名称
    name: 'optionsComponent3',
    // 从父组件接收的属性
    props: {
        grandfatherval: {
            // 必须
            required: true,
            // 类型限制为字符串
            type: String,
        },
    },
    inject: {
        sendtograndson3: {
            // 原名，默认与别名相同
            from: 'sendtograndson3responive',
            // 默认值
            default: 'hi',
            // 不支持类型检查和必须限制
        },
        son: {
            default: 'son',
        }
    }
}
</script>

<template>
    <!-- 作为选项式组件1的子组件 -->
    <div>
        <!-- 层传 -->
        <div>{{ grandfatherval }}</div>
        <!-- 透传存在的属性 -->
        <div>{{ sendtograndson3 }}</div>
        <!-- 透传不存在的属性 -->
        <div>{{ son }}</div>
    </div>
</template>

<style>

</style>