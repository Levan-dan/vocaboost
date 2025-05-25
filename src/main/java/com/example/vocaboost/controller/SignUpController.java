package com.example.vocaboost.controller;

import com.example.vocaboost.model.User;
import com.example.vocaboost.repository.IUserRepository;
import com.example.vocaboost.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/homeWeb")
public class SignUpController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IUserRepository userRepository;


    @GetMapping("")
    public String showMainScreenWebVocaboost() {
        return "/authenticate/main_screen";
    }

    @GetMapping("/showIntroducePage")
    public String showIntroducePage() {
        return "/authenticate/introduce_web";
    }

    @GetMapping("/showSignUpForm")
    public String showScreenSignUp(Model model) {
        model.addAttribute("user", new User());
        return "/authenticate/sign_up";
    }

    @GetMapping("/showLogInForm")
    public String showScreenLogIn(Model model) {
        model.addAttribute("user", new User());
        return "/authenticate/log_in";
    }

    @PostMapping("/signIn")
    public String signInSystem(@ModelAttribute("user") User user, HttpSession session, Model model) {
        return userService.login(user, session, model);
    }


    @GetMapping("/showPrefacePage")
    public String showPreface() {
        return "/authenticate/preface_page";
    }

    @PostMapping("/signUp")
    public String signUpToHomeUser(@ModelAttribute("user") @Valid User user,
                                   HttpSession session,
                                   BindingResult bindingResult,
                                   @RequestParam("avatar") MultipartFile avatar,
                                   Model model, RedirectAttributes redirectAttributes) throws IOException {



        if (userRepository.existsByEmail(user.getEmail())) {
            bindingResult.rejectValue("email", "error.user", "Email already exists");
        }

        if (userRepository.existsByPhoneNumber(user.getPhoneNumber())) {
            bindingResult.rejectValue("phoneNumber", "error.user", "Phone number already exists");
        }

        if (bindingResult.hasErrors()) {
            return "/authenticate/sign_up";
        }

        // Kiểm tra confirmPassword
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            model.addAttribute("passwordMismatch", "Xác nhận mật khẩu không khớp");
            return "/authenticate/sign_up";
        }


        String avatarPath = userService.uploadAvatar(avatar);
        if (avatarPath != null) {
            user.setAvatarPath(avatarPath);
        }

        user.setRole("user");
        user.setCreate_at(LocalDateTime.now());

        userService.save(user);
        session.setAttribute("userId", user.getUserId());
        System.out.println(user.getUserId());


        return "redirect: /SurveyQuestion";
    }


}
