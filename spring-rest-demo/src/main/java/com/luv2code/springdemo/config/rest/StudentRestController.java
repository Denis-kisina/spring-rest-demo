package com.luv2code.springdemo.config.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.config.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> theStudents;

//	define @Postconstruct to load student data once

	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<>();

		theStudents.add(new Student("Denis", "Kisina"));
		theStudents.add(new Student("Ben", "Obbo"));
		theStudents.add(new Student("David", "Clark"));
	}

	@GetMapping("/students")
	public List<Student> getStudents() {

		return theStudents;

	}

//	define end point for "/student/{studentId}" - return student at index

	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {

		if ((studentId > theStudents.size()) || (studentId < 0)) {
			throw new StudentNotFoundException("Student ID not found - " + studentId);
		}

		return theStudents.get(studentId);

	}

}
