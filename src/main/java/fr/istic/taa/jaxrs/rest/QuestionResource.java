package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.QuestionDAO;
import fr.istic.taa.jaxrs.domain.Question;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("question")
@Produces({"application/json"})
public class QuestionResource {
    QuestionDAO questionDAO = new QuestionDAO();

  @GET
  @Path("/{questionId}")
  public Question getQuestionById(@PathParam("questionId") Long questionId)  {
      return questionDAO.findOne(questionId);
  }

  @GET
  @Path("/")
  public List<Question> getQuestions()  {
      return questionDAO.findAll();
  }

  @POST
  @Consumes("application/json")
  public Response addQuestion(
      @Parameter(description = "Question object that needs to be added to the store", required = true) Question question) {
    questionDAO.save(question);
    return Response.ok().entity("SUCCESS").build();
  }
}