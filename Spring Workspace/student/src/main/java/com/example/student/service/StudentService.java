package com.example.student.service;

import com.example.student.entity.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {

    Student addStudent(Student student);

    boolean isStudentExist(Long id);

    Student updateStudent(Long id, Student newStudent);

    void deleteStudent(Long id);
    Student getStudentById(Long id);
    List<Student> getAllStudents();

    Page<Student> pageStudents(int page, int pageSize);
    Page<Student> pageStudentsWithSort(int page, int pageSize, String field);

}
