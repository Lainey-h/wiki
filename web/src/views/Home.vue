<template>
  <a-layout>
    <a-layout-sider width="200" style="background: #fff">
      <a-menu
          mode="inline"
          :default-selected-keys="['1']"
          :default-open-keys="['sub1']"
          :style="{ height: '100%', borderRight: 0 }"
      >
        <a-sub-menu key="sub1">
          <span slot="title"><a-icon type="user" />subnav 1</span>
          <a-menu-item key="1">
            option1
          </a-menu-item>
          <a-menu-item key="2">
            option2
          </a-menu-item>
          <a-menu-item key="3">
            option3
          </a-menu-item>
          <a-menu-item key="4">
            option4
          </a-menu-item>
        </a-sub-menu>
        <a-sub-menu key="sub2">
          <span slot="title"><a-icon type="laptop" />subnav 2</span>
          <a-menu-item key="5">
            option5
          </a-menu-item>
          <a-menu-item key="6">
            option6
          </a-menu-item>
          <a-menu-item key="7">
            option7
          </a-menu-item>
          <a-menu-item key="8">
            option8
          </a-menu-item>
        </a-sub-menu>
        <a-sub-menu key="sub3">
          <span slot="title"><a-icon type="notification" />subnav 3</span>
          <a-menu-item key="9">
            option9
          </a-menu-item>
          <a-menu-item key="10">
            option10
          </a-menu-item>
          <a-menu-item key="11">
            option11
          </a-menu-item>
          <a-menu-item key="12">
            option12
          </a-menu-item>
        </a-sub-menu>
      </a-menu>
    </a-layout-sider>
    <a-layout-content
        :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '280px' }"
    >
      <pre>
        {{ebooks}}
        {{ebooks2}}
        {{mains}}
      </pre>

    </a-layout-content>

  </a-layout>
</template>

<script lang="ts">
import { defineComponent,onMounted,ref,reactive,toRef} from 'vue';
import axios from'axios';
import _default from "ant-design-vue/es/vc-trigger/Popup";
// import data = _default.data;

export default defineComponent({
  name: 'Home',
  components: {
  },
  setup: function () {
    console.log("setup");
    const ebooks=ref();// 响应式数据
    const ebooks1=reactive({books:[]})
    const mains=ref();

    onMounted(() => {
      console.log("onMounted");
      axios.get("http://localhost:8880/ebook/list?name=Spring\n").then((response) => {
        const data =response.data;// 在response里面有一个data，对应的是我们后端CommonResp的数据结构。（data=commonResp）
        ebooks.value=data.content;
        ebooks1.books=data.content;
        console.log(response)
      })
      axios.get("http://localhost:8880/main/list?albh=2009052812388\n").then((response) => {
        const data=response.data;
        mains.value=data.content;
      })
    })
    return {
      ebooks,// html代码要拿到响应式变量，需要在setup最后return
      ebooks2:toRef(ebooks1,"books"),
      mains,
    }
  }
});
</script>
