import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import Antd from 'ant-design-vue';
import 'ant-design-vue/dist/antd.css';

createApp(App as any).use(store).use(router).use(Antd).mount('#app');// hll在 'App' 后加了一个any 解决Tsetse45问题
