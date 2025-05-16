package com.example.vocaboost.model;



import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, length = 50)
    private String username;

    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String phoneNumber;
    private String level;
    private String role;
    @Transient  // Đánh dấu để không lưu MultipartFile vào cơ sở dữ liệu
    private MultipartFile avatar;

    private String avatarPath;  // Lưu đường dẫn của ảnh vào cơ sở dữ liệu
    private LocalDateTime create_at;


    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SurveyResult> surveyResults;
    public User() {}



    public User(String username, String password, String email, String phoneNumber, String level, String role, MultipartFile avatar, LocalDateTime create_at, List<SurveyResult> surveyResults) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.level = level;
        this.role = role;
        this.avatar = avatar;
        this.create_at = create_at;
        this.surveyResults = surveyResults;
    }

    public User(Long userId, String username, String password, String email, String phoneNumber, String level, String role, MultipartFile avatar, LocalDateTime create_at, List<SurveyResult> surveyResults) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.level = level;
        this.role = role;
        this.avatar = avatar;
        this.create_at = create_at;
        this.surveyResults = surveyResults;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
    }

    public LocalDateTime getCreate_at() {
        return create_at;
    }

    public void setCreate_at(LocalDateTime create_at) {
        this.create_at = create_at;
    }

    public List<SurveyResult> getSurveyResults() {
        return surveyResults;
    }

    public void setSurveyResults(List<SurveyResult> surveyResults) {
        this.surveyResults = surveyResults;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }
}
