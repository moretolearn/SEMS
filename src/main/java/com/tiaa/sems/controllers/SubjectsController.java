package com.tiaa.sems.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.tiaa.sems.entitys.Student;
import com.tiaa.sems.entitys.Subjects;
import com.tiaa.sems.services.StudentService;
import com.tiaa.sems.services.SubjectsService;

import jakarta.servlet.http.HttpSession;

@Controller
public class SubjectsController {

	@Autowired
	private SubjectsService subjectsService;
	@Autowired
	private StudentService studentService;
	
	@GetMapping("subject")
	public String Subject(Model model) {
		model.addAttribute("isUpdate",false);
		model.addAttribute("subject", new Subjects());
		return "subject-create-update";
	}

	@PostMapping("subject-create")
	public String addSubjects(@ModelAttribute Subjects subject, Model model) {
		subjectsService.addSubjects(subject);
		return "redirect:/subject-view";
	}
	
	@GetMapping("subject-view")
	public String getSubjects(Model model) {
		List<Subjects> subjects = subjectsService.getAllSubjects();
		model.addAttribute("subjects", subjects);
		return "subject-view";
	}
	
	@GetMapping("/subject-update/{id}")
	public String edit(@PathVariable("id") long id, Model m) {
		Subjects subjects = subjectsService.getSubjectById(id);
		m.addAttribute("subject", subjects);
		m.addAttribute("isUpdate", true);
		return "subject-create-update";
	}

	@PostMapping("subject-update/{id}")
	public String UpdateSubject(@ModelAttribute Subjects subject,@PathVariable("id") Long id, Model model, HttpSession session) {
		Subjects subjects = subjectsService.addSubjects(subject);
		model.addAttribute("subject", subjects);
		return "redirect:/subject-view";
	}
	
	@GetMapping("/subject-delete/{id}")
	public String deleteSubject(@PathVariable("id") Long id, HttpSession session) {
		subjectsService.deleteSubjectById(id);
		session.setAttribute("msg", "The User ID " + id + " Deleted Succesfully");
		return "redirect:/subject-view";
	}

	@GetMapping("Subjects")
	public String Teacher(Model model) {

		model.addAttribute("newSubjects", new Subjects());

		return "SubjectAdd";

	}

	@GetMapping("AssignSub")
	public String AssignSub(Model model) {

		model.addAttribute("Studentpre", new Student());
		model.addAttribute("AllStudents", studentService.getStudent());
		model.addAttribute("AllSubjects", subjectsService.getAllSubjects());

		return "AssignSub";
	}
}
