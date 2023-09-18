package com.tiaa.sems.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiaa.sems.entitys.Subjects;
import com.tiaa.sems.repository.SubjectsRepository;

@Service
public class SubjectsService {
	@Autowired
	private SubjectsRepository subjectsRepository;

	public Subjects addSubjects(Subjects subjects) {
		return subjectsRepository.save(subjects);
	}

	public List<Subjects> getAllSubjects() {
		return subjectsRepository.findAll();
	}
	
	public Subjects getSubjectById(Long id) {
		return subjectsRepository.findById(id).get();
	}
	
	public void deleteSubjectById(Long id) {
		subjectsRepository.deleteById(id);
	}

}
