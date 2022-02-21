package com.example.scholarship_backend.mapper;

import com.example.scholarship_backend.entity.Classes;
import com.example.scholarship_backend.entity.Students;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClassRepository extends JpaRepository<Classes,Integer> {
    public List<Classes> findAllByCollegeId(Integer id);
    Page<Classes> findAllByCollegeId(Integer id, Pageable pageable);
}
