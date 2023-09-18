package com.tiaa.sems.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tiaa.sems.entitys.Parents;
import com.tiaa.sems.services.ParentsService;

@Controller
public class ParentsController {
	
	@Autowired
	ParentsService parentsService;

	@GetMapping("parent-view")
	public String parentShow(Model model) {
		List<Parents> parents = parentsService.getParents();
		System.out.println(parents);
		model.addAttribute("parents", parents);
		return "parent-view";
	}
}
