package my.v01d.graphql_course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.v01d.graphql_course.entities.Filiere;
import my.v01d.graphql_course.entities.Student;
import my.v01d.graphql_course.repositories.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public Student findById(Integer id){
        return studentRepository.findById(id).get();
    }

    public void create(Student Student){
        studentRepository.save(Student);
    }

    public void update(Student newStudent, Integer id) {
        Student oldStud = studentRepository.findById(id).get();

        if (oldStud != null) {
            // Update fields of the oldStud with the newStudent values
            String newName = newStudent.getName();
            Integer newAge = newStudent.getAge();
            Filiere newFiliere = newStudent.getFiliere();

            if (newName != null && !newName.isEmpty()) {
                oldStud.setName(newName);
            }
            if (newAge != null) {
                oldStud.setAge(newAge);
            }
            if (newFiliere != null) {
                oldStud.setFiliere(newFiliere);
            }
            

            studentRepository.save(oldStud);
        }
    }


    public void deleteById(Integer id){
        studentRepository.deleteById(id);
    }
    
    public List<Student> findByFiliere(Filiere filiere){
        return studentRepository.findByFiliere(filiere);
    }
}
