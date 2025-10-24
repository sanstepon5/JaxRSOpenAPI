package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.domain.Answer;
import fr.istic.taa.jaxrs.domain.Student;
import fr.istic.taa.jaxrs.dto.AnswerDTO;
import fr.istic.taa.jaxrs.service.AnswerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("answer")
@Produces({"application/json"})
@Tag(name = "Answer")
public class AnswerResource {
    private final AnswerService answerService = new AnswerService();

  @GET
  @Path("/{answerId}")
  @Operation(
          summary = "Rechercher un réponse de quiz par ID",
          description = "Retourne une réponse au quiz",
          responses = {
                  @ApiResponse(
                          responseCode = "200",
                          description = "Succès",
                          content = @Content(schema = @Schema(implementation = Student.class))
                  ),
                  @ApiResponse(responseCode = "404", description = "Aucune réponse avec cet ID")
          }
  )
  public AnswerDTO getAnswerById(@PathParam("answerId") Long answerId)  {
      return answerService.getById(answerId);
  }

  @GET
  @Path("/")
  @Operation(
          summary = "Récupérer toutes les réponses de la base de données",
          description = "Retourne une liste des réponses des quiz",
          responses = {
                  @ApiResponse(
                          responseCode = "200",
                          description = "Succès",
                          content = @Content(schema = @Schema(implementation = Student.class))
                  ),
                  @ApiResponse(responseCode = "404", description = "Aucune réponse de quiz n'existe dans la BDD")
          }
  )
  public List<AnswerDTO> getAnswers()  {
      return answerService.getAll();
  }

  @POST
  @Consumes("application/json")
  @Operation(
          summary = "Ajouter un réponse au quiz",
          description = "Sauvegarde la réponse au quiz en base de données",
          responses = {
                  @ApiResponse(responseCode = "200", description = "Réponse sauvegardé"),
                  @ApiResponse(responseCode = "400", description = "Requête invalide")
          }
  )
  public Response addAnswer(
      @Parameter(description = "Answer object that needs to be added to the store", required = true) AnswerDTO answer
  ) {
    answerService.create(answer);
    return Response.ok().entity("SUCCESS").build();
  }
}