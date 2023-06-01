package com.example.minischool.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@AttributeOverride(name = "name", column = @Column(name = "guardian_name"))
@AttributeOverride(name = "email", column = @Column(name = "guardian_email"))
@AttributeOverride(name = "mobileNo", column = @Column(name = "guardian_mobileNo"))
public class Guardian {

	private String name;
	private String email;
	private Long mobileNo;

}
