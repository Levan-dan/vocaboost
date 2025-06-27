package com.example.vocaboost.model;

import javax.persistence.*;

@Entity
@Table(name = "Vocabulary")
public class Vocabulary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String word;
    private String image;
    private String transcription;
    private String meaning;

    @Column(columnDefinition = "TEXT")
    private String example;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    public Vocabulary() {
    }

    public Vocabulary(String word, String image, String transcription, String meaning, String example, Lesson lesson) {
        this.word = word;
        this.image = image;
        this.transcription = transcription;
        this.meaning = meaning;
        this.example = example;
        this.lesson = lesson;
    }

    public Vocabulary(Long id, String word, String image, String transcription, String meaning, String example, Lesson lesson) {
        this.id = id;
        this.word = word;
        this.image = image;
        this.transcription = transcription;
        this.meaning = meaning;
        this.example = example;
        this.lesson = lesson;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTranscription() {
        return transcription;
    }

    public void setTranscription(String transcription) {
        this.transcription = transcription;
    }
}
