package com.rishav.navigator.entity;





import java.util.*;
import jakarta.persistence.*;




@Table(name = "student")
@Entity
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentId;


    private String studentName;


    @ManyToMany                 
    @JoinTable(
        name = "students_in_subject",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subject> registeredSubjects;


    @ManyToMany            
    @JoinTable(
        name = "students_in_exam",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "exam_id")
    )
    private List<Exam> registeredExams;


    public Student() {

    }


    public Student(String studentName) {
        this.studentName = studentName;
        this.registeredSubjects = new ArrayList<>();
        this.registeredExams = new ArrayList<>();
    }


    public long getStudentId() {
        return this.studentId;
    }


    public void setStudentId(long id) {
        this.studentId = id;
    }


    public String getStudentName() {
        return studentName;
    }


    public void setStudentName(String name) {
        this.studentName = name;
    }


    public List<Subject> getRegisteredSubjects() {
        return registeredSubjects;
    }


    public List<Exam> getRegisteredExams() {
        return registeredExams;
    }


}