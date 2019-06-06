package jpaModels;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

//
//private int id;
//private String name;
//private String gender;
//private byte[] photo;
//private String faculty;
//@XmlElementWrapper(name = "CourseList")
//@XmlElement(name = "course")
//private List<String> courses;
//private float grades;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class StudentJPA {
    @Id
    @Column(name = "student_id")
    private Integer student_id;
    @Column(name = "student_name")
    private String name;
    @Column(name = "student_gender")
    private String gender;
    @Column(name = "photo")
    private String photo;
    @Column(name = "student_grades")
    private Float grades;

    @ManyToOne
    @JoinColumn(name = "faculty_name")
    private FacultyJPA facultyJPA;

    @ManyToMany
    @JoinTable(
            name = "uni_class",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "class_name")}
    )
    private Set<ClassJPA> classes;



}