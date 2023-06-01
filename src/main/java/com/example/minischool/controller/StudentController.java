package com.example.minischool.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.minischool.entity.Course;
import com.example.minischool.entity.Student;
import com.example.minischool.exceptionHandling.CourseNotFoundException;
import com.example.minischool.exceptionHandling.StudentNotFoundException;
import com.example.minischool.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/student")
	public Student saveStudent(@Valid @RequestBody Student student) {
		return studentService.saveStudent(student);
	}
	
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		return studentService.findAllStudents();
	}
	
	@GetMapping("/student/{studentId}")
	public Student Student(@Param(value = "studentId") Long studentId)throws StudentNotFoundException{
		return studentService.getStudentById(studentId);
		
	}
	
	@GetMapping("/student/{name}")
	public List<Student> getStudentbyName(@Param(value = "name") String firstName) { 
		return studentService.getStudentbyName(firstName) ;
	}
	
	@GetMapping("/student/{name}")
	public List<Student> getStudentbyNameContaining(@Param(value = "name") String string) { 
		return studentService.getStudentbyNameContaining(string) ;
	}
	
	@GetMapping("/student/{name}")
	public List<Student> getStudentByGuardianName(@Param(value = "name") String guardianName) { 
		return studentService.getStudentByGuardianName(guardianName) ;
	}
	
	@GetMapping("/student/{email}")
	public String getStudentFirstNameByEmailAddress(@Param(value = "email") String email) { 
		return studentService.getStudentFirstNameByEmailAddress(email) ;
	}
	
	@PutMapping("/student/{id}")
	public Student updateStudentById(@PathVariable("id") Long studentId,
			@Valid @RequestBody Student student) {
		return studentService.updateStudentById(studentId, student);

	}

	@PutMapping("/student/{firstName}/{email}")
	public Student updateStudentById(@PathVariable("firstName") String firstName,
			@PathVariable String email) {
		return studentService.updateNameByEmailId(firstName, email);

	}
	
	@DeleteMapping("/student/{id}")
	public String deleteStudentById(@PathVariable("id") Long studentId) {
		return studentService.deleteStudentById(studentId);
	}
}
