<script>
    export default {
        inheritAttrs: false,
    }
</script>
<script setup>
import { defineProps, computed, defineEmits } from 'vue';
const props = defineProps({
    switchHeight: {
        type: String,
        default: '1.5em',
    },
    switchWidth: {
        type: String,
        default: '3em',
        validator(value, props) {
            if (value < props.switchHeight) {
                return false;
            } else {
                return true;
            };
        },
    },
    beforeSwitchBgColor: {
        type: String,
        default: 'rgb(230,230,230)'
    },
    afterSwitchBgColor: {
        type: String,
        default: 'rgb(50,50,50)'
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
    <label for="switch" v-bind="$attrs">
        <span></span>
    </label>
</div>
</template>

<style scoped lang="scss">
* {
    box-sizing: border-box;
}
div {
    display: flex;
    align-items: center;
}
input {
    display: none;
}
label {
    width: v-bind('switchWidth');
    height: v-bind('switchHeight'); 
    border: calc(0.05 * v-bind('switchHeight')) solid rgba(128, 128, 128, 0.5);
    border-radius: calc(0.5 * v-bind('switchHeight'));
    background-color: v-bind('beforeSwitchBgColor');
    display: flex;
    align-items: center;
    &:hover {
        border: calc(0.05 * v-bind('switchHeight')) solid rgb(128, 128, 128);
        transition: all 0.3s;
    }
    > span {
        display: inline-block;
        width: calc(0.8 * v-bind('switchHeight'));
        height: calc(0.8 * v-bind('switchHeight'));
        border-radius: calc(0.4 * v-bind('switchHeight'));
        background-image: v-bind(leftImg);
        background-repeat: no-repeat;
        background-position: center;
        background-size: contain;
        background-color: var(--bg-color);
        margin-left: calc(0.05 * v-bind('switchHeight'));
        transition: all 0.3s ease-in-out;
    }
}
input:checked ~ label {
    background-color: v-bind('afterSwitchBgColor');
    > span {
        background-image: v-bind(rightImg);
        background-color: var(--bg-color);
        margin-left: calc(v-bind('switchWidth') - 0.95 * v-bind('switchHeight'));
    }
}
</style>
