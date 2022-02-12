package ru.hogvards.magicschool.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogvards.magicschool.model.Faculty;
import ru.hogvards.magicschool.model.Student;
import ru.hogvards.magicschool.service.FacultyService;

import java.util.Collection;
import java.util.stream.Collectors;

@RequestMapping("faculty")
@RestController
public class FacultyController {
    public final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }


    @PostMapping("create")
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.addFaculty(faculty);
    }

    @PutMapping("edit")
    public Faculty editFaculty(@RequestBody Faculty faculty) {
        return facultyService.editFaculty(faculty);
    }

    @DeleteMapping("delete")
    public ResponseEntity deleteFaculty(@RequestParam long id) {
         facultyService.removeFaculty(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("find")
    public Faculty getFaculty(@RequestParam long id) {
        return facultyService.findFaculty(id);
    }

    @GetMapping("all")
    public Collection<Faculty> getAllFaculties() {
        return facultyService.getAllFaculties();
    }

    @GetMapping("color")
    public Collection<Faculty> sortFacultyByColor(@RequestParam String color) {
        return facultyService.getAllFaculties().stream()
                .filter(faculty -> faculty.getColor().equals(color))
                .collect(Collectors.toList());
    }
}
