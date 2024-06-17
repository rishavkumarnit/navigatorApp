package com.rishav.navigator.service;


import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rishav.navigator.entity.*;
import com.rishav.navigator.exceptions.*;
import com.rishav.navigator.repository.*;




@Service
public class SubjectService {


    @Autowired
    private SubjectRepository subjectRepository;


    public Subject createSubject(Subject subject) {
        if (subject.getSubjectName().trim().isEmpty()) {
            throw new BlankException("Subject Name can't be blank");
        }
        Optional<Subject> existingSubject = subjectRepository.findBySubjectName(subject.getSubjectName());
        if (existingSubject.isPresent()) {
            throw new AlreadyExistsException("Subject already exists");
        }
        
        return subjectRepository.save(subject);

    }


    public List<Subject> findAllSubjects() {
        return subjectRepository.findAll();
    }


    public Subject findSubjectbyId(long subjectId) {
        Optional<Subject> subject = subjectRepository.findById(subjectId);
        if (subject.isPresent()) {
            return subject.get();
        } else {
            throw new NotfoundException("Subject not found");
        }
    }


    public String deleteSubject(long subjectId) {
        subjectRepository.deleteById(subjectId);
        return "Subject deleted successfully";
    }
    
    
}
