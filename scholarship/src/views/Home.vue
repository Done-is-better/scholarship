<template>
  <el-container>
    <el-aside style="background-color:#31367D" v-if="!showMenu">
      <div class="title">
        Scholarship
      </div>
      <div>
        <el-row class="tac">
          <el-col :span="24">
            <el-menu
                active-text-color="#ffd04b"
                background-color="#31367D"
                class="el-menu-vertical-demo"
                default-active="2"
                text-color="#fff"
                @open="handleOpen"
                @close="handleClose"
            >

              <router-link to="/" class="router">
                <el-menu-item index="1">
                  <el-icon><icon-menu /></el-icon>
                  <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-card-text" viewBox="0 0 16 16">
                    <path d="M14.5 3a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-13a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h13zm-13-1A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h13a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-13z"/>
                    <path d="M3 5.5a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zM3 8a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9A.5.5 0 0 1 3 8zm0 2.5a.5.5 0 0 1 .5-.5h6a.5.5 0 0 1 0 1h-6a.5.5 0 0 1-.5-.5z"/>
                  </svg>&nbsp
                  首 页
                </el-menu-item>
              </router-link>
              <el-sub-menu index="2">
                <template #title>
                  <el-icon><location /></el-icon>
                  <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-sliders" viewBox="0 0 16 16">
                    <path fill-rule="evenodd" d="M11.5 2a1.5 1.5 0 1 0 0 3 1.5 1.5 0 0 0 0-3zM9.05 3a2.5 2.5 0 0 1 4.9 0H16v1h-2.05a2.5 2.5 0 0 1-4.9 0H0V3h9.05zM4.5 7a1.5 1.5 0 1 0 0 3 1.5 1.5 0 0 0 0-3zM2.05 8a2.5 2.5 0 0 1 4.9 0H16v1H6.95a2.5 2.5 0 0 1-4.9 0H0V8h2.05zm9.45 4a1.5 1.5 0 1 0 0 3 1.5 1.5 0 0 0 0-3zm-2.45 1a2.5 2.5 0 0 1 4.9 0H16v1h-2.05a2.5 2.5 0 0 1-4.9 0H0v-1h9.05z"/>
                  </svg>&nbsp
                  <span>基础信息管理</span>
                </template>
                <el-menu-item-group title="学生信息">
                  <router-link to="/student" class="router">
                    <el-menu-item index="1-1">
                      <span class="box">
                        学生信息管理
                      </span>
                    </el-menu-item>
                  </router-link>
                  <router-link to="/search-student" class="router">
                    <el-menu-item index="1-2">
                      <span class="box">
                        学生信息查询
                      </span>
                    </el-menu-item>
                  </router-link>
                </el-menu-item-group>

                <el-menu-item-group title="教师信息">
                  <router-link to="/teacher" class="router">
                    <el-menu-item index="1-3">
                      <span class="box">
                        教师信息管理
                      </span>
                    </el-menu-item>
                  </router-link>
                  <router-link to="/search-teacher" class="router">
                    <el-menu-item index="1-4">
                      <span class="box">
                        教师信息查询
                      </span>
                    </el-menu-item>
                  </router-link>
                </el-menu-item-group>
                <el-sub-menu index="1-4">
                  <template #title>item four</template>
                  <el-menu-item index="1-4-1">item one</el-menu-item>
                </el-sub-menu>
              </el-sub-menu>
              <router-link to="/scholarship" class="router">
                <el-menu-item index="3">
                  <el-icon><document /></el-icon>
                  <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-pencil" viewBox="0 0 16 16">
                    <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/>
                  </svg>&nbsp
                  <span>
                    奖学金评定
                  </span>
                </el-menu-item>
              </router-link>
              <router-link to="/userInfo" class="router">
                <el-menu-item index="4">
                  <el-icon><setting /></el-icon>
                  <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-people" viewBox="0 0 16 16">
                    <path d="M15 14s1 0 1-1-1-4-5-4-5 3-5 4 1 1 1 1h8zm-7.978-1A.261.261 0 0 1 7 12.996c.001-.264.167-1.03.76-1.72C8.312 10.629 9.282 10 11 10c1.717 0 2.687.63 3.24 1.276.593.69.758 1.457.76 1.72l-.008.002a.274.274 0 0 1-.014.002H7.022zM11 7a2 2 0 1 0 0-4 2 2 0 0 0 0 4zm3-2a3 3 0 1 1-6 0 3 3 0 0 1 6 0zM6.936 9.28a5.88 5.88 0 0 0-1.23-.247A7.35 7.35 0 0 0 5 9c-4 0-5 3-5 4 0 .667.333 1 1 1h4.216A2.238 2.238 0 0 1 5 13c0-1.01.377-2.042 1.09-2.904.243-.294.526-.569.846-.816zM4.92 10A5.493 5.493 0 0 0 4 13H1c0-.26.164-1.03.76-1.724.545-.636 1.492-1.256 3.16-1.275zM1.5 5.5a3 3 0 1 1 6 0 3 3 0 0 1-6 0zm3-2a2 2 0 1 0 0 4 2 2 0 0 0 0-4z"/>
                  </svg>&nbsp
                  <span>
                    用户管理
                  </span>
                </el-menu-item>
              </router-link>
            </el-menu>
          </el-col>
        </el-row>
      </div>
    </el-aside>
    <el-container>
      <el-header style="background-color:#CEAA61">
        <el-row>
          <div style="width:2rem;height:0.8rem"></div>
        </el-row>
        <el-row>
          <el-col :span="2">
            <span v-if="showMenu" @click="showMenu = !showMenu" class="top1">
              <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-list" viewBox="0 0 16 16">
                <path fill-rule="evenodd" d="M2.5 12a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5z"/>
              </svg>
            </span>
            <span v-if="!showMenu" @click="showMenu = !showMenu" class="top1">
              <svg xmlns="http://www.w3.org/2000/svg" width="27" height="27" fill="currentColor" class="bi bi-chevron-double-left" viewBox="0 0 16 16">
                <path fill-rule="evenodd" d="M8.354 1.646a.5.5 0 0 1 0 .708L2.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0z"/>
                <path fill-rule="evenodd" d="M12.354 1.646a.5.5 0 0 1 0 .708L6.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0z"/>
              </svg>
            </span>
          </el-col>
          <el-col :span="6" :offset="6">
            <span v-if="showMenu" class="mainTitle">Scholarship</span>
            <span v-if="!showMenu" class="mainTitle">奖学金后台管理系统</span>
          </el-col>
          <el-col :span="1" :offset="6" style="margin-top:8px" @click="drawer = !drawer">
              <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-question-circle" viewBox="0 0 16 16">
              <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
              <path d="M5.255 5.786a.237.237 0 0 0 .241.247h.825c.138 0 .248-.113.266-.25.09-.656.54-1.134 1.342-1.134.686 0 1.314.343 1.314 1.168 0 .635-.374.927-.965 1.371-.673.489-1.206 1.06-1.168 1.987l.003.217a.25.25 0 0 0 .25.246h.811a.25.25 0 0 0 .25-.25v-.105c0-.718.273-.927 1.01-1.486.609-.463 1.244-.977 1.244-2.056 0-1.511-1.276-2.241-2.673-2.241-1.267 0-2.655.59-2.75 2.286zm1.557 5.763c0 .533.425.927 1.01.927.609 0 1.028-.394 1.028-.927 0-.552-.42-.94-1.029-.94-.584 0-1.009.388-1.009.94z"/>
            </svg>
          </el-col>
          <el-drawer v-model="drawer" title="奖学金评定说明" :with-header="false">
            <span>
              <h4>奖学金评定说明</h4>
              <p class="gap">总则</p>
              <p class="context text-gap">
                为了鼓励学生刻苦学习，奋发向上，促进学生德、智、体、美等全面发展，根据<a href="http://www.moe.gov.cn/srcsite/A02/s5911/moe_621/201702/t20170216_296385.html" target="_blank" class="context">《普通高等学校学生管理规定》（教育部〔2017〕41号令）</a>、
                <a href="http://tyx.jssnu.edu.cn/2020/0911/c3136a34333/page.htm" target="_blank" class="context">《国家学生体质健康标准》（教体艺〔2014〕5号）</a>等文件精神，结合我校实际，特制定本办法</p>
              <p class="gap">覆盖范围</p>
              <p class="text-gap context">我校2020届学生体侧成绩大于70分，按绩点择优授奖，一等奖占各学院%5，二等奖10%，三等奖15%</p>
              <p class="gap">绩点评定规则</p>
              <p class="text-gap context">学期平均绩点=∑（每一科绩点*每一科学分）/该学期学分总和</p>
              <p class="gap"><router-link :to="`/tabs/textInfo`" @click="drawer = false">评定细则</router-link></p>
            </span>
          </el-drawer>
          <el-col :span="2">
            <el-dropdown>
              <el-avatar  :src="avatar" >
                <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-fingerprint" viewBox="0 0 16 16">
                  <path d="M8.06 6.5a.5.5 0 0 1 .5.5v.776a11.5 11.5 0 0 1-.552 3.519l-1.331 4.14a.5.5 0 0 1-.952-.305l1.33-4.141a10.5 10.5 0 0 0 .504-3.213V7a.5.5 0 0 1 .5-.5Z"/>
                  <path d="M6.06 7a2 2 0 1 1 4 0 .5.5 0 1 1-1 0 1 1 0 1 0-2 0v.332c0 .409-.022.816-.066 1.221A.5.5 0 0 1 6 8.447c.04-.37.06-.742.06-1.115V7Zm3.509 1a.5.5 0 0 1 .487.513 11.5 11.5 0 0 1-.587 3.339l-1.266 3.8a.5.5 0 0 1-.949-.317l1.267-3.8a10.5 10.5 0 0 0 .535-3.048A.5.5 0 0 1 9.569 8Zm-3.356 2.115a.5.5 0 0 1 .33.626L5.24 14.939a.5.5 0 1 1-.955-.296l1.303-4.199a.5.5 0 0 1 .625-.329Z"/>
                  <path d="M4.759 5.833A3.501 3.501 0 0 1 11.559 7a.5.5 0 0 1-1 0 2.5 2.5 0 0 0-4.857-.833.5.5 0 1 1-.943-.334Zm.3 1.67a.5.5 0 0 1 .449.546 10.72 10.72 0 0 1-.4 2.031l-1.222 4.072a.5.5 0 1 1-.958-.287L4.15 9.793a9.72 9.72 0 0 0 .363-1.842.5.5 0 0 1 .546-.449Zm6 .647a.5.5 0 0 1 .5.5c0 1.28-.213 2.552-.632 3.762l-1.09 3.145a.5.5 0 0 1-.944-.327l1.089-3.145c.382-1.105.578-2.266.578-3.435a.5.5 0 0 1 .5-.5Z"/>
                  <path d="M3.902 4.222a4.996 4.996 0 0 1 5.202-2.113.5.5 0 0 1-.208.979 3.996 3.996 0 0 0-4.163 1.69.5.5 0 0 1-.831-.556Zm6.72-.955a.5.5 0 0 1 .705-.052A4.99 4.99 0 0 1 13.059 7v1.5a.5.5 0 1 1-1 0V7a3.99 3.99 0 0 0-1.386-3.028.5.5 0 0 1-.051-.705ZM3.68 5.842a.5.5 0 0 1 .422.568c-.029.192-.044.39-.044.59 0 .71-.1 1.417-.298 2.1l-1.14 3.923a.5.5 0 1 1-.96-.279L2.8 8.821A6.531 6.531 0 0 0 3.058 7c0-.25.019-.496.054-.736a.5.5 0 0 1 .568-.422Zm8.882 3.66a.5.5 0 0 1 .456.54c-.084 1-.298 1.986-.64 2.934l-.744 2.068a.5.5 0 0 1-.941-.338l.745-2.07a10.51 10.51 0 0 0 .584-2.678.5.5 0 0 1 .54-.456Z"/>
                  <path d="M4.81 1.37A6.5 6.5 0 0 1 14.56 7a.5.5 0 1 1-1 0 5.5 5.5 0 0 0-8.25-4.765.5.5 0 0 1-.5-.865Zm-.89 1.257a.5.5 0 0 1 .04.706A5.478 5.478 0 0 0 2.56 7a.5.5 0 0 1-1 0c0-1.664.626-3.184 1.655-4.333a.5.5 0 0 1 .706-.04ZM1.915 8.02a.5.5 0 0 1 .346.616l-.779 2.767a.5.5 0 1 1-.962-.27l.778-2.767a.5.5 0 0 1 .617-.346Zm12.15.481a.5.5 0 0 1 .49.51c-.03 1.499-.161 3.025-.727 4.533l-.07.187a.5.5 0 0 1-.936-.351l.07-.187c.506-1.35.634-2.74.663-4.202a.5.5 0 0 1 .51-.49Z"/>
                </svg>
              </el-avatar>
              <template #dropdown>
                <el-dropdown-menu>
                  <el-dropdown-item style="font-size:12px">
                    <span>当前用户:&nbsp </span>
                    <span>{{user.role}}</span>
                    <span v-if="!user.role">{{userInfo.role}}</span>
                  </el-dropdown-item>
                  <el-dropdown-item>
                    <router-link to="/tabs/textInfo" class="box">评定细则</router-link>
                  </el-dropdown-item>
                  <el-dropdown-item>Action 3</el-dropdown-item>
                  <el-dropdown-item>Action 4</el-dropdown-item>
                  <el-dropdown-item><span @click="logout" class="box">注 销</span></el-dropdown-item>
                </el-dropdown-menu>
              </template>
            </el-dropdown>
          </el-col>
        </el-row>

      </el-header>
      <el-main style="background-color:#EEF3FF">
        <router-view/>
      </el-main>
    </el-container>
  </el-container>
