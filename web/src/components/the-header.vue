<template>
  <a-layout-header class="header">
    <div class="logo" />
    <a-menu
        theme="dark"
        mode="horizontal"
        :default-selected-keys="['2']"
        :style="{ lineHeight: '64px' }"
    >
      <a-menu-item key="/">
        <router-link to="/">首页</router-link> |
      </a-menu-item>
      <a-menu-item key="/admin/user">
        <router-link to="/admin/user">用户管理</router-link> |
      </a-menu-item>
      <a-menu-item key="/admin/main">
        <router-link to="/admin/main">案例管理</router-link> |
      </a-menu-item>
      <a-menu-item key="/about">
        <router-link to="/about">关于我们</router-link> |
      </a-menu-item>

      <a class="login-menu"  v-show="user.id" >
        <span>您好：{{ user.name }}</span>
      </a>
      <a class="login-menu"  v-show="!user.id"  @click="showLoginModal">
        <span>登录</span>
      </a>

    </a-menu>

    <a-modal
        title="登录"
        v-model:visible="loginModalVisible"
        :confirm-loading="loginModalLoading"
        @ok="login"
    >
      <a-form :model="loginUser" :label-col="{ span: 6 }" :wrapper-col="{ span: 18 }">
        <a-form-item label="登录名">
          <a-input v-model:value="loginUser.loginName" />
        </a-form-item>
        <a-form-item label="密码">
          <a-input v-model:value="loginUser.password" type="password" />
        </a-form-item>
      </a-form>
    </a-modal>
  </a-layout-header>
</template>

<script lang="ts">
import { defineComponent, ref,} from 'vue';
import axios from 'axios';
import { message } from 'ant-design-vue';
import store from "@/store";

declare let hexMd5: any;
declare let KEY: any;


export default defineComponent({
  name: "the-header",

  setup () {
    // 登陆后保存
    const user  = ref(); // user:从后端返回出来的登录信息
    user.value={}; //初始给他一个空对象，避免空指针异常
    // 用来登录
    const loginUser = ref({
      loginName: "test",
      password: "test123" // 默认密码
    });
    const loginModalVisible = ref(false);
    const loginModalLoading = ref(false);
    const showLoginModal = () => {
      loginModalVisible.value = true;
    };

    // 登录
    const login = () => {
      console.log("开始登录");
      loginModalLoading.value = true;
      loginUser.value.password = hexMd5(loginUser.value.password + KEY);
      axios.post('/user/login', loginUser.value).then((response) => {
        loginModalLoading.value = false;
        const data = response.data;
        if (data.success) {
          loginModalVisible.value = false;
          message.success("登录成功！");
          user.value = data.content;
          // store.commit("setUser", data.content);
        } else {
          message.error(data.message);
        }
      });
    };

    return{
      loginModalLoading,
      loginModalVisible,
      showLoginModal,
      loginUser,
      login,
      user,
    }
  }
});
</script>

<style scoped>

.login-menu {
  float: right;
  color: white;
  padding-left: 10px;
}
</style>