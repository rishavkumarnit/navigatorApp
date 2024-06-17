package com.rishav.navigator.repository;

import com.rishav.navigator.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;


public interface SubjectRepository extends JpaRepository<Subject, Long>{
    Optional<Subject> findBySubjectName(String subjectName);
}