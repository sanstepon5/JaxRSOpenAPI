package fr.istic.taa.jaxrs.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Schema(description = "Un étudiant avec son age et numéro étudiant")
public class Student extends User implements Serializable {
    private int studentNumber;
    private int age;
    @ManyToMany
    @JoinTable(
            name = "student_quiz",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "quiz_id")
    )
    private List<Quiz> quizList;

    public Student(int studentNumber, int age) {
        this.studentNumber = studentNumber;
        this.age = age;
        this.quizList = new ArrayList<>();
    }

    public Student() {
        this.quizList = new ArrayList<>();
    }
    public List<Quiz> getQuizList() {
        return quizList;
    }

    public void setQuiz(List<Quiz> quizList) {
        this.quizList = quizList;
    }
    public void addQuiz(Quiz quiz) {
        this.quizList.add(quiz);
    }
    public void removeQuiz(Quiz quiz) {
        this.quizList.remove(quiz);
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", studentNumber=" + studentNumber +
                '}';
    }
}
