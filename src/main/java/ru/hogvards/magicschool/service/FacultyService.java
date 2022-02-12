package ru.hogvards.magicschool.service;

import org.springframework.stereotype.Repository;
import ru.hogvards.magicschool.exceptions.BadRequestException;
import ru.hogvards.magicschool.model.Faculty;
import ru.hogvards.magicschool.model.Student;
import ru.hogvards.magicschool.repository.FacultyRepository;

import java.util.Collection;
import java.util.HashMap;

@Repository

public class FacultyService {
    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty addFaculty(Faculty faculty) {
       return facultyRepository.save(faculty);
    }
    public Faculty editFaculty(Faculty faculty) {
        return  facultyRepository.save(faculty);
    }

    public Faculty findFaculty(long id) {
        return facultyRepository.getById(id);
    }

    public void removeFaculty(long id) {
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }
}
