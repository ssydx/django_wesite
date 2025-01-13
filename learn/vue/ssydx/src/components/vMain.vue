<script setup>
import vRightAside from './vRightAside.vue';
import { defineProps,ref } from 'vue';
defineProps({
    mainData: {
        type: Object,
        required:true,
    },
})

</script>

<template>
<div>
    <main>
        <header>
            <h1>{{ $props.mainData.header.title }}</h1>
            <p>{{ $props.mainData.header.subtitle }}</p>
        </header>
        <article>
            <section v-for="item in $props.mainData.sections" :id="item.id">
                <hgroup>
                    <h2>
                        <a :href="'#' + item.id"></a>
                        {{ item.title }}
                    </h2>
                    <p v-if="item.subtitle">{{ item.subtitle }}</p>
                </hgroup>
                <p v-for="para in item.content">{{ para }}</p>
                <hr>
            </section>
        </article>
        <footer>
            <span>{{ $props.mainData.footer.author }}</span>
            <address>{{ $props.mainData.footer.address }}</address>
            <time :datetime="$props.mainData.footer.timeUpdate">{{ $props.mainData.footer.timeUpdate }}</time>
        </footer>
    </main>
    <vRightAside :sections="$props.mainData.sections"></vRightAside>
</div>
</template>

<style scoped>
div {
    display: flex;
    flex-flow: row nowrap;
    align-items: flex-start;
    justify-content: space-between;
    gap: 0 1rem;
}
main {
    flex: 1 1 auto;
    margin-left: 21rem;
    padding: 1rem;
}
section {
    scroll-margin-top: 4rem;
}
section > *:not(hgroup) {
    padding-left: 1rem;
}
hgroup > * {
    padding-left: 1rem;
}
h2:hover > a {
    position: relative;
    color: black;
}
h2:hover > a::before {
    content: '#';
    position: absolute;
    left: -1.5rem;
}
footer {
    display: flex;
    flex-flow: column nowrap;
    align-items: flex-end;
    gap: .5rem 0;
}
@media (max-width: 900px) {
    main {
        margin-left: 0;
    }
}
</style>