package my.v01d.graphql_course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import my.v01d.graphql_course.entities.Filiere;
import my.v01d.graphql_course.entities.Student;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{

    List<Student> findByFiliere(Filiere filiere);
    
}
