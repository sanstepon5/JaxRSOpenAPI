package fr.istic.taa.jaxrs.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Teacher extends User implements Serializable {
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.PERSIST)
    private List<Quiz> quizList;

    public List<Quiz> getQuizList() {
        return quizList;
    }

    public void setQuiz(List<Quiz> quizzList) {
        this.quizList = quizzList;
    }
    public void addQuiz(Quiz quizz) {
        this.quizList.add(quizz);
    }
    public void removeQuiz(Quiz quizz) {
        this.quizList.remove(quizz);
    }

    public Teacher(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.quizList = new ArrayList<>();
    }

    public Teacher() {
        this.quizList = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", quizzList=" + quizList +
                '}';
    }
}
