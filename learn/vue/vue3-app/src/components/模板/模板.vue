<script setup>
import vbind from './属性绑定.vue';
import von from './事件绑定.vue';
import vmodel from './表单绑定.vue';
import vslot from './插槽绑定.vue';
import vstate from './语句绑定.vue';
import vother from './其他绑定.vue';
import speattr from './特殊属性.vue';

</script>

<template>
<div class="order1">
    <vbind></vbind>
</div>
<div class="order2">
    <von></von>
</div>
<div class="order3">
    <vmodel></vmodel>
</div>
<div class="order4">
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
<div class="order5">
    <vstate></vstate>
</div>
<div class="order6">
    <vother></vother>
</div>
<div class="order">
    <speattr></speattr>
</div>

</template>

<style>
body {
    background-color: white;
    color: black;
}
.order1 {
    display: none;
}
.order2 {
    display: none;
}
.order3 {
    display: none;
}
.order4 {
    display: none;
}
.order5 {
    display: none;
}
.order6 {
    display: none;
}
</style>