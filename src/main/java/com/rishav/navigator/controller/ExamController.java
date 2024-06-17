package com.rishav.navigator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.rishav.navigator.service.*;
import com.rishav.navigator.entity.*;
import java.util.*;



@RestController
@RequestMapping("/exams")
public class ExamController {
    

    @Autowired
    private ExamService examService;


    @PutMapping("/{subjectName}")
    @ResponseStatus(HttpStatus.CREATED)
    public Exam registerExam(@PathVariable String subjectName) {
        return examService.createExam(subjectName);
    }


    @GetMapping
    public List<Exam> getExams() {
        return examService.findAllExams();
    }


    @GetMapping("/{examId}")
    @ResponseStatus(HttpStatus.OK)
    public Exam getExam(@PathVariable long examId){
        return examService.findExambyId(examId);
    }

    
    @DeleteMapping("/{examId}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteExam(@PathVariable long examId) {
        return examService.deleteExam(examId);
    }

}
