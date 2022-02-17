package ru.hogvards.magicschool.service;

import org.springframework.stereotype.Service;
import ru.hogvards.magicschool.model.Student;
import ru.hogvards.magicschool.repository.StudentRepository;
import java.util.Collection;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student editStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student findStudent(long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public void removeStudent(long id) {
        studentRepository.deleteById(id);
    }

    public Collection<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
