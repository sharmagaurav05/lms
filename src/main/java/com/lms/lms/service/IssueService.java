package com.lms.lms.service;

import com.lms.lms.dto.IssueDTO;
import com.lms.lms.model.Issue;
import com.lms.lms.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class IssueService {
    @Autowired
    private IssueRepository issueRepository;
    @Autowired
    private BookService bookService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private LibrarianService librarianService;

    public IssueService(IssueRepository issueRepository){
        this.issueRepository =issueRepository;
    }
    public List<Issue> getAllIssued() {
        return issueRepository.getAllIssued();
    }

    public Issue getIssuedById(String issueId) {
        return issueRepository.getIssuedById(issueId);
    }

    public void saveIssues(List<Issue> issues) {
        issues.forEach(issue -> {
            issue.setIssuedOn(LocalDate.now());
        });
        issueRepository.saveIssues(issues);
    }

    public void deleteIssue(String issueId) {
        issueRepository.deleteIssue(issueId);
    }

    public Issue getByStudentId(String studentId) {
        return issueRepository.getByStudentId(studentId);
    }

    public Issue getByIssueId(String issuerId) {
        return issueRepository.getByIssueId(issuerId);
    }

    public Issue saveIssue(IssueDTO issueDTO) {
        Issue issue = new Issue();
        issue.setBookId(issueDTO.getBookId());
        issue.setStudentId(issueDTO.getStudentId());
        issue.setIssuerId(issueDTO.getIssuerId());
        issue.setIssuedOn(LocalDate.now());
        issue.setBookName(bookService.getBookById(issueDTO.getBookId()).getName());
        issue.setStudentName(studentService.getStudentById(issueDTO.getStudentId()).getStudName());
        issue.setIssuerName(librarianService.getLibrarianById(issueDTO.getIssuerId()).getName());
        issueRepository.saveIssue(issue);
        return issue;
    }

    public List<Issue> booksIssuedByIssuer(String issuerId) {
        return issueRepository.booksIssuedByIssuer(issuerId);
    }

    public List<Issue> getIssuesByDateRange(LocalDate startDate, LocalDate endDate) {
        return issueRepository.getIssuesByDateRange(startDate,endDate);
    }


    public void deleteAllIssues() {
        issueRepository.deleteAllIssues();
    }
}
