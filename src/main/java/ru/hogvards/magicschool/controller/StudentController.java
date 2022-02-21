package ru.hogvards.magicschool.controller;

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
    public Student getStudent(@RequestParam (required = false) Long id) {
        return studentService.findStudent(id);
    }

    @GetMapping("all")
    public Collection<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping(params = {"age"})
    public Collection<Student> filterStudentsByAge(@RequestParam (required = false) int age) {
        return studentService.filterStudentByAge(age);
    }
}