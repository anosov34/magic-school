package ru.hogvards.magicschool;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        List<Faculty> faculties = new ArrayList<>();

        Student student1 = new Student(1L, "Lisa", 14);
        Student student2 = new Student(2L, "Gvidon", 13);
        Student student3 = new Student(3L, "Gendolf", 10);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        System.out.println(students);
        Faculty faculty = new Faculty(1L, "First", "red");
        Faculty faculty2 = new Faculty(2L, "Second", "yellow");
        Faculty faculty3 = new Faculty(3L, "Third", "white");
        faculties.add(faculty);
        faculties.add(faculty2);
        faculties.add(faculty3);
        System.out.println(faculties);
    }

}
