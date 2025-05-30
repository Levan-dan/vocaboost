package com.example.vocaboost.service.subject;

import com.example.vocaboost.model.Subject;
import com.example.vocaboost.repository.ISubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectService implements ISubjectService {
    @Value("${file-upload-subject}")
    private String uploadPath_subject;

    @Autowired
    private ISubjectRepository subjectRepository;

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Optional<Subject> findById(Long id) {
        return subjectRepository.findById(id);
    }

    @Override
    public Subject save(Subject entity) {
        return subjectRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public String uploadSubject(MultipartFile file) throws IOException {
        if (file != null && !file.isEmpty()) {
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            File dest = new File(uploadPath_subject, fileName);
            file.transferTo(dest);
            return fileName;
        }
        return "https://png.pngtree.com/png-vector/20220709/ourmid/pngtree-businessman-user-avatar-wearing-suit-with-red-tie-png-image_5809521.png";
    }

    @Override
    public String editImageSubject(Subject subject, MultipartFile multipartFile, String oldImage) throws IOException {
        if (!multipartFile.isEmpty()) {
            String subjectPath = uploadSubject(multipartFile);
            if (subjectPath != null) {
                subject.setImage(subjectPath);
            } else {
                subject.setImage(oldImage);
            }
        } else {
            subject.setImage(oldImage);
        }
        subjectRepository.save(subject);
        return "redirect:/admin/dashboard";
    }
}

