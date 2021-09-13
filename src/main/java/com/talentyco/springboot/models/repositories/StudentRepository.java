package com.talentyco.springboot.models.repositories;

import com.talentyco.springboot.models.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long>  {
}
