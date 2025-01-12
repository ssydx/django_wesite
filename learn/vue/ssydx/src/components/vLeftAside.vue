<script setup>
import { defineProps, ref, watch } from 'vue';
const AsideData = defineProps({
    asideList: {
        type: Object,
        required: true,
    }
});
const filterVal = ref('');
let filteredList = ref(AsideData.asideList);
watch(filterVal,(newVal, oldVal) => {
    filteredList.value = AsideData.asideList.filter(function(val) {
        if (val.isGroup && newVal) {
            return false;
        }
        return val.title.search(newVal) == -1 ? false:true;
    })
});
function resetFilterVal() {
    filterVal.value = '';
}
</script>

<template>
<aside>
    <div>
        <input type="text" v-model="filterVal">
        <button type="reset" @click="resetFilterVal">重置</button>
    </div>
    <TransitionGroup name="list" tag="ul">
        <li v-for="item in filteredList" :key="item.title">
            <span v-if="item.isGroup">{{ item.title }}</span>
            <a :href="item.link" v-else>{{ item.title }}</a>
        </li>
    </TransitionGroup>
</aside>
</template>

<style scoped>
aside {
    padding: 1rem;
    padding-top: 0;
    width: 300px;
    height: calc(100vh - 48px);
    overflow-y: auto;
    position: fixed;
    top: 48px;
}
div {
    display: flex;
    flex-flow: row nowrap;
    align-items: center;
    justify-content: space-between;
    gap: 0 1rem;
    position: sticky;
    top: 0;
    padding: 1rem 0;
    margin-top: 2rem;
    border-bottom: 1px solid rgb(100, 100, 100);
    background-color: white;
}
div > input {
    flex: 1 1 auto;
    border: 1px solid black;
    border-radius: 1rem;
    padding: 0.25rem 0.5rem;
}
div > button {
    border: 1px solid black;
    border-radius: 3px;
    background-color: rgb(199, 199, 199);
}
ul {
    padding: 0;
}
li {
    list-style: none;
}
.list-move,
.list-enter-active,
.list-leave-active {
  transition: all 0.3s cubic-bezier(0.075, 0.82, 0.165, 1);
}
.list-enter-from,
.list-leave-to {
  opacity: 0;
  transform: translateY(50px);
}
li > * {
    display: inline-block;
    margin-bottom: 0.5rem;
}
a {
    text-decoration: none;
    color: rgb(70, 70, 70);
    text-indent: 1rem;
}
span {
    font-weight: 900;
}
a:hover {
    color: black;
    font-weight: 600;
}
@media (max-width: 900px) {
    aside {
        display: none;
    }
}
</style>