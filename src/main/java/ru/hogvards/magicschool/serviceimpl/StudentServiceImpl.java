package ru.hogvards.magicschool.serviceimpl;

import org.springframework.stereotype.Service;
import ru.hogvards.magicschool.exceptions.StudentIsNotFoundException;
import ru.hogvards.magicschool.model.Student;
import ru.hogvards.magicschool.repository.StudentRepository;
import ru.hogvards.magicschool.service.StudentService;

import java.util.Collection;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addAndEditStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student findStudent(Long id) {
        return studentRepository.findById(id).orElseThrow(StudentIsNotFoundException::new);
    }
    public void removeStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Collection<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Collection<Student> getStudentsByAge(int age) {
        return studentRepository.findByAge(age);
    }
    public Collection<Student> getStudentsByAgeRage(int min, int max) {
        return studentRepository.findByAgeBetween(min, max);
    }
}
