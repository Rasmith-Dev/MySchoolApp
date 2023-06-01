package com.example.minischool.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tbl_course", uniqueConstraints = @UniqueConstraint(name = "title_unique", columnNames = "course_title"

))
public class Course {

	@Id
	@SequenceGenerator(name = "course_sequence", sequenceName = "course_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_sequence")
	private Long courseId;
	@Column(name = "course_title", nullable = false)
	private String title;
	@Column(name = "course_credit", nullable = false)
	private int credit;

	/*
	 * @OneToOne(mappedBy = "course") private CourseMaterial courseMaterial;
	 */

	// fetch = FetchType.LAZY this will not include course object in the result and
	// for this we need to add @ToString(exclude = "course")
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "course_id", referencedColumnName = "courseId")
	private CourseMaterial courseMaterial;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "teacher_Id", referencedColumnName = "teacherId")
	private Teacher teacher;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "student_course_map", joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "courseId"), inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "studentId"))
	private List<Student> students;

	public void addStudent(Student student) {
		if (students == null) {
			students = new ArrayList<>();
			students.add(student);
		}

	}

}
