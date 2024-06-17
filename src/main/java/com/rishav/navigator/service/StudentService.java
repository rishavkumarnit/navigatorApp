package com.rishav.navigator.service;


import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rishav.navigator.entity.*;
import com.rishav.navigator.exceptions.*;
import com.rishav.navigator.repository.*;
import org.springframework.transaction.annotation.Transactional;


@Service
public class StudentService {


    @Autowired
    private StudentRepository studentRepository;


    @Autowired
    private SubjectRepository subjectRepository;


    @Autowired
    private ExamRepository examRepository;


    public Student createStudent(Student student) {
        if (student.getStudentName().trim().isEmpty()) {
            throw new BlankException("Student Name can't be blank");
        }
        Optional<Student> existingStudent = studentRepository.findByStudentName(student.getStudentName());
        if (existingStudent.isPresent()) {
            throw new AlreadyExistsException("Student already exists");
        }
        return studentRepository.save(student);
    }


    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }


    public Student findStudentbyId(Long studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        if (student.isPresent()) {
            return student.get();
        } else {
            throw new NotfoundException("Student not found");
        }
    }


    public String deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
        return "Student deleted successfully";
    }


    @Transactional
    public Student enrollStudentInSubject(long studentId , long subjectId) {
        Optional<Subject> optionalsubject = subjectRepository.findById(subjectId);
        if (!optionalsubject.isPresent()) {
            throw new NotfoundException("Subject not found");
        }
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if (!optionalStudent.isPresent()) {
            throw new NotfoundException("Student not found");
        }
        Subject subject = optionalsubject.get();
        Student student = optionalStudent.get();
        subject.getRegisteredStudents().add(student);
        student.getRegisteredSubjects().add(subject);
        subjectRepository.save(subject);
        studentRepository.save(student);

        return student;
    }


    @Transactional
    public Student enrollStudentInExam(long studentId, long examId) {
        Optional<Exam> optionalExam = examRepository.findById(examId);
        if (!optionalExam.isPresent()) {
            throw new NotfoundException("Exam not found");
        }
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if (!optionalStudent.isPresent()) {
            throw new NotfoundException("Student not found");
        }
        Exam exam = optionalExam.get();
        Student student = optionalStudent.get();
        exam.getenrolledStudents().add(student);
        student.getRegisteredExams().add(exam);  
        examRepository.save(exam);
        studentRepository.save(student);

        return student;
    }
}