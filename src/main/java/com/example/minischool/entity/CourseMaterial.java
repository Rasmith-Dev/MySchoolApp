package com.example.minischool.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
//@ToString(exclude = "course")
@Table(name = "tbl_course_material", uniqueConstraints = @UniqueConstraint(name = "url_unique", columnNames = "course_Material_url"

))
@AttributeOverride(name = "id", column = @Column(name = "course_Material_id"))
@AttributeOverride(name = "url", column = @Column(name = "course_Material_url", nullable = false))
public class CourseMaterial {

	@Id
	@SequenceGenerator(name = "courseMaterial_sequence", sequenceName = "courseMaterial_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "courseMaterial_sequence")
	private Long id;
	private String url;

	/*
	 * @OneToOne(cascade = CascadeType.ALL, //fetch = FetchType.LAZY this will not
	 * include course object in the result and for this we need to
	 * add @ToString(exclude = "course") fetch = FetchType.EAGER, optional = false )
	 * 
	 * @JoinColumn( name = "course_id", referencedColumnName = "courseId" ) private
	 * Course course;
	 */

}
