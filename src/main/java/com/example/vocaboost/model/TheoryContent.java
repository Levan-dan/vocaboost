package com.example.vocaboost.model;

import javax.persistence.*;

@Entity
@Table(name = "TheoryContent")
public class TheoryContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private String example;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    public TheoryContent() {
    }

    public TheoryContent(String content, String example, Lesson lesson) {
        this.content = content;
        this.example = example;
        this.lesson = lesson;
    }

    public TheoryContent(Long id, String content, String example, Lesson lesson) {
        this.id = id;
        this.content = content;
        this.example = example;
        this.lesson = lesson;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
}
