<template>
  <a-layout>
    <a-layout-content
        :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '280px' }"
    >
      <p>
        <a-button type="primary" size="large" @click="add()">
          新增
        </a-button>
      </p>
      <a-table
          :data-source="mains"
          :columns="columns"
          :row-key="record => record.albh"
          :pagination="pagination"
          :loading="loading"
          :scroll="{x: 1500, y: 1000}"
          @change="handleTableChange"
      >
        <template v-slot:action="{ text, record}" >
          <a-space size="small" direction="vertical">
            <a-button type="primary" size="small" @click="edit(record)">
              编辑
            </a-button>
            <a-popconfirm
                title="删除后不可恢复，确认删除?"
                ok-text="是"
                cancel-text="否"
                @confirm="handleDelete(record.albh)"
            >
              <a-button type="danger">
                删除
              </a-button>
            </a-popconfirm>

          </a-space>
        </template>
        <template #filterDropdown="{ setSelectedKeys, selectedKeys, confirm, clearFilters, column }">
          <div style="padding: 8px">
            <a-input
                ref="searchInput"
                :placeholder="`Search ${column.dataIndex}`"
                :value="selectedKeys[0]"
                style="width: 188px; margin-bottom: 8px; display: block"
                @change="e => setSelectedKeys(e.target.value ? [e.target.value] : [])"
                @pressEnter="handleSearch(selectedKeys, confirm, column.dataIndex)"
            />
            <a-button
                type="primary"
                size="small"
                style="width: 90px; margin-right: 8px"
                @click="handleSearch(selectedKeys, confirm, column.dataIndex)"
            >
              <template #icon><SearchOutlined /></template>
              查询
            </a-button>
            <a-button size="small" style="width: 90px" @click="handleReset(clearFilters)">
              重置
            </a-button>
          </div>
        </template>
        <template #filterIcon="filtered">
          <search-outlined :style="{ color: filtered ? '#108ee9' : undefined }" />
        </template>
        <template #customRender="{ text, column }">
        <span v-if="searchText && searchedColumn === column.dataIndex">
        <template
            v-for="(fragment, i) in text
            .toString()
            .split(new RegExp(`(?<=${searchText})|(?=${searchText})`, 'i'))"
        >
          <mark
              v-if="fragment.toLowerCase() === searchText.toLowerCase()"
              class="highlight"
              :key="i"
          >
            {{ fragment }}
          </mark>
          <template v-else>{{ fragment }}</template>
        </template>
      </span>
          <template v-else>
            {{ text }}
          </template>
        </template>
      </a-table>

    </a-layout-content>

  </a-layout>
  <a-modal
    title="案例表单"
    v-model:visible="modalVisible"
    :confirm-loading="modalLoading"
    @ok="handleModalOk"
    width="100%"
    cancelText="取消"
    okText="确认"
    >
    <a-form :label-col="labelCol" :wrapper-col="wrapperCol">
      <a-form-item label="井号">
        <a-input v-model:value="main.jh" />
      </a-form-item>
      <a-form-item label="油田名称">
        <a-input v-model:value="main.ytmc" />
