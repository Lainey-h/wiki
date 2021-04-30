<template>
  <a-layout-footer style="text-align: center">
    Lainey知识库,欢迎：{{user.name}}
  </a-layout-footer>
</template>

<script lang = "ts">
  import { defineComponent,computed } from 'vue';
  import _default from "ant-design-vue/es/_util/store/Provider";
  import store from "@/store";


  export default defineComponent({
    name: "the-footer",
    setup(){
      const user = computed(() => store.state.user); // 这个user会去通过computed来实时监听store里的user  前端登录成功（在the-header中写的）后会调用setUser为user赋值，这个footer就可以监听到
      return{
        user
      }
    }

  })
</script>

<style scoped>

</style>