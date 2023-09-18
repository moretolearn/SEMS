package com.tiaa.sems.restapi;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeDTO implements Serializable{
	private String cityName;
	private String fName;
	private String lName;
	private String stateCode;
	
	
}
