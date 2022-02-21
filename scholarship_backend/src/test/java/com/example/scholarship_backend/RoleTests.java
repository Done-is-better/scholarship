package com.example.scholarship_backend;

import com.example.scholarship_backend.entity.Roles;
import com.example.scholarship_backend.mapper.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author chixinyu
 * @version 2022/1/31 14:59
 */
@SpringBootTest
@Slf4j
public class RoleTests {
    @Autowired
    private RoleRepository repository;
    @Test
    void test(){

    }
    @Test
    void findByRoleAndPasswdTest(){
        Roles num = repository.findByRoleAndPassword("admin","123456");
        log.info("{}",num);
        log.info("{}",repository.findByRoleAndPassword("admin","123"));
    }

    @Test
    void addTest(){
//        int res = repository.insertOne("joey","1234");
//        log.info("{}",res);
    }
    @Test
    void deleteOneTest(){
        int res = repository.deleteOne("joey","1234");
        log.info("{}",res);
    }
    @Test
    void updateOne(){
        int res = repository.updateByRole("12345","user");
        log.info("{}",res);
    }
}
