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
import com.example.minischool.entity.Teacher;
import com.example.minischool.exceptionHandling.CourseNotFoundException;
import com.example.minischool.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@PostMapping("/course")
	public Course saveCourse(@Valid @RequestBody Course course) {
		return courseService.saveCourse(course);
	}
	
	@GetMapping("/courses")
	public List<Course> getAllCourses(){
		return courseService.findAllCourses();
	}
	
	@GetMapping("/course/{courseId}")
	public Course getCourseById(@Param(value = "courseId") Long courseId)throws CourseNotFoundException{
		return courseService.getCourseById(courseId);
		
	}
	
	@GetMapping("/course/{name}")
	public Course getCoursebyName(@Param(value = "name") String firstName) { 
		return courseService.getCoursebyName(firstName) ;
	}
	
	@GetMapping("/CourseTitles/{title}/{num}")
	public Page getCourseTitleContains(@Param(value = "title") String title, @Param(value = "title") int pageNumber) {
		return courseService.getCourseTitleContains(title, pageNumber);
	}
	
	@PutMapping("/course/{id}")
	public Course updateCourseById(@PathVariable("id") Long courseId,
			@Valid @RequestBody Course course) {
		return courseService.updateCourseById(courseId, course);

	}

	@DeleteMapping("/course/{id}")
	public String deleteCourseById(@PathVariable("id") Long courseId) {
		return courseService.deleteCourseById(courseId);
	}
}
