package com.example.vocaboost.repository;

import com.example.vocaboost.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITopicRepository extends JpaRepository<Topic, Long> {
    @Query("SELECT t FROM Topic t WHERE t.subject.idSubjects = :subjectId")
    List<Topic> findTopicsBySubjectId(@Param("subjectId") Long subjectId);
}
