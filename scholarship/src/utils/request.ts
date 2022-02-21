import axios ,{AxiosResponse,AxiosRequestConfig} from 'axios'
import {BASE_URL} from './httpconfig'

axios.defaults.baseURL = BASE_URL
//请求拦截器
// axios.interceptors.request.use((configs:AxiosRequestConfig) =>{
//   return configs;
// })
// //响应拦截器
// axios.interceptors.response.use((response:AxiosResponse) =>{
//   return response;
// }, error =>{
//   return Promise.reject(error)
// })
function post(url:string,data={}){
  return new Promise((resolve,reject) =>{
    axios({
      url,
      data,
      method:'POST'
    }).then(
      response => resolve(response.data),
      error => reject(error.message)
    )
  })

}
function get(url:string,params={}){
  return new Promise((resolve,reject) =>{
    axios({
      url,
      params,
      method:'GET'
    }).then(
      response => resolve(response.data),
      error => reject(error.message)
    )
  })
}
export {post,get}
