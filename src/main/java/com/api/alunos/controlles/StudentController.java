package com.api.alunos.controlles;

import com.api.alunos.models.StudentModel;
import com.api.alunos.repositories.StudentRepository;
import com.api.alunos.services.StudentService;
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
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentModel>> findAllStudent() {
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<StudentModel> findStudentById(@PathVariable Integer id) {
        Optional<StudentModel> studentById = studentService.findById(id);
        return ResponseEntity.ok().body(studentById.get());
    }

    @PostMapping
    public ResponseEntity<StudentModel> createNewStudent(@RequestBody StudentModel studentModel) {
        studentModel.setId(null);
        return new ResponseEntity<>(studentService.create(studentModel), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<StudentModel> updateSudent(@PathVariable Integer id, @RequestBody StudentModel studentModel) {
        var updateStudent = studentService.updateNewStudent(id, studentModel);
        return ResponseEntity.ok(updateStudent);
    }

    @PatchMapping("{id}")
    public ResponseEntity<StudentModel> updatePartialSudent(@PathVariable Integer id, @RequestBody StudentModel studentModel) {

        return null;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable Integer id) throws Exception {
        studentService.removeStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
