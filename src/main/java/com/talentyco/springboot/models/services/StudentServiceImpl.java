package com.talentyco.springboot.models.services;

import com.talentyco.springboot.models.entity.Student;
import com.talentyco.springboot.models.repositories.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentServices{

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    @Transactional
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    @Transactional
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    @Transactional
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    @Transactional
    public void deleteStudentById(Long id) {
            studentRepository.deleteById(id);
    }
}
