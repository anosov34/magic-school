package ru.hogvards.magicschool.service;

import ru.hogvards.magicschool.model.Student;

import java.util.Collection;


public interface StudentService {
    Student addStudent(Student student);
    Student findStudent(long id);
    Student removeStudent(long id);
    Student editStudent(Student student);
    Collection<Student> getAllStudents();
    Collection<Student> filterStudentByAge(int age);
    }
