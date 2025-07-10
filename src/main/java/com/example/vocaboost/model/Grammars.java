package com.example.vocaboost.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Grammars")
public class Grammars {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGrammar;

    private String titleGrammar;
    @Column(columnDefinition = "TEXT")
    private String contentGrammar;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    // Liên kết 1 Grammar có nhiều ExampleGrammar
    @OneToMany(mappedBy = "grammar", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExampleGrammar> examples = new ArrayList<>();

    // Constructors
    public Grammars() {}

    // Getters & Setters
    public Long getIdGrammar() {
        return idGrammar;
    }

    public void setIdGrammar(Long idGrammar) {
        this.idGrammar = idGrammar;
    }

    public String getTitleGrammar() {
        return titleGrammar;
    }

    public void setTitleGrammar(String titleGrammar) {
        this.titleGrammar = titleGrammar;
    }

    public String getContentGrammar() {
        return contentGrammar;
    }

    public void setContentGrammar(String contentGrammar) {
        this.contentGrammar = contentGrammar;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public List<ExampleGrammar> getExamples() {
        return examples;
    }

    public void setExamples(List<ExampleGrammar> examples) {
        this.examples = examples;
    }

    // Tiện ích: thêm/xoá ví dụ
    public void addExample(ExampleGrammar example) {
        examples.add(example);
        example.setGrammar(this);
    }

    public void removeExample(ExampleGrammar example) {
        examples.remove(example);
        example.setGrammar(null);
    }
}
