package com.example.scholarship_backend;

import com.example.scholarship_backend.entity.Classes;
import com.example.scholarship_backend.entity.Students;
import com.example.scholarship_backend.mapper.ClassRepository;
import com.example.scholarship_backend.service.ClassService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * @author chixinyu
 * @version 2022/1/31 15:39
 */
@SpringBootTest
@Slf4j
public class ClassesTests {
    @Autowired
    private ClassRepository repository;
    @Autowired
    private ClassService service;

    @Test
    void findByCollegeIdTest(){
        List<Classes> list = repository.findAllByCollegeId(2);
        for (Classes c : list) {
            log.info("{}",c);
        }
    }
    @Test
    void findByCollegeId(){
        Pageable pageable = PageRequest.of(0,8, Sort.Direction.DESC,"classId");
       /* Page<List<Classes>> page = repository.findAllByCollegeId(0,pageable);
        page.forEach(item -> log.info(item.toString()));*/
        log.info("{}",repository.findAllByCollegeId(0,pageable));
    }
    @Test
    void readAllByCollegeIdTest(){
//        Page<Classes> list = service.readAllByCollegeId(1,8,0);
//        log.info("{}",list);
//        list.forEach(item -> log.info(item.toString()));
    }

}
