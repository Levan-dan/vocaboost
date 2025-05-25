package com.example.vocaboost.repository;

import com.example.vocaboost.model.SurveyResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISurveyResultRepository extends JpaRepository<SurveyResult, Long> {

    @Query("SELECT sr FROM SurveyResult sr WHERE sr.users.userId = :userId")
    List<SurveyResult> findAnswerByUserId (@Param("userId") Long userId);

}
