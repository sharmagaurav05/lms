package com.lms.lms.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lms.lms.dto.IssueDTO;
import com.lms.lms.model.Book;
import com.lms.lms.model.Issue;
import com.lms.lms.service.IssueService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.time.format.DateTimeFormatter;

@CrossOrigin
@RestController
@RequestMapping("/issue")

public class IssueController {
    @Autowired
    private IssueService issueService;
    private IssueService issue;
    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    @GetMapping("/get-all-issues")
    public ResponseEntity<List<Issue>> getAllIssued() {
        List<Issue> issues = issueService.getAllIssued();
        return ResponseEntity.ok(issues);
    }

    @GetMapping("/get-issued/{issueId}")
    public ResponseEntity<Issue> getIssuedById(@PathVariable String issueId) {
        Issue issue = issueService.getIssuedById(issueId);
        return ResponseEntity.ok(issue);
    }


    @PostMapping("/save-issues")
    public ResponseEntity<String> saveIssues(@RequestBody List<Issue> issues) {
        issueService.saveIssues(issues);
        return ResponseEntity.ok("Info of multiple issues has been added :");
    }

    @DeleteMapping("/delete-issue/{issueId}")
    public ResponseEntity deleteIssue(@PathVariable String issueId) {
        issueService.deleteIssue(issueId);
        return ResponseEntity.ok("Issue deleted :");
    }

    @GetMapping("/get-issue/{studentId}")
    public ResponseEntity<Issue> getByStudentId(@PathVariable String studentId) {
        Issue issue = issueService.getByStudentId(studentId);
        return ResponseEntity.ok(issue);
    }

    @GetMapping("get-info/{issuerId}")
    public ResponseEntity<Issue> getByIssueId(@PathVariable String issuerId) {
        Issue issues = issueService.getByIssueId(issuerId);
        return ResponseEntity.ok(issues);
    }

    @PostMapping(value = "/issue-book", consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Issue> saveIssue(@RequestBody IssueDTO issueDTO) {
        Issue issue = issueService.saveIssue(issueDTO);
        return ResponseEntity.ok(issue); // can use .build if we want nothing as response
    }

    @GetMapping("/issuer/books-issued")
    public ResponseEntity<List<Issue>> booksIssuedByIssuer(@RequestParam String issuerId) {
        List<Issue> issues = issueService.booksIssuedByIssuer(issuerId);
        return ResponseEntity.ok(issues);
    }

    @GetMapping("/filter-by-date-range")
    public ResponseEntity<List<Issue>> getIssuesByDateRange(@RequestParam @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING) LocalDate startDate,
                                                            @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING) LocalDate endDate) {
        List<Issue> issueList = issueService.getIssuesByDateRange(startDate, endDate);
        return ResponseEntity.ok(issueList);
    }

    @DeleteMapping("/delete-all-issues")
    public ResponseEntity deleteAllIssues() {
        issueService.deleteAllIssues();
        return ResponseEntity.ok("Issues deleted successfully ");
    }
}
