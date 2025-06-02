package com.example.vocaboost.controller;

import com.example.vocaboost.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;

@ControllerAdvice
public class GlobalController {
    @ModelAttribute
    public void addUserToModel(HttpSession session, Model model) {
        User loggedInUser = (User) session.getAttribute("logInUser");

        if (loggedInUser != null) {
            model.addAttribute("currentUser", loggedInUser);
        }
    }
}
