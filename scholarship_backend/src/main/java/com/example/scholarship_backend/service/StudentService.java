package com.example.scholarship_backend.service;

import com.alibaba.fastjson.JSONObject;
import com.example.scholarship_backend.entity.College;
import com.example.scholarship_backend.entity.Students;
import com.example.scholarship_backend.entity.Teachers;
import com.example.scholarship_backend.mapper.CollegeRepository;
import com.example.scholarship_backend.mapper.StudentRepository;
import com.example.scholarship_backend.mapper.TeacherRepository;
import com.example.scholarship_backend.utils.CalculateScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chixinyu
 * @version 2022/1/31 19:54
 */
@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;
    @Autowired
    private CollegeRepository collegeRepository;
    @Autowired
    private CalculateScore calculateScore;
    @Autowired
    private TeacherRepository teacherRepository;

    //分页查询
    public Page<Students> readStudentListByClassId(String classId,Integer currentPage,Integer pageSize,Integer orderState){
        Pageable pageable;
        if(orderState == 0){
            pageable = PageRequest.of(currentPage-1,pageSize, Sort.Direction.ASC,"studentId");
        }else{
            pageable = PageRequest.of(currentPage-1,pageSize, Sort.Direction.DESC,"studentId");
        }
        return repository.findAllByStudentIdStartingWith(classId,pageable);
    }
    //分页总条数
    public int totalRecords(String classId,Integer pageSize){
        List<Students> list = repository.findStudentsByStudentIdStartingWith(classId);
        System.out.println(list.size());
        if(pageSize < 1) return 0;
        return list.size()%pageSize == 0? list.size()/pageSize : list.size()/pageSize + 1;
    }
    //查询单个学生
    public Students readOne(String studentId){
        return repository.findByStudentId(studentId);
    }

    //一级菜单信息
    public String menuInfo(String studentId){
        Students student = readOne(studentId);
        JSONObject obj = new JSONObject();
        obj.put("studentId",student.getStudentId());
        obj.put("studentName",student.getStudentName());
        College college = collegeRepository.findByCollegeId(student.getColleageId());
        obj.put("college",college.getCollegeName());
        double score = calculateScore.computeTenSubjects(student);
        obj.put("scoreLevel",score);
        Teachers admin = teacherRepository.findByTeacherId(student.getAdminId());
        Teachers mentor = teacherRepository.findByTeacherId(student.getMentorId());
        obj.put("admin",admin);
        obj.put("mentor",mentor);
        return obj.toJSONString();
    }
    //详细内容
    public String menuDetail(String studentId){
        JSONObject obj = new JSONObject();
        Students student = repository.findByStudentId(studentId);
        obj.put("student",student);
        Object menuInfo = JSONObject.parseObject(menuInfo(studentId));
        obj.put("menuInfo",menuInfo);
        return obj.toJSONString();
    }

    //根据教师工号查询学生列表
    public Page<Students> getStudentList(Integer teacherId,Integer currentPage, Integer sizePage){
        Pageable pageable = PageRequest.of(currentPage-1,sizePage);
        if(teacherId > 2020008) return repository.findAllByMentorId(teacherId,pageable);
        else return repository.findAllByAdminId(teacherId,pageable);
    }
    public Page<Students> getStudentList(String name,Integer currentPage,Integer pageSize){
        Integer teacherId = teacherRepository.findByTeacherName(name).getTeacherId();
        return getStudentList(teacherId,currentPage,pageSize);
    }

    /*
    * 根据学院id 按比例选出一、二、三等奖
    * 返回信息：
    * */
    int num = 1;
    public List<Map<String,Object>> getScholarList(Integer id){
        List<Students> list = repository.findStudentsByColleageId(id);
        List<Students> res = new ArrayList<>();
        List<Map<String,Object>> ret = new ArrayList<>();

        for(int i=0; i<list.size(); i++){
            for(int j=0; j<list.size(); j++){
                if( calculateScore.computeTenSubjects(list.get(i)) > calculateScore.computeTenSubjects(list.get(j))){
                    Students s = list.get(i);
                    list.set(i,list.get(j));
                    list.set(j,s);
                }
            }
        }
        for(int i=0; i<list.size()*0.3; i++){
            res.add(i, list.get(i));
        }
        double num1 = res.size()*0.144444;
        double num2 = res.size()*0.5;
        final int n1 = (int) num1;
        final int n2 = (int) num2;
        res.forEach(item ->{
           Map<String,Object> subItem = new HashMap<>();
           subItem.put("item",item);
           subItem.put("mentor",teacherRepository.findByTeacherId(item.getMentorId()));
           subItem.put("admin",teacherRepository.findByTeacherId(item.getAdminId()));
           subItem.put("SCI",calculateScore.computeTenSubjects(item));
           subItem.put("college",collegeRepository.findByCollegeId(id));
           subItem.put("level",getStr(n1, n2));
           ret.add(subItem);
        });
        num = 1;
        return ret;
    }

    private String getStr(Integer tag, Integer tag1){
        String str ;
        if(num < tag) {
            str = "一等奖";
        }
        else if(num < tag1) {
            str = "二等奖";
        }
        else {
            str = "三等奖";
        }
        ++num;
        return str;
    }
    public List<Map<String,Object>> getOne(String param){
        List<Map<String,Object>> list = new ArrayList<>();
        if(param.length() < 10) {
            List<Students> res = repository.findByStudentName(param);
            res.forEach(item ->{
                Map<String,Object> map = getMap(item);
                list.add(map);
            });
        } else {
            Students s = repository.findByStudentId(param);
            Map<String,Object> map = getMap(s);
            list.add(map);
        }
        return list;
    }
    private Map<String,Object> getMap(Students stu){
        Map<String,Object> map = new HashMap<>();
        map.put("student",stu);
        map.put("college",collegeRepository.findByCollegeId(stu.getColleageId()));
        map.put("mentor",teacherRepository.findByTeacherId(stu.getMentorId()));
        map.put("admin",teacherRepository.findByTeacherId(stu.getAdminId()));
        return map;
    }
}