</template>

<script lang="ts">
import {ElMessageBox,ElMessage} from 'element-plus'
import {Local} from '@/utils/storage_expire'
import { defineComponent,toRefs,ref,computed,onMounted } from 'vue';
import {useStore} from 'vuex'

export default defineComponent({
  name: 'Home',
  props:{
    change:{type:Function}
  },
  setup(props){
    const {change} = toRefs(props)
    const drawer = ref(false)
    let showMenu = ref(false)
    let user = computed(() => useStore().state.Login.data )
    let userInfo = computed(() => Local.getExpire('userInfo'))

    const logout = () => {
      ElMessageBox.confirm(
          '确认退出当前账号?',
          'Warning',
          {
            confirmButtonText: '确认',
            cancelButtonText: '取消',
            type: 'warning',
          }
      )
          .then(() => {
            ElMessage({
              type: 'success',
              message: '退出成功!',
            })
            change.value!(false)    //ts 类型检查 could be undefined
            localStorage.removeItem('userInfo')
          })
          .catch(() => {
            ElMessage({
              type: 'info',
              message: '取消退出!',
            })
          })
    }

    function avatar(){
      const res = Local.getExpire('userInfo')
      if(res.auth === 1) {
        return '@/assets/image/avatar1.jpg'
      }
      else {
        return '@/assets/image/avatar2.jpg'
      }
    }
    return {
      props,
      logout,
      showMenu,
      avatar,
      user,
      userInfo,
      drawer,

    }
  }
});
</script>
<style scoped>
  .top1{
    padding-top: 10px;
  }
  .box{
    width:100%;
    text-align:center;
    text-decoration:none;
  }
  @font-face{
    font-family:"alger";
    src:url("../assets/common/ALGER.TTF")
  }
  .title{
    height:61px;
    width:100%;
    color:white;
    line-height:61px;
    text-align:center;
    font-family:"alger";
    font-size:24px;
  }
  .right{
    height:600px;
    width:100%;
    border:1px solid white;
  }
  .router{
    color:white;
    text-decoration: none;
  }
  .mainTitle{
    width:100%;
    height:100%;
    font-family:'alger';
    color:white;
    font-size:24px;

  }
  .context{
    font-family:"宋体";
    text-decoration: none;
    text-indent:2rem;
  }
  .gap{
    margin-top:1.2rem;
  }
  .text-gap{
    margin-top:1rem;
    line-height:1.5rem;
  }
</style>
