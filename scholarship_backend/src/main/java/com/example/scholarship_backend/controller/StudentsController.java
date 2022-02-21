package com.example.scholarship_backend.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.scholarship_backend.entity.Students;
import com.example.scholarship_backend.service.StudentService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

/**
 * @author chixinyu
 * @version 2022/1/31 20:38
 */
@Controller
@RequestMapping(value="student")
@CrossOrigin
public class StudentsController {
    @Autowired
    private StudentService service;
    //学生数据分页
    @PostMapping(value="/list")
    public @ResponseBody String getList(@RequestParam(value="classId",required=true) String classId,
                                        @RequestParam(value="pageSize",required=true) Integer pageSize,
                                        @RequestParam(value="currentPage",required=false) Integer currentPage,
                                        @RequestParam(value="orderState",required=false) Integer orderState){
        Integer totalPages = service.totalRecords(classId,pageSize);
        JSONObject obj = new JSONObject();
        obj.put("totalPages",totalPages);
        if(currentPage == null) currentPage = 1;
        if(orderState == null) orderState = 1;
        Page<Students> list = service.readStudentListByClassId(classId,currentPage,pageSize,orderState);
        obj.put("data",list);
        return obj.toJSONString();
    }
    //列表菜单信息
    @GetMapping(value="/list/{studentId}")
    public @ResponseBody String getMenuList(@PathVariable(value="studentId")String studentId){
        return service.menuInfo(studentId);
    }
    @GetMapping(value="/list/detail/{studentId}")
    public @ResponseBody String getMenuDetail(@PathVariable(value="studentId")String studentId){
        return service.menuDetail(studentId);
    }

    @PostMapping(value="/list/students")
    public @ResponseBody Page<Students> getStudentList(@RequestParam(value="param")String param,
                                               @RequestParam(value="currentPage")Integer currentPage,
                                               @RequestParam(value="pageSize")Integer pageSize){
        if(param.length() > 3) return service.getStudentList(Integer.parseInt(param),currentPage,pageSize);
        else return service.getStudentList(param,currentPage,pageSize);
    }
    @GetMapping(value="/scholarship/{collegeId}")
    public @ResponseBody List<Map<String,Object>> getScholarList(@PathVariable(value="collegeId")Integer id){
        return service.getScholarList(id);
    }
    @GetMapping(value="/search/{param}")
    public @ResponseBody List<Map<String,Object>> getOne(@PathVariable(value="param")String param){
        return service.getOne(param);
    }
}
