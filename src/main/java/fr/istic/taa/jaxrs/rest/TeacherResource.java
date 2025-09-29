package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.TeacherDAO;
import fr.istic.taa.jaxrs.domain.Teacher;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("teacher")
@Produces({"application/json"})
public class TeacherResource {
    TeacherDAO teacherDAO = new TeacherDAO();

  @GET
  @Path("/{teacherId}")
  public Teacher getTeacherById(@PathParam("teacherId") Long teacherId)  {
      return teacherDAO.findOne(teacherId);
  }

  @GET
  @Path("/")
  public List<Teacher> getTeachers()  {
      return teacherDAO.findAll();
  }

  @POST
  @Consumes("application/json")
  public Response addTeacher(
      @Parameter(description = "Teacher object that needs to be added to the store", required = true) Teacher teacher) {
    teacherDAO.save(teacher);
    return Response.ok().entity("SUCCESS").build();
  }
}