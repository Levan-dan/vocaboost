package com.example.vocaboost.controller;

import com.example.vocaboost.model.SurveyResult;
import com.example.vocaboost.service.surveyQuestion.ISurveyQuestionService;
import com.example.vocaboost.service.surveyQuestion.SurveyQuestionService;
import com.example.vocaboost.service.surveyResult.ISurveyResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/result")
public class SurveyResultController {
    @Autowired
    private ISurveyResultService surveyResultService;
    @Autowired
    private SurveyQuestionService surveyQuestionService;

    @GetMapping()
    public String showPointSurvay(){
        return "/survey/survey_result";
    }

    @GetMapping("/viewAnswerSurvey")
    public String showAnswerSurvey(Model model, HttpSession session){
        Long userId = (Long) session.getAttribute("userId");
        System.out.println("id user hiển thị bên answer : " + userId);

        model.addAttribute("surveyQuestions", surveyQuestionService.findAll());

        System.out.println("cau hỏi answer đay : " + surveyQuestionService.findAll());

        Map<Long, SurveyResult> userAnswers = surveyResultService.getAnswersByUserId(userId);
        model.addAttribute("userAnswers", userAnswers);
        System.out.println("answer : " + userAnswers);
        return "/survey/view_result_survey";
    }

}
