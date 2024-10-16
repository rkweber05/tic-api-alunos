package com.api.alunos.controlles;

import com.api.alunos.models.StudentModel;
import com.api.alunos.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
@CrossOrigin("*")
@AllArgsConstructor
public class StudentController {
    private final StudentRepository studentRepository;

    @GetMapping
    public ResponseEntity<List<StudentModel>> findAllStudent() {
        return new ResponseEntity<>(studentRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<StudentModel> findStudentById(@PathVariable Integer id) {
        Optional<StudentModel> studentById = studentRepository.findById(id);
        return ResponseEntity.ok().body(studentById.get());
    }

    @PostMapping
    public ResponseEntity<StudentModel> createNewStudent(@RequestBody StudentModel studentModel) {
        studentModel.setId(null);
        return new ResponseEntity<>(studentRepository.save(studentModel), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<StudentModel> updateSudent(@PathVariable Integer id, @RequestBody StudentModel studentModel) {
        var updateStudent = studentRepository.save(studentModel);
        return ResponseEntity.ok(updateStudent);
    }

    @PatchMapping("{id}")
    public ResponseEntity<StudentModel> updatePartialSudent(@PathVariable Integer id, @RequestBody StudentModel studentModel) {

        return null;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable Integer id) {
        studentRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
