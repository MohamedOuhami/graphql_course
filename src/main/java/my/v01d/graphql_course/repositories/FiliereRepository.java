package my.v01d.graphql_course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import my.v01d.graphql_course.entities.Filiere;

@Repository
public interface FiliereRepository extends JpaRepository<Filiere,Integer>{
    
}
