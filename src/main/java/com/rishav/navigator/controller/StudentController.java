package com.rishav.navigator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.rishav.navigator.service.*;
import com.rishav.navigator.entity.*;
import java.util.*;


@RestController
@RequestMapping("/students")
public class StudentController {
    

    @Autowired
    private StudentService studentService;


    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student registerStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }


    @GetMapping
    public List<Student> getStudents() {
        return studentService.findAllStudents();
    }


    @GetMapping("/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public Student getStudent(@PathVariable long studentId){
        return studentService.findStudentbyId(studentId);
    }


    @DeleteMapping("/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteStudent(@PathVariable long studentId) {
        return studentService.deleteStudent(studentId);
    }


    @PostMapping("/{studentId}/enrollinSubject/{subjectId}")
    @ResponseStatus(HttpStatus.OK)
    public Student enrollinSubject(@PathVariable long studentId, @PathVariable long subjectId){
        return studentService.enrollStudentInSubject(studentId, subjectId);
    }


    @PostMapping("/{studentId}/enrollinExam/{examId}")
    @ResponseStatus(HttpStatus.OK)
    public Student enrollinExam(@PathVariable long studentId, @PathVariable long examId){
        return studentService.enrollStudentInExam(studentId, examId);
    }

}
