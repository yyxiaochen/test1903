package com.southwest.test;


import com.southwest.Util.TransactionInvocationHandler;
import com.southwest.domain.Student;
import com.southwest.service.StudentService;
import com.southwest.service.impl.StudentServiceImpl;



import java.util.List;

public class test01 {

    public static void main(String[] args) {
        Student student = new Student();
//        动态代理创建service对象
        StudentService studentService = (StudentService) new TransactionInvocationHandler(new StudentServiceImpl()).getProxy();
//        List<Student> list = studentService.queryStudent();
//        for (Student student:list) {
//            System.out.println(student.id+""+student.username+""+student.password);
//        }
        student.setId(5);
        student.setUsername("");
        student.setPassword("");
        List<Student> studentList = studentService.selectStudent(student);
        System.out.println(studentList);
    }
}
