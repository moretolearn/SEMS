package com.tiaa.sems.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tiaa.sems.entitys.Subjects;
import com.tiaa.sems.entitys.Teachers;
import com.tiaa.sems.services.SubjectsService;
import com.tiaa.sems.services.TeachersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class TeachersController {

	@Autowired
	private TeachersService teachersService;

	@Autowired
	private SubjectsService subjectsService;

	@PostMapping("teacher-create")
	public String addVTypes(@ModelAttribute Teachers teacher,@ModelAttribute Subjects subjects) {
		
		System.out.println(teacher);
		System.out.println(subjects);
		teachersService.addTeacher(teacher);
		return "redirect:/teacher-view";

	}

	@GetMapping("teachers")
	public String Teacher(Model model) {
		model.addAttribute("subjects", subjectsService.getAllSubjects());
		model.addAttribute("teacher", new Teachers());
		model.addAttribute("isUpdate", false);
		return "teacher-create-update";
	}

	@GetMapping("teacher-view")
	public String Teachersshow(Model model) {
		List<Teachers> teachers = teachersService.getTeachers();
		model.addAttribute("teachers", teachers);
		return "teacher-view";
	}

	@GetMapping("teacher-update/{id}")
	public String edit(@PathVariable("id") long id, Model m) {
		Teachers teacher = teachersService.getteaByID(id);
		m.addAttribute("teacher", teacher);
		m.addAttribute("isUpdate", true);
		m.addAttribute("subjects", subjectsService.getAllSubjects());
		return "teacher-create-update";
	}

	@PostMapping("teacher-update/{id}")
	public String UpdateTeacher(@ModelAttribute Teachers teachers, @PathVariable("id") Long id, Model model,
			HttpSession session) {
		teachersService.addTeacher(teachers);
		session.setAttribute("msg", "Student Added Sucessfully...");
		return "redirect:/teacher-view";
	}

	@GetMapping("/teacher-delete/{id}")
	public String deleteTeacher(@PathVariable("id") Long id, HttpSession session) {
		teachersService.deleteTeacherById(id);
		session.setAttribute("msg", "The User ID " + id + " Deleted Succesfully");
		return "redirect:/teacher-view";
	}
}
