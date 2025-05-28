package com.example.vocaboost.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLesson;

    private String title;

    private String description;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL)
    private List<LessonContent> contents;

    @OneToMany(mappedBy = "lesson")
    private List<UserLessonProgress> progressList;

    public Lesson() {
    }

    public Lesson(String title, String description, String createdBy, LocalDateTime createdAt, Topic topic, List<LessonContent> contents, List<UserLessonProgress> progressList) {
        this.title = title;
        this.description = description;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.topic = topic;
        this.contents = contents;
        this.progressList = progressList;
    }

    public Lesson(Long idLesson, String title, String description, String createdBy, LocalDateTime createdAt, Topic topic, List<LessonContent> contents, List<UserLessonProgress> progressList) {
        this.idLesson = idLesson;
        this.title = title;
        this.description = description;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.topic = topic;
        this.contents = contents;
        this.progressList = progressList;
    }

    public Long getIdLesson() {
        return idLesson;
    }

    public void setIdLesson(Long idLesson) {
        this.idLesson = idLesson;
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public List<LessonContent> getContents() {
        return contents;
    }

    public void setContents(List<LessonContent> contents) {
        this.contents = contents;
    }

    public List<UserLessonProgress> getProgressList() {
        return progressList;
    }

    public void setProgressList(List<UserLessonProgress> progressList) {
        this.progressList = progressList;
    }
}
