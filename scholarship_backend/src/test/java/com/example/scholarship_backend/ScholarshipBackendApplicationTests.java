package com.example.scholarship_backend;

import com.example.scholarship_backend.entity.Students;
import com.example.scholarship_backend.entity.Teachers;
import com.example.scholarship_backend.mapper.StudentRepository;
import com.example.scholarship_backend.mapper.TeacherRepository;
import com.example.scholarship_backend.utils.CalculateScore;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class ScholarshipBackendApplicationTests {

    @Autowired
    private CalculateScore calculateScore;
    @Autowired
    private StudentRepository repository;

    @Test
    void contextLoads() {
        double num = 100.0;
        log.info("{}{}{}",num%10," hello ",num/10);
    }

    @Autowired
    private TeacherRepository teacherRepository;
    @Test
    void test(){
        List<Teachers> list = teacherRepository.findAll();
        list.forEach((item) ->{
            log.info(item.toString());
        }) ;
    }

    @Test
    void calculateScore(){
        calculateScore.compute(68);
        log.info("{}",calculateScore.compute(84));
    }
    @Test
    void pointScore(){
        Students students = repository.findByStudentId("2001103206");
        log.info("{}",calculateScore.computeTenSubjects(students));

    }
}
