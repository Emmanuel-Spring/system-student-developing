package com.talentyco.springboot.models.services;

import com.talentyco.springboot.models.entity.Student;

import java.util.List;

public interface StudentServices {

    List<Student> getAllStudent();

    Student saveStudent(Student student);

    Student getStudentById(Long id);

    Student updateStudent(Student student);

    public void deleteStudentById(Long id);
}
