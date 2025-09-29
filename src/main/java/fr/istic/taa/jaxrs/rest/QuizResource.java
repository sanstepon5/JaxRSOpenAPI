package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.QuestionDAO;
import fr.istic.taa.jaxrs.dao.generic.QuizDAO;
import fr.istic.taa.jaxrs.dao.generic.StudentDAO;
import fr.istic.taa.jaxrs.dao.generic.TeacherDAO;
import fr.istic.taa.jaxrs.domain.Question;
import fr.istic.taa.jaxrs.domain.Quiz;
import fr.istic.taa.jaxrs.domain.Student;
import fr.istic.taa.jaxrs.domain.Teacher;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.stream.Collectors;

@Path("quiz")
@Produces({"application/json"})
@Tag(name = "Quiz")
public class QuizResource {
    QuizDAO quizDAO = new QuizDAO();
    TeacherDAO teacherDAO = new TeacherDAO();
    StudentDAO studentDAO = new StudentDAO();
    QuestionDAO questionDAO = new QuestionDAO();

  @GET
  @Path("/{quizId}")
  public Quiz getQuizById(@PathParam("quizId") Long quizId)  {
      return quizDAO.findOne(quizId);
  }

  @GET
  @Path("/")
  public List<Quiz> getQuizs()  {
      return quizDAO.findAll();
  }

  @POST
  @Consumes("application/json")
  public Response addQuiz(
      @Parameter(description = "Quiz object that needs to be added to the store", required = true) Quiz quiz) {
      //Finding all entities associated to ID's ( ca pue la merde JPA)

    Teacher teacher = teacherDAO.findOne(quiz.getTeacher().getId());
    quiz.setTeacher(teacher);


      List<Student> students = quiz.getStudents().stream()
              .map(s -> studentDAO.findOne(s.getId()))
              .collect(Collectors.toList());
      quiz.setStudents(students);

      List<Question> questions = quiz.getQuestions().stream()
              .map(q -> questionDAO.findOne(q.getId()))
              .collect(Collectors.toList());
      quiz.setQuestions(questions);
    quizDAO.save(quiz);


      return Response.ok().entity("SUCCESS").build();
  }
}