package ru.hogvards.magicschool.service;

import ru.hogvards.magicschool.model.Student;

import java.util.Collection;

public interface StudentService {
    Student addAndEditStudent(Student student);
    Student findStudent(Long id);
    void removeStudent(Long id);
    Collection<Student> getAllStudents();
    Collection<Student> getStudentsByAge(int age);
    Collection<Student> getStudentsByAgeRage(int min, int max);
}
