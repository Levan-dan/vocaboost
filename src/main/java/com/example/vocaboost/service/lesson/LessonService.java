package com.example.vocaboost.service.lesson;

import com.example.vocaboost.model.Lesson;
import com.example.vocaboost.repository.ILessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonService implements ILessonService {
    @Autowired
    private ILessonRepository lessonRepository;
    @Override
    public List<Lesson> findAll() {
        return null;
    }

    @Override
    public Optional<Lesson> findById(Long id) {
        return lessonRepository.findById(id);
    }

    @Override
    public Lesson save(Lesson entity) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
