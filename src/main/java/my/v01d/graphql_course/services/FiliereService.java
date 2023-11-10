package my.v01d.graphql_course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.v01d.graphql_course.entities.Filiere;
import my.v01d.graphql_course.repositories.FiliereRepository;

@Service
public class FiliereService {

    @Autowired
    private FiliereRepository filiereRepository;

    public List<Filiere> findAll() {
        return filiereRepository.findAll();
    }

    public Filiere findById(Integer id) {
        return filiereRepository.findById(id).get();
    }

    public void create(Filiere filiere) {
        filiereRepository.save(filiere);
    }

    public void update(Filiere newFiliere, Integer id) {
        Filiere oldFil = filiereRepository.findById(id).get();

        if (oldFil != null) {
            // Update fields of the oldFil with the newFiliere values
            String newCode = newFiliere.getCode();
            String newLibelle = newFiliere.getLibelle();

            if (newCode != null && !newCode.isEmpty()) {
                oldFil.setCode(newCode);
            }
            if (newLibelle != null && !newLibelle.isEmpty()) {
                oldFil.setLibelle(newLibelle);
            }

            filiereRepository.save(oldFil);
        }
    }

    public void deleteById(Integer id) {
        filiereRepository.deleteById(id);
    }

}
