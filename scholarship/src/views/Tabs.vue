<template>
  <el-tabs v-model="picker" class="demo-tabs" @tab-click="handleClick">
    <el-tab-pane label="奖学金评定办法" name="textInfo"><TextInfo/></el-tab-pane>
    <el-tab-pane label="Config" name="second">Config</el-tab-pane>
    <el-tab-pane label="Role" name="third">Role</el-tab-pane>
    <el-tab-pane label="Task" name="fourth">Task</el-tab-pane>
  </el-tabs>
</template>
<script lang="ts">
import { ref } from 'vue'
import {useRoute} from 'vue-router'
import TextInfo from './pages/TextInfo.vue'
export default {
  name:"Tabs",
  components:{
    TextInfo,
  },
  setup(){
    const route = useRoute()
    const picker = ref('second')
    picker.value = route.params.tag as string
    const handleClick = (tab: string, event: Event) => {
      console.log(tab, event)
    }
    return {
      picker,
      handleClick
    }
  }
}
</script>
<style scoped>
.demo-tabs > .el-tabs__content {
  padding: 32px;
  background-color: #f4f5f7;
  color: #6b778c;
  font-size: 32px;
  font-weight: 600;
}
</style>
