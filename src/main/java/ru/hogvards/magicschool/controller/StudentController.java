package ru.hogvards.magicschool.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogvards.magicschool.model.Student;
import ru.hogvards.magicschool.service.StudentService;

import java.util.Collection;
import java.util.stream.Collectors;

@RequestMapping("student")
@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping
    public Student editStudent(@RequestBody Student student) {
        return studentService.editStudent(student);
    }

    @DeleteMapping
    public Student deleteStudent(@RequestParam Long id) {
        return studentService.removeStudent(id);
    }

    @GetMapping(params = {"id"})
    public Student getStudent(@RequestParam Long id) {
        return studentService.findStudent(id);
    }

    @GetMapping("all")
    public Collection<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping(params = {"age"})
    public Collection<Student> sortStudentsByAge(@RequestParam int age) {
        return studentService.getAllStudents().stream()
                .filter(student -> student.getAge() == age)
                .collect(Collectors.toList());
    }
}