package com.api.alunos.services;

import com.api.alunos.models.StudentModel;
import com.api.alunos.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<StudentModel> findAll() {
        return studentRepository.findAll();
    }

    public Optional<StudentModel> findById(Integer id) {
        return studentRepository.findById(id);
    }

    public StudentModel create(StudentModel studentModel) {
        return studentRepository.save(studentModel);
    }

    public StudentModel updateNewStudent(Integer id, StudentModel studentModel) {
        var student = studentRepository.findById(id);

        if (student.isPresent()) {
            studentModel.setName(studentModel.getName());
            studentModel.setSurname(studentModel.getSurname());
            studentModel.setEmail(studentModel.getEmail());
        } else {
            System.out.println("Usuário não cadastrado");
        }

        return studentRepository.save(studentModel);
    }

    public void removeStudent(Integer id) throws Exception {
        StudentModel studentRemove = studentRepository.findById(id).orElseThrow(() -> new Exception("Estudante não encontrado !"));
        studentRepository.delete(studentRemove);
    }
}
