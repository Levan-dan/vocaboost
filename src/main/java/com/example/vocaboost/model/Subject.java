package com.example.vocaboost.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSubjects;

    private String name;

    private String description;

    private String image;
    private String background_color;
    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private List<Topic> topics;

    public Subject() {
    }

    public Subject(String name, String description, String image, String background_color, List<Topic> topics) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.background_color = background_color;
        this.topics = topics;
    }

    public Subject(Long idSubjects, String name, String description, String image, String background_color, List<Topic> topics) {
        this.idSubjects = idSubjects;
        this.name = name;
        this.description = description;
        this.image = image;
        this.background_color = background_color;
        this.topics = topics;
    }

    public Long getIdSubjects() {
        return idSubjects;
    }

    public void setIdSubjects(Long idSubjects) {
        this.idSubjects = idSubjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBackground_color() {
        return background_color;
    }

    public void setBackground_color(String background_color) {
        this.background_color = background_color;
    }
}
