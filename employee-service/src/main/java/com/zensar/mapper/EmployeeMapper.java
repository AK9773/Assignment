package com.zensar.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.zensar.entity.Employee;

public class EmployeeMapper implements RowMapper<Employee> {

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setEmployeeId(rs.getInt("Id"));
		employee.setEmployeeName(rs.getString("Name"));
		employee.setEmployeeAge(rs.getInt("Age"));
		return employee;
	}

}
