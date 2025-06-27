package com.example.vocaboost.controller;

import com.example.vocaboost.model.Lesson;
import com.example.vocaboost.model.Topic;
import com.example.vocaboost.repository.ILessonRepository;
import com.example.vocaboost.service.lesson.ILessonService;
import com.example.vocaboost.service.topic.ITopicService;
import com.example.vocaboost.service.topic.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/lesson")
public class LessonController {
    @Autowired
    private ILessonRepository lessonRepository;
    @Autowired
    private ILessonService lessonService;
    @Autowired
    private ITopicService topicService;
    @GetMapping("/{id}/showLesson")
    public String showListLesson(@PathVariable("id") Long idTopic, Model model){
        Optional<Topic> topic = topicService.findById(idTopic);
        List<Lesson> lesson =  lessonRepository.findLessonsByTopicId(idTopic);
        model.addAttribute("topic", topic.get());
        model.addAttribute("lesson", lesson);
        System.out.println(lesson.size());
        System.out.println("lay lesson thanh cong");
        return "/user/lesson/list_lesson";
    }
}
