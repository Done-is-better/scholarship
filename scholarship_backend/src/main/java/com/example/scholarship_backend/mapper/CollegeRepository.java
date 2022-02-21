package com.example.scholarship_backend.mapper;

import com.example.scholarship_backend.entity.College;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeRepository extends JpaRepository<College,Integer> {
    public College findByCollegeId(Integer id);

}
