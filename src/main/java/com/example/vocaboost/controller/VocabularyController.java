package com.example.vocaboost.controller;

import com.example.vocaboost.model.Lesson;
import com.example.vocaboost.model.Vocabulary;
import com.example.vocaboost.repository.IVocabularyRepository;
import com.example.vocaboost.service.lesson.ILessonService;
import com.example.vocaboost.service.vocabulary.IVocabularyService;
import com.example.vocaboost.service.vocabulary.VocabularyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/vocabulary")
public class VocabularyController {
    @Autowired
    private IVocabularyService vocabularyService;
    @Autowired
    private IVocabularyRepository vocabularyRepository;
    @Autowired
    private ILessonService lessonService;
    @GetMapping("/{id}")
    public String showVocabulary(@PathVariable("id") Long idLesson, Model model){
        List<Vocabulary> vocabularies = vocabularyRepository.findByLessonId(idLesson);
        Optional<Lesson> lessonTitle = lessonService.findById(idLesson);
        model.addAttribute("vocabularies", vocabularies);
        model.addAttribute("lessonTitle", lessonTitle.get());
        return "/user/vocabulary/lish_vocabulary";
    }


}
