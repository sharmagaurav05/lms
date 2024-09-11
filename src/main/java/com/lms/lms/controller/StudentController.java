package com.lms.lms.controller;

import com.lms.lms.model.Student;
import com.lms.lms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    public StudentController(StudentService studentService){
            this.studentService = studentService;
    }
    @GetMapping("/get-all-students")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> studentList = studentService.getAllStudents();
        return ResponseEntity.ok(studentList);
    }

    @GetMapping("/get-student/{studId}")
    public ResponseEntity<Student> getStudentById(@PathVariable String studId){
        Student student = studentService.getStudentById(studId);
        return ResponseEntity.ok(student);
    }

    @PostMapping("/save-student")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return ResponseEntity.ok(student);
    }

    @PostMapping("/save-students")
    public ResponseEntity<String> saveStudents(@RequestBody List<Student> students){
        studentService.saveStudents(students);
        return ResponseEntity.ok("Students saved successfully:");
    }

    @GetMapping("delete-student/{studId}")
    public ResponseEntity deleteStudentById(@PathVariable String studId){
        studentService.deleteStudentById(studId);
        return ResponseEntity.ok("Student having " + studId + "has been successfully deleted : ");
    }

    @DeleteMapping("/delete-all-students")
    public ResponseEntity deleteAllStudents(){
        studentService.deleteAllStudents();
        return ResponseEntity.ok("Students deleted successfully ");
    }
}
