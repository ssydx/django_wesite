<script>
    export default {
        inheritAttrs: false,
    }
</script>
<script setup>
import { ref, defineProps, computed, defineEmits } from 'vue';
const props = defineProps({
    leftImg: {
        type: String,
        default: 'src/assets/sun.png',
    },
    rightImg: {
        type: String,
        default: 'src/assets/moon.png',
    },

})
const leftImg = computed(() => {
    return `url(${props.leftImg})`;
})
const rightImg = computed(() => {
    return `url(${props.rightImg})`;
})
defineEmits(['switch']);
</script>

<template>
<div>
    <input type="checkbox" id="switch" @change="$emit('switch', $event)">
    <label for="switch" v-bind="$attrs">
        <span></span>
    </label>
</div>
</template>

<style scoped lang="scss">
div {
    display: flex;
    align-items: center;
    > input {
        display: none;
        & ~ label {
            width: 3em;
            height: 1.5em; 
            border: 0.05 * 1.5em solid rgba(128, 128, 128, 0.5);
            border-radius: 1em;
            display: flex;
            align-items: center;
            background-color: rgb(230, 230, 230);
            &:hover {
                border: 0.05 * 1.5em solid rgb(128, 128, 128);
                transition: all 0.3s;
            }
            > span {
                display: inline-block;
                width: 0.8 * 1.5em;
                height: 0.8 * 1.5em;
                border-radius: 0.4 * 1.5em;
                background: v-bind(leftImg) no-repeat center/contain var(--bg-color);
                margin-left: 0.05 * 1.5em;
                transition: all 0.3s ease-in-out;
            }
        }
        &:checked ~ label {
            background-color: rgb(50, 50, 50);
            > span {
            background: v-bind(rightImg) no-repeat center/contain var(--bg-color);
            margin-left: calc((1.1 - 0.05) * 1.5em);
        }
        }
    }
}
</style>
