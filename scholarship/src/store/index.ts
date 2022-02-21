import { createStore } from 'vuex'
import {IHome} from '@/type/home-type'
import {ILogin} from '@/type/login-type'
//import Home from './modules/Home'
import Login from './modules/Login'
// export interface IGlobalState{
//   Home:IHome,
//   Login:ILogin
// }
// export default createStore<IGlobalState>({
//   modules: {
//     Home,
//     Login
//   }
// })
export default createStore({
  modules:{
    //Home,
    Login
  }
})
