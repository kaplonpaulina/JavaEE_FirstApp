package models;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import java.util.*;

@Singleton
public class University {

    private Map<Integer, Student> students;

    @PostConstruct
    public void init() {
        students = new HashMap<>();
    }

    public List<Student> getAllStudents(){return new ArrayList<>(students.values());}

    public void addStudent(Student s) {
        students.put(s.getId(), s);
    }

    public void addStudent(int id, String name, char gender, String photo, String faculty, List<String> courses, float grade){
        Student newStudent = new Student(id, name, gender, photo, faculty, courses, grade);
        students.put(id,newStudent);
    }


    public Student delStudent(int id) {return students.remove(id);}

    public Student delStudent(Student s){return delStudent(s.getId());}

    public Student get(int id){return students.get(id);}

}
