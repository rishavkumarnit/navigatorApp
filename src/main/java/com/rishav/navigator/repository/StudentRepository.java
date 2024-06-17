package com.rishav.navigator.repository;

import com.rishav.navigator.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;


public interface StudentRepository extends JpaRepository<Student, Long>{
    Optional<Student> findByStudentName(String studentName);
}