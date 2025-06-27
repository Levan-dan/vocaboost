package com.example.vocaboost.repository;

import com.example.vocaboost.model.Vocabulary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVocabularyRepository extends JpaRepository<Vocabulary, Long> {
    @Query("SELECT v FROM Vocabulary v WHERE v.lesson.idLesson = :lessonId")
    List<Vocabulary> findByLessonId(@Param("lessonId") Long lessonId);
}
