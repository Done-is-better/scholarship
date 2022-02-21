package com.example.scholarship_backend.mapper;

import com.example.scholarship_backend.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRespository extends JpaRepository<Courses,Integer> {
    Courses findByCourseId(Integer id);
}
