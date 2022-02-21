package com.example.scholarship_backend.service;

import com.example.scholarship_backend.entity.Classes;
import com.example.scholarship_backend.mapper.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chixinyu
 * @version 2022/1/31 17:37
 */
@Service
public class ClassService {
    @Autowired
    private ClassRepository repository;
    //用不到分页
   /* public Page<Classes> readAllByCollegeId(Integer id, Integer pageSize, Integer pageNum){
        //List<Classes> list = repository.findAllByCollegeId(id);

        Pageable pageable = PageRequest.of(pageNum,pageSize);
        return repository.findAllByCollegeId(id,pageable);
    }*/
    public List<Classes> readAllByCollegeId(Integer id){
        return repository.findAllByCollegeId(id);
    }
}
