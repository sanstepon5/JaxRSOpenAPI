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
    private List<Quiz> quizzList;

    public Student(int studentNumber, int age) {
        this.studentNumber = studentNumber;
        this.age = age;
        this.quizzList = new ArrayList<>();
    }

    public Student() {
        this.quizzList = new ArrayList<>();
    }
    public List<Quiz> getQuizList() {
        return quizzList;
    }

    public void setQuiz(List<Quiz> quizzList) {
        this.quizzList = quizzList;
    }
    public void addQuiz(Quiz quizz) {
        this.quizzList.add(quizz);
    }
    public void removeQuiz(Quiz quizz) {
        this.quizzList.remove(quizz);
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
