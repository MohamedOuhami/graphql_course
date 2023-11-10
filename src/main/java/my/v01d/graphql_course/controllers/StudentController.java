package my.v01d.graphql_course.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import my.v01d.graphql_course.controllers.FiliereController.FiliereInput;
import my.v01d.graphql_course.entities.Filiere;
import my.v01d.graphql_course.entities.Student;
import my.v01d.graphql_course.services.FiliereService;
import my.v01d.graphql_course.services.StudentService;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private FiliereService filiereService;

    @QueryMapping
    List<Student> Students() {
        return studentService.findAll();
    }

    @QueryMapping
    Student studentById(@Argument Integer id) {
        return studentService.findById(id);
    }

    @QueryMapping
    public List<Student> findByFiliere(@Argument FiliereIdentifier filiereId){
        return studentService.findByFiliere(filiereService.findById(filiereId.id()));
    }

    // Adding Student
    @MutationMapping
    Student addStudent(@Argument StudentInput studentInput) {

        Student student = null;

        try {
            student = new Student(
                studentInput.name(),
                studentInput.age(),
                filiereService.findById(studentInput.filiereId()));
            studentService.create(student);

        } catch (Exception err) {
            System.out.println("The Student input name is : " + student.getName());
        }
        return student;
    }

    // Deleting Student
    @MutationMapping
    public Boolean deleteStudent(@Argument int id) {
        try {
            studentService.deleteById(id);
            return true;
        } catch (Exception err) {
            System.out.println("The id to delete is " + id);
            return false;
        }
    }

    // Updating Student
    @MutationMapping
    public Boolean updateStudent(
        @Argument Integer id, 
        @Argument StudentInput studentInput
        ) {
        try {
            studentService.update(new Student(
                studentInput.name(),
                studentInput.age(),
                filiereService.findById(studentInput.filiereId()))
                , id);
            return true;
        } catch (Exception err) {
            err.printStackTrace();
            return false;
        }
    }

    record StudentInput(String name, Integer age, Integer filiereId) {
    }

    record FiliereIdentifier(Integer id) {
    }

}
