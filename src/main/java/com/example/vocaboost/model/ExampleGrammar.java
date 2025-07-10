package com.example.vocaboost.model;

import javax.persistence.*;

@Entity
@Table(name = "ExampleGrammar")
public class ExampleGrammar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExample;

    private String imageExample;

    @Column(columnDefinition = "TEXT")
    private String contentExample;

    @ManyToOne
    @JoinColumn(name = "grammar_id")
    private Grammars grammar;

    // Constructors
    public ExampleGrammar() {}

    // Getters & Setters
    public Long getIdExample() {
        return idExample;
    }

    public void setIdExample(Long idExample) {
        this.idExample = idExample;
    }

    public String getImageExample() {
        return imageExample;
    }

    public void setImageExample(String imageExample) {
        this.imageExample = imageExample;
    }

    public String getContentExample() {
        return contentExample;
    }

    public void setContentExample(String contentExample) {
        this.contentExample = contentExample;
    }

    public Grammars getGrammar() {
        return grammar;
    }

    public void setGrammar(Grammars grammar) {
        this.grammar = grammar;
    }
}
