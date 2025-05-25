package com.example.vocaboost.service.surveyResult;

import com.example.vocaboost.model.SurveyResult;
import com.example.vocaboost.repository.ISurveyQuestionRepository;
import com.example.vocaboost.repository.ISurveyResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class SurveyResultService implements ISurveyResultService {
    @Autowired
    private ISurveyResultRepository surveyResultRepository;

    @Override
    public List<SurveyResult> findAll() {
        return null;
    }

    @Override
    public Optional<SurveyResult> findById(Long id) {
        return null;
    }

    @Override
    public SurveyResult save(SurveyResult entity) {
        return surveyResultRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<SurveyResult> saveAll(List<SurveyResult> results) {
        return surveyResultRepository.saveAll(results);
    }

    @Override
    public Map<Long, SurveyResult> getAnswersByUserId(Long userId) {
        List<SurveyResult> results = surveyResultRepository.findAnswerByUserId(userId);

        return results.stream()
                .collect(Collectors.toMap(
                        result -> result.getSurveyQuestion().getSurveyQuestionId(), // key: surveyQuestion_id
                        Function.identity()
                ));
    }

}
