package com.jsp.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.employee.controller.Employeecontroller;
import com.jsp.employee.entity.Employee;
import com.jsp.employee.repository.Employeerepository;

@Service
public class Employeeservice {
	@Autowired
	Employeerepository er;
	public void insert1(int eId,String eName,int eSalary)
	{
		er.insert2(eId, eName, eSalary);
	}
	public void update1(int eId,int eSalary)
	{
		er.update2(eId,eSalary);
	}
	public void delete1(int eId)
	{
		er.delete2(eId);
	}
	public List<Employee> fetch1()
	{
		List<Employee> l1=er.fetch2();
		return l1;
	}
}
