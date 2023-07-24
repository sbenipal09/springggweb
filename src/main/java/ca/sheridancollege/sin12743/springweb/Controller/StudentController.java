package ca.sheridancollege.sin12743.springweb.Controller;

import ca.sheridancollege.sin12743.springweb.Repository.StudentRepo;
import ca.sheridancollege.sin12743.springweb.bean.Student;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController//repo
@RequestMapping("/students")
public class StudentController {
    private final StudentRepo stuRepo;
    public StudentController(StudentRepo stuRepo) {
        this.stuRepo = stuRepo;
    }
    @GetMapping(value = {"/",""})
    public ArrayList<Student> goHome(){

        return stuRepo.getStudents();
    }
    @GetMapping("/{id}")
    public Student getStudentElement(@PathVariable int id){

        return stuRepo.getStudentById(id);
    }
    @PostMapping(value = {"/",""} ,headers={"Content-type=application/json"})
    public Student addStudent(@RequestBody Student student) {
        stuRepo.addStudent(student);
        //last student in the collection
        return stuRepo.getStudents().get(stuRepo.getStudents().size()-1);
    }

    @PutMapping(value = {"/",""} ,headers={"Content-type=application/json"})
    public ArrayList<Student> updateStudentCollection(@RequestBody Student[] students) {
        for (Student s : students) {
            stuRepo.updateStudent(s);
        }
return stuRepo.getStudents();
    }

}
