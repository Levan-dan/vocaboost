package com.example.vocaboost.controller;

import com.example.vocaboost.model.Subject;
import com.example.vocaboost.repository.ISubjectRepository;
import com.example.vocaboost.service.subject.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private ISubjectService subjectService;
    @Autowired
    private ISubjectRepository subjectRepository;

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        model.addAttribute("subject", subjectService.findAll());
        return "/admin/dashboard";
    }

    @GetMapping("/showAddSubjectForm")
    public String showFormAddSubject(Model model) {
        model.addAttribute("subject", new Subject());
        return "/admin/subject/addSubjectForm";
    }

    @PostMapping("/addSubject")
    public String addSub(@ModelAttribute("subject") @Valid Subject subject, BindingResult bindingResult,
                         @RequestParam("imageSubjectUpload") MultipartFile imageSubject, RedirectAttributes redirectAttributes) throws IOException {

        if (bindingResult.hasErrors()) {
            return "/admin/subject/addSubjectForm";
        }

        String subjectPath = subjectService.uploadSubject(imageSubject);
        if (subjectPath != null) {
            subject.setImage(subjectPath);
        }

        subjectService.save(subject);
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/{id}/updateSubjectForm")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Optional<Subject> subject = subjectService.findById(id);
        if (subject.isPresent()) {
            Subject subject1 = subject.get();
            model.addAttribute("subjectEdit", subject1);
            System.out.println(subject1.getImage());
        }

        System.out.println(id);
        System.out.println(subject);
        return "/admin/subject/editSubject";
    }

    @PostMapping("/editSubject")
    public String editSubject(@ModelAttribute("subjectEdit") Subject subject,
                              @RequestParam("imageSubjectUpload") MultipartFile multipartFile,
                              @RequestParam("oldImage") String oldImage) throws IOException {

        return subjectService.editImageSubject(subject, multipartFile, oldImage);
    }


    @GetMapping("/{id}/deleteSubject")
    public String deleteSub(@PathVariable("id") Long id){
        System.out.println(id);
        subjectService.deleteById(id);
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/searchSubjects")
    public String searchSubjects(@RequestParam("keySubject") String keyword, Model model) {
        List<Subject> results = subjectRepository.findByNameContainingIgnoreCase(keyword);
        model.addAttribute("subject", results);
        return "/admin/dashboard :: subjectListFragment";
    }



}
