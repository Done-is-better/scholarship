import {post,get} from './request'

export const HttpManager = {
  login: (url: string, data: FormData) => post(url,data),
  getEcharts:(url:string) => get(url),
  getRoleList: (url: string, data: FormData) => post(url,data),
  modifyRoleByAdmin: (url: string, data: FormData) => post(url,data),
  deleteRoleByAdmin: (url: string, data: FormData) => post(url,data),
  addRole:(url:string, data: FormData) => post(url,data),
  getTeacherList:(url:string) => get(url),
  getStudentsWithSameTeacher:(url:string, data:{}) => post(url,data),
  getStudentList:(url:string,data:FormData) => post(url,data),
  getStudentDetail:(url:string) => get(url),
  getScholarList:(url:string) => get(url),
  getSearchList:(url:string) => get(url),
  getSearchTeacher:(url:string) => get(url),
}
