package com.example.vocaboost.model;


import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @NotBlank(message = "Username must not be blank")
    @Pattern(
            regexp = "^(?!\\s*$)(?!.*\\s{2,})(?=.{3,50}$)[A-Za-z0-9 ]+$",
            message = "Username must be 3-50 characters long, no spaces or accents"
    )
    private String username;

    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;

    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "Invalid email format")
    @Column( unique = true)
    private String email;

    @Pattern(regexp = "^0\\d{9}$", message = "Incorrect phone number format")
    @Column( unique = true)
    private String phoneNumber;

    private String level;
    private String role;
    @Transient  // Đánh dấu để không lưu MultipartFile vào cơ sở dữ liệu
    private MultipartFile avatar;
    @Transient // Để không map field này vào database
    private String confirmPassword;

    private String avatarPath;  // Lưu đường dẫn của ảnh vào cơ sở dữ liệu
    private LocalDateTime create_at;

    @OneToMany(mappedBy = "user")
    private List<UserLessonProgress> progressList;

    @OneToMany(mappedBy = "user")
    private List<UserExercise> exercises;


    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SurveyResult> surveyResults;

    public User() {
    }


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


    public String getConfirmPassword() {
        return confirmPassword;
    }

    public List<UserLessonProgress> getProgressList() {
        return progressList;
    }

    public void setProgressList(List<UserLessonProgress> progressList) {
        this.progressList = progressList;
    }

    public List<UserExercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<UserExercise> exercises) {
        this.exercises = exercises;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", level='" + level + '\'' +
                ", role='" + role + '\'' +
                ", avatar=" + avatar +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", avatarPath='" + avatarPath + '\'' +
                ", create_at=" + create_at +
                '}';
    }
}
