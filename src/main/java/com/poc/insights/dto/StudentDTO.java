package com.poc.insights.dto;

import com.poc.insights.domain.Student;

public record StudentDTO (
		long id,
		String name) {



	public static StudentDTO fromDomain(Student student) {
		return new StudentDTO(
				student.getId(),
				student.getName()
				);
	}

}



