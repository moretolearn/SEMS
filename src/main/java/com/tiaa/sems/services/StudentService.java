package com.tiaa.sems.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiaa.sems.entitys.Student;
import com.tiaa.sems.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	public List<Student> getStudent() {
		return studentRepository.findAll();
	}

	public Student getStdByID(long ID) {
		Optional<Student> model = studentRepository.findById(ID);
		if (model.isPresent()) {
			return model.get();
		}
		return null;
	}

	public void deleteByStudentId(Long ID) {
		studentRepository.deleteById(ID);
	}

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public void createStudent(Student student) {
		studentRepository.save(student);
	}

	public void updateStudent(Student student, Long id) {
		Student std = studentRepository.findById(id).get();
		std.setName(student.getName());
		studentRepository.save(std);
	}
}
