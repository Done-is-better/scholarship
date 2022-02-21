package com.example.scholarship_backend.service;

import com.alibaba.fastjson.JSONObject;
import com.example.scholarship_backend.entity.Students;
import com.example.scholarship_backend.mapper.StudentRepository;
import com.example.scholarship_backend.utils.CalculateScore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chixinyu
 * @version 2022/2/8 10:43
 */
@Service
@Slf4j
public class EChartsService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CalculateScore calculateScore;
    public List<Double> collegeHighScore(){
        List<Double> arr = new ArrayList<>();
        for(int i=0; i<6; i++){
            arr.add(0.0);
            List<Students> list = studentRepository.findStudentsByColleageId(i);
            arr.set(i, calculateScore.computeTenSubjects(list.get(0)));
            int finalI = i;
            list.forEach(item -> {
               if(calculateScore.computeTenSubjects(item) > arr.get(finalI) ){
                   arr.set(finalI,calculateScore.computeTenSubjects(item));
               }
            });
        }
        return arr;
    }
    public List<Double> collegeLowScore(){
        List<Double> arr = new ArrayList<>();
        for(int i=0; i<6; i++){
            arr.add(0.0);
            List<Students> list = studentRepository.findStudentsByColleageId(i);
            arr.set(i,calculateScore.computeTenSubjects(list.get(0)));
            int finalI = i;
            list.forEach(item -> {
                if(calculateScore.computeTenSubjects(item) - arr.get(finalI) < 0){
                    arr.set(finalI,calculateScore.computeTenSubjects(item));
                }
            });
        }
        return arr;
    }
    public List<Integer> getScoNum(){
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<6; i++){
            List<Students> list = studentRepository.findStudentsByColleageId(i);
            double item = list.size()*0.3;
            res.add((int) item);
        }
        return res;
    }
    public Object getThreeScoNum(){
        List<Integer> list = getScoNum();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        list.forEach(item -> {
            list1.add(item/6);
            list2.add(item/3);
            list3.add(item/2);
        });
        JSONObject obj = new JSONObject();
        obj.put("list1",list1);
        obj.put("list2",list2);
        obj.put("list3",list3);
        return obj;
    }
}
