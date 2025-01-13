<script setup>
import { onMounted, ref,defineProps } from 'vue';
const rightData = defineProps({
    sections: {

    },
})
const actEle = ref('');
onMounted(() => {
  window.addEventListener('scroll', () => {
    rightData.sections.forEach((item) => {
        if (window.scrollY + 80 > document.getElementById(item.id).offsetTop) {
            actEle.value = item.id;
        }
    })
  });
});
</script>

<template>
<aside>
    <h5>本页目录</h5>
    <ul>
        <li v-for="item in sections">
            <a :href="'#' + item.id" :class="{ active: actEle === item.id}">{{ item.title }}</a>
        </li>
    </ul>
</aside>
</template>

<style scoped>
aside {
    flex: 0 0 auto;
    margin-top: 1rem;
    padding: 1rem;
    width: 200px;
    height: calc(100vh - 6rem);
    overflow-y: auto;
    position: sticky;
    top: 3rem;
}
li {
    margin-bottom: 0.5rem;
}
a {
    text-decoration: none;
    color: rgb(70, 70, 70);
    height: 1.5rem;
    line-height: 1.5rem;
}
a.active {
    font-weight: 900;
    position: relative;
}
a.active::before {
    content: '';
    display: inline-block;
    width: 0.25rem;
    height: 1rem;
    background-color: aqua;
    position: absolute;
    left: -1rem;
    top: 0.25rem;
    border-radius: 0.25rem;
}
@media (max-width: 1200px) {
    aside {
        display: none;
    }
}
</style>