
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import models.Credentials;
import models.Student;
import models.University;

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
    @Path("/students")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> filterStudents(@QueryParam("gender") @DefaultValue("all") String gender) {
        Student s = new Student(1, "name", "f", "photo", "wiet", new ArrayList<>(Arrays.asList("a", "b")), 4);

        Student ss = new Student(11, "name", "f", "photo", "wiet", new ArrayList<>(Arrays.asList("a", "b")), 4);

        university.addStudent(s);
        university.addStudent(ss);

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
    public String addStudent( Student student){
        university.addStudent(student);
        return "added";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/addStudent")
    public String editStudent(@QueryParam("id") int id, Student student){
        university.delStudent(id);
        university.addStudent(student);
        return "edited";
    }










    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response authenticateUser(Credentials credentials) {

        String username = credentials.getUsername();
        String password = credentials.getPassword();
        try {
            authenticate(username, password);

            String token = issueToken(username);

            return Response.ok(token).build();

        } catch (Exception e) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }

    private void authenticate(String username, String password) throws Exception {

        Map<String,String> users = new HashMap<>();
        users.put("ppp","ppp");

        if(!users.get(username).equals(password)){
            throw new Exception("no such user");
        }
    }

    private String issueToken(String username) {
        // Issue a token (can be a random String persisted to a database or a JWT token)
        // The issued token must be associated to a user
        // Return the issued token

        return username+"123";

    }


}
