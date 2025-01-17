<script setup>
import { defineProps,ref } from 'vue';
const props = defineProps({
    dropdownName: {
        type: String,
        default: '链接',
    },
    dropdownList: {
        type: Array,
        default: [
            {title:'分组1', link: '', type: 'group'},
            {title:'项目1', link: '#', type: 'item'},
            {title:'项目2', link: '#', type: 'item'},
            {title:'项目3', link: '#', type: 'item'},
            {title:'项目4', link: '#', type: 'item'},
            {title:'分组1', link: '', type: 'group'},
            {title:'项目1', link: '#', type: 'item'},
            {title:'项目2', link: '#', type: 'item'},
            {title:'项目3', link: '#', type: 'item'},
            {title:'项目4', link: '#', type: 'item'},
            {title:'项目5', link: '#', type: 'item'},
            {title:'项目6', link: '#', type: 'item'},
            {title:'分组1', link: '', type: 'group'},
            {title:'项目1', link: '#', type: 'item'},
            {title:'项目2', link: '#', type: 'item'},
            {title:'项目3', link: '#', type: 'item'},
        ],
    }
})
</script>

<template>

<div class="dropdown">
    <span class="dropdownName">
        <slot name="name">
            {{ dropdownName }}
        </slot>
        <slot name="tag">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" height="1em">
                <path d="M12,16c-0.3,0-0.5-0.1-0.7-0.3l-6-6c-0.4-0.4-0.4-1,0-1.4s1-0.4,1.4,0l5.3,5.3l5.3-5.3c0.4-0.4,1-0.4,1.4,0s0.4,1,0,1.4l-6,6C12.5,15.9,12.3,16,12,16z"></path>
            </svg>
        </slot>
    </span>
    <span class="dropdownHelper"></span>
    <ul class="dropdownList">
        <li v-for="item in props.dropdownList">
            <div v-if="item.type === 'group'">{{ item.title }}</div>
            <a v-else :href="item.link">{{ item.title }}</a>
        </li>
    </ul>
</div>
</template>

<style scoped lang="scss">
.dropdown {
    position: relative;
    &:hover {
        > .dropdownName {
            color: grey;
        }
        > .dropdownHelper {
            visibility: visible;
        }
        > .dropdownList {
            visibility: visible;
            opacity: 1;
            transform: translateY(0);
            transition: all 0.25s;
        }
    }
    > .dropdownName {
        display: flex;
        align-items: center;
        height: 1em;
        cursor: pointer;
    }
    > .dropdownHelper {
        visibility: hidden;
        position: absolute;
        top: 100%;
        height: 1em;
        left: 0;
        width: 100%;
    }
    > .dropdownList {
        visibility: hidden;
        opacity: 0;
        transform: translateY(-1em);
        position: absolute;
        top: calc(100% + 1em);
        max-height: calc(100vh - 6em);
        right: 0;
        min-width: 10em;
        padding: 1em;
        margin: 0;
        border-radius: 0.5em;
        box-shadow: 0 0 0.5em -0.25em grey;
        overflow-y: auto;
        background-color: var(--bg-color);
        color: var(--tt-color);
        > li {
            > * {
                width: 100%;
            }
            > div {
                    font-weight: 600;
                    position: relative;
                }
            &:not(:last-child) {
                margin-bottom: 0.5em;
                & ~ li > div::before {
                    content: '';
                    position: absolute;
                    top:-0.5px;
                    width: 100%;
                    height: 1px;
                    background-color: grey;
                }
            }
            &:not(:first-child) > div {
                padding-top: 0.5em;
            }
        }
    }

}
</style>