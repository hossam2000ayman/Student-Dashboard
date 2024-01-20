package com.example.student.repository;

import com.example.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    /**Using during update or delete Student*/
    boolean existsStudentById(Long id);

   /**Using during create new Student*/
    boolean existsStudentByNameAndAddressAndPercentage(String name, String address, Double percentage);

}
