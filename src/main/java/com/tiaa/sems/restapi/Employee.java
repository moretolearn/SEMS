package com.tiaa.sems.restapi;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement
public class Employee implements Serializable {
	private String city;
	private String firstName;
	private String lastName;
	private String state;
}
