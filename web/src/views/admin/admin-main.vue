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
              Search
            </a-button>
            <a-button size="small" style="width: 90px" @click="handleReset(clearFilters)">
              Reset
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
    >
    <a-form :model="main" :label-col="{ span: 6 }" :wrapper-col="{ span: 18 }">
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
        <a-input v-model:value="main.jx" />
      </a-form-item>
      <a-form-item label="事故类型">
        <a-input v-model:value="main.sglx" type="textarea" />
      </a-form-item>
      <a-form-item label="钻遇地层">
        <a-input v-model:value="main.zydc" />
      </a-form-item>
      <a-form-item label="事故发生起始井深">
        <a-input v-model:value="main.zs" />
      </a-form-item>
      <a-form-item label="事故发生终止井深">
        <a-input v-model:value="main.zzjs" />
      </a-form-item>
      <a-form-item label="事故发生时间">
        <a-date-picker show-time placeholder="Select Time" @change="onTimeChange" @ok="onTimeOk" v-model:value="main.sgfssj"/>
      </a-form-item>
      <a-form-item label="损失时间">
        <a-input v-model:value="main.sssj" />
      </a-form-item>
    </a-form>
  </a-modal>
</template>

<script lang="ts">
import { defineComponent,onMounted,ref,reactive,toRef} from 'vue';
import axios from'axios';
import _default from "ant-design-vue/es/vc-trigger/Popup"; // 这里是在添加表格组件的时候写的 never use 暂时注释掉
import data = _default.data;
// import _default from "ant-design-vue/es/color-picker";// default重名 注释掉了
// import size = _default.props.size;
// import { SearchOutlined } from '@ant-design/icons-vue';
import { Moment } from 'moment';
import { message } from "ant-design-vue";
import {Tool} from "@/util/tool";

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
      axios.get("/main/list",{
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
    const handleModalOk = () => {
      modalLoading.value = true;
      axios.post("/main/save", main.value).then((response) => {
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
      modalVisible.value = true;
      main.value = Tool.copy(record)
    };
    /**
     * 新增
     */
    const add= () => {
      modalVisible.value = true;
      main.value = {};
    };

    const handleDelete =(albh: number) => {
      axios.delete("/main/delete/" + albh).then((response) => {
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
