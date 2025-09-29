package fr.istic.taa.jaxrs.domain;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Answer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String answerText;
    private boolean correct;
    @ManyToOne
    private Question question;

    public Answer(Question question, String answerText, boolean correct) {
        this.question = question;
        this.answerText = answerText;
        this.correct = correct;
    }

    public Answer() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerText='" + answerText + '\'' +
                ", correct=" + correct +
                ", question=" + question +
                '}';
    }
}
