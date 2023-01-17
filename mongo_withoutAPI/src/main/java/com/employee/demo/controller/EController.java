package com.employee.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.employee.demo.model.EModel;
import com.employee.demo.repository.ERepo;

@Controller
public class EController {
	@Autowired
	ERepo erepo;
	
	@RequestMapping("index")
	public String index()
	{
		return "index.jsp";
	}
	
	@RequestMapping("addEmp")
	public String addEmp(EModel emodel)
	{
		erepo.save(emodel);
		return "index.jsp";
	}
	
	@RequestMapping("getEmp")
	public ModelAndView getEmp(@RequestParam int id)
	{
		ModelAndView mv = new ModelAndView("display.jsp");
		EModel emodel = erepo.findById(id).orElse(new EModel());
		mv.addObject(emodel);
		return mv;
	}
	
	@RequestMapping("updEmp")
	public ModelAndView updEmp(EModel emodel)
	{
		ModelAndView mv = new ModelAndView("update.jsp");
		emodel = erepo.findById(emodel.getId()).orElse(new EModel());
		mv.addObject(emodel);
		return mv;
	}
	
	@RequestMapping("delEmp")
	public ModelAndView delEmp(@RequestParam int id)
	{
		ModelAndView mv = new ModelAndView("delete.jsp");
		EModel emodel = erepo.findById(id).orElse(new EModel());
		erepo.deleteById(id);
		mv.addObject(emodel);
		return mv;
	}
	
	
	
	
	
	
	
	
	
	
}
