package com.example.vocaboost.model;


import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "survey_results")
public class SurveyResult {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resultId;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User users;


    @ManyToOne
    @JoinColumn(name = "surveyQuestion_id", nullable = false)
    private SurveyQuestion surveyQuestion;


    private String selectedOption;
    private boolean isCorrect;


    private LocalDateTime submitted_at;

    public SurveyResult() {}

    public SurveyResult(User users, SurveyQuestion surveyQuestion, String selectedOption, boolean isCorrect, LocalDateTime submitted_at) {
        this.users = users;
        this.surveyQuestion = surveyQuestion;
        this.selectedOption = selectedOption;
        this.isCorrect = isCorrect;
        this.submitted_at = submitted_at;
    }

    public SurveyResult(Long resultId, User users, SurveyQuestion surveyQuestion, String selectedOption, boolean isCorrect, LocalDateTime submitted_at) {
        this.resultId = resultId;
        this.users = users;
        this.surveyQuestion = surveyQuestion;
        this.selectedOption = selectedOption;
        this.isCorrect = isCorrect;
        this.submitted_at = submitted_at;
    }

    public Long getResultId() {
        return resultId;
    }

    public void setResultId(Long resultId) {
        this.resultId = resultId;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public SurveyQuestion getSurveyQuestion() {
        return surveyQuestion;
    }

    public void setSurveyQuestion(SurveyQuestion surveyQuestion) {
        this.surveyQuestion = surveyQuestion;
    }

    public String getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(String selectedOption) {
        this.selectedOption = selectedOption;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public LocalDateTime getSubmitted_at() {
        return submitted_at;
    }

    public void setSubmitted_at(LocalDateTime submitted_at) {
        this.submitted_at = submitted_at;
    }

    @Override
    public String toString() {
        return "SurveyResult{" +
                "resultId=" + resultId +
                ", users=" + users +
                ", surveyQuestion=" + surveyQuestion +
                ", selectedOption='" + selectedOption + '\'' +
                ", isCorrect=" + isCorrect +
                ", submitted_at=" + submitted_at +
                '}';
    }
}
