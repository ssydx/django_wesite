<script>
import optionsComponent1 from './选项式组件1.vue';
export default {
    components: {
        optionsComponent1,
    },
    data() {
        return {
            peoNum: 43,
        }
    }
}
</script>

<template>
    <form action="#">
        <input type="search" name="q" id="" placeholder="请输入">
        <button type="submit">提交</button>
    </form>
    <hr>
    <optionsComponent1 fatherval1="gcgl" :fatherval2="peoNum"></optionsComponent1>
</template>

<style>

</style>