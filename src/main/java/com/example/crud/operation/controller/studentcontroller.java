package com.example.crud.operation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.operation.entity.student;
import com.example.crud.operation.repository.studentrepository;

@RestController
public class studentcontroller {
     
	@Autowired
	studentrepository repo;
	//get all the students
	//localhost:8080/students
	@GetMapping("/students")
	public List<student> getAllStudents(){
		List<student>  students=repo.findAll();
		return students;
	}
	
	//localhost:8080/students/1 or 2
	@GetMapping("/students/{id}")
	public student getStudent(@PathVariable int id){
		student  studentss=repo.findById(id).get();
		return studentss;
	}
	
	////localhost:8080/students/add
	@PostMapping("/students/add")
	@ResponseStatus(code=HttpStatus.CREATED)//this way we can the httpstatus in postman instead 200 this display 20
	public void createstudent(@RequestBody student studentt){
		 repo.save(studentt);
		
	}
	//localhost:8080/students/1 or 2
	@PutMapping("/students/update/{id}")
	public student UpdateStudent(@PathVariable int id){
		student  studentt=repo.findById(id).get(); 
		studentt.setName("anu");  //studentt is table name
		studentt.setPercentage(95);
		repo.save(studentt);
		return studentt;
	}
	
	@DeleteMapping("/students/delete/{id}")
	public void removeStudent(@PathVariable int id){
		student  studentt=repo.findById(id).get();
		repo.delete(studentt);
	
}}

