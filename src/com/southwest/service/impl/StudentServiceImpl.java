package com.southwest.service.impl;

import com.southwest.Util.SqlSessionUtil;
import com.southwest.dao.StudentDao;
import com.southwest.domain.Student;
import com.southwest.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    StudentDao studentDao = SqlSessionUtil.getSqlSession().getMapper(StudentDao.class);
    List<Student> list = null;
    @Override
    public int addStudent(Student student) {
        int res = studentDao.insert(student);
        return res;
    }

    @Override
    public List<Student> queryStudent() {
        list = studentDao.selectAll();
        return list;
    }
    @Override
    public List<Student> selectStudent(Student student){
        list = studentDao.selectOne(student);
        return list;
    }
}
