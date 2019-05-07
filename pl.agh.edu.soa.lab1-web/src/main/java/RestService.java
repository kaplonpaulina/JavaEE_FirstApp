
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import models.Student;
import models.University;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    public Student getStudent() {
        return new Student(1, "name", "f", "photo", "wiet", new ArrayList<>(Arrays.asList("a", "b")), 4);
    }

    @GET
    @Path("/students")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> filterStudents(@QueryParam("gender") @DefaultValue("all") String gender) {
        Student s = new Student(1, "name", "f", "photo", "wiet", new ArrayList<>(Arrays.asList("a", "b")), 4);

        Student ss = new Student(11, "name", "f", "photo", "wiet", new ArrayList<>(Arrays.asList("a", "b")), 4);

        university.addStudent(s);
        university.addStudent(ss);

        List<Student> students = new ArrayList<>();

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




//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Path("/addStudent")
//    public void addStudent(@QueryParam("jsn") String json) {
//        //university.addStudent(id, name, gender, photo, faculty, new ArrayList<String>(Arrays.asList("aa","bb")), grades);
////return;
//        //System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//    }


}
