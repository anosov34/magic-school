package ru.hogvards.magicschool.service;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import ru.hogvards.magicschool.exceptions.BadRequestException;
import ru.hogvards.magicschool.model.Faculty;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    private final HashMap<Long, Faculty> faculties = new HashMap<>();
    private long id = 0;

    public Faculty addFaculty(Faculty faculty) {
        faculty.setId(++id);
        faculties.put(id, faculty);
        return faculty;
    }

    public Faculty findFaculty(long id) {
        if (!faculties.containsKey(id)) {
            throw new BadRequestException();
        }
        return faculties.get(id);
    }

    public Faculty removeFaculty(long id) {
        if (!faculties.containsKey(id)) {
            throw new BadRequestException();
        }
        return faculties.remove(id);
    }

    public Faculty editFaculty(Faculty faculty) {
        if (faculties.containsKey(faculty.getId())) {
            faculties.put(faculty.getId(), faculty);
            return faculty;
        }
        return null;
    }

    public Collection<Faculty> filterFacultyByColor(String color) {
        List<Faculty> sortedByColorFaculties = new ArrayList<>();
        for (Faculty faculty : faculties.values()) {
            if (faculty.getColor().equals(color)) {
                sortedByColorFaculties.add(faculty);
            }
        }
        if (sortedByColorFaculties.size() == 0) {
            return null;
        }
        return sortedByColorFaculties;
    }

    public Collection<Faculty> getAllFaculties() {
        return faculties.values();
    }
}
