package com.example.minischool.service;

import java.util.List;

import javax.validation.Valid;

import com.example.minischool.entity.Teacher;
import com.example.minischool.exceptionHandling.TeacherNotFoundException;

public interface TeacherService {

	public Teacher saveTeacher(@Valid Teacher teacher);
	
	public List<Teacher> getAllTeachers();

	public String deleteTeacherById(Long teacherId);
	public Teacher updateTeacherById(Long teacherId, @Valid Teacher teacher);

	public List<Teacher> getTeacherByName(String teacherName);

	public Teacher getTeacherById(Long teacherId)throws TeacherNotFoundException;

	; 

}
