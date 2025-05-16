package com.example.vocaboost.model;


import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "survey_results")
public class SurveyResult {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resultId;

    @Getter
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User users;

    @Getter
    @ManyToOne
    @JoinColumn(name = "surveyQuestion_id", nullable = false)
    private SurveyQuestion surveyQuestion;

    @Getter
    private char selectedOption;
    private boolean isCorrect;

    @Getter
    private int point;

    public SurveyResult() {}

    public SurveyResult(User users, SurveyQuestion surveyQuestion, char selectedOption, boolean isCorrect, int point) {
        this.users = users;
        this.surveyQuestion = surveyQuestion;
        this.selectedOption = selectedOption;
        this.isCorrect = isCorrect;
        this.point = point;
    }

    public SurveyResult(Long resultId, User users, SurveyQuestion surveyQuestion, char selectedOption, boolean isCorrect, int point) {
        this.resultId = resultId;
        this.users = users;
        this.surveyQuestion = surveyQuestion;
        this.selectedOption = selectedOption;
        this.isCorrect = isCorrect;
        this.point = point;
    }

    public void setResultId(Long resultId) {
        this.resultId = resultId;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public void setSurveyQuestion(SurveyQuestion surveyQuestion) {
        this.surveyQuestion = surveyQuestion;
    }

    public void setSelectedOption(char selectedOption) {
        this.selectedOption = selectedOption;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
