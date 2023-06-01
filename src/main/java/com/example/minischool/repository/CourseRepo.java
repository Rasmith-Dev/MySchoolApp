package com.example.minischool.repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.minischool.entity.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {

	Page<Course> findByTitleContaining(String title, PageRequest p);
	
	Course findByTitle(String title);
}
