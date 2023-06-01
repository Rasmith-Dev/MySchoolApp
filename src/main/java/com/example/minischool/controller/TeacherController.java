package com.example.minischool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import  javax.validation.Valid;

import com.example.minischool.entity.Teacher;
import com.example.minischool.exceptionHandling.TeacherNotFoundException;
import com.example.minischool.service.TeacherService;

@RestController
public class TeacherController {

	@Autowired
	private TeacherService teacherService;
	
	@PostMapping("/teacher")
	public Teacher addTeacher(@Valid @RequestBody Teacher teacher) {
		return teacherService.saveTeacher(teacher);
	}

	@GetMapping("/teacher")
	public List<Teacher> getAllTeachers() {
		return teacherService.getAllTeachers();
	}

	@GetMapping("/teacher/{id}")
	public Teacher getTeacherById(@PathVariable("id") Long teacherId) throws TeacherNotFoundException {
		return teacherService.getTeacherById(teacherId);
	}

	@GetMapping("/teacher/{name}")
	public List<Teacher> getTeacherByName(@PathVariable("name") String teacherName) {
		return teacherService.getTeacherByName(teacherName);
	}

	@PutMapping("/teacher/{id}")
	public Teacher updateDepartmentById(@PathVariable("id") Long teacherId,
			@Valid @RequestBody Teacher teacher) {
		return teacherService.updateTeacherById(teacherId, teacher);

	}

	@DeleteMapping("/teacher/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long teacherId) {
		return teacherService.deleteTeacherById(teacherId);
	}
}
