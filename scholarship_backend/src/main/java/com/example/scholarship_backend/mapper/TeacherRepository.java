package com.example.scholarship_backend.mapper;

import com.example.scholarship_backend.entity.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TeacherRepository extends JpaRepository<Teachers,Integer> {
    Teachers findByTeacherId(Integer id);
    Teachers findByTeacherName(String name);
}
