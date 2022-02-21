<template>
  <el-row>
    <el-table :data="arr.data" stripe style="width: 100%">
      <el-table-column prop="id" label="id" width="100"/>
      <el-table-column prop="role" label="Role" width="140" />
      <el-table-column prop="password" label="password" width="120" />
      <el-table-column prop="auth" label="right level" width="160" />
      <el-table-column prop="phone" label="phone" width="180"/>
      <el-table-column prop="email" label="email" width="180"/>
      <el-table-column label="option" width="300">
        <template v-slot="scope">
          <el-button type="warning" size="small" @click="edit(scope.row.id)">编辑</el-button>
          <el-button type="danger" size="small" @click="toDelete(scope.row.id)">删除</el-button>
          <el-button type="success" size="small" @click="add">添加</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-dialog v-model="dialogFormVisible" :title="getTitle()">
      <el-form :model="form">
        <el-form-item label="Role">
          <el-input v-model="form.newName" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="Password">
          <el-input v-model="form.newPassword"/>
        </el-form-item>
        <el-form-item label="权限等级">
          <el-input v-model.number="form.auth"/>
        </el-form-item>
        <el-form-item label="Email">
          <el-input v-model="form.email"/>
        </el-form-item>
        <el-form-item label="Phone">
          <el-input v-model.number="form.phone"/>
        </el-form-item>
      </el-form>
      <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取消</el-button>
        <el-button type="primary" @click="choseToDo()"
        >确认</el-button
        >
      </span>
      </template>
    </el-dialog>
  </el-row>
</template>

<script>
import {onMounted,computed,reactive,ref,toRefs,shallowRef} from 'vue'
import {HttpManager} from '../../utils/httpmanager'
import {Local} from '../../utils/storage_expire'
import {useStore} from 'vuex'
import {ElMessage, ElMessageBox} from 'element-plus'

export default {
  name: "Users",
  setup(){
    let dialogFormVisible = ref(false)
    let form = reactive({
      newName:'',
      newPassword:'',
      roleId:Number,
      auth:'',
      email:'',
      phone:'',
      name:String,
      password:''
    })
    let user = computed(() => useStore().state.Login.data)
    let arr = shallowRef([])
    let isAdd = ref(true)
    function getName(){
      if(user.value.role === undefined) return Local.getExpire('userInfo').role
      else return user.value.role
    }
    function getPassword(){
      if(user.value.password === undefined) return Local.getExpire('userInfo').password
      else return user.value.password
    }
    onMounted(() =>{
      let name = getName()
      let password = getPassword()
      let request = new FormData()
      request.append('name',name)
      request.append('password',password)
      HttpManager.getRoleList('/role/list',request).then(
          data => {arr.value = data},
          error => console.log(error.message)
      )
    })
    function edit(even){
      isAdd.value = false
      form.roleId = even
      form.name = getName()
      form.password = getPassword()
      dialogFormVisible.value = true
    }
    function doEdit(){
      let data = new FormData()
      data.append('name',form.name)
      data.append('password',form.password)
      data.append('roleId',form.roleId)
      data.append('newName',form.newName)
      data.append('newPassword',form.newPassword)
      data.append('auth',form.auth)
      data.append('email',form.email)
      data.append('phone',form.phone)
      // console.log('formdata ==== ',data)
      HttpManager.modifyRoleByAdmin('/role/modify/admin',data).then(
          res => {
            if(res.status === 1) ElMessage({
              type:'success',
              message:'修改成功!'
            })
            else ElMessage({
              type:'warning',
              message:'修改失败!'
            })
          },
          err => console.log(err)
      )
      dialogFormVisible.value = false
    }
    function toDelete(roleId){
        ElMessageBox.confirm(
            '确认删除该账号?',
            'Warning',
            {
              confirmButtonText: '确认',
              cancelButtonText: '取消',
              type: 'warning',
            }
        )
        .then(() => {
          doDelete(roleId)
        })
        .catch(() => {
          ElMessage({
            type: 'success',
            message: '取消',
          })
        })
    }

    function doDelete(roleId){
      let data = new FormData()
      data.append('name',getName())
      data.append('password',getPassword())
      data.append('roleId',roleId)
      HttpManager.deleteRoleByAdmin('/role/destroy',data).then(
          res => {
            if(res.status === 1) ElMessage({
              type:'success',
              message:'删除成功!'
            })
            else ElMessage({
              type:'warning',
              message:'删除失败！'
            })
          },
          err => console.log(err)
      )
    }
    function add(){
      dialogFormVisible.value = true
      isAdd.value = true
      let data = new FormData()
      data.append('name',form.newName)
      data.append('password',form.newPassword)
      data.append('auth',form.auth)
      data.append('email',form.email)
      data.append('phone',form.phone)
      HttpManager.addRole('/role/logup',data).then(
         res => {
            if(res.status === 1) ElMessage({
              type:'success',
              message:'添加成功!'
            })
           else ElMessage({
              type:'warning',
              message:'添加失败！'
            })
           dialogFormVisible.value = false
          },
          err => console.log('sign up error ',err.message)
      )
    }
    function getTitle(){
      return isAdd.value? '添加用户':'修改用户信息'
    }
    function choseToDo(){
      if(isAdd.value) add()
      else doEdit()
    }
    return {
      arr,
      edit,
      dialogFormVisible,
      form,
      doEdit,
      doDelete,
      add,
      toDelete,
      getTitle,
      choseToDo
    }
  }
}
</script>

<style scoped>

</style>
