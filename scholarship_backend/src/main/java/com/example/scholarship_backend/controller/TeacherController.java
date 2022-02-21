package com.example.scholarship_backend.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.scholarship_backend.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author chixinyu
 * @version 2022/2/17 22:16
 */
@Controller
@CrossOrigin
@RequestMapping(value="teacher")
public class TeacherController {
    @Autowired
    private TeacherService service;

    @GetMapping("/list")
    public @ResponseBody String getList(){
        JSONObject obj = new JSONObject();
        obj.put("data",service.getList());
        return obj.toJSONString();
    }
    @GetMapping("/search/{param}")
    public @ResponseBody
    List< Map<String,Object>> getOne(@PathVariable(value="param")String param){
        return service.getOne(param);
    }
}
