package com.example.minischool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.minischool.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

	public List<Student> findByFirstName(String name);

	public List<Student> findByFirstNameContaining(String name);

	// this feature is not yet needed so commenting the below line of code
	// public List<Student> findByLastNameNotNull();

	public List<Student> findByGuardianName(String name);

	// jpql
	@Query("select s.firstName from Student s where s.emailId = ?1")
	public String getStudentFirstNameByEmailAddress(String name);

	// sql // youtuber query @Query(value = "select s.first_name from tbl_student s
	// where s.email_address = ?1", or the below one is working fine
	@Query(value = "select first_name from tbl_student where email_address = ?1", nativeQuery = true)
	public String getStudentFirstNameByEmailAddressNative(String name);

	@Query(value = "select first_name from tbl_student where email_address= :emailId", nativeQuery = true)
	public String getStudentFirstNameByEmailAddressNativewithParam(@Param("emailId") String name);

	@Modifying
	@Transactional
	@Query(value = "update tbl_student set first_name = :firstName where email_address = :emailId", nativeQuery = true)
	public void updateNameByEmailId(@Param("firstName") String firstName, @Param("emailId") String emailId);

	public Student findByEmail(String email);
}
