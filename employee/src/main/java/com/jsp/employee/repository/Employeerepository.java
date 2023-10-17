package com.jsp.employee.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.jsp.employee.entity.Employee;

@Repository
public class Employeerepository {
	public void insert2(int eId,String eName,int eSalary)
	{
		Employee e1=new Employee();
		e1.seteId(eId);
		e1.seteName(eName);
		e1.seteSalary(eSalary);

		Configuration cfg=new Configuration().configure().addAnnotatedClass(Employee.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		Transaction trans=session.beginTransaction();
		//Business Logic
		session.save(e1);

		trans.commit();
		session.close();
	}
	public void update2(int eId,int eSalary)
	{
		Configuration cfg=new Configuration().configure().addAnnotatedClass(Employee.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		Transaction trans=session.beginTransaction();
		//Business Logic
		Employee e1=session.find(Employee.class,eId);
		e1.seteSalary(eSalary);
		session.save(e1);

		trans.commit();
		session.close();
	}
	public void delete2(int eId)
	{
		Configuration cfg=new Configuration().configure().addAnnotatedClass(Employee.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		Transaction trans=session.beginTransaction();
		//Business Logic
		Employee e1=session.find(Employee.class,eId);
		session.delete(e1);

		trans.commit();
		session.close();
	}
	public List<Employee> fetch2()
	{
		Configuration cfg=new Configuration().configure().addAnnotatedClass(Employee.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		Transaction trans=session.beginTransaction();
		//Business Logic
		Query query=session.createQuery("from Employee");
		List<Employee> l1=query.list();
		for(Employee e:l1)
		{
			System.out.println(e);
		}

		trans.commit();
		session.close();
		return l1;
	}
}
