package com.tiaa.sems.restapi;

import java.util.Arrays;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.tiaa.sems.entitys.Student;
import com.tiaa.sems.services.StudentService;

import jakarta.servlet.http.HttpSession;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@RestController
@RequestMapping("/api")
public class RestAPI {

	@Autowired
	StudentService studentService;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	Mapper mapper;
	

	@GetMapping(path = "/list", produces = { MediaType.APPLICATION_JSON_VALUE })
	List<Student> getStudents(HttpSession httpSession) {
		httpSession.setAttribute("name", "ram");
		httpSession.removeAttribute("name");
		return studentService.getAllStudents();
	}
	
	@GetMapping(path = "/list1", produces = { MediaType.APPLICATION_JSON_VALUE })
	EmployeeDTO getStudents1() {
		
		Employee forEntity = restTemplate.getForObject("https://mocktarget.apigee.net/json", Employee.class);
		System.out.println(forEntity);
		EmployeeDTO map = mapper.map(forEntity, EmployeeDTO.class);
		System.err.println(map);
		
		return map;
	}
	
	
}
