package com.example.scholarship_backend.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author chixinyu
 * @version 2022/1/31 15:33
 */
@Entity(name="classes")
@Data
@Accessors(chain=true)
public class Classes {
    @Id
    private Integer classId;
    @Column(name="coll_id")
    private Integer collegeId;
}
