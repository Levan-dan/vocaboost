package com.example.vocaboost.service.user;

import com.example.vocaboost.model.Subject;
import com.example.vocaboost.model.User;
import com.example.vocaboost.service.IGenerateService;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;

public interface IUserService extends IGenerateService<User> {
    String uploadAvatar(MultipartFile file) throws IOException;
    String login(User user, HttpSession session, Model model);
    String addSubject(Subject subject);
}
