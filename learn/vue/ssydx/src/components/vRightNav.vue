<script setup>
import { defineProps, onMounted } from 'vue';
import vThemeSwitch from './vThemeSwitch.vue';
import vNavBar from './vNavBar.vue';
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
    <vNavBar :nav-list="navRightData.navList"></vNavBar>
    <vThemeSwitch @switch="switchTheme"></vThemeSwitch>
</div>
</template>

<style scoped lang="scss">
div.rightNav {
    display: flex;
    flex-flow: row nowrap;
    align-items: center;
    gap: 0 2rem;
    > * {
        flex: 0 0 auto;
    }
}

</style>