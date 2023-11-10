package my.v01d.graphql_course.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import my.v01d.graphql_course.entities.Filiere;
import my.v01d.graphql_course.services.FiliereService;

@Controller
public class FiliereController {

    @Autowired
    private FiliereService filiereService;

    @QueryMapping
    List<Filiere> filieres() {
        return filiereService.findAll();
    }

    @QueryMapping
    Filiere filiereById(@Argument Integer id) {
        return filiereService.findById(id);
    }

    // Adding filiere
    @MutationMapping
    Filiere addFiliere(@Argument FiliereInput filiereInput) {

        Filiere filiere = null;
        try {
            filiere = new Filiere(filiereInput.libelle(),filiereInput.code());
            filiereService.create(filiere);

        } catch (Exception err) {
            System.out.println("The filiere input libelle is : " + filiereInput.libelle);
        }
        return filiere;
    }

    // Deleting Filiere
    @MutationMapping
    public Boolean deleteFiliere(@Argument int id) {
        try {
            filiereService.deleteById(id);
            return true;
        } catch (Exception err) {
            System.out.println("The id to delete is " + id);
            return false;
        }
    }

    // Updating Filiere
    @MutationMapping
    public Boolean updateFiliere(@Argument Integer id, @Argument FiliereInput filiereInput) {

        try {
            filiereService.update(new Filiere(filiereInput.libelle(), filiereInput.code()), id);
            return true;
        } catch (Exception err) {
            err.printStackTrace();
            return false;
        }
    }

    record FiliereInput(String code, String libelle) {
    }

}
