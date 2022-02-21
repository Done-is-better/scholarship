import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import {Local} from '@/utils/storage_expire'
import {ElMessage} from 'element-plus'
const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    redirect:'/index'
  },
  {
    path:'/index',
    name:'Index',
    component: () => import('@/views/Index.vue')
  },
  {
    path:'/scholarship',
    name:'Scholarship',
    component:() => import('@/views/Scholarship.vue')
  },
  {
    path:'/student',
    name:'Student',
    component:() => import('@/views/Student.vue'),
    meta:{needsAuth:true}
  },
  {
    path:'/teacher',
    name:'Teacher',
    meta:{needsAuth:true},
    component:() => import('@/views/Teacher.vue'),
  },
  {
    path:'/userInfo',
    name:'UserInfo',
    component:() => import('@/views/UserInfo.vue')
  },
  {
    name:'Tag',
    path:'/tabs/:tag',
    component:() => import('@/views/Tabs.vue')
  },
  {
    name:'StudentDetail',
    path:'/student-detail',
    component:() => import('@/views/pages/StudentDetail.vue')
  },
  {
    name:'SearchStudent',
    path:'/search-student',
    component:() => import('@/views/SearchStudent.vue')
  },
  {
    name:'SearchTeacher',
    path:'/search-teacher',
    component:() => import('@/views/SearchTeacher.vue')
  }

]


const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

router.beforeEach((to,from,next) =>{
  if(to.meta.needsAuth){
    let res = Local.getExpire('userInfo')
    if(res.auth !== 1 && res.auth !== 0){
      ElMessage({
        type:'warning',
        message:'当前用户无此权限!!!'
      })
    }else{
      next()
    }
  }else{
    next()
  }
})

export default router