<!--        <a-select v-model:value="main.ytmc" placeholder="请选择油田名称">-->
<!--          <a-select-option v-for="m in mains" :key="m.ytmc" :value="m.ytmc">-->
<!--            {{m.ytmc}}-->
<!--          </a-select-option>-->
<!--        </a-select>-->
      </a-form-item>
      <a-form-item label="井型">
        <a-select v-model:value="main.jx" placeholder="请选择井型">
          <a-select-option value="直井">直井</a-select-option>
          <a-select-option value="定向井">定向井</a-select-option>
        </a-select>
      </a-form-item>
      <a-form-item label="事故类型">
        <a-select v-model:value="main.sglx" placeholder="请选择事故类型">
          <a-select-option value="井漏">井漏</a-select-option>
          <a-select-option value="井塌">井塌</a-select-option>
          <a-select-option value="井喷">井喷</a-select-option>
          <a-select-option value="砂桥">砂桥</a-select-option>
          <a-select-option value="溢流">溢流</a-select-option>
          <a-select-option value="泥包">泥包</a-select-option>
          <a-select-option value="缩径">缩径</a-select-option>
          <a-select-option value="井下落物">井下落物</a-select-option>
          <a-select-option value="钻井液污染">钻井液污染</a-select-option>
          <a-select-option value="钻具断落">钻具断落</a-select-option>
        </a-select>
      </a-form-item>
      <a-form-item label="钻遇地层">
        <a-select v-model:value="main.zydc" placeholder="请选择钻遇地层">
          <a-select-option value="库车组">库车组</a-select-option>
          <a-select-option value="康村组">康村组</a-select-option>
          <a-select-option value="吉迪克组">吉迪克组</a-select-option>
          <a-select-option value="苏维依组">苏维依组</a-select-option>
          <a-select-option value="库姆格列群">库姆格列群</a-select-option>
        </a-select>
      </a-form-item>
      <a-form-item label="事故发生起始井深">
        <a-input-number v-model:value="main.zs" :min="0"  :step="0.1" />
      </a-form-item>
      <a-form-item label="事故发生终止井深">
        <a-input-number v-model:value="main.zzjs" :min="0"  :step="0.1" />
      </a-form-item>
      <a-form-item label="事故发生时间">
        <a-date-picker show-time   placeholder="请选择时间"  @change="onTimeChange" @ok="onTimeOk" v-model:value="main.sgfssj"/>
      </a-form-item>
      <a-form-item label="损失时间">
        <a-input-number v-model:value="main.sssj" :min="0"  :step="0.1" />
      </a-form-item>
      <a-form-item label="岩性">
        <a-input v-model:value="main.yx" />
      </a-form-item>
      <a-form-item label="套管名称">
        <a-input v-model:value="main.tgmc" />
      </a-form-item>
      <a-form-item label="套管顶部深度(m)">
        <a-input-number v-model:value="main.tgdbsd" :min="0"  :step="0.1" />
      </a-form-item>
      <a-form-item label="套管外径(mm)">
        <a-input-number v-model:value="main.tgwj" :min="0"  :step="0.1" />
      </a-form-item>
      <a-form-item label="套管鞋深度(m)">
        <a-input-number v-model:value="main.tgxsd" :min="0"  :step="0.1" />
      </a-form-item>
      <a-form-item label="工作方式">
        <a-input v-model:value="main.gzfs" />
      </a-form-item>
      <a-form-item label="事故征兆类型">
        <a-cascader v-model:value="main.sgzzlx" :options="options" placeholder="请选择" />
      </a-form-item>
      <a-form-item label="事故发生经过描述">
        <a-textarea auto-size v-model:value="main.sgfsms" />
      </a-form-item>
      <a-form-item label="事故处理过程描述">
        <a-textarea auto-size v-model:value="main.sgclms" />
      </a-form-item>
      <a-form-item label="专家处理意见描述">
        <a-textarea auto-size v-model:value="main.zjclyj" />
      </a-form-item>
      <a-form-item label="案例来源">
        <a-input v-model:value="main.slly" />
      </a-form-item>
      <a-form-item label="案例类别">
        <a-radio-group v-model:value="main.sllb">
          <a-radio value="一般典型">一般典型</a-radio>
          <a-radio value="典型">典型</a-radio>
          <a-radio value="非常典型">非常典型</a-radio>
        </a-radio-group>
      </a-form-item>

    </a-form>
  </a-modal>
</template>

<script lang="ts">
import { defineComponent,onMounted,ref,reactive,toRef} from 'vue';
import axios from'axios';
import _default from "ant-design-vue/es/vc-trigger/Popup";
import data = _default.data;
// import _default from "ant-design-vue/es/color-picker";// default重名 注释掉了
//import size = _default.props.size;
import { Moment } from 'moment';
import { message } from "ant-design-vue";
import {Tool} from "@/util/tool";
import zhCN from 'ant-design-vue/es/locale/zh_CN'

