<template>
  <a-layout>
    <a-layout-content
        :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '280px' }"
    >

      <a-descriptions title="井下复杂情况与事故诊断处理实例" :data-source="mains" bordered>
        <template #renderItem="{ item }">
          <a-descriptions-item label="油田名称">{{item.ytmc}}</a-descriptions-item>
          <a-descriptions-item label="井型">{{item.jx}}</a-descriptions-item>
          <a-descriptions-item label="事故发生起始井深">{{item.zs}}</a-descriptions-item>
          <a-descriptions-item label="事故发生终止井深">{{item.zzjs}}</a-descriptions-item>
          <a-descriptions-item label="钻遇地层">{{item.zydc}}</a-descriptions-item>
          <a-descriptions-item label="事故类型">{{item.sglx}}</a-descriptions-item>
          <a-descriptions-item label="事故发生时间">{{item.sgfssj}}</a-descriptions-item>
          <a-descriptions-item label="损失时间">{{item.sssj}}</a-descriptions-item>
        </template>
      </a-descriptions>

    </a-layout-content>

  </a-layout>
</template>

<script lang="ts">
import { defineComponent,onMounted,ref,reactive,toRef} from 'vue';
import axios from'axios';
import _default from "ant-design-vue/es/vc-trigger/Popup"; // 这里是在添加表格组件的时候写的 never use 暂时注释掉
import data = _default.data;
import { Moment } from 'moment';
import { message } from "ant-design-vue";
import {Tool} from "@/util/tool";
import {useRoute} from "vue-router";

export default defineComponent({
  name: 'More',
  setup: function () {
    const route = useRoute();
    console.log("路由：", route);
    console.log("route.path：", route.path);
    console.log("route.query：", route.query);
    console.log("route.param：", route.params);
    console.log("route.fullPath：", route.fullPath);
    console.log("route.name：", route.name);
    console.log("route.meta：", route.meta);

    const param = ref();
    param.value = {};
    const mains=ref();

    const handleQuery = () => {
      mains.value = [];
      axios.get("/main/list",{
      }).then((response) => {
        const data = response.data;
        if (data.success){
          mainAlbh: route.query.mainAlbh;
          mains.value = data.content;
        }else {
          message.error(data.message);
        }
      })
    }
    onMounted(() => {
      console.log("onMounted222");
      handleQuery();
    })
    return {
      param,
      mains,
      handleQuery,
      searchText: '',
      searchedColumn: '',

    }
  }
});
</script>

<style scoped>
.highlight {
  background-color: rgb(255, 192, 105);
  padding: 0px;
}
</style>
