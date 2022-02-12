package ru.hogvards.magicschool.service;

import org.springframework.stereotype.Repository;
import ru.hogvards.magicschool.exceptions.BadRequestException;
import ru.hogvards.magicschool.model.Faculty;
import ru.hogvards.magicschool.model.Student;

import java.util.Collection;
import java.util.HashMap;
@Repository
public class StudentService {

    private final HashMap<Long, Student> students = new HashMap<>();
    private long id = 0;

    public Student addStudent(Student student) {
        student.setId(++id);
        students.put(id, student);
        return student;
    }

    public Student findStudent(long id) {
        if (!students.containsKey(id)) {
            throw new BadRequestException();
        }
        return students.get(id);
    }

    public Student removeStudent(long id) {
        if (!students.containsKey(id)) {
            throw new BadRequestException();
        }
        return students.remove(id);
    }

    public Student editStudent(Student student) {
        if (students.containsKey(student.getId())) {
            students.put(student.getId(), student);
            return student;
        }
        return null;
    }
    public Collection<Student> getAllStudents() {
        return students.values();
    }
}
