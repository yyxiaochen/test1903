package com.southwest.service;

import com.southwest.domain.Student;

import java.util.List;

public interface StudentService {
     int addStudent(Student student);
     List<Student> queryStudent();
     List<Student> selectStudent(Student student);
}
