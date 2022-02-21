<template>
  <div id="nav">
    <Home v-if="isLog == true" :change="logStatus"/>
    <Login v-if="isLog == false" :doChange="logStatus"/>
  </div>

</template>
<script lang="ts">
  import {Local,storageInit} from '@/utils/storage_expire'
  import {defineComponent,ref,watch,onMounted} from 'vue'
  import Home from './views/Home.vue'
  import Login from './components/Login.vue'
  export default defineComponent({
    name:'App',
    components:{
      Home,
      Login,
    },
    setup(){
      storageInit()
      let isLog = ref(false)
      function logStatus(value:boolean){
        isLog.value = value
      }
      if(Local.getExpire('userInfo')){
        isLog.value = true
      }
      watch(isLog,() => console.log(isLog.value),{immediate:true})
      return {
        isLog,
        logStatus
      }
    }
  })
</script>
<style>
 *{
   margin:0;
   padding:0;
 }
</style>
