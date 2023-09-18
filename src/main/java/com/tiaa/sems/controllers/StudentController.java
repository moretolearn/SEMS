package com.tiaa.sems.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tiaa.sems.entitys.Parents;
import com.tiaa.sems.entitys.Student;
import com.tiaa.sems.repository.StudentRepository;
import com.tiaa.sems.services.ParentsService;
import com.tiaa.sems.services.StudentService;

import jakarta.servlet.http.HttpSession;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	@Autowired
	private ParentsService parentsService;
	@Autowired
	private StudentRepository studentRepository;

	@PostMapping("student-parent-create")
	public String addStudent(@ModelAttribute Student student, @ModelAttribute Parents parent, Model model,
			HttpSession session) {
		model.addAttribute("isUpdate", false);
		Parents temp = parentsService.addParents(parent);
		student.setParents(temp);
		studentService.addStudent(student);
		return "redirect:/student-view";
	}

	@PostMapping("AssignSubjectConform")
	public String AssignSubjectConform(@ModelAttribute Student student, Model model) {
//        System.out.println("type added");
//        StudentSer.addStudent(Student);
		Student student1 = studentRepository.findById(student.getId()).get();
		student1.setSubjects(student.getSubjects());

		studentService.addStudent(student1);

		List<Student> student2 = studentService.getStudent();
		model.addAttribute("student", student2);

		return "Studentshow";
	}

	@GetMapping("student-create-update")
	public String Student(Model model) {

		model.addAttribute("parent", new Parents());
		model.addAttribute("student", new Student());
		model.addAttribute("isUpdate", false);
		return "student-create-update";

	}

	  @GetMapping("/") public String Home(Model model,HttpSession httpSession) {
	  List<com.tiaa.sems.entitys.Student> arrayList = new ArrayList<Student>();
	  model.addAttribute("students",arrayList);
	  httpSession.setAttribute("app_name", "Student Education Management System");
	  model.addAttribute("app_name", httpSession.getAttribute("app_name"));
	  return "student-view";
	  
	  }

//	@GetMapping("/")
//	public String Home(@ModelAttribute("student") Student student, @ModelAttribute("parent") Parents parent,
//			HttpSession m) {
//		student.setName("ram");
//		parent.setMotherName("Mohan");
//		return "index";
//
//	}

	@PostMapping("/endpoint")
	public String Home1(@ModelAttribute("student") Student student, @ModelAttribute("parent") Parents parent) {
		System.out.println(student);
		return "home";
	}

	@GetMapping("/student-view")
	public String STHome(Model model) {
		List<Student> student = studentService.getStudent();
		model.addAttribute("students", student);
		return "student-view";
	}

	@GetMapping("/student-update/{id}")
	public String edit(@PathVariable("id") long id, Model m) {
		Student student = studentService.getStdByID(id);
		m.addAttribute("student", student);
		m.addAttribute("isUpdate", true);
		return "student-create-update";
	}

	@PostMapping("student-update/{id}")
	public String UpdateStudent(@ModelAttribute Student student, @PathVariable("id") Long id, Model model,
			HttpSession session) {
		studentService.addStudent(student);
		return "redirect:/student-view";
	}

	@GetMapping("/student-delete/{id}")
	public String deleteStudent(@PathVariable("id") Long ID, HttpSession session) {
		studentService.deleteByStudentId(ID);
		session.setAttribute("msg", "The User ID " + ID + " Deleted Succesfully");
		return "redirect:/student-view";
	}

//    @GetMapping("/Studentshow/delete/{ID}")
//    public String DeleteStd(@PathVariable("ID") long ID){
//
//    }

//    @Autowired
//    private StudentService studentService;
//    @GetMapping("/")
//    public String getAllStudents(Model model) {
//        List<Student> students = studentService.getStudent();
//        model.addAttribute("students", students);
//        return "home";
//    }
//    @GetMapping("/create")
//    public String createStudentPage(Model model) {
//        Student student = new Student();
//        model.addAttribute("student", student);
//        model.addAttribute("isUpdate", false);
//        return "create-update";
//    }
//    @GetMapping("/update/{id}")
//    public String updateStudentPage(Model model, @PathVariable("id") Long id) {
//        Student student = studentService.getStdByID(id);
//        model.addAttribute("student", student);
//        model.addAttribute("isUpdate", true);
//        return "create-update";
//    }
//	@PostMapping("/student-update/{id}")
//	public String createStudent(@ModelAttribute("student") Student student, @PathVariable("id") Long id) {
//		studentService.updateStudent(student, id);
//		return "redirect:/student-view";
//	}
//    @PostMapping("/create")
//    public String createStudent(@ModelAttribute("student") Student student) {
//        studentService.addStudent(student);
//        return "redirect:/";
//    }
//    @GetMapping("/delete/{id}")
//    public String deleteStudent(@PathVariable("id") Long id) {
//        studentService.deleteByStudentId(id);
//        return "redirect:/";
//    }
}