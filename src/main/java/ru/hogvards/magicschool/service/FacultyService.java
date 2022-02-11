package ru.hogvards.magicschool.service;

import org.springframework.stereotype.Repository;
import ru.hogvards.magicschool.model.Faculty;
import ru.hogvards.magicschool.model.Student;

import java.util.Collection;
import java.util.HashMap;

@Repository

public class FacultyService {
    private final HashMap<Long, Faculty> faculties = new HashMap<>();
    private long id = 0;

    public Faculty addFaculty(Faculty faculty) {
        faculty.setId(++id);
        faculties.put(id, faculty);
        return faculty;
    }

    public Faculty findFaculty(long id) {
        return faculties.get(id);
    }

    public Faculty removeFaculty(long id) {
        return faculties.remove(id);
    }

    public Faculty editFaculty(Faculty faculty) {
        if (faculties.containsKey(faculty.getId())) {
            faculties.put(faculty.getId(), faculty);
            return faculty;
        }
        return null;
    }

    public Collection<Faculty> getAllFaculties() {
        return faculties.values();
    }
}
