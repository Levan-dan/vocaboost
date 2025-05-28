package com.example.vocaboost.controller;

import com.example.vocaboost.service.subject.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private ISubjectService subjectService;
    @GetMapping("/dashboard")
    public String showDashboard(Model model){
        model.addAttribute("subject", subjectService.findAll());
        return "/admin/dashboard";
    }
}
