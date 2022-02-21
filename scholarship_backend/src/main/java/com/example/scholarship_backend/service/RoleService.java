package com.example.scholarship_backend.service;

import com.alibaba.fastjson.JSONObject;
import com.example.scholarship_backend.entity.Roles;
import com.example.scholarship_backend.mapper.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

/**
 * @author chixinyu
 * @version 2022/1/31 23:56
 */
@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Roles readByRoleAndPassword(String name, String password){
        return roleRepository.findByRoleAndPassword(name, password);
    }

    public String addOneRecord(String role, String password, Integer auth, String email, BigInteger phone){
        Roles r = roleRepository.findByRole(role);
        JSONObject obj = new JSONObject();
        if(r == null){
            int num = roleRepository.insertOne(role,password,auth,email,phone);
            if(num == 1){
                obj.put("status",1);
                obj.put("msg","插入成功");
            }else{
                obj.put("status",0);
                obj.put("msg","插入失败");
            }
        }else{
            obj.put("status",0);
            obj.put("msg","该用户名已被占用");
        }

        return obj.toJSONString();
    }

    //删除当前用户
    public String deleteOneRecord(String role, String password){
        Roles res = readByRoleAndPassword(role,password);
        JSONObject obj = new JSONObject();
        if(res != null){
            roleRepository.deleteById(res.getId());
            obj.put("status",1);
            obj.put("msg","删除成功");
        }else{
            obj.put("status",0);
            obj.put("msg","该用户不存在");
        }
        return obj.toJSONString();
    }
    //管理员删除操作
    public JSONObject deleteByAdmin(String role, String password,Integer roleId){
        Roles res = readByRoleAndPassword(role,password);
        JSONObject obj = new JSONObject();
        if(res.getAuth() == 1){
            roleRepository.deleteById(roleId);
            obj.put("status",1);
            obj.put("msg","删除成功");
        }else{
            obj.put("status",0);
            obj.put("msg","无权限");
        }
        return obj;
    }
    public String updateOneRecord(String role,String password,String newRole,String newPassword){
        Roles res = readByRoleAndPassword(role,password);
        if(res != null){
            int i = roleRepository.updateAllById(newPassword,newRole,res.getId());
            return i == 1? "修改成功" : "修改失败";
        }else {
            return "无权限";
        }
    }
    //超级用户：查看用户列表
    public String selectAllRoles(String name,String password){
        Roles role = roleRepository.findByRoleAndPassword(name,password);
        JSONObject obj = new JSONObject();
        if(role.getAuth() == 1){
            List<Roles> list = roleRepository.findAll();
            obj.put("status",1);
            obj.put("msg","成功");
            obj.put("data",list);
        }else{
            obj.put("status","0");
            obj.put("msg","无权限");
        }
        return obj.toJSONString();
    }

    //当前用户的修改操作
    public String modify(String name,String password,String newName,String newPassword,String email,BigInteger phone){
        Roles role = roleRepository.findByRoleAndPassword(name,password);
        JSONObject obj = new JSONObject();
        if(newName == null){
            newName = role.getRole();
        }else{
            Roles res = roleRepository.findByRole(newName);
            if(res != null){
                obj.put("status",0);
                obj.put("msg","该用户名已被占用");
                return obj.toJSONString();
            }
        }
        if(newPassword == null) newName = role.getPassword();
        if(email == null) email = role.getEmail();
        if(phone == null) phone = role.getPhone();
        int num = roleRepository.updateById(newName,newPassword,email,phone,role.getId());
        if(num == 1){
            obj.put("status",1);
            obj.put("msg","更新成功");
        }else{
            obj.put("status",0);
            obj.put("msg","更新失败");
        }
        return obj.toJSONString();
    }
    //管理员修改
    public String modifyRole(String name,String password,Integer roleId,String newName,
                             String newPassword, Integer auth,String email,BigInteger phone){
        Roles role = roleRepository.findByRoleAndPassword(name,password);
        JSONObject obj = new JSONObject();
        if(role.getAuth() == 1){
           Optional<Roles> res = roleRepository.findById(roleId);
           if(res.isPresent()) role = res.get();
           if(newName == null){
               newName = role.getRole();
           }else{
               Roles r = roleRepository.findByRole(newName);
               if(r != null){
                   obj.put("status",0);
                   obj.put("msg","该用户名已被占用");
                   return obj.toJSONString();
               }
           }
           if(newPassword == null) newPassword = role.getPassword();
           if(email == null) email = role.getEmail();
           if(phone == null) phone = role.getPhone();
           if(auth == null) auth = role.getAuth();
           int num = roleRepository.updateById(newName,newPassword,auth,email,phone,roleId);
           if(num == 1){
               obj.put("status",1);
               obj.put("msg","修改成功");
           }else{
               obj.put("status",0);
               obj.put("msg","修改失败");
           }
        }else{
            obj.put("status",0);
            obj.put("msg","无权限");
        }
        return obj.toJSONString();
    }
}
