package com.example.vocaboost.service.user;

import com.example.vocaboost.model.User;
import com.example.vocaboost.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Value("${file-upload}")
    private String uploadPath;

    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public String uploadAvatar(MultipartFile file) throws IOException {
        if (file != null && !file.isEmpty()) {
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            File dest = new File(uploadPath, fileName);
            file.transferTo(dest);
            return fileName;
        }
        return "https://png.pngtree.com/png-vector/20220709/ourmid/pngtree-businessman-user-avatar-wearing-suit-with-red-tie-png-image_5809521.png";
    }


    @Override
    public String login(User user, HttpSession session, Model model) {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser.isPresent()) {
            User databaseUser = existingUser.get();

            if (databaseUser.getPassword().equals(user.getPassword())) {
                session.setAttribute("logInUser", databaseUser);

                model.addAttribute("successMessage", "You have successfully logged in!");

                if ("admin".equals(databaseUser.getRole())) {
                    model.addAttribute("redirectUrl", "/admin/dashboard");
                } else if ("user".equals(databaseUser.getRole())) {
                    model.addAttribute("redirectUrl", "/user/subject");
                } else {
                    model.addAttribute("error", "Unknown role");
                    return "/authenticate/log_in";
                }
                return "/authenticate/log_in";

            } else {
                model.addAttribute("error", "Invalid account");
                return "/authenticate/log_in";
            }

        } else {
            model.addAttribute("error", "Email account does not exist");
            return "/authenticate/log_in";
        }
    }

}
