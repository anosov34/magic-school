package ru.hogvards.magicschool.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogvards.magicschool.model.Faculty;
import ru.hogvards.magicschool.service.FacultyService;
import java.util.Collection;
import java.util.stream.Collectors;

@RequestMapping("faculty")
@RestController
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
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
    public Faculty getFaculty(@RequestParam Long id) {
        return facultyService.findFaculty(id);
    }

    @GetMapping("all")
    public Collection<Faculty> getAllFaculties() {
        return facultyService.getAllFaculties();
    }

    @GetMapping(params = {"color"})
    public Collection<Faculty> sortFacultyByColor(@RequestParam String color) {
        return facultyService.getAllFaculties().stream()
                .filter(faculty -> faculty.getColor().equals(color))
                .collect(Collectors.toList());
    }
}
