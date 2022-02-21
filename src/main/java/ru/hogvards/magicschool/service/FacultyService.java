package ru.hogvards.magicschool.service;
import org.springframework.stereotype.Service;
import ru.hogvards.magicschool.exceptions.FacultyIsNotFoundException;
import ru.hogvards.magicschool.model.Faculty;
import ru.hogvards.magicschool.repository.FacultyRepository;
import java.util.Collection;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty addAndEditFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(Long facultyId) {
        return facultyRepository.findById(facultyId).orElseThrow(FacultyIsNotFoundException::new);
    }

    public void removeFaculty(Long facultyId) {
        facultyRepository.deleteById(facultyId);
    }

    public Collection<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

    public Collection<Faculty> getFacultyByColor(String color) {
        return facultyRepository.findFacultyByColor(color);
    }
}
