package com.jpaConcepts.demo.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpaConcepts.demo.entity.Course;
import com.jpaConcepts.demo.entity.Teacher;

@SpringBootTest
class TeacherRepositoryTest {
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	//@Test
	void saveTeacher() {
		var course = Course.builder()
				.credit(7)
				.title("DBA")
				.build();
		var course1 = Course.builder()
				.credit(9)
				.title("MP")
				.build();
		
//		var teacher = Teacher.builder()
//				.firstName("meou")
//				.lastName("bow")
//				.listOfCourses(List.of(course, course1))
//				.build();
//		
//		var result = teacherRepository.save(teacher);
//		
		//System.out.println("RESULT: " + result);
	}

}
