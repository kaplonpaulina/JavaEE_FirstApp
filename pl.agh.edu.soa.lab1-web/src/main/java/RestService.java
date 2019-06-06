
import com.google.protobuf.ByteString;
import models.Student;
import models.StudentP;
import models.University;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
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
    public Student getStudent(@NotNull @QueryParam("id") int id) {
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
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/addStudent")
    @JWTTokenNeeded
    public Response addStudent(@NotNull @FormParam("id") Integer id, @FormParam("name") String name, @FormParam("gender") String gender, @FormParam("photo") String photo,@FormParam("faculty") String faculty,@FormParam("grades") String grades ){
        Student s = new Student(id,name,gender,null, faculty,null, 2);
        university.addStudent(s);
        return Response.status(Response.Status.CREATED).entity(s).build();
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


    @GET
    @Path("/proto")
    public Response getProto(@QueryParam("id") int id) {

        Student s = university.get(id);
        if(s==null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        ProtobufProvider provider = new ProtobufProvider();
        Annotation[] EMPTY_ANNOTATIONS = {};

        //StudentP.StudentProto sp = StudentP.StudentProto.newBuilder().setId(s.getId()).setName(s.getName()).setGender(s.getGender()).setFaculty(s.getFaculty()).setPhoto(ByteString.copyFrom(s.getPhoto())).setCourse(0,"soa").setGrades(String.valueOf(s.getGrades())).build();
        StudentP.StudentProto sp = StudentP.StudentProto.newBuilder().setId(s.getId()).setName(s.getName()).setGender(s.getGender()).setFaculty(s.getFaculty()).setPhoto(ByteString.copyFrom(s.getPhoto())).setGrades(String.valueOf(s.getGrades())).build();

        final byte[] buf;
        try(final ByteArrayOutputStream os = new ByteArrayOutputStream()){
            provider.writeTo(sp, sp.getClass(), null, EMPTY_ANNOTATIONS, ProtobufMediaType.MEDIA_TYPE, null, os);
            buf = os.toByteArray();
            return Response.ok().entity(buf).type("application/x-protobuf").build();


        } catch (IOException e) {

            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }


    }




}
