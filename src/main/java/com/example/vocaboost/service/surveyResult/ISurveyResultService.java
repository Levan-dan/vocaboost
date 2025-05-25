package com.example.vocaboost.service.surveyResult;

import com.example.vocaboost.model.SurveyResult;
import com.example.vocaboost.service.IGenerateService;

import java.util.List;
import java.util.Map;

public interface ISurveyResultService extends IGenerateService<SurveyResult> {
    List<SurveyResult> saveAll(List<SurveyResult> results);
    Map<Long, SurveyResult> getAnswersByUserId(Long userId);
}
