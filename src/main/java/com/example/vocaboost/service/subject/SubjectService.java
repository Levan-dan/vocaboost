package com.example.vocaboost.service.subject;

import com.example.vocaboost.model.Subject;
import com.example.vocaboost.repository.ISubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService implements ISubjectService {
    @Autowired
    private ISubjectRepository subjectRepository;

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Optional<Subject> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Subject save(Subject entity) {
        return subjectRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {

    }
}
