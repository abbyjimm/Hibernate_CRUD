package com.code.hibernate.crud;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hibernate.entity.Employee;

public class QueryEmployee {

	public static void main(String[] args) {
		
		// Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try {
			// Start a transaction
			session.beginTransaction();
			
			// Query Employees
			List<Employee> employees = session.createQuery("from Employee").getResultList();
			
			displayEmployees(employees);
			
			// Query Employees: firstName='Aby'
			employees = session.createQuery("from Employee e where e.firstName='Aby'").getResultList();
			
			// Display the Employees
			System.out.println("\n\nEmployees whith first name = Aby");
			displayEmployees(employees);
						
			// Query Employees: firstName = Jhoana or firstName = Abigail
			employees = session.createQuery("from Employee e where e.firstName = 'Jhoana' or e.firstName='Mayra'").getResultList();
			
			// Display the Employee results 
			System.out.println("\n\n Employees who have firts name = Jhoana or first name = Mayra");
			displayEmployees(employees);
			
			// Query Employees where company LIKE '%company'
			employees = session.createQuery("from Employee e where e.company LIKE '%company%'").getResultList();
			
			// Display the employee results 
			System.out.println("\n\n Employees where company LIKE '%company'");
			displayEmployees(employees);
			
			// Commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}
	}

	private static void displayEmployees(List<Employee> employees) {
		for(Employee employee: employees) {
			System.out.println(employee);
		}
	}
}
