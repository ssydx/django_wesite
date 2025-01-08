<template>
  <!-- 变量 -->
  <div>{{ varName }}</div>
  <!-- 注入HTML -->
  <div>{{ rawHTML }}</div>
  <div v-html="rawHTML"></div>
  <!-- 属性绑定 -->
  <!-- 绑定id -->
  <div v-bind:id="varId1">123</div>
  <!-- 绑定class -->
  <div v-bind:class="varClass1">123</div>
  <!-- 绑定多属性 -->
  <div v-bind="varObj">123</div>
  <!-- 绑定布尔属性 -->
  <input type="checkbox" name="" id="" v-bind:checked="varChecked">
  <!-- 缩写 -->
  <div :id="varId1" :class="varObj.class">123</div>
  <!-- 函数 -->
  <div>{{ func1(name) }}</div>
  <div :title="func1('ssydx')">123</div>
  <!-- 事件绑定 -->
  <button type="button" v-on:click="evtfunc1()">按钮1</button>
  <button type="button" @click="evtfunc2()">按钮2</button>
  <!-- 动态参数 -->
  <div v-bind:[varAttr]='name'>123</div>
  <!-- 修饰符 -->
  <div id="id3" @mouseenter="evtfunc3()" @mouseleave="evtfunc4()">123</div>
  <!-- 响应 -->
  <div>{{ state1.count }}</div>
  <button type="button" @click="increment1">计数器</button>
  <div>{{ state2 }}</div>
  <button type="button" @click="increment2">计数器</button>
  <!-- 计算属性 -->
  <div>{{ author.books.length }}</div>
  <div>{{ booknum }}</div>
  <div>{{ bookcnt }}</div>
  <div>{{ bookcntfunc() }}</div>
  <!-- 侦听 -->
  <p>
    Ask a yes/no question:
    <input v-model="question" />
  </p>
  <p>{{ answer }}</p>
  <!-- 样式绑定 -->
  <div :class="{class1: cToF}">123</div>
  <div :style="{ color: varcolor,fontSize: fontSize + 'px','border-top': varborder }">这是一个块</div>
  <div :style="varStyle1">这是一个块</div>
  <div :style="[varStyle1,varStyle2]">这是一个块</div>
  <!-- 条件语句 -->
  <div v-if="seen === 'a'">if {{ seen }}</div>
  <div v-else-if="seen === 'b'">else-if1 {{ seen }}</div>
  <div v-else-if="seen === 'c'">else-if2 {{ seen }}</div>
  <div v-else>else {{ seen }}</div>
  <div v-show="seen === 'a'">show {{ seen }}</div>
  <!-- 循环语句 -->
  <div v-for="item in arr">{{ item }}</div>
  <ul>
    <template v-for="(value,key) in obj">
      <li>{{ key }}</li>
      <li>{{ value }}</li>
    </template>
  </ul>
  <span v-for="i in 5">valu2:{{ i }} </span>
  <!-- 事件绑定再探之修饰符 -->
  <button @click.once="func2('123')">按钮</button>
  <button @click.ctrl="func2">按钮</button>
  <button @click.ctrl.exact="func2">按钮</button>
  <!-- 表单绑定 -->
  <input type="text" :value="model_value1">
  <input type="text" :value="model_value1" @input="func3">
  <input type="text" :value="model_value1" @input="event => model_value1 = event.target.value">
  <!-- v-model -->
  <input type="text" v-model.lazy="model_value1">
  <HelloWorld msg="ssydx"/>
  <!-- 组件 -->
  <comp1 />
  <comp2 title="123"/>
  <comp2 v-for="post in posts" :key="post.id" :title="post.title"/>
  <div :style="{ fontSize: postFontSize + 'em' }">
    <comp2
      v-for="post in posts"
      :key="post.id"
      :title="post.title"
      @enlarge-text="postFontSize += 0.1"
    />
    <!-- @enlarge-text="postFontSize += 0.1" 为自定义事件 -->
  </div>
  <comp3>
    发生了一些错误。
  </comp3>
  <comp4 />
  <comp5 ssydx="123" />
  <comp6 ssydx="123" />
  <!-- 数值或布尔等总应该进行动态绑定，静态值会被视为字符串，而动态被视为表达式 -->
  <comp7 name="ssydx" :age="12" :note="30" />
  <comp7 v-bind="obj2" />
  <comp8 :age="123" />
  <div :style="{ fontSize: size + 'px' }">123</div>
  <comp9 @evt1="(n) => { size += n }" />
  <comp10 :class="varClass3"/>
  <comp11>
    <template v-slot:header="headerProps">头部 {{ headerProps.class }}</template>
    <template #main>主体</template>
    <template #default>默认</template>
    <template #[slotname]>脚部</template>
  </comp11>
  
