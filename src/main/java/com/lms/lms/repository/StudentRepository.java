package com.lms.lms.repository;

import com.lms.lms.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {
    @Autowired
    private MongoTemplate mongoTemplate;
    public StudentRepository(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    public List<Student> getAllStudents(){
        return mongoTemplate.findAll(Student.class);
    }

    public Student getStudentById(String studId){
        return mongoTemplate.findById(studId,Student.class);
    }

    public void saveStudent(Student student){
        mongoTemplate.save(student,"Student");
    }

    public void saveStudents(List<Student> students){
        students.forEach(student -> {
            mongoTemplate.save(student,"Student");
        });
    }

    public void deleteStudentById(String studId){
        Query query = new Query();
        query.addCriteria(Criteria.where("studId").is(studId));
        mongoTemplate.findAndRemove(query,Student.class);
    }

    public void deleteAllStudents() {
        mongoTemplate.remove(new Query(), "Student");
    }
}

