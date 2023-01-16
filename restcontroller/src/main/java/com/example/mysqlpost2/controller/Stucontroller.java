package com.example.mysqlpost2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mysqlpost2.Model.Student;
import com.example.mysqlpost2.Repository.Reppo;

@RestController

public class Stucontroller {
	@Autowired
	
	Reppo repo;
	
	@PostMapping("/addstu")
	public String addstu(@RequestBody Student stu) {
		repo.save(stu);
		return "record inserded"+stu.getId();
	}
	@GetMapping("/display")
	public List<Student> display(){
		return (List<Student>) repo.findAll();
	}
	@GetMapping("/search/{id}")
	public Optional<Student> display(@PathVariable int id){
		return repo.findById(id);
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		repo.deleteById(id);
		return "record deleted :" +id;
	}
	@RequestMapping("update/{id}")
	public String update(@RequestBody Student stu) {
		Student exist=repo.findById(stu.getId()).get();
		exist.setName(stu.getName());
		repo.save(exist);
		return "updated :"+stu.getId();
	}
	
}















