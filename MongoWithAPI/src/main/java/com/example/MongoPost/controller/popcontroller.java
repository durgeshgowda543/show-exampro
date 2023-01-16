package com.example.MongoPost.controller;

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

import com.example.MongoPost.Model.People;
import com.example.MongoPost.Repository.Ruppu;

@RestController
public class popcontroller {
	@Autowired
	
	Ruppu repo;

	@PostMapping("/addpp")
	public String addpp(@RequestBody People pp) {
		repo.save(pp);
		return "record inserted :"+pp.getId();
	}
	@GetMapping("/display")
	public List<People> display(){
		return repo.findAll();
	}
	@GetMapping("/search/{id}")
	public Optional<People> display(@PathVariable int id){
		return repo.findById(id);
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id){
		repo.deleteById(id);
		return "record deleted :"+id;	
	}
	@RequestMapping("/update/{id}")
	public String update(@RequestBody People pp) {
		People exist=repo.findById(pp.getId()).get();
		repo.save(pp);
		return "updated :"+pp.getId();
		
	}
}




















