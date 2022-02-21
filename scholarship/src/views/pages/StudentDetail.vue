<template>
  <div class="expand">
    <el-row>
      <el-col :span="24">
        <el-descriptions title="学生信息:">
          <el-descriptions-item label="姓名:"><span>{{data.studentName}}</span></el-descriptions-item>
          <el-descriptions-item label="学号:" :v-text="options">{{data.studentId}}</el-descriptions-item>
          <el-descriptions-item label="学院:">{{data.college}}</el-descriptions-item>
          <el-descriptions-item label="学分:">
            <el-tag size="small">{{data.scoreLevel}}</el-tag>
          </el-descriptions-item>
          <el-descriptions-item label="管理员:">{{data.admin.teacherName}}</el-descriptions-item>
          <el-descriptions-item label="导师:">{{data.mentor.teacherName}}</el-descriptions-item>
        </el-descriptions>
      </el-col>
    </el-row>
    <el-row>&nbsp</el-row>
    <el-row>
      <el-col :span="24">
        <el-descriptions title="成绩">
          <el-descriptions-item label="Web 前端技术">{{scoreList.score1}}</el-descriptions-item>
          <el-descriptions-item label="Web 框架应用开发">{{scoreList.score2}}</el-descriptions-item>
          <el-descriptions-item label="Android 移动应用开发">{{scoreList.score3}}</el-descriptions-item>
          <el-descriptions-item label="JavaWeb 开发应用">{{scoreList.score4}}</el-descriptions-item>
          <el-descriptions-item label="MySql 数据库开发与应用">{{scoreList.score5}}</el-descriptions-item>
          <el-descriptions-item label="高等数学">{{scoreList.score6}}</el-descriptions-item>
          <el-descriptions-item label="专转本高等数学">{{scoreList.score7}}</el-descriptions-item>
          <el-descriptions-item label="英语四级提高">{{scoreList.score8}}</el-descriptions-item>
          <el-descriptions-item label="体育选修">{{scoreList.score9}}</el-descriptions-item>
          <el-descriptions-item label="时事与政治">{{scoreList.score10}}</el-descriptions-item>
        </el-descriptions>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import {useRoute} from 'vue-router'
import {HttpManager} from "../../utils/httpmanager";
import {onMounted,reactive,shallowRef,ref} from 'vue'
export default {
  name: "StudentDetail",
  setup(){
    let data = reactive({
      studentName:'',
      studentId:'',
      scoreLevel:'',
      college:'',
      mentor:{},
      admin:{}
    })
    let scoreList = reactive({
      score1:'',
      score2:'',
      score3:'',
      score4:'',
      score5:'',
      score6:'',
      score7:'',
      score8:'',
      score9:'',
      score10:''
    })
    onMounted(() =>{
      HttpManager.getStudentDetail(`/student/list/detail/${useRoute().params.studentId}`).then(
          res => {
            data.studentName = res.menuInfo.studentName
            data.studentId = res.menuInfo.studentId
            data.scoreLevel = res.menuInfo.scoreLevel
            data.college = res.menuInfo.college
            data.mentor = res.menuInfo.mentor
            data.admin = res.menuInfo.admin
            scoreList.score1 = res.student.score1
            scoreList.score2 = res.student.score2
            scoreList.score3 = res.student.score3
            scoreList.score4 = res.student.score4
            scoreList.score5 = res.student.score5
            scoreList.score6 = res.student.score6
            scoreList.score7 = res.student.score7
            scoreList.score8 = res.student.score8
            scoreList.score9 = res.student.score9
            scoreList.score10 = res.student.score10
          },
          err => console.log(err.message)
      )
    })

    return {
      data,
      scoreList,
    }
  }
}
</script>

<style scoped>
  .expand{
    height:650px;
    width:100%;
  }
</style>
