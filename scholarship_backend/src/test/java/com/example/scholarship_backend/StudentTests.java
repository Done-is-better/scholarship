package com.example.scholarship_backend;

import com.example.scholarship_backend.entity.Students;
import com.example.scholarship_backend.mapper.StudentRepository;
import com.example.scholarship_backend.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * @author chixinyu
 * @version 2022/1/31 14:26
 */
@SpringBootTest
@Slf4j
public class StudentTests {
    @Autowired
    private StudentRepository repository;
    @Autowired
    private StudentService service;

    @Test
    void test(){
       List<Students> list = repository.findAll();
       list.forEach(item -> log.info(item.toString()));
    }
   /* @Test
    void findAllByMentorIdTest(){
        List<Students> students = repository.readAllByMentorId(2020010);
        students.forEach(item ->{
            log.info("{}",item.toString());
        });
    }*/
    @Test
    void findAllByStudentIdContains(){
        //List<Students> list = repository.readAllByStudentIdLike(20032933);
        List<Students> list = repository.selectStudents(20032933);
        list.forEach(item -> log.info("{}",item.toString()));
    }
    @Test
    void findAllByStudentIdStartWith(){
        String param = "20032933";
        List<Students> list = repository.findStudentsByStudentIdStartingWith(param);
        list.forEach(item -> log.info(item.toString()));
    }

    @Test
    void findAllByStudentIdStartWithTest(){
        Pageable pageable = PageRequest.of(0,8);
        Page<Students> page = repository.findAllByStudentIdStartingWith("20032933",pageable);
        page.forEach(item -> log.info("{}",item.toString()));

    }
    @Test
    void readStudentListByStudentIdTest(){
        Page<Students> list = service.readStudentListByClassId("20032933",1,8,0);
        list.forEach(item -> log.info(item.toString()));
    }
    @Test
    void totalRecords(){
        int num = service.totalRecords("20032933",9);
        log.info("{}",num);
    }

    @Test
    void getStudentListTest(){
        Page<Students> list = service.getStudentList(2020002,1,8);
        list.forEach(item ->{
            log.info("{}",item);
        });
    }

    @Test
    void getScholarListTest(){
        List<Map<String,Object>> map  = service.getScholarList(2);
        System.out.println(map.size());
        log.info("{}",map);
    }
    @Test
    void findOneTest(){
        //Students s = service.getOne("高旭");
        List<Map<String,Object>> stu = service.getOne("高旭");
        log.info("{}",stu);
    }

}
