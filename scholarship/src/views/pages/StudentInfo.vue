<template>
  <el-row>
    <el-col :span="5">
      <el-cascader :options="options" @change="handleChange" size="large"/>
    </el-col>
    <el-col :span="5">
      <el-select v-model="param.pageSize" class="m-2" placeholder="Select" size="large">
        <el-option
            v-for="item in pageSizeList"
            :key="item.value"
            :label="item.label"
            :value="item.value"
        >
        </el-option>
      </el-select>
    </el-col>
    <el-col :span="5">
      <el-select v-model="param.orderState" class="m-2" placeholder="Select" size="large">
        <el-option
            v-for="item in orderList"
            :key="item.value"
            :label="item.label"
            :value="item.value"
        >
        </el-option>
      </el-select>
    </el-col>
    <el-col :span="3">
      <el-button type="success" @click="doChange">搜索</el-button>
    </el-col>
  </el-row>
  <el-row>&nbsp</el-row>
  <el-scrollbar max-height="500">
    <el-table
        :data="tableData"
        style="width: 100%"
    >
      <el-table-column prop="studentId" label="学号" width="180" />
      <el-table-column prop="studentName" label="姓名" width="120" />
      <el-table-column prop="colleageId" label="学院" width="180" />
      <el-table-column prop="mentorId" label="导师" width="180"/>
      <el-table-column prop="adminId" label="管理员" width="180"/>
      <el-table-column label="操作">
        <template v-slot="scope">
          <el-button type="success" size="small" @click="doTrans(scope.row.studentId)">查看</el-button>
          <el-button type="warning" size="small">编辑</el-button>
          <el-button type="danger" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-row>&nbsp</el-row>
    <el-row>
      <el-col :span="6" :offset="8">
        <el-pagination background
                       layout="prev, pager, next"
                       :total="totalPages*10"
                       v-model:currentPage = "param.currentPage"
                       @current-change="doChange">
        </el-pagination>
      </el-col>
    </el-row>
  </el-scrollbar>

</template>

<script>
import {ref,onMounted,reactive} from 'vue'
import {useRouter,useRoute} from 'vue-router'
import {HttpManager} from "../../utils/httpmanager";