interface Option {
  value: string;
  label: string;
  children?: Option[];
}
const options: Option[] = [
  {
    value: '钻进',
    label: '钻进',
    children: [
      {
        value: '上提有阻短距离内阻力消失',
        label: '上提有阻短距离内阻力消失',
        children: [
          {
            value: '泵压正常',
            label: '泵压正常',
          },
          {
            value: '泵压逐渐上升',
            label: '泵压逐渐上升',
          },
          {
            value: '泵压波动忽大忽小',
            label: '泵压波动忽大忽小',
          },
            ],
          },{
        value: '上提一直有阻力忽大忽小',
        label: '上提一直有阻力忽大忽小',
        children: [
          {
            value: '泵压正常',
            label: '泵压正常',
          },
          {
            value: '泵压逐渐上升',
            label: '泵压逐渐上升',
          },
          {
            value: '泵压波动忽大忽小',
            label: '泵压波动忽大忽小',
          },
        ],
      },
      {
        value: '上提一直有阻力越来越大',
        label: '上提一直有阻力越来越大',
        children: [
          {
            value: '泵压正常',
            label: '泵压正常',
          },
          {
            value: '泵压逐渐上升',
            label: '泵压逐渐上升',
          },
          {
            value: '泵压波动忽大忽小',
            label: '泵压波动忽大忽小',
          },
        ],
      },
      {
        value: '下放有较大阻力',
        label: '下放有较小阻力',
        children: [
          {
            value: '泵压正常',
            label: '泵压正常',
          },
          {
            value: '泵压逐渐上升',
            label: '泵压逐渐上升',
          },
          {
            value: '泵压波动忽大忽小',
            label: '泵压波动忽大忽小',
          },
        ],
      },
        ],
  },
  {
    value: '起钻',
    label: '起钻',
    children: [
      {
        value: '钻具静止时间较长',
        label: '钻具静止时间较长',
        children: [
              {
                value: '钻柱上行环空液面不下降',
                label: '钻柱上行环空液面不下降',
              },
              {
                value: '钻井液随钻柱上行返出井口',
                label: '钻井液随钻柱上行返出井口',
              },
              {
                value: '钻柱内孔返喷钻井液',
                label: '钻柱内孔返喷钻井液',
              },
            ],
      },
      {
        value: '钻柱上行突然遇阻',
        label: '钻柱上行突然遇阻',
        children: [
              {
                value: '钻柱上行环空液面不下降',
                label: '钻柱上行环空液面不下降',
              },
              {
                value: '钻井液随钻柱上行返出井口',
                label: '钻井液随钻柱上行返出井口',
              },
              {
                value: '钻柱内孔返喷钻井液',
                label: '钻柱内孔返喷钻井液',
              },
            ],
      },
      {
        value: '钻柱在一定阻力下可以上行',
        label: '钻柱在一定阻力下可以上行',
        children: [
              {
                value: '钻柱上行环空液面不下降',
                label: '钻柱上行环空液面不下降',
              },
              {
                value: '钻井液随钻柱上行返出井口',
                label: '钻井液随钻柱上行返出井口',
              },
              {
                value: '钻柱内孔返喷钻井液',
                label: '钻柱内孔返喷钻井液',
              },
            ],
      },
      {
        value: '钻具循环活动正常停泵就有阻力',
        label: '钻具循环活动正常停泵就有阻力',
        children: [
              {
                value: '钻柱上行环空液面不下降',
                label: '钻柱上行环空液面不下降',
              },
              {
                value: '钻井液随钻柱上行返出井口',
                label: '钻井液随钻柱上行返出井口',
              },
              {
                value: '钻柱内孔返喷钻井液',
                label: '钻柱内孔返喷钻井液',
              },
            ],
      },
    ]
  },
  {
    value: '下钻',
    label: '下钻',
    children: [
      {
        value: '钻具静止时间较长',
        label: '钻具静止时间较长',
        children: [
              {
                value: '下钻柱时井口不返钻井液',
                label: '下钻柱时井口不返钻井液',
              },
              {
                value: '钻柱内孔反喷钻井液',
                label: '钻柱内孔反喷钻井液',
              },
              {
                value: '钻柱内孔返喷钻井液',
                label: '钻柱内孔返喷钻井液',
              },
            ],
      },
      {
        value: '钻柱上行突然遇阻',
        label: '钻柱上行突然遇阻',
        children: [
          {
            value: '下钻柱时井口不返钻井液',
            label: '下钻柱时井口不返钻井液',
          },
          {
            value: '钻柱内孔反喷钻井液',
            label: '钻柱内孔反喷钻井液',
          },
          {
            value: '钻柱内孔返喷钻井液',
            label: '钻柱内孔返喷钻井液',
          },
        ],

      },
      {
        value: '钻柱在一定阻力下可以上行',
        label: '钻柱在一定阻力下可以上行',
        children: [
          {
            value: '下钻柱时井口不返钻井液',
            label: '下钻柱时井口不返钻井液',
          },
          {
            value: '钻柱内孔反喷钻井液',
            label: '钻柱内孔反喷钻井液',
          },
          {
            value: '钻柱内孔返喷钻井液',
            label: '钻柱内孔返喷钻井液',
          },
        ],

      },
      {
        value: '钻具循环活动正常停泵就有阻力',
        label: '钻具循环活动正常停泵就有阻力',
        children: [
          {
            value: '下钻柱时井口不返钻井液',
            label: '下钻柱时井口不返钻井液',
          },
          {
            value: '钻柱内孔反喷钻井液',
            label: '钻柱内孔反喷钻井液',
          },
          {
            value: '钻柱内孔返喷钻井液',
            label: '钻柱内孔返喷钻井液',
          },
        ],

      },
    ]
  },
];

