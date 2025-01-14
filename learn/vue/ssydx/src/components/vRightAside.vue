<script setup>
import { onMounted, ref,defineProps } from 'vue';
const rightData = defineProps({
    sections: {

    },
})
const actEle = ref('');
const actEvt = function(evt) {
    actEle.value = evt.target.getAttribute('href').slice(1);
}
// 点击两次才能切换
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
            <a :href="'#' + item.id" :class="{ active: actEle === item.id}" @click="actEvt">{{ item.title }}</a>
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
    color: rgb(128, 128, 128);
    height: 1.5rem;
}
a.active {
    font-weight: 600;
    color: var(--tt-color);
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