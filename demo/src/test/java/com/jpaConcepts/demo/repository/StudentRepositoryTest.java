package com.jpaConcepts.demo.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.jpaConcepts.demo.entity.Guardian;
import com.jpaConcepts.demo.entity.Student;

@SpringBootTest
class StudentRepositoryTest {
	
	@Autowired
	StudentRepository studentRepository;
	
	//@Test
	void saveStudent() {
		var student = Student.builder()
				.firstName("Vikram")
				.lastName("Dhoke")
				.emailId("vik@gmaill.com")
//				.guardian.s("APPU")
//				.guardianEmail("appu@gmail.com")
//				.guardianMobile("8291999666")
				.build();
		studentRepository.save(student);
	}
	
	//@Test
	void saveStudentWithGuardian() {
		var guardian = Guardian.builder()
				.name("Nik")
				.email("n@gmail.com")
				.mobile("299299999")
				.build();
		
		var student = Student.builder()
				.firstName("Mayur")
				.lastName("Meshram")
				.emailId("mdm@meshram1.com")
				.guardian(guardian)
				.build();
		studentRepository.save(student);
	}
	
	//@Test
	void findByStudentName() {
		var student = studentRepository.findByFirstName("Mayur");
		System.out.println(student);
	}
	
	//@Test
	void findByStudentEmail() {
		var student = studentRepository.getStudentyByEmailId("vik@gmail.com");
		System.out.println(student);
	}
	
	//@Test
	void findByStudentEmailNative() {
		var student = studentRepository.getStudentyByEmailIdNative("vik@gmail.com");
		System.out.println(student);
	}
	
	
	//@Test
	void findByStudentEmailNativeNamedParam() {
		var student = studentRepository.getStudentyByEmailIdNativeNamedParam("vik@gmail.com");
		System.out.println(student);
	}
	
	@Test
	void updateStudentEmailId() {
		var value = studentRepository.updateStudentEmailId("vikram714@gmail.com", "Vikram");
		System.out.println(value);
	}

}
