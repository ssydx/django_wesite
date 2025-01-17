<script setup>
import vSwitchButton from './vSwitchButton.vue';
import vDropdown from './vDropdown.vue';
import vLink from './vLink.vue';
import vNavBar from './vNavBar.vue';
const switchData = {
    switchHeight: '8rem',
    switchWidth: '8rem',
}
</script>

<template>
<div class="c">
    <vSwitchButton></vSwitchButton>
    <vDropdown></vDropdown>
    <vNavBar></vNavBar>
</div>

</template>

<style scoped lang="scss">
.c {
    display: flex;
    flex-direction: column;
    align-items: center;
}

</style>