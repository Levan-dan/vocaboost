package com.example.vocaboost.controller;

import com.example.vocaboost.model.User;
import com.example.vocaboost.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/homeWeb")
public class SignUpController {
    @Autowired
    private IUserService userService;

    @Value("${file-upload}")
    private String uploadPath;

    @GetMapping("")
    public String showMainScreenWebVocaboost(){
        return "/user/main_screen";
    }

    @GetMapping("showSignUpForm")
    public String showScreenSignUp(Model model){
        model.addAttribute("user", new User());
        return "/user/sign_up";
    }

    @GetMapping("/showLogInForm")
    public String showScreenLogIn(Model model){
        model.addAttribute("user", new User());
        return "/user/log_in";
    }

}
