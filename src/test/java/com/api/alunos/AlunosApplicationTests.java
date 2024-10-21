package com.api.alunos;

import com.api.alunos.controlles.StudentController;
import com.api.alunos.models.StudentModel;
import com.api.alunos.repositories.StudentRepository;
import com.api.alunos.services.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class AlunosApplicationTests {
	@Autowired
	private StudentService service;

	private StudentRepository studentRepository;

	@BeforeEach
	void setup() {
		service = new StudentService();
		service.create(new StudentModel(1, "Rodrigo", "Weber", "rodrigo@teste.com", 123546, 321123));
		service.create(new StudentModel(2, "Amanda", "Kunzler", "amanda@teste.com", 123654, 654489));
	}

	@Test
	void checkAllStudents() {
		List<StudentModel> listWaitStudent = new ArrayList<>();
		listWaitStudent.add(new StudentModel(1, "Rodrigo", "Weber", "rodrigo@teste.com", 123546, 321123));
		listWaitStudent.add(new StudentModel(2, "Amanda", "Kunzler", "amanda@teste.com", 123654, 654489));

		List<StudentModel> getStudents = service.findAll();

		// Checks that the size of the student list is equal to the expected list
		Assertions.assertEquals(listWaitStudent.size(), getStudents.size());

		// Checks that the list obtained contains all the expected students
		Assertions.assertEquals(listWaitStudent, getStudents);
	}


}
