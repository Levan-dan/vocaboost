package com.example.vocaboost.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Topics")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTopic;

    private String title;

    private String description;

    private String image;
    private String level;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
    private List<Lesson> lessons;

    public Topic() {
    }

    public Topic(String title, String description, String image, String level, Subject subject, List<Lesson> lessons) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.level = level;
        this.subject = subject;
        this.lessons = lessons;
    }

    public Topic(Long idTopic, String title, String description, String image, String level, Subject subject, List<Lesson> lessons) {
        this.idTopic = idTopic;
        this.title = title;
        this.description = description;
        this.image = image;
        this.level = level;
        this.subject = subject;
        this.lessons = lessons;
    }


    public Long getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(Long idTopic) {
        this.idTopic = idTopic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
