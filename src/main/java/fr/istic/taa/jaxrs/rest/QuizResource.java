package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dto.QuestionDTO;
import fr.istic.taa.jaxrs.dto.StudentDTO;
import fr.istic.taa.jaxrs.dto.TeacherDTO;
import fr.istic.taa.jaxrs.service.QuestionService;
import fr.istic.taa.jaxrs.service.QuizService;
import fr.istic.taa.jaxrs.service.StudentService;
import fr.istic.taa.jaxrs.service.TeacherService;
import fr.istic.taa.jaxrs.dto.QuizDTO;
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
    QuizService quizService = new QuizService();

  @GET
  @Path("/{quizId}")
  public QuizDTO getQuizById(@PathParam("quizId") Long quizId)  {
      return quizService.getById(quizId);
  }

  @GET
  @Path("/")
  public List<QuizDTO> getQuizs()  {
      return quizService.getAll();
  }

  @POST
  @Consumes("application/json")
  public Response addQuiz(
      @Parameter(description = "Quiz object that needs to be added to the store", required = true) QuizDTO quiz
  ) {
      quizService.create(quiz);
      return Response.ok().entity("SUCCESS").build();
  }
}