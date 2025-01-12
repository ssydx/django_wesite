<script setup>
import { defineProps } from 'vue';
const navRightData = defineProps({
    navList: {
        type: Object,
        required: true,
    },
    navOther: {

    },
});
</script>

<template>
<ul>
    <li v-for="navitem in navRightData.navList">
        <a :href="navitem.link">{{ navitem.title }}</a>
    </li>
    <li v-if="navRightData.navOther">{{ navRightData.navOther }}</li>
</ul>
</template>

<style scoped>
ul {
    flex: 1 0 auto;
    display: flex;
    flex-flow: row nowrap;
    align-items: center;
    justify-content: flex-end;
    gap: 0 1rem;
}
li {
    list-style: none;
    flex: 0 0 auto;
}
a {
    text-decoration: none;
    color: black;
}
a:hover {
    font-weight: 900;
}
</style>