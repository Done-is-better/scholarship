<template>
  <el-row>
    <el-col :span="6">
      <el-input placeholder="请输入姓名、工号" v-model="input" @keyup.enter="doSearch"/>
    </el-col>
    <el-col :span="2">
      <el-button type="success" @click="doSearch">搜索</el-button>
    </el-col>
  </el-row>
  <el-row></el-row>
  <el-scrollbar height="615px">
    <el-table :data="store" border style="width: 100%">
      <el-table-column prop="teacher.teacherId" label="ID" width="180" />
      <el-table-column prop="teacher.teacherName" label="姓名" width="180" />
      <el-table-column prop="course.courseName" label="授课内容" />
    </el-table>
  </el-scrollbar>
</template>

<script>
import {HttpManager} from "../utils/httpmanager";
import {ref,reactive,shallowRef} from 'vue'
export default {
  name: "SearchTeacher",
  setup(){
    let input = ref('')
    let store = shallowRef([])
    function doSearch(){
      HttpManager.getSearchTeacher(`/teacher/search/${input.value}`).then(
          res =>{
            store.value = res
            console.log(' @@@ ',store.value)
          },
          err => console.log(err.message)
      )
    }
    return {
      input,
      doSearch,
      store,
    }
  }
}
</script>

<style scoped>

</style>
