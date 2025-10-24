package fr.istic.taa.jaxrs.dto;

import java.util.List;

public class TeacherDTO extends UserDTO {
    private String firstName;
    private String lastName;
    private List<Long> quizIds; // references to Quiz entities

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public List<Long> getQuizIds() { return quizIds; }
    public void setQuizIds(List<Long> quizIds) { this.quizIds = quizIds; }
}
