<template>
  <div class="login">
    <div class="box">
      <h2>登 录</h2>
      <el-row>&nbsp </el-row>
      <el-row>
        <el-col :span="6">用户名</el-col>
        <el-col :span="16">
          <el-input type="text" v-model="login.userName" placeholder="用户名" @blur="userCheck" @focus="clearUser"/>
        </el-col>
      </el-row>
      <el-row>&nbsp
        <el-col :span="6"></el-col>
        <el-col :span="6">
          <span class="red">{{res.userMessage}}</span>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="6">密 码</el-col>
        <el-col :span="16">
          <el-input type="password" v-model="login.password" placeholder="密码" @blur="passCheck" @focus="clearPass" show-password/>
        </el-col>
      </el-row>
      <el-row>&nbsp
        <el-col :span="6"></el-col>
        <el-col :span="6">
          <span class="red">{{res.passMessage}}</span>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="6"></el-col>

        <el-col :span="5">
          <el-checkbox v-model="login.remember" size="large"></el-checkbox>
          <span class="blue" @click="login.remember = !login.remember">七天免登录</span>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="6"></el-col>
        <el-col :span="12">
          <el-button type="primary" @click="doHidden">login</el-button>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
import {useStore} from 'vuex'
import {Local} from '@/utils/storage_expire'
import {ElMessage} from 'element-plus'
import {HttpManager} from "@/utils/httpmanager";
import {toRefs,reactive,computed} from 'vue'
import * as TYPE from '@/type/actions-type'

export default {
  name: "Login",
  props:{
    doChange:{type:Function}
  },
  setup(props){
    const store = useStore()
    const {doChange} = toRefs(props)
    let login = reactive({
      userName:'',
      password:'',
      remember:false
    })
    let res = reactive({
      userMessage:'',
      passMessage:''
    })

    function doHidden(){
      const args = new FormData()
      args.append("name",login.userName)
      args.append("password",login.password)
      HttpManager.login('/role/login',args)
      .then(data => {
        if(data !== ''){
          doChange.value(true)
          if(login.remember) {
            Local.setExpire('userInfo',data,7*24*60*60*1000)
          }
          ElMessage({
            message:'登录成功',
            type:'success'
          })
          store.commit('Login/store',data)
        } else {
          ElMessage({
            message:'用户名或密码错误',
            type:'warning'
          })
        }

      })

    }
    function userCheck(){
      if(login.userName === '') res.userMessage = '用户名不能为空！'
    }
    function passCheck(){
      if(login.password === '') res.passMessage = '密码不能为空!'
    }
    function clearUser(){ res.userMessage = ''}
    function clearPass(){ res.passMessage = ''}
    return {
      doHidden,
      props,
      login,
      res,
      userCheck,
      passCheck,
      clearUser,
      clearPass
    }
  }
}
</script>

<style scoped>
*{
  margin:0;
  padding:0;
}
.login{
  width:100%;
  height:824px;
  background:url("../assets/image/login.jpg") no-repeat;
  background-size:100% 130%;
  opacity:.6;
  position:relative;
}
.box{
  width:34%;
  height:300px;
  background-color:#DAD9C4;
  z-index:1;
  border-radius:20px;
  position:absolute;
  top:200px;
  left:480px;
  text-align:center;
}
h2{
  margin-top:2rem;
}
.blue{
  font-size:12px;
  color:blue;
}
.red{
  font-size:12px;
  color:red;
}
</style>
