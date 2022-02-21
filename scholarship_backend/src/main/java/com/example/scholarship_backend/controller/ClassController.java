package com.example.scholarship_backend.controller;

import com.example.scholarship_backend.entity.Classes;
import com.example.scholarship_backend.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author chixinyu
 * @version 2022/2/3 13:33
 */
@Controller
@CrossOrigin
@RequestMapping(value="class")
public class ClassController {
    @Autowired
    private ClassService classService;

    @GetMapping(value="/list/{collegeId}")
    public @ResponseBody List<Classes> getClassList(@PathVariable(name="collegeId")Integer id){
        return classService.readAllByCollegeId(id);
    }
}
