package com.southwest.dao;

import com.southwest.domain.Student;

import java.util.List;
//数据访问层实现增删改查
public interface StudentDao {
     int insert(Student student);
     List<Student> selectAll();
     List<Student> selectOne(Student student);
     void delete(int ID);
}
