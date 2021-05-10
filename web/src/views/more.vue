<template>
  <a-layout>
    <a-layout-content
        :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '280px' }"
    >

<!--      <p> {{accidents.value}}</p>-->
      <a-typography>
        <a-typography-title align="center"> 井下复杂情况与事故诊断处理实例</a-typography-title>
        <a-typography-paragraph>
          <a-table
              :data-source="accidents"
              :columns="columns"
              :pagination="false"
              :row-key="record => record.albh"
          >
            <template #renderItem="{ text }">
              <a>{{ text }}</a>
            </template>
          </a-table>
        </a-typography-paragraph>
        <a-typography-title > 1.基础数据 </a-typography-title>
        <p align="center">(1)井深结构</p>
        <a-typography-paragraph>
          <a-table
              :data-source="accidents"
              :columns="columns2"
              :pagination="false"
              :row-key="record => record.albh"
          >
            <template #renderItem="{ text }">
              <a>{{ text }}</a>
            </template>
          </a-table>
        </a-typography-paragraph>
        <p align="center">(2)其它</p>
        <a-typography-paragraph>
        </a-typography-paragraph>
        <a-typography-title > 2.事故发生征兆</a-typography-title>
          <a-list :bordered="true"  item-layout="vertical" size="large" :data-source="accidents">
            <template #renderItem="{ item }">
              <a-list-item key="item.albh">
                {{item.sgzzlx}}
              </a-list-item>
            </template>
          </a-list>
        <a-typography-paragraph>
<!--          {{accidents[0].sgfsms}}-->

        </a-typography-paragraph>
        <br/>
        <a-typography-title> 3.事故发生经过</a-typography-title>
        <a-typography-paragraph>
          <a-list :bordered="true"  item-layout="vertical" size="large" :data-source="accidents">
            <template #renderItem="{ item }">
              <a-list-item key="item.albh">
                {{ item.sgfsms}}
              </a-list-item>
            </template>
          </a-list>
        </a-typography-paragraph>
        <a-typography-title > 4.事故处理过程</a-typography-title>
          <a-list :bordered="true"  item-layout="vertical" size="large" :data-source="accidents">
            <template #renderItem="{ item }">
              <a-list-item key="item.albh">
                {{ item.sgclms}}
              </a-list-item>
            </template>
          </a-list>
        <a-typography-paragraph >
<!--          {{accidents.value[0].albh}}-->
<!--            {{columns[0].title}}-->
<!--             {{resp[0].ytmc}}-->
<!--            <template #renderItem="resp">-->
<!--              <a>{{ resp[0].ytmc }}</a>-->
<!--            </template>-->
        </a-typography-paragraph>
        <a-typography-title > 5.专家处理意见</a-typography-title>
          <a-list :bordered="true"  item-layout="vertical" size="large" :data-source="accidents">
            <template #renderItem="{ item }">
              <a-list-item key="item.albh">
                {{ item.zjclyj}}
              </a-list-item>
            </template>
          </a-list>
        <a-typography-paragraph >

        </a-typography-paragraph>

      </a-typography>>


