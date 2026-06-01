package com.example.student_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.student_management.entity.Student;
import com.example.student_management.service.StudentService;


@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	private StudentService stuserv;

	@PostMapping("/save")
	public Student createStudent(@RequestBody Student s) {
		return stuserv.create(s);
	}

	@GetMapping("/getById/{id}")
	public Student getById(@PathVariable Long id) {
		return stuserv.getStuById(id);
	}

	@GetMapping("/getall")
	public List<Student> getAll() {
		return stuserv.getAll();
	}
	
	@GetMapping("/getByName")
	public List<Student> getByName(@RequestParam String stuName) {
		return stuserv.getByName(stuName);
	}
	
	@GetMapping("/getByContact")
	public Student getByMobile(@RequestParam Long mobNumber) {
		return stuserv.getByContact(mobNumber);
	}
	
	@GetMapping("/getByDept")
	public List<Student> getByDept(@RequestParam String dept) {
		return stuserv.getBydept(dept);
	}
	
	@GetMapping("/getByCity")
	public List<Student> getByCity(@RequestParam String city){
		return stuserv.getByCity(city);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public String deleteById(@PathVariable Long id) {
		return stuserv.deleteById(id);
	}
	
	@PutMapping("/update")
	public String Update(@RequestParam Long id, @RequestBody Student newstu) {
		return stuserv.update(id, newstu);
	}

}
