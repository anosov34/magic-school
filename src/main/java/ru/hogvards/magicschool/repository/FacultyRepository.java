package ru.hogvards.magicschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogvards.magicschool.model.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty,Long> {

}
