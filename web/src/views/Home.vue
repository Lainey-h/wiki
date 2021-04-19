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
      <a-table
          :data-source="mains"
          :columns="columns"
          :row-key="record => record.albh"
          :pagination="pagination"
          :loading="loading"
          :scroll="{x: 1500, y: 1000}"
          @change="handleTableChange"
      >
        <template #action>
          <a>action</a>
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
</template>

<script lang="ts">
import { defineComponent,onMounted,ref,reactive,toRef} from 'vue';
import axios from'axios';
import _default from "ant-design-vue/es/vc-trigger/Popup"; // 这里是在添加表格组件的时候写的 never use 暂时注释掉
import data = _default.data;
// import { SearchOutlined } from '@ant-design/icons-vue';

export default defineComponent({
  name: 'Home',

  setup: function () {
    console.log("setup");
    // const ebooks = ref();// 响应式数据
    // const ebooks1=reactive({books:[]})
    const param = ref();
    param.value = {};
    const mains=ref();
    const  pagination = ref({
      current: 1,
      pageSize: 8,
      total: 0
    });1
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
        width: 150,
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
        width: 50,
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
        width: 50,
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
        width: 50,
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
        width: 50,
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
        width: 50,
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
        width: 50,
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
        width: 50,
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
        title: '损失时间',
        dataIndex: 'sssj',
        width: 50,
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
        title: '事故发生时间',
        dataIndex: 'sgfssj',
        width: 50,
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
        title: 'Action',
        key: 'operation',
        fixed: 'right',
        width: 100,
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
      axios.get("/main/list",params).then((response) => {
        loading.value = false;
        const data = response.data;
        mains.value = data.content;
        // 重置分页按钮
        pagination.value.current = params.page;
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

    onMounted(() => {
      console.log("onMounted222");
      handleQuery({});
    /*  axios.get("http://localhost:8880/main/list?name=Spring\n").then((response) => {
        const data =response.data;// 在response里面有一个data，对应的是我们后端CommonResp的数据结构。（data=commonResp）
        mains.value=data.content;
        ebooks1.books=data.content;
        console.log(response)
      })*/
      /*axios.get("http://localhost:8880/main/list").then((response) => {
        const data=response.data;
        mains.value=data.content;
      })*/
    })
    return {
      // ebooks// html代码要拿到响应式变量，需要在setup最后return
      // ebooks2:toRef(ebooks1,"books"),
      mains,
      columns,
      handleSearch,
      handleReset,
      searchText: '',
      searchInput,
      searchedColumn: '',

      loading,
      pagination,
      handleTableChange,
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