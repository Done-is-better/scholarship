package com.example.scholarship_backend;

import com.example.scholarship_backend.entity.College;
import com.example.scholarship_backend.mapper.CollegeRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author chixinyu
 * @version 2022/1/31 15:29
 */
@SpringBootTest
@Slf4j
public class CollegeTests {
    @Autowired
    private CollegeRepository repository;
    @Test
    void test(){
        College college = repository.findByCollegeId(0);
        log.info("{}",college.getCollegeName());
    }
}
