package com.example.vocaboost.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/SurveyQuestion")
public class SurveyQuestionController {
    @GetMapping
    public String showSurveyQuestionPage(){
        return "/authenticate/surveyQuestion";
    }
}
