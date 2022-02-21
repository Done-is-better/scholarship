import {Module} from 'vuex'

import {ILogin,IData} from '@/type/login-type'
import * as TYPE from '@/type/actions-type'

const state = {
  data:{}
}
const Login = {
  namespaced:true,
  state,
  mutations:{
    store(state:{data:{}},payload:{}){
      console.log('###STORE#### ',payload)
      state.data = payload
    }
  }
}
export default Login
