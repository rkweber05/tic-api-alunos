package com.api.alunos.repositories;

import com.api.alunos.models.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentModel, Integer> {
}
