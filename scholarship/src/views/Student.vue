<template>
  <div class="expand">
    <StudentInfo/>
  </div>
</template>

<script>
import StudentInfo from './pages/StudentInfo.vue'

export default {
  name: "Student",
  components:{
    StudentInfo
  }
}
</script>

<style scoped>
  .expand{
    width: 100%;
    height: 650px;
  }
</style>
