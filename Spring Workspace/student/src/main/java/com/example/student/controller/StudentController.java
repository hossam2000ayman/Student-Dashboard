package com.example.student.controller;

import com.example.student.entity.Student;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
@RequestMapping("api/students")
public class StudentController {


    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping("exist/{id}")
    boolean isStudentExist(@PathVariable Long id) {
        return studentService.isStudentExist(id);
    }

    @PutMapping("update/{id}")
    Student updateStudent(@PathVariable Long id, @RequestBody Student newStudent) {
        return studentService.updateStudent(id, newStudent);
    }

    @DeleteMapping("delete/{id}")
    void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @GetMapping("get/{id}")
    Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping
    List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("page")
    Page<Student> pageStudents(@RequestParam int page, @RequestParam int pageSize) {
        return studentService.pageStudents(page, pageSize);
    }

    @GetMapping("page/sort")
    Page<Student> pageStudentsWithSort(@RequestParam int page, @RequestParam int pageSize, @RequestParam String field) {
        return studentService.pageStudentsWithSort(page, pageSize, field);
    }
}
