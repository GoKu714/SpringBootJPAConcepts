package com.jpaConcepts.demo.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpaConcepts.demo.entity.Course;
import com.jpaConcepts.demo.entity.CourseMaterial;

@SpringBootTest
class CourseMaterialRepositoryTest {
	
	@Autowired
	private CourseMaterialRepository repository;

	@Test
	void saveCourseMaterial() {

		var course = Course.builder()
		.title("JAVA")
		.credit(6)
		.build();
		
		var courseMaterial = CourseMaterial.builder()
				.url("www.moogle.com")
				//.course(course)
				.build();
		
		var result = repository.save(courseMaterial);
		System.out.println("RESULTT : " + result);
	}
	
	//@Test
	void getListOfCourseMaterial() {

		var courseMaterialList = repository.findAll();
		System.out.println("RESULTT : " + courseMaterialList);
	}

}
