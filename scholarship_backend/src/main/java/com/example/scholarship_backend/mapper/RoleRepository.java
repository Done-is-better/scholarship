package com.example.scholarship_backend.mapper;

import com.example.scholarship_backend.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

public interface RoleRepository extends JpaRepository<Roles,Integer> {
    //查
    Roles findByRoleAndPassword(String role,String password);
    Roles findByRole(String role);
    //增
    @Transactional
    @Modifying
    @Query(value="insert into role(role,passwd,auth,email,phone) values (?1,?2,?3,?4,?5)",nativeQuery = true)
    int insertOne(String role, String password, Integer auth, String email, BigInteger phone);
    //删
    @Transactional
    @Modifying
    @Query(value="delete from role where role = ?1 and passwd = ?2",nativeQuery = true)
    int deleteOne(String role,String password);


    void deleteById(Integer id);
    //该
    @Transactional
    @Modifying
    @Query(value="update role set passwd = ?1 where role = ?2",nativeQuery = true)
    int updateByRole(String password, String role);

    @Transactional
    @Modifying
    @Query(value="update role r set r.passwd=?1 and r.role=?2 where id = ?3",nativeQuery = true)
    int updateAllById(String password,String role,Integer id);

    @Transactional
    @Modifying
    @Query(value="update role set role=?1,passwd = ?2,email = ?3,phone=?4 where id=?5",nativeQuery = true)
    int updateById(String role,String password,String email,BigInteger phone,Integer id);

    @Transactional
    @Modifying
    @Query(value="update role set role=?1,passwd = ?2,auth=?3,email = ?4,phone=?5 where id=?6",nativeQuery = true)
    int updateById(String role,String password,Integer auth,String email,BigInteger phone,Integer id);
}
