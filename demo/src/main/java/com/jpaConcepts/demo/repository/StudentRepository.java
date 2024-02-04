package com.jpaConcepts.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpaConcepts.demo.entity.Student;
import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	public Student findByFirstName(String firstName);
	
	//JPQL
	@Query("SELECT s FROM Student s WHERE s.emailId = ?1")
	public Student getStudentyByEmailId(String emailId);
	
	//NativeQuery
	@Query(
			value = "SELECT * FROM tbl_student s WHERE s.email_address = ?1",
			nativeQuery = true
			)
	public Student getStudentyByEmailIdNative(String emailId);
	
	//NativeQueryWithNamedParam
	@Query(
			value = "SELECT * FROM tbl_student s WHERE s.email_address = :emailId",
			nativeQuery = true
			)
	public Student getStudentyByEmailIdNativeNamedParam(@Param("emailId") String emailId);
	
	//NativeQueryWithModifyingAndTransactional
	@Modifying
	@Transactional
	@Query(
			value = "Update tbl_student s set s.email_address = ?1 where s.first_name = ?2",
			nativeQuery = true
			)
	public int updateStudentEmailId(String emailid, String firstName);
}
