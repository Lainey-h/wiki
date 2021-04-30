import { createStore } from 'vuex'

 const store = createStore({
  state: { // 全局变量
    user: {}
  },
  mutations: { // 对变量的操作都写在该方法中 同步
    setUser(state,user){
      state.user = user;
    }

  },
  actions: { // // 对变量的操作都写在该方法中 支持异步
  },
  modules: {
  }
})
export default store;