package com.example.student_management.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.student_management.entity.Student;

public interface StudentRepo extends JpaRepository<Student,Long>{
	
	List<Student> findByStuName(String stuName);
	Optional<Student> findByMobNumber(Long mobNumber);
	List<Student> findByDept(String dept);
	List<Student> findByCity(String city);

}
