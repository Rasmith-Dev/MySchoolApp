package com.example.minischool.service;

import java.util.List;

import javax.validation.Valid;

import com.example.minischool.entity.Student;
import com.example.minischool.exceptionHandling.StudentNotFoundException;

public interface StudentService {

	Student saveStudent(@Valid Student student);

	List<Student> findAllStudents();

	Student getStudentById(Long studentId) throws StudentNotFoundException;

	List<Student> getStudentbyName(String firstName);

	Student updateStudentById(Long studentId, @Valid Student student);

	String deleteStudentById(Long studentId);

	List<Student> getStudentbyNameContaining(String string);

	List<Student> getStudentByGuardianName(String guardianName);

	String getStudentFirstNameByEmailAddress(String email);

	Student updateNameByEmailId(String sName,String email);

}
