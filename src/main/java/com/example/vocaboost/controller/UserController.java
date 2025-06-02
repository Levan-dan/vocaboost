package com.example.vocaboost.controller;

import com.example.vocaboost.model.Subject;
import com.example.vocaboost.repository.ISubjectRepository;
import com.example.vocaboost.service.subject.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private ISubjectService subjectService;
    @Autowired
    private ISubjectRepository subjectRepository;
    @GetMapping("/subject")
    public String showHomeUser(Model model){
       model.addAttribute("subject", subjectService.findAll());
        return "/user/homeUser";
    }

    @GetMapping("/searchSubjects")
    public String searchSubjects(@RequestParam("keySubject") String keyword, Model model) {
        List<Subject> results = subjectRepository.findByNameContainingIgnoreCase(keyword);
        model.addAttribute("subject", results);
        return "/user/homeUser :: subjectListFragment";
    }

    @GetMapping("/logOut")
    public String logOutAuthenticate(HttpSession session){
        session.removeAttribute("logInUser");
        return "redirect:/homeWeb";
    }
}
