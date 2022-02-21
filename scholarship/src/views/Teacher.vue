<template>
  <el-row>
    <el-col :span="8" >
      <el-input placeholder="输入姓名、工号" v-model="search.param" @keyup.enter="doSearch"/>
    </el-col>
    <el-col :span="4" :offset="1">
      <el-input-number v-model="search.pageSize" :min="1" :max="12" />
    </el-col>
    <el-col :span="4">
      <el-button type="primary" @click="doSearch">搜索</el-button>
    </el-col>
  </el-row>
  <el-row>
    <el-col >&nbsp</el-col>
  </el-row>
  <el-row>
    <el-col :span="12">
      <el-scrollbar height="600px">
        <el-table
            :data="tableData"
            style="width: 100%"
        >
          <el-table-column prop="id" label="NO." width="80" />
          <el-table-column prop="name" label="姓名" width="120" />
          <el-table-column prop="teacherId" label="工号" width="180" />
          <el-table-column prop="course" label="课程" width="180"/>
        </el-table>
      </el-scrollbar>
    </el-col>
    <el-col :span="12">
      <el-scrollbar height="600px">
        <el-table
            :data="searchList"
            style="width: 100%"
        >
          <el-table-column prop="studentId" label="ID" width="200"/>
          <el-table-column prop="studentName" label="姓名" width="180"/>
          <el-table-column prop="colleageId" label="学院" width="180"/>
        </el-table>
        <el-row>&nbsp </el-row>
        <el-row>
          <el-col :span="12" :offset="4">
            <el-pagination background layout="prev, pager, next"
                           :total="totalPages*10"
                           v-model:currentPage="search.currentPage"
                           @current-change="doSearch">

            </el-pagination>
          </el-col>
        </el-row>
      </el-scrollbar>
    </el-col>
  </el-row>
</template>

<script>
import {HttpManager} from '../utils/httpmanager'
import {reactive,ref,onMounted} from 'vue'
import {ElMessage} from "element-plus";
export default {
  name: "Teacher",
  setup(){
    const tableData= ref([])
    let searchList = ref([])
    let totalPages = ref('')
    const search = reactive({
      param:'',
      currentPage:1,
      pageSize:8
    })
    onMounted(() =>{
      HttpManager.getTeacherList('/teacher/list').then(
          res => {
            tableData.value = res.data
          },
          err => console.log(err.message)
      )
    })
    function doSearch(){
      if(search.param.trim() === ''){
        ElMessage({
          type: 'warning',
          message: '姓名或工号不能为空'
        })
        return;
      }
      let data = new FormData()
      data.append('param',search.param.trim())
      data.append('currentPage',search.currentPage)
      data.append('pageSize',search.pageSize)
      HttpManager.getStudentsWithSameTeacher('/student/list/students',data).then(
          res => {
            searchList.value = res.content
            totalPages.value = res.totalPages
            console.log(' res ==== ',res)
          },
          err => console.log(err.message)
      )
    }

    return {
      tableData,
      searchList,
      doSearch,
      search,
      totalPages
    }
  }
}
</script>

<style scoped>
.el-table .warning-row {
  --el-table-tr-bg-color: var(--el-color-warning-lighter);
}
.el-table .success-row {
  --el-table-tr-bg-color: var(--el-color-success-lighter);
}
</style>
