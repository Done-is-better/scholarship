package com.example.scholarship_backend.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author chixinyu
 * @version 2022/1/31 15:21
 */
@Entity(name="colleage")
@Data
@Accessors(chain=true)
public class College {
    @Id
    @Column(name="coll_id")
    private Integer collegeId;
    @Column(name="coll_name")
    private String collegeName;
}
