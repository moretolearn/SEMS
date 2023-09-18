package com.tiaa.sems.entitys;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Subjects {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String subName;
    private String chapters;

    @OneToMany(mappedBy = "subjects")
    private Set<Teachers>teachers = new HashSet<>();
}
