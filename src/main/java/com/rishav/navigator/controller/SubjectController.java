package com.rishav.navigator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.rishav.navigator.service.*;
import com.rishav.navigator.entity.*;
import java.util.*;


@RestController
@RequestMapping("/subjects")
public class SubjectController {
    

    @Autowired
    private SubjectService subjectService;


    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Subject registerSubject(@RequestBody Subject subject) {
        return subjectService.createSubject(subject);
    }


    @GetMapping
    public List<Subject> getSubjects() {
        return subjectService.findAllSubjects();
    }


    @GetMapping("/{subjectId}")
    @ResponseStatus(HttpStatus.OK)
    public Subject getSubject(@PathVariable long subjectId){
        return subjectService.findSubjectbyId(subjectId);
    }


    @DeleteMapping("/{subjectId}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteStudent(@PathVariable long subjectId) {
        return subjectService.deleteSubject(subjectId);
    }
    



}
