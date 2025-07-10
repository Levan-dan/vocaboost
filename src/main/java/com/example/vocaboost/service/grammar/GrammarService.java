package com.example.vocaboost.service.grammar;

import com.example.vocaboost.repository.IGrammarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GrammarService  implements IGrammarService{
    @Autowired
    private IGrammarRepository grammarRepository;
    @Override
    public List findAll() {
        return grammarRepository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Object save(Object entity) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
