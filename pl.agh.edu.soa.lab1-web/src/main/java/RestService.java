
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import models.Student;
import models.University;

import java.io.ByteArrayInputStream;
import java.util.*;
import java.util.stream.Collectors;


@Path("/MyApi")
@ApplicationPath("/api")
public class RestService extends Application {
    @Inject
    University university;


    //localhost:8080/pl.agh.edu.soa.lab1/api/MyApi/sayHello
    @GET
    @Path("sayHello")
    public String getHelloMsg() {
        return "Hello world";
    }

    @GET
    @Path("/echo")
    public Response getEchoMsg(@QueryParam("message") String msg) {

        return Response.ok("Your massage was : " + msg).build();
    }

    @GET
    @Path("/student")
    @Produces(MediaType.APPLICATION_JSON)
    public Student getStudent(@QueryParam("id") int id) {
        return university.get(id);
    }

    @GET
    @Path("/photo")
    @Produces("image/png")
    public Response getPhoto(@QueryParam("id") int id) {
        byte[] photo = university.get(id).getPhoto();

        return Response.ok(new ByteArrayInputStream(photo)).build();
    }

    @GET
    @Path("/students")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> filterStudents(@QueryParam("gender") @DefaultValue("all") String gender) {

        List<Student> students;

        switch (gender) {
            case "male":
            case "m":
            case "males":
                students = university.getAllStudents().stream().filter(a -> a.getGender().equals("m")).collect(Collectors.toList());
                break;
            case "female":
            case "f":
            case "females":
                students = university.getAllStudents().stream().filter(a -> a.getGender().equals("f")).collect(Collectors.toList());
                break;
            case "all":
                students = university.getAllStudents();
                break;
            default:
                students = university.getAllStudents().stream().filter(a -> !a.getGender().equals("m") && !a.getGender().equals("f")).collect(Collectors.toList());
                break;
        }

        return students;
    }



    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/addStudent")
    @JWTTokenNeeded
    public String addStudent( Student student){
        university.addStudent(student);
        return "added";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/editStudent")
    @JWTTokenNeeded
    public String editStudent(@QueryParam("id") int id, Student student){
        university.delStudent(id);
        university.addStudent(student);
        return "edited";
    }





}
