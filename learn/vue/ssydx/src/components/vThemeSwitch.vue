<script setup>
import { ref, defineProps, computed, defineEmits } from 'vue';
const props = defineProps({
    height: {
        type: String,
        default: '1.5rem',
    },
    width: {
        type: String,
        default: '3rem',
    },
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
    <label for="switch">
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
            width: v-bind('props.width');
            height: v-bind('props.height');
            border: calc(v-bind('props.height') / 20) solid rgba(128, 128, 128, 0.5);
            border-radius: calc(v-bind('props.height') / 2);
            display: flex;
            align-items: center;
            background-color: rgb(230, 230, 230);
            &:hover {
                border: calc(v-bind('props.height') / 20) solid rgb(128, 128, 128);
                transition: all 0.3s;
            }
            > span {
                display: inline-block;
                width: calc(v-bind('props.height') / 10 * 8);
                height: calc(v-bind('props.height') / 10 * 8);
                border-radius: calc(v-bind('props.height') / 20 * 8);
                background: v-bind(leftImg) no-repeat center/contain var(--bg-color);
                margin-left: calc(v-bind('props.height') /10);
                transition: all 0.3s ease-in-out;
            }
        }
        &:checked ~ label {
            background-color: rgb(50, 50, 50);
            > span {
            background: v-bind(rightImg) no-repeat center/contain var(--bg-color);
            margin-left: calc(v-bind('props.width') - v-bind('props.height'));
        }
        }
    }
}



</style>
