package com.example.vocaboost.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
    @GetMapping("/showTest")
    public String showTestList(){
        return "/user/test/list_test_grammar.html";
    }

}
