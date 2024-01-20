package com.example.student.service.serviceImplementation;

import com.example.student.entity.Student;
import com.example.student.exception.StudentAlreadyExistException;
import com.example.student.exception.StudentNotFoundException;
import com.example.student.repository.StudentRepository;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImplementation implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImplementation(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student addStudent(Student student) {
        if (studentRepository.existsStudentByNameAndAddressAndPercentage(student.getName(),student.getAddress(),student.getPercentage()))
            throw new StudentAlreadyExistException("Student already registered ");
        return studentRepository.save(student);
    }

    @Override
    public boolean isStudentExist(Long id) {
        return studentRepository.existsStudentById(id);
    }

    @Override
    public Student updateStudent(Long id, Student newStudent) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentRepository.existsStudentById(id)) {
            Student student = studentOptional.get();
            if (!newStudent.getName().isEmpty())
                student.setName(newStudent.getName());
            if (!newStudent.getAddress().isEmpty())
                student.setAddress(newStudent.getAddress());
            if (!newStudent.getPercentage().isNaN())
                student.setPercentage(newStudent.getPercentage());

            return studentRepository.saveAndFlush(student);
        } else {
            throw new StudentNotFoundException("Student Not Found for Update");
        }
    }

    @Override
    public void deleteStudent(Long id) {
        if (studentRepository.existsStudentById(id)) {
            studentRepository.deleteById(id);
        }else{
            throw new  StudentNotFoundException("Student ID not Found for delete");
        }
    }

    @Override
    public Student getStudentById(Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        return studentOptional.get();
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Page<Student> pageStudents(int page, int pageSize) {
        return studentRepository.findAll(PageRequest.of(page, pageSize));
    }

    @Override
    public Page<Student> pageStudentsWithSort(int page, int pageSize, String field) {
        return studentRepository.findAll(PageRequest.of(page, pageSize).withSort(Sort.by(field).ascending()));
    }
}
