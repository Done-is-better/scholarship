<template>
  <el-row>
    <el-col :span="6">
      <el-card class="box-card card1" ref="card1"></el-card>
    </el-col>
    <el-col :span="6" :offset="1">
      <el-card class="box-card card2"></el-card>
    </el-col>
    <el-col :span="10" :offset="1">
      <el-card class="box-card card3"></el-card>
    </el-col>
  </el-row>
  <el-row>
    <el-col :span="24">&nbsp</el-col>
  </el-row>
  <el-row>
    <el-col :span="12">
      <el-card class="box-card card4"></el-card>
    </el-col>
    <el-col :span="11" :offset="1">
      <el-card class="box-card card5"></el-card>
    </el-col>
  </el-row>
</template>

<script>
import * as echarts from 'echarts'
import {HttpManager} from '../utils/httpmanager'
import {getCurrentInstance,onMounted,ref} from 'vue'
export default {
  name: "Index",
  setup(){
    //let currentInstance = ''
    let card1 = ref(null)
    onMounted(() =>{
      HttpManager.getEcharts('/echarts/chart/1').then(
          data => echarts.init(document.querySelector('.card1'),'light').setOption({
            tooltip:{
              trigger:'item'
            },
            legend:{
              right:'right',
              top:'10px'
            },
            radar:{
              indicator:[
                {
                  name:'机电',
                  max:5.0
                },{
                  name:'电商',
                  max:5.0
                },{
                  name:'会国',
                  max:5.0
                },{
                  name:'信息',
                  max:5.0
                },{
                  name:'纺艺',
                  max:5.0
                },{
                  name:'人旅',
                  max:5.0
                }
              ]
            },
            series:[
              {
                type:'radar',
                data:[{
                  name:'最高绩点',
                  value:data.high
                },{
                  name:'最低绩点',
                  value:data.low
                }]
              }
            ]
          }),
          error => console.log(error.message)
      )
      HttpManager.getEcharts('/echarts/chart/2').then(
          data => echarts.init(document.querySelector('.card2'),'light').setOption({
            title:{
              text:'各学院获奖总人数',
              left:'center',
              textStyle:{
                fontWeight:'lighter'
              }
            },
            tooltip:{
              trigger:'item',
            },
            legend:{
              left:'center',
              top:'bottom',
            },
            series:[
              {
                name: "人数",
                type: "pie",
                //内外半径
                radius: [20, 110],
                center: ["50%", "50%"],
                //半径模式
                roseType: "radius",
                label: {
                  show: false
                },
                labelLine: {
                  length: 12,
                  length2: 20
                },
                emphasis: {
                  label: {
                    show: true
                  }
                },
                data: [
                  { value: data.num[0], name: "机电" },
                  { value: data.num[1], name: "电商" },
                  { value: data.num[2], name: "会国" },
                  { value: data.num[3], name: "信息" },
                  { value: data.num[4], name: "纺艺" },
                  { value: data.num[5], name: "人旅" },
                ]
              }
            ]
          })
      )
      HttpManager.getEcharts('/echarts/chart/3').then(
          data => echarts.init(document.querySelector('.card3'),'light').setOption({
            title:{
              text:'各奖项人数',
              left:'center',
              textStyle:{
                color:'black',
                fontWeight:'lighter',
              }
            },
            tooltip:{},
            xAxis:{
              type:'category',
              data:['机电','电商','会国','信息','纺艺','人旅']
            },
            yAxis:{
              type:'value'
            },
            series:[
              {
                name:'一等奖',
                type:'bar',
                data:data.list1,
                markPoint:{
                  data:[
                    {name:'high',type:'max'},{name:'low',type:'min'}
                  ]
                },
                label:{
                  show:true,
                  rotate: 60,
                },
                barWidth:'30%'
              },{
                name:'二等奖',
                type:'bar',
                data:data.list2,
                markPoint:{
                  data:[
                    {name:'high',type:'max'},{name:'low',type:'min'}
                  ]
                },
                label:{
                  show:true,
                  rotate: 60,
                },
                barWidth:'30%'
              },{
                name:'三等奖',
                type:'bar',
                data:data.list3,
                markPoint:{
                  data:[
                    {name:'high',type:'max'},{name:'low',type:'min'}
                  ]
                },
                label:{
                  show:true,
                  rotate: 60,
                },
                barWidth:'30%'
              }
            ]
          })
      )

      echarts.init(document.querySelector('.card4'),'light').setOption({

        xAxis:{
          type:'category'
        },
        yAxis:{
          type:'value'
        },
        series:[
          {
            name: "直接登录",
            data: [123, 23, 33, 42, 123, 5, 142],
            type: "line",
            stack: "总量",
            smooth: true,
            //修改当先线条样式
            lineStyle: {
              color: "blue",
              width: 2
            },
            areaStyle: {
              color: new echarts.graphic.LinearGradient(
                  0,
                  0,
                  0,
                  1, [{
                    offset: 0,
                    //渐变色起始颜色
                    color: "#003B7D"
                  },
                    {
                      offset: 0.4,
                      color: "#2F68E2"
                    },
                    {
                      offset: 0.8,
                      //结束颜色
                      color: "#17ABFF"
                    }
                  ], false
              ),
              shadowColor: "rgba(1,1,1,.2)"
            },
            //设置拐点、大小及显示
            symbol: "circle",
            symbolSize: 4,
            showSymbol: false,
            //设置拐点颜色、边框
            itemStyle: {
              color: "yellow",
              borderColor: "rgba(13,45,31,.5)",
              borderWidth: 12
            }

      }]

      })
      HttpManager.getEcharts('/echarts/chart/3').then(
          data => echarts.init(document.querySelector('.card5'),'light').setOption({
            title:{
              text:'各院一等奖统计',
              left:'center',
              textStyle:{
                color:'silver',
                fontWeight:'lighter'
              },
            },
            legend:{
              right:'20px',
              top:'10px'
            },
            tooltip:{
              trigger:'axis'
            },
            xAxis:{
              type:'category',
              data:['机电','电商','会国','信息','纺艺','人旅']
            },
            yAxis:{
              type:'value'
            },
            series:[
              {
                name:'个数',
                type:'line',
                data:data.list1,
                stack:'总量',
                lineStyle:{
                  color:'blue',
                  width:2
                },
                symbol:'circle',
                symbolSize:4,
                showSymbol:false,
                itemStyle:{
                  color:'yellow',
                  borderStyle:'rgba(13,45,31,.5)',
                  borderWidth:12
                }
              }
            ]
          })
      )

    })
    return {
      card1
    }
  }
}
</script>

<style scoped>

  .box-card{
    width:100%;
    height:310px;
    background-color:#FFFDFC
  }
</style>
