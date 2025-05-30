package com.example.vocaboost.service.subject;

import com.example.vocaboost.model.Subject;
import com.example.vocaboost.service.IGenerateService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ISubjectService extends IGenerateService<Subject> {
    public String uploadSubject(MultipartFile file) throws IOException;
    public String editImageSubject(Subject subject, MultipartFile multipartFile, String oldImage) throws IOException;
}
