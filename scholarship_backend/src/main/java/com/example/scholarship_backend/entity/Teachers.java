package com.example.scholarship_backend.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author chixinyu
 * @version 2022/1/31 13:49
 */
@Entity(name="teachers")
@Data
@Accessors(chain=true)
public class Teachers {
    @Id
    private Integer teacherId;
    @Column(name="teacher_name")
    private String teacherName;
    @Column(name="course_id")
    private Integer courseId;
    @Column(name="id")
    private Integer id;

}
