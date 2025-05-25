package com.example.vocaboost.controller;

import com.example.vocaboost.model.SurveyQuestion;
import com.example.vocaboost.model.SurveyResult;
import com.example.vocaboost.model.User;
import com.example.vocaboost.service.surveyQuestion.ISurveyQuestionService;
import com.example.vocaboost.service.surveyResult.ISurveyResultService;
import com.example.vocaboost.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/SurveyQuestion")
public class SurveyQuestionController {
    @Autowired
    private IUserService userService;
    @Autowired
    private ISurveyResultService surveyResultService;
    @Autowired
    private ISurveyQuestionService surveyQuestionService;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping
    public String showSurveyQuestionPage(Model model) {
        model.addAttribute("surveyQuestions", surveyQuestionService.findAll());
        return "/authenticate/surveyQuestion";
    }

    @PostMapping("/submitSurvey")
    public String submitSurvey(HttpSession session, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        Long userId = (Long) session.getAttribute("userId");
        Optional<User> user = userService.findById(userId);

        List<SurveyQuestion> questions = surveyQuestionService.findAll();
        List<SurveyResult> results = new ArrayList<>();

        int correctCount = 0;

        for (int i = 0; i < questions.size(); i++) {
            String selectedOption = request.getParameter("q" + i);
            if (selectedOption == null) continue;

            SurveyQuestion q = questions.get(i);
            System.out.println("nguoi dung chon : " + selectedOption);
            System.out.println("dung la : " + q.getCorrectOption());

            boolean isCorrect = selectedOption.equals(String.valueOf(q.getCorrectOption()));

            if (isCorrect)
                correctCount++;

            SurveyResult result = new SurveyResult();
            result.setUsers(user.orElse(null));
            result.setSurveyQuestion(q);
            result.setSelectedOption(selectedOption);
            result.setCorrect(isCorrect);
            result.setSubmitted_at(LocalDateTime.now());

            results.add(result);
        }

        surveyResultService.saveAll(results);
        System.out.println("da luu data");

        // Gọi stored procedure để cập nhật level
        jdbcTemplate.update("CALL SubmitSurveyAndUpdateLevel(?)", userId);
        System.out.println("da cap nhat level user");

        redirectAttributes.addFlashAttribute("point", correctCount);
        redirectAttributes.addFlashAttribute("avatar", user.map(User::getAvatarPath).orElse("/default-avatar.png"));
        return "redirect:/result";
    }


}
