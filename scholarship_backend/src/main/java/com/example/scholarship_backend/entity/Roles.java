package com.example.scholarship_backend.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * @author chixinyu
 * @version 2022/1/31 14:54
 */
@Entity(name="role")
@Data
@Accessors(chain=true)
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="role")
    private String role;
    @Column(name="passwd")
    private String password;
    @Column(name="auth")
    private Integer auth;
    @Column(name="email")
    private String email;
    @Column(name="phone")
    private BigInteger phone;
}
