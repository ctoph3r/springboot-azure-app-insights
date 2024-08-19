package com.poc.insights.service;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.javafaker.Faker;
import com.poc.insights.domain.Student;
import com.poc.insights.dto.StudentDTO;
import com.poc.insights.repository.StudentRepository;

import jakarta.transaction.Transactional;

@RestController
@Service
public class StudentService {


	@Autowired
	private StudentRepository studentRepository;


	@GetMapping("/student")
	@Transactional
	public StudentDTO getStudent(@RequestParam long id) {
		return  StudentDTO.fromDomain(studentRepository.getReferenceById(id));
	}

	@GetMapping("/students")
	@Transactional
	public List<StudentDTO> getStudents() {
		return  studentRepository.findAll().stream().map(StudentDTO::fromDomain).toList();
	}
	
	
	
	@PostMapping("/student")
	public StudentDTO saveStudent(@RequestBody Student student) {
		return  StudentDTO.fromDomain(studentRepository.save(student));
	}

	
	@GetMapping("/student/generate")
	@Transactional
	public List<StudentDTO> generateStudents(@RequestParam int number) {
	    Faker ukFaker = new Faker(new Locale("en-GB"));
		for(int i=0;i<number;i++) {
			Student student = new Student();
			student.setName(ukFaker.name().fullName());
			studentRepository.save(student);
		}
		return  studentRepository.findAll().stream().map(StudentDTO::fromDomain).toList();
	}


} 