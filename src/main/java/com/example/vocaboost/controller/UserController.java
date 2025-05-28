package com.example.vocaboost.controller;

import com.example.vocaboost.repository.ISubjectRepository;
import com.example.vocaboost.service.subject.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private ISubjectService subjectService;
    @GetMapping("/subject")
    public String showHomeUser(Model model){
       model.addAttribute("subject", subjectService.findAll());
        return "/user/homeUser";
    }
}
