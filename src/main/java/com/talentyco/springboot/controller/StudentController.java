package com.talentyco.springboot.controller;

import com.talentyco.springboot.models.entity.Student;
import com.talentyco.springboot.models.services.StudentServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {


    private StudentServices studentServices;

    public StudentController(StudentServices studentServices) {
        this.studentServices = studentServices;
    }




    // Handler method to handle list student and return mode and view

    @GetMapping("/students")
    public String listStudent(Model modelo) {

        modelo.addAttribute("students", studentServices.getAllStudent());
        modelo.addAttribute("titulo", "Student Managedment System. ");

        return "students";
    }




    @GetMapping("/students/new")
    public String createStudentForm(Model modelo) {

        //Create student object to hold form data
        Student student = new Student();
        modelo.addAttribute("student", student);

        return "create_student";
    }





    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {

        studentServices.saveStudent(student);

        return "redirect:/students";

    }



    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model modelo){

        modelo.addAttribute("student", studentServices.getStudentById(id));
        return "edit_student";
    }



    @PostMapping("/students/{id}")
    public String updateStudentForm(@PathVariable Long id, @ModelAttribute("student") Student student, Model modelo){

        // GET STUDENT FROM DATABASE BY ID
        Student existingStudent = studentServices.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        // SAVE UPDATED STUDENT OBJECT
        studentServices.updateStudent(existingStudent);

        return "redirect:/students";
    }



    @GetMapping("/students/{id}")
    public String deleteStudentForm(@PathVariable Long id) {
        studentServices.deleteStudentById(id);

        return "redirect:/students";
    }


}
