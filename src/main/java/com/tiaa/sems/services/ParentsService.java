package com.tiaa.sems.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiaa.sems.entitys.Parents;
import com.tiaa.sems.entitys.Teachers;
import com.tiaa.sems.repository.ParentsRepository;

@Service
public class ParentsService {

    @Autowired
    private ParentsRepository parentsRepository;


    public Parents addParents(Parents parents){
        return parentsRepository.save(parents);
    }
    
    public List<Parents> getParents(){
        return parentsRepository.findAll();
    }

}
