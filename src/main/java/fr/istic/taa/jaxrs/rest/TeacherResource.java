package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dto.TeacherDTO;
import fr.istic.taa.jaxrs.service.TeacherService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("teacher")
@Produces({"application/json"})
@Tag(name = "Teacher")
public class TeacherResource {
    TeacherService teacherService = new TeacherService();

  @GET
  @Path("/{teacherId}")
  public TeacherDTO getTeacherById(@PathParam("teacherId") Long teacherId)  {
      return teacherService.getById(teacherId);
  }

  @GET
  @Path("/")
  public List<TeacherDTO> getTeachers()  {
      return teacherService.getAll();
  }

  @POST
  @Consumes("application/json")
  public Response addTeacher(
      @Parameter(description = "Teacher object that needs to be added to the store", required = true) TeacherDTO teacher) {
      teacherService.create(teacher);
    return Response.ok().entity("SUCCESS").build();
  }
}