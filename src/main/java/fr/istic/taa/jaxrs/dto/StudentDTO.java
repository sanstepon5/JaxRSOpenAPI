package fr.istic.taa.jaxrs.dto;

import java.util.List;

public class StudentDTO extends UserDTO {
    private int studentNumber;
    private int age;
    private List<Long> quizIds; // quizzes the student is enrolled in

    public int getStudentNumber() { return studentNumber; }
    public void setStudentNumber(int studentNumber) { this.studentNumber = studentNumber; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public List<Long> getQuizIds() { return quizIds; }
    public void setQuizIds(List<Long> quizIds) { this.quizIds = quizIds; }
}

