package com.ashok.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashok.model.Student;
import com.ashok.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepo;

	// Create/Update
	public void saveStudent(Student student) {
		studentRepo.save(student);
	}

	// Read
	public List<Student> listStudents() {
		return (List<Student>) studentRepo.findAll();
	}
	
	public Student get(Long id) {
        return studentRepo.findById(id).get();
    }
	
	//Delete
	public void delete(Long id) {
		studentRepo.deleteById(id);
    }
}
