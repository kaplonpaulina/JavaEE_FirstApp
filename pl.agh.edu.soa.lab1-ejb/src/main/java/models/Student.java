package models;

import javax.xml.bind.annotation.*;
import java.util.List;


@XmlType(name = "student")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
    private int id;
    private String name;
    private char gender;
    private String photo;
    private String faculty;
    @XmlElementWrapper(name = "CourseList")
    @XmlElement(name = "course")
    private List<String> courses;
    private float grades;

    public Student(){}
    public Student(int id, String name, char gender, String photo, String faculty, List<String> courses, float grades) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.photo = photo;
        this.faculty = faculty;
        this.courses = courses;
        this.grades = grades;
    }


    @Override
    public String toString() {
        return "id: " +id+ "; name: " + name +"; gender: " + gender +  "; photo: " + photo + "; faculty:" + faculty + "; courses: " + courses+"; grades: "+ grades;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public float getGrades() {
        return grades;
    }

    public void setGrades(float grades) {
        this.grades = grades;
    }
}