export default defineComponent({
  name: 'AdminMain',
  setup: function () {
    // const ebooks = ref();// 响应式数据
    // const ebooks1=reactive({books:[]})
    const param = ref();
    param.value = {};
    const mains=ref();
    const  pagination = ref({
      current: 1,
      pageSize: 8,
      total: 0
    });
    const loading = ref(false);

    const state = reactive({
      searchText: '',
      searchedColumn: '',
    });

    const searchInput = ref();

    const columns = [
      {
        title: '案例编号',
        dataIndex: 'albh',
        width: 100,
        fixed: 'left',
        slots: {
          filterDropdown: 'filterDropdown',
          filterIcon: 'filterIcon',
          customRender: 'customRender',
        },
        onFilter: (value: any, record: any) =>
            record.albh.toString().toLowerCase().includes(value.toLowerCase()),
        onFilterDropdownVisibleChange: (visible: any) => {
          if (visible) {
            setTimeout(() => {
              console.log(searchInput.value);
              searchInput.value.focus();
            }, 0);
          }
        },
      },
      {
        title: '井号',
        dataIndex: 'jh',
        slots: {
          filterDropdown: 'filterDropdown',
          filterIcon: 'filterIcon',
          customRender: 'customRender',
        },
        onFilter: (value: any, record: any) =>
            record.jh.toString().toLowerCase().includes(value.toLowerCase()),
        onFilterDropdownVisibleChange: (visible: any) => {
          if (visible) {
            setTimeout(() => {
              searchInput.value.focus();
            });
          }
        },
      },
      {
        title: '油田名称',
        dataIndex: 'ytmc',
        slots: {
          filterDropdown: 'filterDropdown',
          filterIcon: 'filterIcon',
          customRender: 'customRender',
        },
        onFilter: (value: any, record: any) =>
            record.ytmc.toString().toLowerCase().includes(value.toLowerCase()),
        onFilterDropdownVisibleChange: (visible: any) => {
          if (visible) {
            setTimeout(() => {
              searchInput.value.focus();
            });
          }
        },
      },
      {
        title: '井型',
        dataIndex: 'jx',
        slots: {
          filterDropdown: 'filterDropdown',
          filterIcon: 'filterIcon',
          customRender: 'customRender',
        },
        onFilter: (value: any, record: any) =>
            record.jx.toString().toLowerCase().includes(value.toLowerCase()),
        onFilterDropdownVisibleChange: (visible: any) => {
          if (visible) {
            setTimeout(() => {
              console.log(searchInput.value);
              searchInput.value.focus();
            }, 0);
          }
        },
      },
      {
        title: '事故类型',
        dataIndex: 'sglx',
        slots: {
          filterDropdown: 'filterDropdown',
          filterIcon: 'filterIcon',
          customRender: 'customRender',
        },
        onFilter: (value: any, record: any) =>
            record.sglx.toString().toLowerCase().includes(value.toLowerCase()),
        onFilterDropdownVisibleChange: (visible: any) => {
          if (visible) {
            setTimeout(() => {
              console.log(searchInput.value);
              searchInput.value.focus();
            }, 0);
          }
        },
      },
      {
        title: '钻遇地层',
        dataIndex: 'zydc',
        slots: {
          filterDropdown: 'filterDropdown',
          filterIcon: 'filterIcon',
          customRender: 'customRender',
        },
        onFilter: (value: any, record: any) =>
            record.zydc.toString().toLowerCase().includes(value.toLowerCase()),
        onFilterDropdownVisibleChange: (visible: any) => {
          if (visible) {
            setTimeout(() => {
              console.log(searchInput.value);
              searchInput.value.focus();
            }, 0);
          }
        },
      },
      {
        title: '事故发生起始井深',
        dataIndex: 'zs',
        slots: {
          filterDropdown: 'filterDropdown',
          filterIcon: 'filterIcon',
          customRender: 'customRender',
        },
        onFilter: (value: any, record: any) =>
            record.zs.toString().toLowerCase().includes(value.toLowerCase()),
        onFilterDropdownVisibleChange: (visible: any) => {
          if (visible) {
            setTimeout(() => {
              console.log(searchInput.value);
              searchInput.value.focus();
            }, 0);
          }
        },
      },
      {
        title: '事故发生终止井深',
        dataIndex: 'zzjs',
        slots: {
          filterDropdown: 'filterDropdown',
          filterIcon: 'filterIcon',
          customRender: 'customRender',
        },
        onFilter: (value: any, record: any) =>
            record.zzjs.toString().toLowerCase().includes(value.toLowerCase()),
        onFilterDropdownVisibleChange: (visible: any) => {
          if (visible) {
            setTimeout(() => {
              console.log(searchInput.value);
              searchInput.value.focus();
            }, 0);
          }
        },
      },
      {
        title: '事故发生时间',
        dataIndex: 'sgfssj',
        slots: {
          filterDropdown: 'filterDropdown',
          filterIcon: 'filterIcon',
          customRender: 'customRender',
        },
        onFilter: (value: any, record: any) =>
            record.sgfssj.toString().toLowerCase().includes(value.toLowerCase()),
        onFilterDropdownVisibleChange: (visible: any) => {
          if (visible) {
            setTimeout(() => {
              console.log(searchInput.value);
              searchInput.value.focus();
            }, 0);
          }
        },
      },
      {
        title: '损失时间',
        dataIndex: 'sssj',
        slots: {
          filterDropdown: 'filterDropdown',
          filterIcon: 'filterIcon',
          customRender: 'customRender',
        },
        onFilter: (value: any, record: any) =>
            record.sssj.toString().toLowerCase().includes(value.toLowerCase()),
        onFilterDropdownVisibleChange: (visible: any) => {
          if (visible) {
            setTimeout(() => {
              console.log(searchInput.value);
              searchInput.value.focus();
            }, 0);
          }
        },
      },

      {
        title: 'Action',
        key: 'action',
        fixed: 'right',
        width: 150,
        slots: { customRender: 'action' },
      }
    ];

    const handleSearch = (selectedKeys: any, confirm: any, dataIndex: any) => {
      confirm();
      state.searchText = selectedKeys[0];
      state.searchedColumn = dataIndex;
    };

    const handleReset = (clearFilters: any) => {
      clearFilters();
      state.searchText = '';
    };

    const handleQuery = (params: any) => {
      loading.value=true;
      // 如果不清空现有数据，则编辑保存重新加载数据后，再点编辑，则列表显示的还是编辑前的数据
      mains.value = [];
      axios.get("/all/list",{
        params:{
          page: params.page,
          size: params.size,
          name: param.value.name
        }
      }).then((response) => {

        loading.value = false;
        const data = response.data;
        if (data.success){
          mains.value = data.content.list;
          // 重置分页按钮
          pagination.value.current = params.page;
          pagination.value.total = data.content.total;
        }else {
          message.error(data.message);
        }
      })
    }

    // 表格点击页码时触发
    const handleTableChange = (pagination: any) => {
      console.log("看看自带的分页参数都有啥：" + pagination);
      handleQuery({
        page: pagination.current,
        size: pagination.pageSize
      });
    };
    //------------表单--------------
    const main = ref({});
    const modalVisible = ref(false);
    const modalLoading = ref(false);
    const handleModalOk = () => { //这个方法十点确认执行的方法？嗯嗯
      console.log(111);
      modalLoading.value = true;
      axios.post("/all/save", main.value).then((response) => {
        console.log(response);
        modalLoading.value = false;
        const data = response.data; // data = commonResp
        if (data.success) {
          modalVisible.value = false;
          // 重新加载列表
          handleQuery({
            page: pagination.value.current,
            size: pagination.value.pageSize,
          });
        }else{
          message.error(data.message)
        }
      });
    };
    /**
     * 编辑
     */
    const edit = (record: any) => {
      // //这块调后台接口，拿到数据后赋值给定义的新变量 、、这块人家做的是单边，所哟把之单表的数据给拷贝了一份  把main替换为all？ 步步，掉后台接口是穿的参数是对象
      // axios.get("/sss/ss/id",)//在这个调咱们写的那个查询接口，拿到数据后把数据赋值给你新定义的变量：就是数据源
      // axios.post("",all)这块all是个对象，你得声明一下，把数据封装起来  这个是点确定后调的，点编辑进来先调查询接口
      console.log(record);
      console.log(111);
      modalVisible.value = true;
      main.value = Tool.copy(record)//  是点击编辑就会调用edit然后调用后台的save接口 保存成功就关闭这个弹框
    };
    /**

     * 新增
     */
    const add= () => {
      modalVisible.value = true;
      main.value = {};
    };

    const handleDelete =(albh: number) => {
      axios.delete("/all/delete/" + albh).then((response) => {
        const data = response.data; // data = commonResp
        if (data.success) {
          // 重新加载列表
          handleQuery({
            page: pagination.value.current,
            size: pagination.value.pageSize,
          });
        } else {
          message.error(data.message);
        }
      });
    };


    const onTimeChange = (value: Moment[], dateString: string[]) => {
      console.log('Selected Time: ', value);
      console.log('Formatted Selected Time: ', dateString);
    };

    const onTimeOk = (value: Moment[]) => {
      console.log('onOk: ', value);
    };



    onMounted(() => {
      console.log("onMounted222");
      handleQuery({
        page: 1,
        size: pagination.value.pageSize
      });
      /*  axios.get("http://localhost:8880/main/list?name=Spring\n").then((response) => {
          const data =response.data;// 在response里面有一个data，对应的是我们后端CommonResp的数据结构。（data=commonResp）
          mains.value=data.content;
          ebooks1.books=data.content;
        })*/
      /*axios.get("http://localhost:8880/main/list").then((response) => {
        const data=response.data;
        mains.value=data.content;
      })*/
    })
    return {
      // ebooks// html代码要拿到响应式变量，需要在setup最后return
      // ebooks2:toRef(ebooks1,"books"),
      param,
      mains,
      pagination,
      columns,
      loading,
      handleTableChange,
      handleQuery,
      handleSearch,
      handleReset,
      searchText: '',
      searchInput,
      searchedColumn: '',


      edit,
      add,
      handleDelete,

      main,
      modalVisible,
      modalLoading,
      handleModalOk,
      onTimeChange,
      onTimeOk,

      options,
      labelCol: { span: 4 },
      wrapperCol: { span: 14 },
    }
  }
});
</script>

