/**
 * 
 */
package com.vicrodri.angularpoc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vicrodri.angularpoc.model.Employee;
import com.vicrodri.angularpoc.service.EmployeeService;

/**
 * @author vrodriguezgu
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	/* (non-Javadoc)
	 * @see com.vicrodri.angularpoc.repository.EmployeeRepository#findAll()
	 */
	@Override
	public List<Employee> findAll() {
    	List<Employee> resultList = new ArrayList<Employee>();
    	resultList.add(new Employee());
        return resultList;
	}

	/* (non-Javadoc)
	 * @see com.vicrodri.angularpoc.repository.EmployeeRepository#findById(long)
	 */
	@Override
	public Employee findById(long employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.vicrodri.angularpoc.repository.EmployeeRepository#save(com.vicrodri.angularpoc.model.Employee)
	 */
	@Override
	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.vicrodri.angularpoc.repository.EmployeeRepository#detele(com.vicrodri.angularpoc.model.Employee)
	 */
	@Override
	public long delete(Employee employee) {
		// TODO Auto-generated method stub
		return 0;
	}

}
