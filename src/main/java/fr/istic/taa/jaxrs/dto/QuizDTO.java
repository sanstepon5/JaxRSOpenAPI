package fr.istic.taa.jaxrs.dto;

import java.util.List;


public class QuizDTO {
    private Long id;
    private int accessCode;
    private Long teacherId;
    private List<Long> questionIds;
    private List<Long> studentIds;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getAccessCode() { return accessCode; }
    public void setAccessCode(int accessCode) { this.accessCode = accessCode; }

    public Long getTeacherId() { return teacherId; }
    public void setTeacherId(Long teacherId) { this.teacherId = teacherId; }

    public List<Long> getQuestionIds() { return questionIds; }
    public void setQuestionIds(List<Long> questionIds) { this.questionIds = questionIds; }

    public List<Long> getStudentIds() { return studentIds; }
    public void setStudentIds(List<Long> studentIds) { this.studentIds = studentIds; }
}

