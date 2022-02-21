package com.example.scholarship_backend.service;

import com.example.scholarship_backend.entity.Courses;
import com.example.scholarship_backend.entity.Teachers;
import com.example.scholarship_backend.mapper.CourseRespository;
import com.example.scholarship_backend.mapper.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chixinyu
 * @version 2022/2/17 22:21
 */
@Service
public class TeacherService {
    @Autowired
    private TeacherRepository repository;
    @Autowired
    private CourseRespository courseRespository;

    public List<Object> getList(){
        List<Teachers> list = repository.findAll();
        List<Object> res = new ArrayList<>();
        list.forEach(item ->{
            Courses course = courseRespository.findByCourseId(item.getCourseId());
            List<Object> cell = new ArrayList<>();
            Map<String,Object> map = new HashMap<>();
            map.put("name",item.getTeacherName());
            map.put("id",item.getId());
            map.put("teacherId",item.getTeacherId());
            map.put("course",course.getCourseName());
            res.add(map);
        });
        return res;
    }
    public List<Map<String,Object>> getOne(String param){
        List<Map<String,Object>> list = new ArrayList<>();
        if(param.length() < 4){
            Map<String,Object> item = new HashMap<>();
            Teachers teacher = repository.findByTeacherName(param);
            item.put("teacher", teacher);
            item.put("course",courseRespository.findByCourseId(teacher.getCourseId()));
            list.add(item);
        }else{
            Map<String,Object> item = new HashMap<>();
            Teachers teacher = repository.findByTeacherId(Integer.parseInt(param));
            item.put("teacher",teacher);
            item.put("course",courseRespository.findByCourseId(teacher.getCourseId()));
            list.add(item);
        }
        return list;
    }
}