</template>

<script>
import { reactive,ref,computed,watch } from 'vue';
import HelloWorld from './components/HelloWorld.vue';
import comp1 from './components/comp1.vue';
import comp2 from './components/comp2.vue';
import comp3 from './components/comp3.vue';
import comp4 from './components/comp4.vue';
import comp5 from './components/comp5.vue';
import comp6 from './components/comp6.vue';
import comp7 from './components/comp7.vue';
import comp8 from './components/comp8.vue';
import comp9 from './components/comp9.vue';
import comp10 from './components/comp10.vue';
import comp11 from './components/comp11.vue';

export default {
  components: {
    HelloWorld,
    comp1,
    comp2,
    comp3,
    comp4,
    comp5,
    comp6,
    comp7,
    comp8,
    comp9,
    comp10,
    comp11,

  },
  data() {
    return {
      varName: 'hello world',
      rawHTML: '<h1>123</h1>',
      message3: '<h1>123</h1>',
      varId1: 'id1',
      varClass1: 'class1',
      varClass3: 'class3',
      varObj: {
        id: 'id2',
        class: 'class2',
      },
      varChecked: true,
      func1: function(name) {
        return '你好,' + name;
      },
      name: 'ssydx',
      evtfunc1() {
        document.querySelector('#id1').style.fontSize = '48px';
      },
      evtfunc2() {
        document.querySelector('#id2').style.fontSize = '48px';
      },
      varAttr: 'title',
      evtfunc3: function() {
        document.querySelector('#id3').style.color = 'red';
      },
      evtfunc4: function() {
        document.querySelector('#id3').style.color = 'initial';
      },
      cToF: true,
      iToF: false,
      varcolor: "blue",
      fontSize: 32,
      varborder: '5px solid white',
      varStyle1: {
        background: 'blue',
        color: 'red',
      },
      varStyle2: {
        fontSize: '32px',
        margin: '10px',
      },
      seen: 'e',
      arr: [
        'a','b','c'
      ],
      obj: {
        name: 'ssydx',
        age: '26',
        sex: 'male',
      },
      func2: function(val) {
        console.log(val);
      },
      model_value1: '请输入文本',
      func3: function(event) {
        // this指data()返回的代理对象
        this.model_value1 = event.target.value;
      },
      obj2: {
        name: 'ssydx',
        age: 26,
        note: 'warning',
      },
      size: 16,
      slotname: 'footer',
    };
  },
  setup() {
    // 代理
    const state1 = reactive({ count: 1 });
    function increment1() {
      state1.count++;
    }
    const state2 = ref(1);
    function increment2() {
      state2.value++;
    }
    // 计算属性
    const author = reactive({
      name: 'John Doe',
      books: [
        'Vue 2 - Advanced Guide',
        'Vue 3 - Basic Guide',
        'Vue 4 - The Mystery'
      ]
    })
    const booknum = computed(() => {
      return author.books.length;
    })
    const bookcnt = author.books.length;
    function bookcntfunc() {
      return author.books.length;
    }
    author.books.push('Vue 5 - The Future');
    // 侦听
    const question = ref('');
    const answer = ref('问题以?结尾');
    watch(question, async (newQuestion, oldQuestion) => {
      if (newQuestion.indexOf('?') > -1) {
        answer.value = 'Thinking...';
        try {
          const res = await fetch('https://yesno.wtf/api');
          answer.value = (await res.json()).answer + ' ' + oldQuestion;
        } catch (error) {
          answer.value = 'Error! Could not reach the API. ' + error;
        }
      }
    });
    const posts = ref([
      { id: 1, title: 'a' },
      { id: 2, title: 'b' },
      { id: 3, title: 'c' }
    ]);
    const postFontSize = ref(1);
    return {
      state1,
      increment1,
      state2,
      increment2,
      author,
      booknum,
      bookcnt,
      bookcntfunc,
      question,
      answer,
      posts,
      postFontSize,
    };
  }

};
</script>

<style>
  #id1 {
    color: aqua;
  }
  .class1 {
    background-color: red;
  }
  #id2.class2 {
    color: rgb(4, 0, 255);
    background-color: rgb(0, 255, 4);
  }
  .class3 {
    border: 1px solid aquamarine;
  }
</style>