<script setup>
import { defineProps } from 'vue';
import vDropdown from './vDropdown.vue';
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
<div class="rightNav">
    <ul>
        <li v-for="navitem in navRightData.navList">
            <a v-if="navitem.type === 'link'" :href="navitem.link">{{ navitem.title }}</a>
            <vDropdown v-else-if="navitem.type === 'dropdown'" :dropdown-name="navitem.title" :dropdown-list="navitem.dropdownList"></vDropdown>
        </li>
        <li v-if="navRightData.navOther">{{ navRightData.navOther }}</li>

    </ul>
</div>
</template>

<style scoped lang="scss">
div.rightNav {
    display: flex;
    flex-flow: row nowrap;
    align-items: center;
    justify-content: flex-end;
    gap: 0 1rem;
    > * {
        flex: 0 0 auto;
    }
    > ul {
        display: flex;
        flex-flow: row nowrap;
        align-items: center;
        justify-content: flex-start;
        gap: 0 0.5rem;
        > li {
            flex: 0 0 auto;
            > a:hover {
                font-weight: 900;
            }
        }
    }
}

</style>