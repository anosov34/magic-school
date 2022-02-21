package ru.hogvards.magicschool.service;

import ru.hogvards.magicschool.model.Faculty;

import java.util.Collection;

public interface FacultyService {
    Faculty addAndEditFaculty(Faculty faculty);
    Faculty findFaculty(Long facultyId);
    void removeFaculty(Long facultyId);
    Collection<Faculty> getAllFaculties();
    Collection<Faculty> getFacultyByColor(String color);
}