package com.example.minischool.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.minischool.entity.Course;
import com.example.minischool.entity.CourseMaterial;
import com.example.minischool.entity.Guardian;
import com.example.minischool.entity.Student;
import com.example.minischool.entity.Teacher;
import com.example.minischool.exceptionHandling.CourseNotFoundException;
import com.example.minischool.repository.CourseRepo;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseRepo courseRepo;
	

	public Course saveCourse(@Valid Course course) {
		courseRepo.save(course);
		return course;
	}
	
	public List<Course> findAllCourses() {
		List<Course> list = courseRepo.findAll();
        return list;
	}

	public Course getCourseById(Long courseId) throws CourseNotFoundException {
		Optional<Course> c = courseRepo.findById(courseId);
		if(!c.isPresent()) {
			throw new CourseNotFoundException("Sorry, You have provided a wrong ID. there is no record found with ID: "+ courseId +". Please check the ID and try again");
		}
		return c.get();
	}


	public Course getCoursebyName(String title) {
		return courseRepo.findByTitle(title);
	}

	public Course updateCourseById(Long courseId, @Valid Course course) {
		Course courseDb = courseRepo.findById(courseId).get();
		if(Objects.nonNull(course.getTitle()) && !"".equals(course.getTitle()) && !(course.getTitle()).equals(courseDb.getTitle())){
			courseDb.setTitle(course.getTitle());
		}
		if(Objects.nonNull(course.getCredit()) && !"".equals(course.getCredit()) && (course.getCredit() != courseDb.getCredit())){
			courseDb.setCredit(course.getCredit());
		}
		return courseRepo.save(courseDb);
	}

	public String deleteCourseById(Long courseId) {
		if(courseRepo.existsById(courseId)) {
			courseRepo.deleteById(courseId);
			return "Successfully deleted";
		}else 
		return "Sorry, You have provided a wrong ID. there is no record found with ID: " + courseId + ". Please check the ID and try again";
	}

	@Override
	public Page getCourseTitleContains(String title, int pageNumber) {
		
		return courseRepo.findByTitleContaining(title, PageRequest.ofSize(pageNumber));
	}

}
