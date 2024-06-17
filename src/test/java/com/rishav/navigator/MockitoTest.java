package com.rishav.navigator;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.rishav.navigator.controller.*;
import com.rishav.navigator.service.*;
import com.rishav.navigator.entity.*;



@ExtendWith(MockitoExtension.class)
public class MockitoTest {


    @Mock
    private ExamService examService;


    @InjectMocks
    private ExamController examController;


    @Test
    public void testGetExamById() {
        Subject subject = new Subject();
        subject.setSubjectId(100);
        subject.setSubjectName("English");
        Exam exam = new Exam();
        exam.setexamId(100);
        exam.setSubject(subject);
        when(examService.findExambyId(100)).thenReturn(exam);
        Exam result = examController.getExam(100);
        assertNotNull(result);
        assertEquals(100, result.getexamId());
        assertEquals("English", result.getSubject().getSubjectName());
    }


    @Mock
    private StudentService studentService;


    @InjectMocks
    private StudentController studentController;


    @Test
    public void testGetStudentById() {
        Student student = new Student();
        student.setStudentId(100l);
        student.setStudentName("Michael");
        when(studentService.findStudentbyId(100l)).thenReturn(student);
        Student result = studentController.getStudent(100);
        assertNotNull(result);
        assertEquals(100, result.getStudentId());
        assertEquals("Michael", result.getStudentName());
    }


    @Mock
    private SubjectService subjectService;


    @InjectMocks
    private SubjectController subjectController;


    @Test
    public void testGetSubjectById() {
        Subject subject = new Subject();
        subject.setSubjectId(100l);
        subject.setSubjectName("English");
        when(subjectService.findSubjectbyId(100l)).thenReturn(subject);
        Subject result = subjectController.getSubject(100);
        assertNotNull(result);
        assertEquals(100, result.getSubjectId());
        assertEquals("English", result.getSubjectName());
    }

}