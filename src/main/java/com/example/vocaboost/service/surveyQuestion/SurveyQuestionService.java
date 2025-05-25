package com.example.vocaboost.service.surveyQuestion;

import com.example.vocaboost.model.SurveyQuestion;
import com.example.vocaboost.repository.ISurveyQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyQuestionService implements ISurveyQuestionService{

    @Autowired
    private ISurveyQuestionRepository surveyQuestionRepository;
    @Override
    public List<SurveyQuestion> findAll() {
        return surveyQuestionRepository.findAll();
    }

    @Override
    public Optional<SurveyQuestion> findById(Long id) {
        return null;
    }

    @Override
    public SurveyQuestion save(SurveyQuestion entity) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }


}
