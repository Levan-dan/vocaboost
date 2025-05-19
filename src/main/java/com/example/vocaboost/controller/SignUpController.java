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


    @GetMapping("")
    public String showMainScreenWebVocaboost() {
        return "/user/main_screen";
    }

    @GetMapping("/showIntroducePage")
    public String showIntroducePage() {
        return "/user/introduce_web";
    }

    @GetMapping("/showSignUpForm")
    public String showScreenSignUp(Model model) {
        model.addAttribute("user", new User());
        return "/user/sign_up";
    }

    @GetMapping("/showLogInForm")
    public String showScreenLogIn(Model model) {
        model.addAttribute("user", new User());
        return "/user/log_in";
    }

    @GetMapping("/showPrefacePage")
    public String showPreface() {
        return "/user/preface_page";
    }

    @PostMapping("/signUp")
    public String signUpToHomeUser(@ModelAttribute("user") User user,
                                   @RequestParam("avatar") MultipartFile avatar,
                                   Model model) throws IOException {

        String avatarPath = userService.uploadAvatar(avatar);
        if (avatarPath != null) {
            user.setAvatarPath(avatarPath);
        }

        user.setRole("user");
        user.setCreate_at(LocalDateTime.now());

        userService.save(user);

//        model.addAttribute("mess", "Đăng ký thành công và ảnh đã được lưu!");
//        model.addAttribute("name", user.getUsername());
//        model.addAttribute("imageName", user.getAvatarPath());

        return "/user/surveyQuestion";
    }


}
