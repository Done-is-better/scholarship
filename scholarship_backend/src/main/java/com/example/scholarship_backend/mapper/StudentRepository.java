package com.example.scholarship_backend.mapper;

import com.example.scholarship_backend.entity.Students;
import com.example.scholarship_backend.entity.Teachers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Students,Integer> {

    Page<Students> findAllByAdminId(Integer id,Pageable pageable);
    Page<Students> findAllByMentorId(Integer id,Pageable pageable);
    @Query(value="select * from students where ?1 like stud_id",nativeQuery = true)
    //public List<Students> readAllByStudentIdLike(Integer studentId);
    public List<Students> selectStudents(Integer id);
    public List<Students> findStudentsByStudentIdStartingWith(String num);
    public List<Students> findStudentsByColleageId(Integer id);
    Page<Students> findAllByStudentIdStartingWith(String pattern, Pageable pageable);

    //查找一个student
    Students findByStudentId(String studentId);
    List<Students> findByStudentName(String name);



}
