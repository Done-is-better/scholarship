package com.example.scholarship_backend;

import com.example.scholarship_backend.entity.Teachers;
import com.example.scholarship_backend.mapper.TeacherRepository;
import com.example.scholarship_backend.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;
import java.util.Optional;

/**
 * @author chixinyu
 * @version 2022/1/31 14:05
 */
@SpringBootTest
@Slf4j
public class TeacherTests {
    @Autowired
    private TeacherRepository repository;
    @Autowired
    private TeacherService service;

    @Test
    void findCourseId(){
        Optional<Teachers> t = repository.findById(2020004);
        Teachers teachers = t.get();
        log.info(teachers.getTeacherName());
    }
    @Test
    void findOne(){
        Teachers t = repository.findByTeacherId(2020004);
        log.info("{}",t);
    }
    @Test
    void findAll(){
        log.info("{}",service.getList());
    }
    @Test
    void findOneTest(){
        //Map<String, Map<String,Object>> map = service.getOne("2020005");
        //log.info("{}",map);
    }
}
