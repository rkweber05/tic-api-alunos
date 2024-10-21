package com.api.alunos.controlles;

import com.api.alunos.dtos.UpdateStudentDTO;
import com.api.alunos.exceptions.CustomException;
import com.api.alunos.models.StudentModel;
import com.api.alunos.repositories.StudentRepository;
import com.api.alunos.services.StudentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
@CrossOrigin("*")
@AllArgsConstructor
@NoArgsConstructor
public class StudentController {
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentModel>> findAllStudent() {
        try {
            return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
        } catch (Exception exception) {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<StudentModel> findStudentById(@PathVariable Integer id) {
        try {
            Optional<StudentModel> studentById = studentService.findById(id);
            return ResponseEntity.ok().body(studentById.get());
        } catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<StudentModel> createNewStudent(@RequestBody StudentModel studentModel) {
        try {
            studentModel.setId(null);
            return new ResponseEntity<>(studentService.create(studentModel), HttpStatus.CREATED);
        } catch (Exception exception) {
            return ResponseEntity.noContent().build();
        }

    }

    @PutMapping("{id}")
    public ResponseEntity<StudentModel> updateSudent(@PathVariable Integer id, @RequestBody StudentModel studentModel) {
        try {
            var updateStudent = studentService.updateNewStudent(id, studentModel);
            return ResponseEntity.ok(updateStudent);
        } catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }

    }

    @PatchMapping("{id}")
    public ResponseEntity<StudentModel> updatePartialSudent(@PathVariable Integer id, @RequestBody UpdateStudentDTO studentDTO) {
        try {
            StudentModel updateStudentPartial = studentService.updatePartialStudent(id, studentDTO);
            return ResponseEntity.ok(updateStudentPartial);
        } catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable Integer id) {
        try {
            studentService.removeStudent(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }
}
