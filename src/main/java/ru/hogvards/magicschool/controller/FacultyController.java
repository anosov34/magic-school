package ru.hogvards.magicschool.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogvards.magicschool.model.Faculty;
import ru.hogvards.magicschool.service.FacultyService;
import java.util.Collection;

@RequestMapping("faculty")
@RestController
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.addAndEditFaculty(faculty);
    }

    @PutMapping
    public Faculty editFaculty(@RequestBody Faculty faculty) {
        return facultyService.addAndEditFaculty(faculty);
    }

    @DeleteMapping
    public ResponseEntity<Faculty> deleteFaculty(@RequestParam Long facultyId) {
        facultyService.removeFaculty(facultyId);
        return ResponseEntity.ok().build();
    }

    @GetMapping(params = {"facultyId"})
    public Faculty getFaculty(@RequestParam(required = false) Long facultyId) {
        return facultyService.findFaculty(facultyId);

    }

    @GetMapping
    public Collection<Faculty> getAllFaculties() {
        return facultyService.getAllFaculties();
    }

    @GetMapping(params = {"color"})
    public Collection<Faculty> sortFacultyByColor(@RequestParam(required = false) String color) {
        return facultyService.getFacultyByColor(color);
    }
}