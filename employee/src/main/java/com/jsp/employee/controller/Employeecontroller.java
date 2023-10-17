package com.jsp.employee.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.employee.entity.Employee;
import com.jsp.employee.service.Employeeservice;
@Controller
public class Employeecontroller {
	@Autowired
	Employeeservice es;
	@RequestMapping("/insert")
	public ModelAndView insert(HttpServletRequest req,HttpServletResponse resp)
	{
		int eId=Integer.parseInt(req.getParameter("eId"));
		String eName=req.getParameter("eName");
		int eSalary=Integer.parseInt(req.getParameter("eSalary"));

		es.insert1(eId, eName, eSalary);

		ModelAndView mav=new ModelAndView();
		mav.setViewName("output.jsp");
		mav.addObject("output","DATA IS INSERTED SUCCESSFULLY");
		return mav;
	}
	@RequestMapping("/update")
	public ModelAndView update(HttpServletRequest req,HttpServletResponse resp)
	{
		int eId=Integer.parseInt(req.getParameter("eId"));
		int eSalary=Integer.parseInt(req.getParameter("eSalary"));

		es.update1(eId,eSalary);

		ModelAndView mav=new ModelAndView();
		mav.setViewName("output.jsp");
		mav.addObject("output","DATA IS UPDATED SUCCESSFULLY");
		return mav;
	}
	@RequestMapping("/delete")
	public ModelAndView delete(HttpServletRequest req,HttpServletResponse resp)
	{
		int eId=Integer.parseInt(req.getParameter("eId"));

		es.delete1(eId);

		ModelAndView mav=new ModelAndView();
		mav.setViewName("output.jsp");
		mav.addObject("output","DATA IS DELETED SUCCESSFULLY");
		return mav;
	}
	@RequestMapping("/fetch")
	public ModelAndView fetch(HttpServletRequest req,HttpServletResponse resp)
	{
		
		List<Employee> l1=es.fetch1();

		ModelAndView mav=new ModelAndView();
		mav.setViewName("output.jsp");
		mav.addObject("output","DATA IS FETCHED SUCCESSFULLY");
		return mav;
	}
}
