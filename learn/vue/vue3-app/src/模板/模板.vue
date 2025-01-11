<script setup>
import vbind from './属性绑定.vue';
import von from './事件绑定.vue';
import vmodel from './表单绑定.vue';
import vslot from './插槽绑定.vue';
import vstate from './语句绑定.vue';
import vother from './其他绑定.vue';
import speattr1 from './特殊属性1.vue';
import speattr2 from './特殊属性2.vue';
import comp from './内置组件.vue';

</script>

<template>
<div class="d-none">
    <vbind></vbind>
</div>
<div class="d-none">
    <von></von>
</div>
<div class="">
    <vmodel></vmodel>
</div>
<div class="d-none">
    <vslot>
        <template v-slot="aaa">
            默认插槽
            {{ aaa.userName }}
            {{ aaa.userAge }}
        </template>
        <template v-slot:header>
            header
        </template>
        <template #footer>
            footer
        </template>
        <template #main="{ name1,age }">
            main
            {{ name1 }}
            {{ age }}
        </template>
        <template #ls="{ item }">
            <p>{{ item.name }}</p>
        </template>
        <template v-slot:same="sameProps">
            <p>{{ sameProps.data.name }}</p>
        </template>
    </vslot>
</div>
<div class="d-none">
    <vstate></vstate>
</div>
<div class="d-none">
    <vother></vother>
</div>
<div id="flex-row" class="d-none">
    <div>
        <speattr1></speattr1>
    </div>
    <div>
        <speattr2></speattr2>
    </div>
</div>
<div class="d-none">
    <comp></comp>
</div>

</template>

<style>
body {
    background-color: white;
    color: black;
}
#flex-row {
    display: flex;
    flex-direction: row;
    align-items:flex-start;
    justify-content: space-between;
}
#flex-row > * {
    flex: 1 0 auto;
}
.d-none {
    display: none !important;
}
</style>