package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.StudentDAO;
import fr.istic.taa.jaxrs.domain.Student;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("student")
@Produces({"application/json"})
@Tag(name = "Student")
public class StudentResource {
    StudentDAO studentDAO = new StudentDAO();

  @GET
  @Path("/{studentId}")
  @Operation(
          summary = "Rechercher un étudiant par ID",
          description = "Retourne un étudiant",
          responses = {
                  @ApiResponse(
                          responseCode = "200",
                          description = "Succès",
                          content = @Content(schema = @Schema(implementation = Student.class))
                  ),
                  @ApiResponse(responseCode = "404", description = "Aucun étudiant avec cet ID")
          }
  )
  public Student getStudentById(@PathParam("studentId") Long studentId)  {
      return studentDAO.findOne(studentId);
  }

  @GET
  @Path("/")
  public List<Student> getStudents()  {
      return studentDAO.findAll();
  }

  @POST
  @Consumes("application/json")
  @Operation(
          summary = "Ajouter un étudiant",
          description = "Sauvegarder l'étudiant en base de données",
          responses = {
                  @ApiResponse(responseCode = "200", description = "Étudiant sauvegardé"),
                  @ApiResponse(responseCode = "400", description = "Requête invalide")
          }
  )
  public Response addStudent(
      @Parameter(description = "Student object that needs to be added to the store", required = true) Student student) {
    studentDAO.save(student);
    return Response.ok().entity("SUCCESS").build();
  }
}