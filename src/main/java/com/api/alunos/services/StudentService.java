package com.api.alunos.services;

import com.api.alunos.dtos.UpdateStudentDTO;
import com.api.alunos.models.StudentModel;
import com.api.alunos.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class StudentService {
    private StudentRepository studentRepository;

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

    public void removeStudent(Integer id){
        studentRepository.deleteById(id);
    }

    public StudentModel updatePartialStudent(Integer id, UpdateStudentDTO studentDTO) throws Exception {
        StudentModel student = studentRepository.findById(id).orElseThrow(() -> new Exception("Student not found"));

        if (studentDTO.getName() != null) {
            student.setName(studentDTO.getName());
        }

        if (studentDTO.getSurname() != null) {
            student.setSurname(studentDTO.getSurname());
        }

        if (studentDTO.getEmail() != null) {
            student.setEmail(studentDTO.getEmail());
        }

        if (studentDTO.getCpf() != null) {
            student.setCpf(studentDTO.getCpf());
        }

        if (studentDTO.getRg() != null) {
            student.setRg(studentDTO.getRg());
        }

        return studentRepository.save(student);
    }
}
