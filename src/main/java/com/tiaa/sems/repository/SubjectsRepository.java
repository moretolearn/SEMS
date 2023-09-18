package com.tiaa.sems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiaa.sems.entitys.Subjects;

public interface SubjectsRepository extends JpaRepository<Subjects, Long>{
	
}