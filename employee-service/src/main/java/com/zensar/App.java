package com.zensar;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zensar.configuration.ConfigurationFile;
import com.zensar.entity.Employee;
import com.zensar.repository.EmployeeRepositoryImpl;

public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				ConfigurationFile.class);

		EmployeeRepositoryImpl employeeRepositoryImpl = applicationContext.getBean(EmployeeRepositoryImpl.class);

		System.out.println("Adding employee data into database");
		employeeRepositoryImpl.create(3, "Sam", 22);
		employeeRepositoryImpl.create(4, "Samaira", 23);
		employeeRepositoryImpl.create(5, "Harry", 28);
		employeeRepositoryImpl.create(6, "Jack", 29);

		System.out.println("Getting Empoyee data having id number 4");
		Employee employee = employeeRepositoryImpl.getEmployee(4);
		System.out.println("Employee Id= " + employee.getEmployeeId());
		System.out.println("Employee Name= " + employee.getEmployeeName());
		System.out.println("Employee Age= " + employee.getEmployeeAge());

		System.out.println("Employee table data");
		List<Employee> listOFEmployee = employeeRepositoryImpl.listOFEmployee();
		for (Employee employee2 : listOFEmployee) {
			System.out.println("Id= " + employee2.getEmployeeId() + "	Name=" + employee2.getEmployeeName()
					+ "	Age=" + employee2.getEmployeeAge());
		}

		System.out.println("updating employee data into database");
		employeeRepositoryImpl.update(6, 26);

		System.out.println("Deleting data having id number 3");
		employeeRepositoryImpl.delete(3);

		applicationContext.close();
	}
}
