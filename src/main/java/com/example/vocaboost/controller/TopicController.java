package com.example.vocaboost.controller;

import com.example.vocaboost.model.Subject;
import com.example.vocaboost.model.Topic;
import com.example.vocaboost.model.User;
import com.example.vocaboost.repository.ITopicRepository;
import com.example.vocaboost.service.subject.ISubjectService;
import com.example.vocaboost.service.topic.ITopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/topic")
public class TopicController {
    @Autowired
    private ITopicService topicService;
    @Autowired
    private ITopicRepository topicRepository;
    @Autowired
    private ISubjectService subjectService;
    @GetMapping("/{id}/showTopic")
    public String showTopic(@PathVariable("id") Long idSub, Model model, HttpSession session){
        Optional<Subject> findSubject = subjectService.findById(idSub);

        List<Topic> listTopic = topicRepository.findTopicsBySubjectId(idSub);

        User loginUser = (User) session.getAttribute("logInUser");
        if (loginUser == null) {
            return "redirect:/login"; // Nếu chưa đăng nhập thì chuyển hướng về trang login
        }
        // 4. Lọc các topic theo level người dùng
        List<Topic> filteredTopics = listTopic.stream()
                .filter(topic -> topic.getLevel().equals(loginUser.getLevel()))
                .collect(Collectors.toList());

        model.addAttribute("nameSubject", findSubject.get());
        model.addAttribute("topic", filteredTopics);
        return "/user/topic/list_topic";

    }

}
