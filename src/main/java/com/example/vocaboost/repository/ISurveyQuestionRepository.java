package com.example.vocaboost.repository;

import com.example.vocaboost.model.SurveyQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISurveyQuestionRepository extends JpaRepository<SurveyQuestion, Long> {
}
