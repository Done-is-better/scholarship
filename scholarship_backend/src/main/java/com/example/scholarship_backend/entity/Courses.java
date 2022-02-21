package com.example.scholarship_backend.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author chixinyu
 * @version 2022/1/31 15:13
 */
@Entity(name="courses")
@Data
@Accessors(chain=true)
public class Courses {
    @Id
    private Integer courseId;
    @Column(name="course_name")
    private String courseName;
}
