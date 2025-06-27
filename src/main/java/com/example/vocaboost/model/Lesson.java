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

    private int progress;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @OneToMany(mappedBy = "lesson")
    private List<UserLessonProgress> progressList;
    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL)
    private List<Vocabulary> vocabularies;

    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL)
    private List<TheoryContent> theoryContents;
    public Lesson() {
    }

    public Lesson(String title, String description, int progress, String createdBy, LocalDateTime createdAt, Topic topic, List<UserLessonProgress> progressList, List<Vocabulary> vocabularies, List<TheoryContent> theoryContents) {
        this.title = title;
        this.description = description;
        this.progress = progress;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.topic = topic;
        this.progressList = progressList;
        this.vocabularies = vocabularies;
        this.theoryContents = theoryContents;
    }

    public Lesson(Long idLesson, String title, String description, int progress, String createdBy, LocalDateTime createdAt, Topic topic, List<UserLessonProgress> progressList, List<Vocabulary> vocabularies, List<TheoryContent> theoryContents) {
        this.idLesson = idLesson;
        this.title = title;
        this.description = description;
        this.progress = progress;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.topic = topic;
        this.progressList = progressList;
        this.vocabularies = vocabularies;
        this.theoryContents = theoryContents;
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


    public List<UserLessonProgress> getProgressList() {
        return progressList;
    }

    public void setProgressList(List<UserLessonProgress> progressList) {
        this.progressList = progressList;
    }

    public List<Vocabulary> getVocabularies() {
        return vocabularies;
    }

    public void setVocabularies(List<Vocabulary> vocabularies) {
        this.vocabularies = vocabularies;
    }

    public List<TheoryContent> getTheoryContents() {
        return theoryContents;
    }

    public void setTheoryContents(List<TheoryContent> theoryContents) {
        this.theoryContents = theoryContents;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}
