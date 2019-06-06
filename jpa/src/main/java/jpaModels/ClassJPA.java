package jpaModels;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "uni_class")
public class ClassJPA {

    @Id
    @Column(name = "class_name")
    private String name;

    @ManyToMany(mappedBy = "classes")
    private List<StudentJPA> students;


}
