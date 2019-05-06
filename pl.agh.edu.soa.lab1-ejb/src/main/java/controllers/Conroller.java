package controllers;

import models.Student;
import models.University;
import org.jboss.ws.api.annotation.WebContext;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.Base64;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
@WebService
@DeclareRoles({"admin"})
@WebContext(authMethod="BASIC",transportGuarantee="NONE")
public class Conroller {

    @Inject
    University university;

    @WebMethod
    @RolesAllowed("admin")
    @XmlElement(name = "student")
    public void addStudent(@WebParam(name = "id") @XmlElement(required = true) int id,
                              @WebParam(name = "name") String name,
                              @WebParam(name = "gender") char gender,
                              @WebParam(name = "photo") byte[] photo,
                              @WebParam(name = "faculty") String faculty,
                              @WebParam(name = "courses") List<String> courses,
                              @WebParam(name = "grades") float grades) {
        university.addStudent(id,name, gender,Base64.getEncoder().encodeToString(photo),faculty,courses,grades);
    }
    @WebMethod
    @RolesAllowed("admin")
    @XmlElement(name = "student")
    public void delStudent(@WebParam(name = "id") @XmlElement int id) {
        university.delStudent(id);
    }



    @WebMethod
    @PermitAll
    @XmlElement(name = "student")
    public Student editStudent(@WebParam(name = "id") int studentId,
                               @WebParam(name = "newName") String newName,
                               @WebParam(name = "gender") char newGender,
                               @WebParam(name = "newPhoto") byte[] newPhoto,
                               @WebParam(name = "newFaculty") String newFaculty,
                               @WebParam(name = "newCourses") List<String> newCourses,
                               @WebParam(name = "grades") float newGrades) {


        Student student = university.get(studentId);

        if (newName != null) {
            student.setName(newName);
        }

        if (((Character) newGender) != null) {
            student.setGender(newGender);
        }

        if (newPhoto != null) {
            student.setPhoto(Base64.getEncoder().encodeToString(newPhoto));
        }

        if (newFaculty != null) {
            student.setFaculty(newFaculty);
        }

        if (newCourses != null) {
            student.setCourses(newCourses);
        }

        if(((Float) newGrades) != null){
            student.setGrades(newGrades);
        }


        university.addStudent(student);


        return student;
    }

    @WebMethod
    @RolesAllowed("admin")
    @XmlElement(name = "student")
    public Student getStudent(@WebParam(name = "id") @XmlElement int id) {
        return university.get(id);
    }

    @WebMethod
    @PermitAll
    @XmlElementWrapper(name = "StudentList")
    @XmlElement(name = "student")
    public List<Student> listStudents(@WebParam(name="faculty") String fFilter,
                                      @WebParam(name="gender") String gFilter,
                                      @WebParam(name = "gradeOrder") String oFilter) {

        List<Student> students = university.getAllStudents();

        if(!fFilter.isEmpty()){

            students = students.stream().filter(a -> a.getFaculty().equals(fFilter)).collect(Collectors.toList());

        }

        if(!gFilter.isEmpty()){
            switch (gFilter){
                case "male":
                case "m":
                case "males":
                    students = students.stream().filter(a->a.getGender()=='m').collect(Collectors.toList());
                    break;
                case "female":
                case "f":
                case "females":
                    students = students.stream().filter(a->a.getGender()=='f').collect(Collectors.toList());
                    break;
                default:
                    students = students.stream().filter(a->a.getGender()!='f' && a.getGender()!='m').collect(Collectors.toList());
                    break;
            }
        }

        if(!oFilter.isEmpty()){
            switch (oFilter){
                case "down":
                    students = students.stream().sorted(Comparator.comparing(Student::getGrades).reversed()).collect(Collectors.toList());
                    break;

                case "up":
                default:
                    students = students.stream().sorted(Comparator.comparing(Student::getGrades)).collect(Collectors.toList());

            }
        }

        return students;
    }

}
