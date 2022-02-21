package ru.hogvards.magicschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hogvards.magicschool.model.Student;

import java.util.Collection;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    Collection<Student> findStudentByAge(int age);
}
