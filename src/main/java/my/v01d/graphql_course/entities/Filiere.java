package my.v01d.graphql_course.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Filiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String libelle;
    private String code;

    @OneToMany(mappedBy = "filiere")
    private List<Student> students;

    public Filiere(String libelle, String code) {
        this.libelle = libelle;
        this.code = code;
    }

    public Filiere() {
    }

    
    
}