<style scoped >
.highlight {
  background-color: rgb(255, 192, 105);
  padding: 0px;
}
/*.ant-modal {*/
/*  box-sizing: border-box;*/
/*  margin: 0;*/
/*  padding: 0;*/
/*  color: rgba(0, 0, 0, 0.65);*/
/*  font-size: 14px;*/
/*  font-variant: tabular-nums;*/
/*  line-height: 1.5715;*/
/*  list-style: none;*/
/*  font-feature-settings: 'tnum';*/
/*  position: relative;*/
/*  top: 0px;*/
/*  !* width: auto; *!*/
/*  margin: 0 auto;*/
/*  padding-bottom: 24px;*/
/*  pointer-events: none;*/
/*  max-width: 100%;*/
/*}*/

/*.ant-modal-content {*/
/*  position: relative;*/
/*  background-color: #fff;*/
/*  background-clip: padding-box;*/
/*  border: 0;*/
/*  border-radius: 2px;*/
/*  box-shadow: 0 4px 12px rgb(0 0 0 /15%);*/
/*  pointer-events: auto;*/
/*  display: flex;*/
/*  flex-direction: column;*/
/*}*/

/*.ant-modal-body {*/
/*  padding: 24px;*/
/*  font-size: 14px;*/
/*  line-height: 1.5715;*/
/*  word-wrap: break-word;*/
/*  flex: 1;*/
/*}*/
</style>
