package com.example.vocaboost.service;

import com.example.vocaboost.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IUserService extends IGenerateService<User>{
    String uploadAvatar(MultipartFile file) throws IOException;
}
