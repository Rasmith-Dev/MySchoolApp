package com.example.minischool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.minischool.entity.CourseMaterial;

@Repository
public interface CourseMaterialRepo extends JpaRepository<CourseMaterial, Long> {

}
