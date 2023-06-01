package com.example.minischool.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.minischool.entity.Teacher;
import com.example.minischool.exceptionHandling.TeacherNotFoundException;
import com.example.minischool.repository.TeacherRepo;

@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private TeacherRepo teacherRepo;

	@Override
	public Teacher saveTeacher(@Valid Teacher teacher) {
		teacherRepo.save(teacher);
		return teacher;
	}

	@Override
	public List<Teacher> getAllTeachers() {
		return teacherRepo.findAll();
	}

	@Override
	public List<Teacher> getTeacherByName(String firstName) {
		List<Teacher> t = teacherRepo.findByFirstName(firstName);
		return t;
	}

	@Override
	public Teacher getTeacherById(Long teacherId) throws TeacherNotFoundException{
		Optional<Teacher> t = teacherRepo.findById(teacherId);
		if(!t.isPresent()) {
			throw new TeacherNotFoundException("Teacher with ID: " + teacherId + " is not found!!");
		}
		return t.get();
	}
	
	@Override
	public Teacher updateTeacherById(Long teacherId, @Valid Teacher teacher) {
		Teacher teacherDb = teacherRepo.findById(teacherId).get();
		if(Objects.nonNull(teacher.getFirstName()) && !"".equals(teacher.getFirstName()) && !(teacher.getFirstName()).equals(teacherDb.getFirstName())){
			teacherDb.setFirstName(teacher.getFirstName());
		}
		if(Objects.nonNull(teacher.getLastName()) && !"".equals(teacher.getLastName()) && (teacher.getLastName()).equals(teacherDb.getLastName())) {
			teacherDb.setLastName(teacher.getLastName());
		}
		return teacherRepo.save(teacherDb);
	}
	
	@Override
	public String deleteTeacherById(Long teacherId) {
		if(teacherRepo.existsById(teacherId)) {
			teacherRepo.deleteById(teacherId);
			return "Successfully deleted";
		}else 
		return "Sorry, You have provided a wrong ID. there is no record found with ID: " + teacherId + ". Please check the ID and try again";
	}



	

}
