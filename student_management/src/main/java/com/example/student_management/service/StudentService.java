package com.example.student_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student_management.entity.Student;
import com.example.student_management.exception.CityNotFound;
import com.example.student_management.exception.ContactNotFound;
import com.example.student_management.exception.DeptNotFound;
import com.example.student_management.exception.StudentNotFoundException;
import com.example.student_management.repository.StudentRepo;

@Service
public class StudentService {

	@Autowired
	public StudentRepo sturepo;

	// student creation
	public Student create(Student s) {
		return sturepo.save(s);
	}

	// Finding Student
	public Student getStuById(Long id) {
		return sturepo.findById(id).orElseThrow(()->new StudentNotFoundException("Student not found with id"+id));

	}

	public List<Student> getAll() {
		return sturepo.findAll();
	}

	public List<Student> getByName(String stuName) {
		return sturepo.findByStuName(stuName);
	}

	public Student getByContact(Long mobNumber) {
		return sturepo.findByMobNumber(mobNumber).orElseThrow(()->new ContactNotFound("contact "+mobNumber+" is not available"));
	}

	public List<Student> getBydept(String dept) {
		List<Student> students=sturepo.findByDept(dept);
		
		if(students.isEmpty()) {
			throw new DeptNotFound("Department"+dept+"not found");
		}
		
	     return students; 
	}

	public List<Student> getByCity(String city) {
		List location= sturepo.findByCity(city);
		
		if(location.isEmpty()) {
			throw new CityNotFound("City "+city+" not found");
		}
		return location;
	}

	// Deletion of data
	public String deleteById(Long id) {
		Student s = sturepo.findById(id).orElse(null);
		if (s != null) {
			sturepo.delete(s);
			return "data is deleted";
		}
		return "can't find the data";

	}

	// Updation of Data
	public String update(Long id, Student newstu) {
		Student exstu = sturepo.findById(id).orElse(null);
		if (exstu != null) {
			exstu.setStuName(newstu.getStuName());
			exstu.setCity(newstu.getCity());
			exstu.setDept(newstu.getDept());
			exstu.setMobNumber(newstu.getMobNumber());

			sturepo.save(exstu);
			return "data Updated Successfully";
		}
		return "data not updated";
	}

}
