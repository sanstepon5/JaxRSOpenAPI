package fr.istic.taa.jaxrs.dto;

import java.util.List;


public class QuestionDTO {
    private Long id;
    private String questionText;
    private Long quizId;
    private List<Long> answerIds;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getQuestionText() { return questionText; }
    public void setQuestionText(String questionText) { this.questionText = questionText; }

    public Long getQuizId() { return quizId; }
    public void setQuizId(Long quizId) { this.quizId = quizId; }

    public List<Long> getAnswerIds() { return answerIds; }
    public void setAnswerIds(List<Long> answerIds) { this.answerIds = answerIds; }
}
