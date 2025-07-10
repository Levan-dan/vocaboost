package com.example.vocaboost.controller;

import com.example.vocaboost.model.ExampleGrammar;
import com.example.vocaboost.model.Grammars;
import com.example.vocaboost.repository.IGrammarRepository;
import com.example.vocaboost.service.grammar.IGrammarService;
import com.example.vocaboost.service.topic.ITopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/grammar")
public class GrammarController {
    @Autowired
    private IGrammarService grammarService;
    @Autowired
    private IGrammarRepository grammarRepository;
    @Autowired
    private ITopicService topicService;


    @GetMapping("/{id}/show_grammar")
    public String showGrammarTopic(@PathVariable("id") Long id, Model model){
        model.addAttribute("topic", topicService.findById(id).get());

        // Load tất cả grammar theo topic (id là idTopic)
        List<Grammars> grammars = grammarRepository.findGrammarById(id);
        model.addAttribute("grammar", grammars);

        // Load tất cả ví dụ của các grammar thuộc topic đó
        Map<Long, List<ExampleGrammar>> exampleMap = new HashMap<>();
        for (Grammars g : grammars) {
            List<ExampleGrammar> examples = grammarRepository.findAllByGrammarId(g.getIdGrammar());
            exampleMap.put(g.getIdGrammar(), examples);
        }

        model.addAttribute("exampleMap", exampleMap);

        return "/user/grammar/grammarInfo.html";
    }



}