<!--      <a-descriptions title="井下复杂情况与事故诊断处理实例" >-->
<!--        <template #renderItem="accidents">-->
<!--          <a-descriptions-item label="油田名称">{{accidents.ytmc}}</a-descriptions-item>-->
<!--          <a-descriptions-item label="井型">{{accidents.jx}}</a-descriptions-item>-->
<!--          <a-descriptions-item label="事故发生起始井深">{{accidents.zs}}</a-descriptions-item>-->
<!--          <a-descriptions-item label="事故发生终止井深">{{accidents.zzjs}}</a-descriptions-item>-->
<!--          <a-descriptions-item label="钻遇地层">{{accidents.zydc}}</a-descriptions-item>-->
<!--          <a-descriptions-item label="事故类型">{{accidents.sglx}}</a-descriptions-item>-->
<!--          <a-descriptions-item label="事故发生时间">{{accidents.sgfssj}}</a-descriptions-item>-->
<!--          <a-descriptions-item label="损失时间">{{accidents.sssj}}</a-descriptions-item>-->
<!--        </template>-->
<!--      </a-descriptions>-->

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
    //你是在这个setup方法里做了所有的工作，这个我还不知道在这个里面怎么给外面哪个data里的对象赋值，你查下 我听懂了一步分
    const route = useRoute();
    console.log("路由：", route);
    console.log("route.path：", route.path);
    console.log("route.query：", route.query);
    console.log("route.param：", route.params);
    console.log("route.fullPath：", route.fullPath);
    console.log("route.name：", route.name);
    console.log("route.meta：", route.meta);
    // 你可以看下之前的表格 也是通过接口拿到数据的呢个
    const columns= [
      {
        title: '井号',
        dataIndex: 'jh',
        align: 'center',
      },
      {
        title: '油田名称',
        dataIndex: 'ytmc',
        align: 'center',
      },
      {
        title: '井型', //显示的是列的名称
        dataIndex: 'jx', //对应的字段你把这个先改了，三个表，有三个columns  想用一些其他的数据展示组件 不想全部都用表格 ok吗 列表数据一般都是table展示，像你其他信息可以用card 不然我整个项目 全部都是只用了table组件哈哈哈哈
        align: 'center',
      },
      {
        title: '事故类型',
        dataIndex: 'sglx',
        align: 'center',
      },
      {
        title: '钻遇地层',
        dataIndex: 'zydc',
        align: 'center',
      },
      {
        title: '事故发生起始井深(m)',
        dataIndex: 'zs',
        align: 'center',
      },
      {
        title: '事故发生终止井深(m)',
        dataIndex: 'zzjs',
        align: 'center',
      },
      {
        title: '事故发生时间',
        dataIndex: 'sgfssj',
      },
      {
        title: '损失时间',
        dataIndex: 'sssj',
        align: 'center',
      },
    ]
    const columns2= [
      {
        title: '套管名称',
        dataIndex: 'tgmc',
        align: 'center',
      },
      {
        title: '套管顶部深度(m)',
        dataIndex: 'tgdbsd',
        align: 'center'
      },
      {
        title: '套管外径(mm)', //显示的是列的名称
        dataIndex: 'tgwj', //对应的字段你把这个先改了，三个表，有三个columns  想用一些其他的数据展示组件 不想全部都用表格 ok吗 列表数据一般都是table展示，像你其他信息可以用card 不然我整个项目 全部都是只用了table组件哈哈哈哈
        align: 'center',
      },
      {
        title: '套管鞋深度(m)',
        dataIndex: 'tgxsd',
        align: 'center',
      },

    ]
    const param = ref();
    param.value = {};
    // const resp: Record<any, any>[] = []
    const accidents=ref();
   //  accidents.value= {};
    const  handleQuery =  (albh: any) => { //这有个参数
      console.log(route.query.mainAlbh)
      console.log(route.query)
      console.log(111111111111111111111111111111111)
      accidents.value = [];
      var albts = parseInt(albh)
      axios.get("/main/listByAlbh/" + albts).then((response) => {
        const data = response.data;
        console.log(response);
        console.log(33);
        if (response.status === 200){
          // mainAlbh: route.query.mainAlbh;
          // accidents.value = {
          //   albh: route.query.mainAlbh
          // };
          accidents.value = response.data;
         //  resp.push(response.data[0]);
          // resp = response.data[0];
          console.log(33);
         //  console.log(resp);
          // datasource.push(response.data) //这个变量怎么才能用你datasource？吗？嗯嗯 表格组建？不是，我在下面声明了这个， 稍等一下啊 好的
          console.log(accidents.value);
          console.log(accidents);
          console.log(accidents.value[0].sgfsms);
          console.log(44);
        }else {
          message.error(data.message);  //要不先不用这个description看组件 用表格组建 这个表格组件我用过 应该显示起来没有问题 先验证接口 接口好着，我看下，这数据就没附上去
        }
      })
    }
    onMounted(() => { //这个方法是在页面初始化时候调用的， 调了handleQuery方法，handleQuery方法 在上面已经声明了
      console.log("onMounted222"); //现在这块值拿到了，
      console.log(route.query)
      var i = route.query.mainAlbh
      // handleQuery;//你原来是这么写的，没传参，所以这个方法没有调，改成下面的以后
      handleQuery(i); //这个route.query.mainAlbh 是我参照这个人写的在这里 你这块如果要拿这个值怎么写，传参 是说表里的字段吗  放到这 具体我不清楚 呢个人它是根据 表的主键 拿到
    })
 //这个return 是你这个方法里需要返回的一些值，你所有的逻辑全在这个方法中执行的
    return {
      param,
      accidents,
      columns,
      columns2,
     //  resp,
      //  datasource:[],
      handleQuery,
      // searchText: '',
      // searchedColumn: '',

    }
  },
});
</script>
};

<style scoped>

</style>
