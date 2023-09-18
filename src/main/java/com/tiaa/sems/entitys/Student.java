package com.tiaa.sems.entitys;


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
@Entity
@Data
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Integer age;
    private String grade;
    private String clz;
//    private String address;
    private String tp;
    private String email;
    
    @OneToOne
    @JoinColumn(name = "parent_id",referencedColumnName = "ID")
    private Parents parents;
    
    @ManyToMany
    @JoinTable(
            name = "Student_Subject",
            joinColumns = @JoinColumn(name = "Student_ID"),
            inverseJoinColumns = @JoinColumn(name = "Subject_ID")
    )
    private Set<Subjects> subjects = new HashSet<>();
}