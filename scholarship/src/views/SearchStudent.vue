<template>
  <el-row>
    <el-col :span="6">
      <el-input v-model="input" placeholder="输入姓名或学号" @keydown.enter="doSearch"/>
    </el-col>
    <el-col :span="2" :offset="1">
      <el-button type="primary" @click="doSearch">查询</el-button>
    </el-col>
  </el-row>
  <el-row>&nbsp</el-row>
  <el-row>
    <el-col :span="24">
      <el-scrollbar height="600px">
        <el-table :data="tableData" border style="width: 100%">
          <el-table-column prop="student.studentId" label="ID" width="180" />
          <el-table-column prop="student.studentName" label="姓名" width="180" />
          <el-table-column prop="college.collegeName" label="学院" width="180"/>
          <el-table-column prop="admin.teacherName" label="辅导员" width="180"/>
          <el-table-column prop="mentor.teacherName" label="导师" width="180"/>
        </el-table>
      </el-scrollbar>
    </el-col>
  </el-row>
</template>

<script>
import {HttpManager} from '../utils/httpmanager'
import {ref,shallowRef} from 'vue'
export default {
  name: "SearchStudent",
  setup(){
    const input = ref('')
    let tableData = shallowRef([])
    function doSearch(){
      HttpManager.getSearchList(`/student/search/${input.value}`).then(
          res => {
            tableData.value = res
            console.log('#### RES ####',res)
          },
          err => console.log(err.message)
      )
    }
    return {
      input,
      doSearch,
      tableData,
    }
  }
}
</script>

<style scoped>

</style>
