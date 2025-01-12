<script setup>
import { onMounted, ref } from 'vue';
const hash = ['home1','home2','home3','home4',];
const actEle = ref('');
onMounted(() => {
  window.addEventListener('scroll', () => {
    hash.forEach((item) => {
        if (window.scrollY + window.innerHeight/2 > document.getElementById(item).offsetTop) {
            actEle.value = '#' + item;
        }
    })
  });
  // 初始化时检查一次

});
</script>

<template>
<aside>
    <h6>本页目录</h6>

    <ul>
        <span></span>
        <li>
            <a href="#home1" :class="{ active: actEle === '#home1'}">1</a>
        </li>
        <li>
            <a href="#home2" :class="{ active: actEle === '#home2'}">2</a>
        </li>
        <li>
            <a href="#home3" :class="{ active: actEle === '#home3'}">3</a>
        </li>
        <li>
            <a href="#home4" :class="{ active: actEle === '#home4'}">4</a>
        </li>
    </ul>
</aside>
</template>

<style scoped>
aside {
    flex: 0 0 auto;
    padding: 1rem;
    width: 200px;
    height: calc(100vh - 48px - 1rem);
    overflow-y: auto;
    position: sticky;
    margin-top: 1rem;
    top: 48px;
}
ul {
    padding: 0;
}
li {
    list-style: none;
}
li > * {
    display: inline-block;
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