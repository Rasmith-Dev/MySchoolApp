package com.example.minischool.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;

import com.example.minischool.entity.Course;
import com.example.minischool.entity.Teacher;
import com.example.minischool.exceptionHandling.CourseNotFoundException;

public interface CourseService {

	public List<Course> findAllCourses();

	public Course saveCourse(@Valid Course course);

	public Course getCourseById(Long courseId) throws CourseNotFoundException;

	public Course getCoursebyName(String title);

	public Course updateCourseById(Long courseId, @Valid Course course);

	public String deleteCourseById(Long courseId);

	public Page getCourseTitleContains(String title, int pageNumber);
	
	
}
