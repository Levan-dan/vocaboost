package com.example.vocaboost.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "LessonContents")
public class LessonContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLessonC;

    @Enumerated(EnumType.STRING)
    private ContentType contentType;

    @Column(name = "content_data", columnDefinition = "TEXT")
    private String contentData;

    @Column(name = "content_order")
    private Integer contentOrder;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @OneToMany(mappedBy = "content")
    private List<UserExercise> exercises;

    public enum ContentType {
        text, video, image, quiz
    }

    public LessonContent() {
    }

    public LessonContent(ContentType contentType, String contentData, Integer contentOrder, Lesson lesson, List<UserExercise> exercises) {
        this.contentType = contentType;
        this.contentData = contentData;
        this.contentOrder = contentOrder;
        this.lesson = lesson;
        this.exercises = exercises;
    }

    public LessonContent(Long idLessonC, ContentType contentType, String contentData, Integer contentOrder, Lesson lesson, List<UserExercise> exercises) {
        this.idLessonC = idLessonC;
        this.contentType = contentType;
        this.contentData = contentData;
        this.contentOrder = contentOrder;
        this.lesson = lesson;
        this.exercises = exercises;
    }

    public Long getId() {
        return idLessonC;
    }

    public void setId(Long idLessonC) {
        this.idLessonC = idLessonC;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    public String getContentData() {
        return contentData;
    }

    public void setContentData(String contentData) {
        this.contentData = contentData;
    }

    public Integer getContentOrder() {
        return contentOrder;
    }

    public void setContentOrder(Integer contentOrder) {
        this.contentOrder = contentOrder;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public List<UserExercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<UserExercise> exercises) {
        this.exercises = exercises;
    }
}
