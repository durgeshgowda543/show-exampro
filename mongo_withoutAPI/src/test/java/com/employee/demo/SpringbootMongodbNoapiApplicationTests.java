package com.employee.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.employee.demo.model.EModel;
import com.employee.demo.repository.ERepo;

@SpringBootTest
class SpringbootMongodbNoapiApplicationTests {
	@Autowired
	ERepo erepo;
	
	@Test
	public void createEmp()
	{
		EModel em = new EModel();
		em.setId(2);
		em.setName("second one");
		erepo.save(em);
	}
	
	@Test
	public void readAll()
	{
		Iterable<EModel> em = erepo.findAll();
	}
	
	@Test
	public void deleteRec()
	{
		erepo.deleteById(100);
	}
	
	@Test
	public void update()
	{
		EModel em = erepo.findById(102).get();
		em.setName("nomad");
		erepo.save(em);
	}
	
	
	
	
	
	
	
	
	
	
	

}
