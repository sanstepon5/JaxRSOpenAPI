package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.AnswerDAO;
import fr.istic.taa.jaxrs.domain.Answer;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("answer")
@Produces({"application/json"})
public class AnswerResource {
    AnswerDAO answerDAO = new AnswerDAO();

  @GET
  @Path("/{answerId}")
  public Answer getAnswerById(@PathParam("answerId") Long answerId)  {
      return answerDAO.findOne(answerId);
  }

  @GET
  @Path("/")
  public List<Answer> getAnswers()  {
      return answerDAO.findAll();
  }

  @POST
  @Consumes("application/json")
  public Response addAnswer(
      @Parameter(description = "Answer object that needs to be added to the store", required = true) Answer answer) {
    answerDAO.save(answer);
    return Response.ok().entity("SUCCESS").build();
  }
}