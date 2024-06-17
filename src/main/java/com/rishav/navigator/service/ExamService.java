package com.rishav.navigator.service;

import java.util.*;
import com.rishav.navigator.entity.*;
import com.rishav.navigator.exceptions.*;
import com.rishav.navigator.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class ExamService {


    @Autowired
    private ExamRepository examRepository;


    @Autowired
    private SubjectRepository subjectRepository;

    
    public Exam createExam(String subjectName){

        Optional<Subject> existingSubject = subjectRepository.findBySubjectName(subjectName);

        if (!existingSubject.isPresent()) {
            throw new NotfoundException("Subject not found");
        }

        Exam exam = new Exam(existingSubject.get());
        return examRepository.save(exam);

    }


    public List<Exam> findAllExams() {
        return examRepository.findAll();
    }


    public Exam findExambyId(long examId) {
        Optional<Exam> exam = examRepository.findById(examId);
        if (exam.isPresent()) {
            return exam.get();
        } else {
            throw new NotfoundException("Exam not found");
        }
    }


    
    public String deleteExam(long examId) {
        examRepository.deleteById(examId);
        return "Exam deleted successfully";
    }
    
    
}
