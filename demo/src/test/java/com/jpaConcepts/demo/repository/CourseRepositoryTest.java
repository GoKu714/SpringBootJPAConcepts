package com.jpaConcepts.demo.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.print.attribute.standard.PageRanges;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.jpaConcepts.demo.entity.Course;
import com.jpaConcepts.demo.entity.Student;
import com.jpaConcepts.demo.entity.Teacher;

@SpringBootTest
class CourseRepositoryTest {
	@Autowired
	private CourseRepository courseRepository;
	
	//@Test
	void getCourses() {
		var courses = courseRepository.findAll();
		System.out.println(courses);
	}
	
	//@Test
	void saveCourseWithTeacher() {
		
		var teacher = Teacher.builder()
				.firstName("Boku1d")
				.lastName("Mahasha1y")
				.build();
		var course = Course.builder()
				.credit(15)
				.title("JAVA1")
				.teacher(teacher)
				.build();
		var result = courseRepository.save(course);
		System.out.println("RESULT : " + result);
	}
	
	
	//@Test
	void getNumberOfPages() {
		//We are saying that one page is made of 3 records and we are getting 0th index page so it will return 1st three
		//records
		Pageable courseRowsWithThreeRecords = PageRequest.of(0, 3);
		
		//We are saying that one page is made of 2 records and we are getting 1st index page so it will return 3rs and 4th
		//record
		Pageable courseRowsWithTowRecords = PageRequest.of(1, 2);
		
		var threeRecords = courseRepository.findAll(courseRowsWithThreeRecords).getContent();
		var twoRecords = courseRepository.findAll(courseRowsWithTowRecords).getContent();
		
		System.out.println("THREEE RECORDS : " + threeRecords);
		System.out.println("TWO RECORDS : " + twoRecords);
	}
	
	//@Test
	void findAllWithSorting() {
		var findCourseSortedByTitle = PageRequest.of(0, 2, Sort.by("title"));
		var findCourseSortedByTitleDesceding = PageRequest.of(0, 2, Sort.by("title").descending());
		var findCourseSortedByTitleAndCreditDescending = PageRequest.of(0, 2, Sort.by("title").descending().and(Sort.by("credit")));
		var twoRecords = courseRepository.findAll(findCourseSortedByTitle).getContent();
		System.out.println("TWO SORTED RECORDS : " + twoRecords);
	}
	
	
	//@Test
	void findByTitleContaining() {
		Pageable p = PageRequest.of(0, 10);
		var courses = courseRepository.findByTitleContaining("D", p).getContent();
		System.out.println("COURSESS : " + courses);
	}
	
	@Test
	void addCourseWithStudentsAndTeacher() {
		var student1 = Student.builder()
				.firstName("Goku")
				.lastName("Saiyan")
				.emailId("goku.saiyan@gmail.com")
				.build();
		var student2 = Student.builder()
				.firstName("Vegeta")
				.lastName("Saiyajin")
				.emailId("vegeta.saiyajin@gmail.com")
				.build();
		
		var teacher = Teacher.builder()
				.firstName("Whis")
				.lastName("DK")
				.build();
		
		var course = Course.builder()
				.credit(100)
				.title("SSG")
				.students(List.of(student1, student2))
				.teacher(teacher)
				.build();
		
		var result = courseRepository.save(course);
		System.out.println("RESULTT : " + result);
	}
}
