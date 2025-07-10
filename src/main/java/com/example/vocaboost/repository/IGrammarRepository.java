package com.example.vocaboost.repository;

import com.example.vocaboost.model.ExampleGrammar;
import com.example.vocaboost.model.Grammars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGrammarRepository extends JpaRepository<Grammars, Long> {
    @Query("SELECT g FROM Grammars g  WHERE g.topic.idTopic = :id")
    List<Grammars> findGrammarById(@Param("id") Long id);

    @Query("SELECT e FROM ExampleGrammar e WHERE e.grammar.idGrammar = :grammarId")
    List<ExampleGrammar> findAllByGrammarId(@Param("grammarId") Long grammarId);
}
