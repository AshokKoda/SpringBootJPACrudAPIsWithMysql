package com.ashok.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.ashok.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
