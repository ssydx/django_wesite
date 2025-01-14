<script setup>
import { defineProps, onMounted } from 'vue';
import vDropdown from './vDropdown.vue';
import vThemeSwitch from './vThemeSwitch.vue';
const navRightData = defineProps({
    navList: {
        type: Object,
        required: true,
    },
    navOther: {

    },
});
const switchTheme = function(evt) {
    if (evt.currentTarget.checked) {
        document.body.setAttribute('data-theme','dark');
        localStorage.setItem('data-theme','dark');
    } else {
        document.body.setAttribute('data-theme', 'light');
        localStorage.setItem('data-theme','light');
    }
}
onMounted(() => {
    if (localStorage.getItem('data-theme') == 'dark') {
        document.querySelector('input[type=checkbox]').click();
    }
})
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
    <vThemeSwitch @switch="switchTheme"></vThemeSwitch>
</div>
</template>

<style scoped lang="scss">
div.rightNav {
    display: flex;
    flex-flow: row nowrap;
    align-items: center;
    justify-content: flex-end;
    gap: 0 2rem;
    > * {
        flex: 0 0 auto;
    }
    > ul {
        height: 100%;
        display: flex;
        flex-flow: row nowrap;
        align-items: center;
        justify-content: flex-start;
        > li {
            flex: 0 0 auto;
            height: 100%;
            > * {
                padding: 0 0.5rem;
            }
        }
    }
}

</style>