package ru.hogvards.magicschool.service;

import ru.hogvards.magicschool.model.Faculty;


import java.util.Collection;


public interface FacultyService {
    Faculty addFaculty(Faculty faculty);
    Faculty findFaculty(long id);
    Faculty removeFaculty(long id);
    Faculty editFaculty(Faculty faculty);
    Collection<Faculty> filterFacultyByColor(String color);
    Collection<Faculty> getAllFaculties();
}

