package com.nuistindo.UniversitySystem.repository;

import com.nuistindo.UniversitySystem.model.EnrollmentsModel;
import com.nuistindo.UniversitySystem.model.StudentsModel;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EnrollmentsRepository extends JpaRepository<EnrollmentsModel, Integer> {

	//int countByStudentId(String student_id);
	@Query("SELECT COUNT(e) FROM EnrollmentsModel e WHERE e.student_id = :studentId")
	int countEnrollmentsByStudentId(@Param("studentId") String studentId);

}
