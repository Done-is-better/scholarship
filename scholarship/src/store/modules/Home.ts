// import {IHome} from '@/type/home-type'
// import {Module} from 'vuex'
// import {IGlobalState} from '..'
// import * as TYPE from '@/type/actions-type'
//
// const state:IHome = {
//   swiper : [],
//   nav:[]
// }
// const Home:Module<IHome,IGlobalState> = {
//   namespaced: true,
//   state,
//   mutations:{
//     [TYPE.SET_NAV](state, payload=[]){
//       state.swiper = payload
//     }
//   },
//   actions:{
//     async [TYPE.SET_NAV]({commit}){   //content,value
//       // const nav = await getData()
//       const nav = [1,2]
//       commit(TYPE.SET_NAV,nav)
//     }
//   }
// }
// export default Home
