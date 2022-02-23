package ru.hogvards.magicschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hogvards.magicschool.model.Faculty;

import java.util.Collection;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty,Long> {
    Collection<Faculty> findFacultyByNameIgnoreCase(String name);
    Collection<Faculty> findFacultyByColorIgnoreCase(String color);
}
