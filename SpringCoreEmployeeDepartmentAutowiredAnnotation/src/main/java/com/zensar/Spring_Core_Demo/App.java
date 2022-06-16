package com.zensar.Spring_Core_Demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.zensar.beans.Employee;

public class App {
	public static void main(String[] args) {

		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		Employee student1 = (Employee) context.getBean("employee");
		System.out.println(student1);
		
		
	}	
	
}
