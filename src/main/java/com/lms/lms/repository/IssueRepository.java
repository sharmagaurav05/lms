package com.lms.lms.repository;

import com.lms.lms.model.Book;
import com.lms.lms.model.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class IssueRepository  {
    @Autowired
    private MongoTemplate mongoTemplate;
    public IssueRepository(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    public List<Issue> getAllIssued() {
        return mongoTemplate.findAll(Issue.class);
    }

    public Issue getIssuedById(String issueId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("issueId").is(issueId));
        List<Issue> issueList = mongoTemplate.find(query,Issue.class);
        return issueList.get(0);
    }

    public void saveIssues(List<Issue> issues) {
        issues.forEach(issue -> {
            mongoTemplate.save(issue,"Issue");
        });
    }

    public void deleteIssue(String issueId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("issueId").is(issueId));
        mongoTemplate.findAndRemove(query,Issue.class);
    }

    public Issue getByStudentId(String studentId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("studentId").is(studentId));
        List<Issue> issues = mongoTemplate.find(query,Issue.class);
        return issues.get(0);
    }

    public Issue getByIssueId(String issuerId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("issuerId").is(issuerId));
        List<Issue> issueList = mongoTemplate.find(query, Issue.class);
        return issueList.get(0);
    }

    public void saveIssue(Issue issue) {
        mongoTemplate.save(issue,"Issue");
    }

    public List<Issue> booksIssuedByIssuer(String issuerId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("issuerId").is(issuerId));
        List<Issue> issues = mongoTemplate.find(query, Issue.class);
        return issues;
    }


    public List<Issue> getIssuesByDateRange(LocalDate startDate, LocalDate endDate) {
        Query query = new Query();
        query.addCriteria(Criteria.where("issuedOn").gte(startDate).lte(endDate));
        return mongoTemplate.find(query, Issue.class);
    }

    public void deleteAllIssues() {
        mongoTemplate.remove(new Query(), "Issue");
    }
}
