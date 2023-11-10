package my.v01d.graphql_course.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer age;

    @ManyToOne(fetch = FetchType.LAZY)
    private Filiere filiere;

    public Student(String name,Integer age,Filiere filiere){
        this.name = name;
        this.age = age;
        this.filiere = filiere;
    }

    public Student() {
    }

}
