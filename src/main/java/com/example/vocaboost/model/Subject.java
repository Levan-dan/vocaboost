package com.example.vocaboost.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "Subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSubjects;
    @NotBlank(message = "Subject name must not be blank")
    @Size(max = 50, message = "Subject name must not exceed 50 characters")
    private String name;
    private String description;

    private String image;
    @Transient  // Đánh dấu để không lưu MultipartFile vào cơ sở dữ liệu
    private MultipartFile subjectImage;
    private String background_color;
    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private List<Topic> topics;

    public Subject() {
    }

    public Subject(String name, String description, MultipartFile subjectImage, String background_color, List<Topic> topics) {
        this.name = name;
        this.description = description;
        this.subjectImage = subjectImage;
        this.background_color = background_color;
        this.topics = topics;
    }

    public Subject(Long idSubjects, String name, String description, MultipartFile subjectImage, String background_color, List<Topic> topics) {
        this.idSubjects = idSubjects;
        this.name = name;
        this.description = description;
        this.subjectImage = subjectImage;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public MultipartFile getSubjectImage() {
        return subjectImage;
    }

    public void setSubjectImage(MultipartFile subjectImage) {
        this.subjectImage = subjectImage;
    }

    public String getBackground_color() {
        return background_color;
    }

    public void setBackground_color(String background_color) {
        this.background_color = background_color;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "idSubjects=" + idSubjects +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", subjectImage=" + subjectImage +
                ", background_color='" + background_color + '\'' +
                '}';
    }
}
