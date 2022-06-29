package com.zensar.repository;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.zensar.entity.Employee;
import com.zensar.mapper.EmployeeMapper;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void create(int employeeId, String employeeName, int employeeAge) {
		String sql = "insert into employee value(?,?,?)";
		jdbcTemplate.update(sql, employeeId, employeeName, employeeAge);
	}

	public Employee getEmployee(int employeeId) {
		String sql = "select * from employee where id = ?";
		Employee employee = jdbcTemplate.queryForObject(sql, new Object[] { employeeId }, new EmployeeMapper());
		return employee;
	}

	public List<Employee> listOFEmployee() {
		String sql = "select * from employee";
		List<Employee> listOfEmployee = jdbcTemplate.query(sql, new EmployeeMapper());
		return listOfEmployee;
	}

	public void delete(int employeeId) {
		String sql = "delete from employee where id = ?";
		jdbcTemplate.update(sql, employeeId);
	}

	public void update(int employeeId, int employeeAge) {
		String sql = "update employee set age = ? where id = ?";
		jdbcTemplate.update(sql, employeeAge, employeeId);

	}

}