export default {
  name: "StudentInfo",
  setup(){
    const router = useRouter()
    const param = reactive({
      classId:'20032933',
      pageSize:10,
      currentPage:1,
      orderState:0
    })
    const totalPages = ref('')
    const tableData = ref([])
    const pageSizeList = ref([
      {value:5, label:5},{value:10, label:10},{value:15, label:15}
    ])
    const orderList = ref([
      {value:0, label:'正序'},{value:1, label:'倒序'}
    ])

    const options = ref([
      {
        value: '信息技术学院',
        label: '信息技术学院',
        children: [
          {
            value: 20030031,
            label: '20030031',
          },{
            value: 20032031,
            label: '20032031',
          },{
            value: 20032332,
            label: '20032332'
          },{
            value: 20032333,
            label: '20032333'
          },{
            value: 20032531,
            label: '20032531'
          },{
            value: 20032931,
            label: '20032931',
          },{
            value: 20032932,
            label: '20032932'
          },{
            value: 20032933,
            label: '20032933'
          },{
            value: 20033231,
            label: '20033231'
          },{
            value: 20033232,
            label: '20033232'
          },{
            value: 20033233,
            label: '20033233'
          }
        ],
      },
      {
        value: '机电技术学院',
        label: '机电技术学院',
        children: [
          {
            value: 20090031,
            label: '20090031'
          },
          {
            value: 20090032,
            label: '20090032'
          },
          {
            value: 20090033,
            label: '20090033'
          },
          {
            value: 20091031,
            label: '20091031'
          },
          {
            value: 20091032,
            label: '20091032'
          },
          {
            value: 20091631,
            label: '20091631'
          },{
            value: 20091731,
            label: '20091731'
          },{
            value: 20093631,
            label: '20093631'
          },{
            value: 20093731,
            label: '20093731'
          }
        ],
      },
      {
        value: '电子商务与物流学院',
        label: '电子商务与物流学院',
        children:[
          {
            value:20010031,
            label:'20010031'
          },{
            value: 20010032,
            label: '20010032'
          },{
            value: 20010131,
            label: '20010131'
          },{
            value: 20010132,
            label: '20010132'
          },{
            value: 20010833,
            label: '20010833'
          },{
            value: 20010834,
            label: '20010834'
          },{
            value: 20011031,
            label: '20011031'
          },{
            value: 20011032,
            label: '20011032'
          },{
            value: 20011033,
            label: '20011033'
          },{
            value: 20011134,
            label: '20011134'
          },{
            value: 20011531,
            label: '20011531'
          },{
            value: 20012131,
            label: '20032131'
          },{
            value: 20012132,
            label: '20012132'
          },{
            value: 20012133,
            label: '20012133'
          },{
            value: 20012234,
            label: '20012134'
          }
        ]
      },
      {value: '会计与国贸学院',
       label: '会计与国贸学院',
       children:[
         {
           label:'20020031',
           value: 20020031
         },{
           label: '20020032',
           value: 20020032
         },{
           label: '20020033',
           value: 20020033
         },{
           label: '20020034',
           value: 20020034
         },{
           label: '20020035',
           value: 20020035
         },{
           label: '20020036',
           value: 20020036
         },{
           label: '20020037',
           value: 20020037
         },{
           label: '20020038',
           value: 20020038
         },{
           label: '20020531',
           value: 20020531
         },{
           label: '20021131',
           value: 20021131
         },{
           label: '20022031',
           value: 20022031
         },{
           label: '20022032',
           value: 20022032
         },{
           label: '20022033',
           value: 20022033
         },{
           label: '20022331',
           value: 20022331
         },{
           label: '20022332',
           value: 20022332
         }
       ]
      },
      {
        value: '纺织服装与艺术传媒学院',
        label: '纺织服装与艺术传媒学院',
        children:[
          {
            value: 20040431,
            label: '20040431'
          },{
            value: 20040831,
            label: '20040831'
          },{
            value: 20040931,
            label: '20040931'
          },{
            value: 20042231,
            label: '20042231'
          },{
            value: 20042232,
            label: '20042242'
          },{
            value: 20042233,
            label: '20042233'
          },{
            value: 20043331,
            label: '20043331'
          },{
            value: 20043332,
            label: '20043332'
          },{
            value: 20043333,
            label: '20043333'
          },{
            value: 20043431,
            label: '20043431'
          },{
            value: 20043631,
            label: '20043631'
          },{
            value: 20043632,
            label: '20043632'
          },{
            value: 20043731,
            label: '20043731'
          },{
            value: 20043834,
            label: '20043834'
          },{
            value: 20043932,
            label: '20043932'
          },{
            value: 20043933,
            label: '20043933'
          }
        ]
      },
      {
        value: '人文社科与旅游管理学院',
        label: '人文社科与旅游管理学院',
        children:[
          {
            label: '20050031',
            value: 20050031
          },{
            label: '20050131',
            value: 20050131
          },{
            label: '20050132',
            value: 20050132
          },{
            label: '20051031',
            value: 20051031
          },{
            label: '20051032',
            value: 20051032
          },{
            label: '20051131',
            value: 20051131
          },{
            label: '20051132',
            value: 20051132
          },{
            label: '20051231',
            value: 20051231
          },{
            label: '20051633',
            value: 20051633
          },{
            label: '20051634',
            value: 20051634
          },{
            label: '20051733',
            value: 20051733
          }
        ]
      }])

    function handleChange(value){
      param.classId = value[1]
      toInvoke();
    }
    onMounted(() =>{
      toInvoke()
    })
    function toInvoke(){
      let data = new FormData()
      data.append('classId',param.classId)
      data.append('pageSize',param.pageSize)
      data.append('currentPage',param.currentPage)
      data.append('orderState',param.orderState)
      HttpManager.getStudentList('/student/list',data).then(
          res => {
            tableData.value = res.data.content
            totalPages.value = res.data.totalPages
          },
          err => console.log(err.message)
      )
    }
    function doChange(){
      toInvoke();
    }
    function doTrans(id){
      router.push({name:'StudentDetail', params:{studentId:id}})
    }
    return {
      options,
      handleChange,
      tableData,
      totalPages,
      doChange,
      param,
      pageSizeList,
      orderList,
      doTrans,
    }
  }
}
</script>

<style scoped>

</style>
