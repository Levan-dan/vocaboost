package com.example.vocaboost.service.vocabulary;

import com.example.vocaboost.model.Vocabulary;
import com.example.vocaboost.repository.IVocabularyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class VocabularyService implements IVocabularyService{
    @Autowired
    private IVocabularyRepository vocabularyRepository;
    @Override
    public List<Vocabulary> findAll() {
        return vocabularyRepository.findAll();
    }

    @Override
    public Optional<Vocabulary> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Vocabulary save(Vocabulary entity) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
