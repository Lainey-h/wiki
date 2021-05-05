import { createStore } from 'vuex'

declare let SessionStorage: any;
const USER = "USER";

 const store = createStore({
  state: { // 全局变量
    user: SessionStorage.get(USER) || {}
  },
  mutations: { // 对变量的操作都写在该方法中 同步
    setUser(state,user){
        console.log("store user：", user);
        state.user = user;
        SessionStorage.set(USER, user);
    }

  },
  actions: { // // 对变量的操作都写在该方法中 支持异步
  },
  modules: {
  }
})
export default store;