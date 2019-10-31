/**
 * 
 */
package com.vicrodri.angularpoc.service;

import java.util.List;

import com.vicrodri.angularpoc.model.Employee;

/**
 * @author vrodriguezgu
 *
 */
public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(long employeeId);
	
	public Employee save(Employee employee);
	
	public long delete (Employee employee);
}
