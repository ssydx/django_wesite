<script setup>
import vRightAside from './vRightAside.vue';
import { defineProps,ref } from 'vue';
defineProps({
    mainData: {
        type: Object,
        required:true,
    },
})
const links = ref([]);
mainData.sections.value.forEach(
    
)

</script>

<template>
<div>
    <main>
        <section v-for="item in $props.mainData.sections" :id="item.id">
            <hgroup>
                <h2>{{ item.title }}</h2>
                <p v-if="item.subtitle">{{ item.subtitle }}</p>
            </hgroup>
            <p v-for="para in item.content">{{ para }}</p>
        </section>
    </main>
    <vRightAside></vRightAside>
</div>
</template>

<style scoped>
div {
    display: flex;
    flex-flow: row nowrap;
    align-items: flex-start;
    justify-content: space-between;
    gap: 0 2rem;
}
main {
    flex: 1 1 auto;
    margin-top: 1rem;
    margin-left: 300px;
    padding: 1rem;
}
section {
    scroll-margin-top: 48px;
}
@media (max-width: 900px) {
    main {
        margin-left: 0;
    }
}
</style>