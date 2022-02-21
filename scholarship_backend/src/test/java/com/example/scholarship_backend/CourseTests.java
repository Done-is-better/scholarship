package com.example.scholarship_backend;

import com.example.scholarship_backend.entity.Courses;
import com.example.scholarship_backend.mapper.CourseRespository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author chixinyu
 * @version 2022/1/31 15:17
 */
@SpringBootTest
@Slf4j
public class CourseTests {
    @Autowired
    private CourseRespository repository;
    @Test
    void findByIdTest(){
        Courses course = repository.findByCourseId(1);
        log.info("{}",course);
    }
}
