package com.example.minischool.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.minischool.entity.Student;
import com.example.minischool.exceptionHandling.StudentNotFoundException;
import com.example.minischool.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentRepo;

	@Override
	public Student saveStudent(@Valid Student student) {
		studentRepo.save(student);
		return student;
	}

	@Override
	public List<Student> findAllStudents() {
		return studentRepo.findAll();
	}

	@Override
	public Student getStudentById(Long studentId) throws StudentNotFoundException {
		Optional<Student> s = studentRepo.findById(studentId);
		if (!s.isPresent()) {
			throw new StudentNotFoundException("Student with StudentId: " + studentId + " does not exist");
		}
		return s.get();
	}

	public List<Student> getStudentbyName(String firstName) {
		return studentRepo.findByFirstName(firstName);
	}

	@Override
	public Student updateStudentById(Long studentId, @Valid Student student) {
		Student studentDb = studentRepo.findById(studentId).get();
		if (Objects.nonNull(student.getFirstName()) && !"".equals(student.getFirstName())
				&& !(student.getFirstName()).equals(studentDb.getFirstName())) {
			studentDb.setFirstName(student.getFirstName());
		}
		if (Objects.nonNull(student.getLastName()) && !"".equals(student.getLastName())
				&& !(student.getLastName()).equals(studentDb.getLastName())) {
			studentDb.setLastName(student.getLastName());
		}
		if (Objects.nonNull(student.getEmailId()) && !"".equals(student.getEmailId())
				&& !(student.getEmailId()).equals(studentDb.getEmailId())) {
			studentDb.setEmailId(student.getEmailId());
		}
		if (Objects.nonNull(student.getGuardian())) {
			studentDb.setGuardian(student.getGuardian());
		}
		return studentRepo.save(studentDb);
	}

	public String deleteStudentById(Long studentId) {
		if (studentRepo.existsById(studentId)) {
			studentRepo.deleteById(studentId);
			return "Successfully deleted";
		} else
			return "Sorry, You have provided a wrong ID. there is no record found with studentId: " + studentId
					+ ". Please check the ID and try again";
	}

	public List<Student> getStudentbyNameContaining(String string) {
		return studentRepo.findByFirstNameContaining(string);
	}

	@Override
	public List<Student> getStudentByGuardianName(String guardianName) {
		return studentRepo.findByGuardianName(guardianName);
	}

	@Override
	public String getStudentFirstNameByEmailAddress(String email) {
		return studentRepo.getStudentFirstNameByEmailAddress(email);
	}

	@Override
	public Student updateNameByEmailId(String sName, String email) {
		 studentRepo.updateNameByEmailId(sName, email);
		 return studentRepo.findByEmail(email);
	}

	
}
