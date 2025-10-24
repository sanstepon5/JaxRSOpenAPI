package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.QuestionDAO;
import fr.istic.taa.jaxrs.domain.Question;
import fr.istic.taa.jaxrs.dto.QuestionDTO;
import fr.istic.taa.jaxrs.service.QuestionService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("question")
@Produces({"application/json"})
@Tag(name = "Question")
public class QuestionResource {
    QuestionService questionService = new QuestionService();

  @GET
  @Path("/{questionId}")
  public QuestionDTO getQuestionById(@PathParam("questionId") Long questionId)  {
      return questionService.getById(questionId);
  }

  @GET
  @Path("/")
  public List<QuestionDTO> getQuestions()  {
      return questionService.getAll();
  }

  @POST
  @Consumes("application/json")
  public Response addQuestion(
      @Parameter(description = "Question object that needs to be added to the store", required = true) QuestionDTO question) {
    questionService.create(question);
    return Response.ok().entity("SUCCESS").build();
  }
}