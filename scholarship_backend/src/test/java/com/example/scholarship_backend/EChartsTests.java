package com.example.scholarship_backend;

import com.example.scholarship_backend.service.EChartsService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author chixinyu
 * @version 2022/2/8 11:10
 */
@SpringBootTest
@Slf4j
public class EChartsTests {
    @Autowired
    private EChartsService service;
    @Test
    void getHighScore(){
        List<Double> res = service.collegeHighScore();
        log.info("{}",res);
    }
    @Test
    void getLowScore(){
        List<Double> res = service.collegeLowScore();
        log.info("{}",res);
    }
    @Test
    void getNum(){
        log.info("{}",service.getScoNum());
    }
}
