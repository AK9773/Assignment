package com.zensar.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.zensar.entity.Employee;

@Repository
public interface EmployeeRepository {

	public void create(int employeeId, String employeeName, int employeeAge);

	public Employee getEmployee(int employeeId);

	public List<Employee> listOFEmployee();

	public void delete(int employeeId);

	public void update(int employeeId, int employeeAge);

}
