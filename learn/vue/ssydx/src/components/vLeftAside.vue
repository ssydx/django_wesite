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
    width: 20rem;
    height: calc(100vh - 48px);
    overflow-y: auto;
    position: fixed;
    top: 48px;
    color: var(--tt-color);
    background-color: var(--bg-color);
}
div {
    display: flex;
    flex-flow: row nowrap;
    align-items: center;
    justify-content: space-between;
    gap: 0 1rem;
    position: sticky;
    top: 0;
    padding: 2rem 0;
    margin-top: 1rem;
    background-color: var(--bg-color);
    border-bottom: 1px solid rgb(128, 128, 128);
}
div > input {
    flex: 1 1 auto;
    border: 1px solid var(--tt-color);
    border-radius: 1rem;
    padding: 0.25rem 0.5rem;
}
div > button {
    border: 1px solid var(--tt-color);
    border-radius: 3px;
    background-color: rgb(128, 128, 128);
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
ul {
    padding-top: 1rem;
}
li:not(:last-child) {
    margin-bottom: 0.5rem;
}
a {
    color: rgb(128, 128, 128);
    padding-left: 1rem;
}
span {
    font-weight: 900;
}
a:hover {
    color: var(--tt-color);
    font-weight: 600;
}
@media (max-width: 900px) {
    aside {
        display: none;
    }
}
</style>