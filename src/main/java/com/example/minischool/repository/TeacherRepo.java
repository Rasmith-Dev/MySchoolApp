package com.example.minischool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.minischool.entity.Teacher;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long> {

	public List<Teacher> findByFirstName(String firstName);
}
