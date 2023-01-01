package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //http://localhost:8080/api/v1/student/
    @GetMapping("/")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    //http://localhost:8080/api/v1/student/
    @PostMapping("/")
    public  void registerNewStudent(@RequestBody Student student)
    {
        studentService.addNewStudent(student);
    }

    //http://localhost:8080/api/v1/student/1?name=Maria
    //http://localhost:8080/api/v1/student/1?name=Maria&email=maria@gmail.com
    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId,name,email);
    }

    //http://localhost:8080/api/v1/student/1
    @DeleteMapping(path = "{studentID}")
    public void deleteStudent(@PathVariable("studentID") Long studentId){
        studentService.deleteStudent(studentId);
    }

}
