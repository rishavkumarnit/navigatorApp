package com.rishav.navigator.entity;





import java.util.*;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;




@Table(name = "subject")
@Entity
public class Subject {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long subjectId;


    private String subjectName;


    @ManyToMany(mappedBy = "registeredSubjects")
    @JsonBackReference
    private List<Student> registeredStudents;


    public Subject() {

    }


    public Subject(String subjectName) {
        this.subjectName = subjectName;
        this.registeredStudents = new ArrayList<>();
    }


    public long getSubjectId() {
        return this.subjectId;
    }

    public void setSubjectId(long id) {
        this.subjectId = id;
    }


    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String name) {
        this.subjectName = name;
    }


    public List<Student> getRegisteredStudents() {
        return registeredStudents;
    }


}
