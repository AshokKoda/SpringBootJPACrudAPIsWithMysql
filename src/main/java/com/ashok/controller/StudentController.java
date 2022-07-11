package com.ashok.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashok.model.Student;
import com.ashok.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/saveStudent")
	public void save(@RequestBody Student student) {
		studentService.saveStudent(student);
	}
	
	@GetMapping("/getList")
	public List<Student> getAllStudents(){
		return studentService.listStudents();
	}
	
	@GetMapping("/getList/{id}")
	public ResponseEntity<Student> get(@PathVariable Long id) {
	    try {
	    	Student student = studentService.get(id);
	        return new ResponseEntity<Student>(student, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@PutMapping("/updateStudent")
	public ResponseEntity<?> update(@RequestBody Student student) {
	    try {
	    	studentService.saveStudent(student);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public void delete(@PathVariable Long id) {
		studentService.delete(id);
	}
}
