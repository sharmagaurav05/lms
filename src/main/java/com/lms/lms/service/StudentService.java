package com.lms.lms.service;

import com.lms.lms.model.Student;
import com.lms.lms.repository.LibrarianRepository;
import com.lms.lms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents(){
        return studentRepository.getAllStudents();
    }

    public Student getStudentById(String studId){
        return studentRepository.getStudentById(studId);
    }

    public Student saveStudent(Student student){
        studentRepository.saveStudent(student);
        return student;
    }

    public void saveStudents(List<Student> students){
        studentRepository.saveStudents(students);
    }

    public void deleteStudentById(String studId){
        studentRepository.deleteStudentById(studId);
    }

    public void deleteAllStudents() {
        studentRepository.deleteAllStudents();
    }
}
