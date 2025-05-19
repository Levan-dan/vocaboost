package com.example.vocaboost.service;

import com.example.vocaboost.model.User;
import com.example.vocaboost.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

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
    public User findById(int id) {
        return null;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public String uploadAvatar(MultipartFile file) throws IOException {
        if (file != null && !file.isEmpty()) {
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            File dest = new File(uploadPath, fileName);
            file.transferTo(dest);
            return "/images/" + fileName;
        }
        return null;
    }
}
