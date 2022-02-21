package com.example.scholarship_backend.controller;

import com.example.scholarship_backend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.math.BigInteger;

/**
 * @author chixinyu
 * @version 2022/1/31 23:55
 */
@Controller
@RequestMapping(value="role")
@CrossOrigin
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping(value="/login")
    public @ResponseBody Object toLogin(@RequestParam(value="name",required = true)String name,
                                        @RequestParam(value="password",required=true)String password){
        return roleService.readByRoleAndPassword(name,password);
    }
    //增、删、查  需要权限auth==1
    @PostMapping(value="/logup")
    public @ResponseBody String toLogup(@RequestParam(value="name",required=true)String name,
                                        @RequestParam(value="password",required=true)String password,
                                        @RequestParam(value="auth",required = true)Integer auth,
                                        @RequestParam(value="email",required = false)String email,
                                        @RequestParam(value="phone",required = false)BigInteger phone){
        return roleService.addOneRecord(name,password,auth,email,phone);
    }
    //超级用户注销操作
    @PostMapping(value="/destroy")
    public @ResponseBody Object toDestroy(@RequestParam(value="name",required=true)String name,
                                          @RequestParam(value="password",required=true)String password,
                                          @RequestParam(value="roleId",required=true)Integer roleId){
        return roleService.deleteByAdmin(name,password,roleId);
    }
    //当前用户注销操作
    @PostMapping(value="/destoryOne")
    public @ResponseBody String toDestoryOne(@RequestParam(value="name")String name,
                                             @RequestParam(value="password")String password){
        return roleService.deleteOneRecord(name,password);
    }
    //超级用户：查看用户列表
    @PostMapping(value="/list")
    public @ResponseBody String toSelectAll(@RequestParam(value="name")String name,
                                            @RequestParam(value="password")String password){
        return roleService.selectAllRoles(name,password);
    }

    //当前用户修改操作
    @PostMapping(value="modify")
    public @ResponseBody String toModify(@RequestParam(value="name",required=true)String name,
                                         @RequestParam(value="password",required=true)String password,
                                         @RequestParam(value="newName",required=false)String newName,
                                         @RequestParam(value="newPassword",required=false)String newPassword,
                                         @RequestParam(value="email",required = false)String email,
                                         @RequestParam(value="phone",required=false)BigInteger phone){
        return roleService.modify(name,password,newName,newPassword,email,phone);
    }
    //管理员修改操作
    @PostMapping(value="/modify/admin")
    public @ResponseBody String toModifyByAdmin(@RequestParam(value="name")String name,
                                                @RequestParam(value="password")String password,
                                                @RequestParam(value="roleId")Integer roleId,
                                                @RequestParam(value="newName",required=false)String newName,
                                                @RequestParam(value="newPassword",required=false)String newPassword,
                                                @RequestParam(value="auth",required=false)Integer auth,
                                                @RequestParam(value="email",required=false)String email,
                                                @RequestParam(value="phone",required=false)BigInteger phone){
        return roleService.modifyRole(name,password,roleId,newName,newPassword,auth,email,phone);
    }
}
