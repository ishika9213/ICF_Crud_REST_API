package com.howtodoinjava.demo.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.howtodoinjava.demo.exception.RecordNotFoundException;
import com.howtodoinjava.demo.model.DependantsEntity;
import com.howtodoinjava.demo.service.DependantsService;

@Controller
@RequestMapping("/")
public class DependantsMvcController 
{
	@Autowired
	DependantsService service;

	@RequestMapping(path = {"/dependants"})
	public String getAllDependants(Model model) 
	{
		List<DependantsEntity> list = service.getAllDependants();

		model.addAttribute("dependants", list);
		return "list-dependants";
	}

	@RequestMapping(path = {"/editDependants", "/editDependants/{id}"})
	public String editDependantsByEmpId(Model model, @PathVariable("id") Optional<Long> id) 
							throws RecordNotFoundException 
	{
		if (id.isPresent()) {
			DependantsEntity entity = service.getDependantsByEmpId(id.get());
			model.addAttribute("dependants", entity);
		} else {
			model.addAttribute("dependants", new DependantsEntity());
		}
		return "add-edit-dependants";
	}
	
	@RequestMapping(path = "/dependants/delete/{id}")
	public String deleteDependantsByEmpId(Model model, @PathVariable("id") Long id) 
							throws RecordNotFoundException 
	{
		service.deleteDependantsById(id);
		return "redirect:/";
	}

	@RequestMapping(path = "/createDependnats", method = RequestMethod.POST)
	public String createOrUpdateDependants(DependantsEntity dependants) 
	{
		service.createOrUpdateDependants(dependants);
		return "redirect:/";
	}
}
