package com.example.vocaboost.repository;

import com.example.vocaboost.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILessonRepository extends JpaRepository<Lesson, Long> {
    @Query("SELECT l FROM Lesson l WHERE l.topic.idTopic = :topicId")
    List<Lesson> findLessonsByTopicId(@Param("topicId") Long topicId);
}
