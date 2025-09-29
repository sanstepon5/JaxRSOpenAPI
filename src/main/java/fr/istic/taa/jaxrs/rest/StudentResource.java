package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.StudentDAO;
import fr.istic.taa.jaxrs.domain.Student;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("student")
@Produces({"application/json"})
public class StudentResource {
    StudentDAO studentDAO = new StudentDAO();

  @GET
  @Path("/{studentId}")
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
  public Response addStudent(
      @Parameter(description = "Student object that needs to be added to the store", required = true) Student student) {
    studentDAO.save(student);
    return Response.ok().entity("SUCCESS").build();
  }
}