package ru.hogvards.magicschool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.hogvards.magicschool.exceptions.BadRequestException;
import ru.hogvards.magicschool.model.Faculty;
import ru.hogvards.magicschool.model.Student;
import ru.hogvards.magicschool.repository.FacultyRepository;

import java.util.Collection;
import java.util.HashMap;


@Service
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

    public Faculty findFaculty(Long facultyId) {
        return facultyRepository.findById(facultyId).orElse(null);
    }

    public void removeFaculty(Long facultyId) {
        facultyRepository.deleteById(facultyId);
    }

    public Collection<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }
}
