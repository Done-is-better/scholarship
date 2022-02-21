package com.example.scholarship_backend.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.scholarship_backend.service.EChartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author chixinyu
 * @version 2022/2/8 11:41
 */
@Controller
@CrossOrigin
@RequestMapping("echarts")
public class EchartsController {
    @Autowired
    private EChartsService service;

    @GetMapping("/chart/{index}")
    public @ResponseBody Object getObj(@PathVariable(name="index")Integer id){
        JSONObject obj = new JSONObject();
        if(id.equals(1)){
            obj.put("low",service.collegeLowScore());
            obj.put("high",service.collegeHighScore());
        }else if(id.equals(2)){
            obj.put("num",service.getScoNum());
        }else if(id.equals(3)){
            return service.getThreeScoNum();
        }

        return obj;
    }
}
