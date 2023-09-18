package com.tiaa.sems.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiaa.sems.entitys.Teachers;
import com.tiaa.sems.repository.TeachersRepository;

@Service
public class TeachersService {

	@Autowired
	private TeachersRepository teachersRepository;

	public Teachers addTeacher(Teachers teachers) {
		return teachersRepository.save(teachers);
	}

	public List<Teachers> getTeachers() {

		return teachersRepository.findAll();
	}

	public Teachers getteaByID(long ID) {

		Optional<Teachers> model = teachersRepository.findById(ID);

		if (model.isPresent()) {
			return model.get();
		}
		return null;
	}
	
	public void deleteTeacherById(Long Id) {
		teachersRepository.deleteById(Id);
	}

}
