package com.rishav.navigator.entity;





import java.util.*;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;




@Table(name = "exam")
@Entity
public class Exam {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long examId;


    @ManyToOne
    private Subject subject;


    @ManyToMany(mappedBy = "registeredExams")
    @JsonBackReference
    private List<Student> enrolledStudents;


    public Exam(){

    }


    public Exam(Subject subject) {
        this.subject = subject;
        this.enrolledStudents = new ArrayList<>();
    }


    public long getexamId(){
        return this.examId;
    }


    public void setexamId(long id){
        this.examId = id;
    }


    public Subject getSubject() {
        return this.subject;
    }


    public void setSubject(Subject sub) {
        this.subject = sub;
    }


    public List<Student> getenrolledStudents(){
        return this.enrolledStudents;
    }


}
