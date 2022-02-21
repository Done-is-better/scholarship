package com.example.scholarship_backend.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author chixinyu
 * @version 2022/1/31 14:14
 */
@Entity(name="students")
@Data
@Accessors(chain=true)
public class Students {
    @Id
    @Column(name="stud_id")
    private String studentId;
    @Column(name="stud_name")
    private String studentName;
    @Column(name="coll_id")
    private Integer colleageId;
    @Column(name="s1")
    private Double score1;
    @Column(name="s2")
    private Double score2;
    @Column(name="s3")
    private Double score3;
    @Column(name="s4")
    private Double score4;
    @Column(name="s5")
    private Double score5;
    @Column(name="s6")
    private Double score6;
    @Column(name="s7")
    private Double score7;
    @Column(name="s8")
    private Double score8;
    @Column(name="s9")
    private Double score9;
    @Column(name="s10")
    private Double score10;
    @Column(name="admin_id")
    private Integer adminId;
    @Column(name="mentor_id")
    private Integer mentorId;
}
