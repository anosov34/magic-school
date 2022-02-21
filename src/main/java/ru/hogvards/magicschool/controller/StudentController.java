package ru.hogvards.magicschool.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogvards.magicschool.model.Student;
import ru.hogvards.magicschool.serviceimpl.StudentServiceImpl;

import java.util.Collection;

@RequestMapping("student")
@RestController
public class StudentController {
    private final StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.addAndEditStudent(student);
    }

    @PutMapping
    public Student editStudent(@RequestBody Student student) {
        return studentService.addAndEditStudent(student);
    }

    @DeleteMapping
    public ResponseEntity<Student> deleteStudent(@RequestParam Long id) {
        studentService.removeStudent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(params = {"id"})
    public Student getStudent (@RequestParam(required = false) Long id){
        return studentService.findStudent(id);
    }

    @GetMapping
    public Collection<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping(params = {"age"})
    public Collection<Student> sortStudentsByAge(@RequestParam(required = false) int age) {
        return studentService.findStudentByAge(age);
    }
}