<template>
  <el-row>
    <el-col :span="6">
      <el-select v-model="value" class="m-2" placeholder="请选择" size="large">
        <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value"
            @click="doSearch"
        >
        </el-option>
      </el-select>
    </el-col>
  </el-row>
  <el-row>&nbsp</el-row>
  <el-row>
    <el-col :span="24">
      <el-scrollbar height="590px">
        <el-table :data="scholarList" stripe style="width: 100%">
          <el-table-column prop="item.studentId" label="ID" width="180" align="center"/>
          <el-table-column prop="item.studentName" label="姓名" width="140" align="center"/>
          <el-table-column prop="SCI" label="绩点" width="240" align="center"/>
          <el-table-column prop="level" label="LEVEL" width="140" align="center"/>
          <el-table-column prop="college.collegeName" label="学院" width="200" align="center"/>
          <el-table-column prop="admin.teacherName" label="辅导员" width="140" align="center"/>
          <el-table-column prop="mentor.teacherName" label="导师" width="140" align="center"/>
        </el-table>
      </el-scrollbar>
    </el-col>
  </el-row>
  <el-row>
    <el-col :span="24">

    </el-col>
  </el-row>
</template>

<script>
import {HttpManager} from '../../utils/httpmanager'
import {reactive,ref,shallowRef,onMounted} from 'vue'
export default {
  name: "ScholarList",
  setup(){
    const value = ref('')
    const options = reactive([
      {
        label:'信息技术学院',
        value:3
      },{
        label:'机电技术学院',
        value:0
      },{
        label:'电子商务与物理学院',
        value:1
      },{
        label:'会计与国贸学院',
        value:2
      },{
        label:'纺织服装与艺术传媒学院',
        value:4
      },{
        label:'人文社科与旅游管理学院',
        value:5
      }
    ])
    let scholarList = shallowRef([])
    function doSearch(){
      HttpManager.getScholarList(`/student/scholarship/${value.value}`).then(
          res => {
            scholarList.value = res
          },
          err => console.log(err.message)
      )
    }
    onMounted(() => {
      HttpManager.getScholarList('/student/scholarship/3').then(
          res => scholarList.value = res,
          err => console.log(err.message)
      )
    })
    return {
      options,
      value,
      doSearch,
      scholarList,
    }
  }
}
</script>

<style scoped>

</style>
