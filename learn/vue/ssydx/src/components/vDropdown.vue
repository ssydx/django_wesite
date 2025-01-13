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
    <a>
        <div>{{ props.dropdownName }}</div>
        <svg xmlns="http://www.w3.org/2000/svg" aria-hidden="true" focusable="false" viewBox="0 0 24 24" class="vt-flyout-button-text-icon" width="16px">
            <path d="M12,16c-0.3,0-0.5-0.1-0.7-0.3l-6-6c-0.4-0.4-0.4-1,0-1.4s1-0.4,1.4,0l5.3,5.3l5.3-5.3c0.4-0.4,1-0.4,1.4,0s0.4,1,0,1.4l-6,6C12.5,15.9,12.3,16,12,16z"></path>
        </svg>
    </a>
    <ul>
        <li v-for="item in props.dropdownList">
            <div v-if="item.type === 'group'">{{ item.title }}</div>
            <a v-else :href="item.link">{{ item.title }}</a>
        </li>
    </ul>
</div>
</template>

<style scoped lang="scss">
div.dropdown {
    display: flex;
    flex-flow: row nowrap;
    align-items: center;
    justify-content: flex-start;
    gap: 0 1rem;
    position: relative;
    > * {
        flex: 0 0 auto;
    }
    > a {
        height: 3rem;
        display: flex;
        align-items: center;
        &:hover {
            font-weight: 600;
            & ~ ul {
                visibility: visible;
                opacity: 1;
            }
        }
    }
    > ul {
        &:hover {
            visibility: visible;
            opacity: 1;
        }
        position: absolute;
        top: calc(100%);
        left: 100%;
        transform: translateX(-100%);
        margin: 0;
        padding: 1rem;
        width: 11rem;
        max-height: calc(100vh - 200% - 1rem);
        overflow-y: auto;
        background-color: var(--bg-color);
        color: var(--tt-color);
        border-radius: 0.5rem;
        box-shadow: 0 0 0.5rem -0.25rem black;
        visibility: hidden;
        opacity: 0;
        transition: opacity 0.3s ease-in-out;
        > li {
            > a:hover {
                font-weight: 600;
            }
            &:not(:last-child) {
                margin-bottom: 0.5rem;
                > div {
                    font-weight: 600;
                }
                & ~ li > div {
                    border-top: 1px solid black;
                }
            }
            &:not(:first-child) > div {
                padding-top: 0.5rem;
            }
        }
    }
}
</style>