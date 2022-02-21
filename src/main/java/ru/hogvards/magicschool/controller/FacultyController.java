package ru.hogvards.magicschool.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogvards.magicschool.model.Faculty;
import ru.hogvards.magicschool.serviceimpl.FacultyServiceImpl;
import java.util.Collection;

@RequestMapping("faculty")
@RestController
public class FacultyController {
    private final FacultyServiceImpl facultyService;

    public FacultyController(FacultyServiceImpl facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.addFaculty(faculty);
    }

    @PutMapping
    public Faculty editFaculty(@RequestBody Faculty faculty) {
        return facultyService.editFaculty(faculty);
    }

    @DeleteMapping
    public Faculty deleteFaculty(@RequestParam Long id) {
        return facultyService.removeFaculty(id);
    }

    @GetMapping(params = {"id"})
    public Faculty getFaculty(@RequestParam(required = false) Long id) {
        return facultyService.findFaculty(id);
    }

    @GetMapping("all")
    public Collection<Faculty> getAllFaculties() {
        return facultyService.getAllFaculties();
    }

    @GetMapping(params = {"color"})
    public Collection<Faculty> filterFacultyByColor(@RequestParam (required = false) String color) {
        return facultyService.filterFacultyByColor(color);
    }
}
