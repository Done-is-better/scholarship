<template>
  <div v-show="isShow" class="setting">
<!--    <Suspense>
      <template v-slot:default>
        <Users/>
      </template>
      <template v-slot:fallback>
        <h2>加载中...</h2>
      </template>
    </Suspense>-->
    <el-scrollbar height="650px">
      <Users/>
    </el-scrollbar>
  </div>
</template>

<script>
import {onMounted,computed,ref,defineAsyncComponent} from 'vue'
import {useStore} from 'vuex'
import {Local} from '../utils/storage_expire'
import {ElMessage} from 'element-plus'
//const Users = defineAsyncComponent(() => import('./pages/Users.vue'))
import Users from './pages/Users.vue'
export default {
  name: "UserInfo",
  components:{
    Users
  },
  setup(){
    const user = computed(() => useStore().state.Login.data)
    let isShow = ref(false)

    onMounted(() =>{
      let auth = ''
      if(user.value.auth === undefined){
        auth = Local.getExpire('userInfo').auth
      }else{
        auth = user.value.auth
      }

      if(auth !== 1) ElMessage({
        type:'warning',
        message:'您当前使用的账号无此权限!'
      })
      else{
        isShow.value = true
      }
    })
    return {
      user,
      isShow,
    }
  }
}
</script>

<style scoped>
  .setting{
    height:650px;
  }
</style>
