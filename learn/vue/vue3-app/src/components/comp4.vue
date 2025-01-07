<script setup>
import Home from './comp1.vue'
import Posts from './comp2.vue'
import Archive from './comp3.vue'
import { ref } from 'vue'
 
const currentTab = ref('Home')
// 组件对象列表
const tabs = {
  Home,
  Posts,
  Archive,
}
</script>

<template>
  <div class="demo">
    <!-- 对每个按钮添加类和事件 -->
    <!-- 点击事件后将currenttab设置为当前按钮 -->
    <!-- 如果是当前按钮则添加active类 -->
    <button
       v-for="(_, tab) in tabs"
       :key="tab"
       :class="['tab-button', { active: currentTab === tab }]"
       @click="currentTab = tab"
     >
      {{ tab }}
    </button>
    <!-- 显示对应的组件 -->
    <component :is="tabs[currentTab]" class="tab"></component>
  </div>
</template>

<style></style>