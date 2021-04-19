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
import com.howtodoinjava.demo.model.EducationalQualificationsEntity;
import com.howtodoinjava.demo.service.EducationalQualificationsService;

@Controller
@RequestMapping("/")
public class EducationalQualificationsMvcController 
{
	@Autowired
	EducationalQualificationsService service;

	@RequestMapping(path = {"/qualifications"})
	public String getAllQualifications(Model model) 
	{
		List<EducationalQualificationsEntity> list = service.getAllQualifications();

		model.addAttribute("qualifications", list);
		return "list-qualifications";
	}

	@RequestMapping(path = {"/editQualifications", "/editQualifications/{id}"})
	public String editQualificationsByEmpId(Model model, @PathVariable("id") Optional<Long> id) 
							throws RecordNotFoundException 
	{
		if (id.isPresent()) {
			EducationalQualificationsEntity entity = service.getQualificationsByEmpId(id.get());
			model.addAttribute("qualifications", entity);
		} else {
			model.addAttribute("qualifications", new EducationalQualificationsEntity());
		}
		return "add-edit-qualifications";
	}
	
	@RequestMapping(path = "/qualifications/delete/{id}")
	public String deleteQualificationsByEmpId(Model model, @PathVariable("id") Long id) 
							throws RecordNotFoundException 
	{
		service.deleteQualificationsById(id);
		return "redirect:/";
	}

	@RequestMapping(path = "/createQualifications", method = RequestMethod.POST)
	public String createOrUpdateQualifications(EducationalQualificationsEntity dependants) 
	{
		service.createOrUpdateQualifications(dependants);
		return "redirect:/";
	}
}
