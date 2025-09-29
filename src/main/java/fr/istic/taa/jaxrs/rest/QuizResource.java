package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.QuizDAO;
import fr.istic.taa.jaxrs.domain.Quiz;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("quiz")
@Produces({"application/json"})
public class QuizResource {
    QuizDAO quizDAO = new QuizDAO();

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
    quizDAO.save(quiz);
    return Response.ok().entity("SUCCESS").build();
  }
}