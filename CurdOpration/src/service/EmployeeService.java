package service;


import java.util.List;

import business.bean.EmployeeBean;

public interface EmployeeService {
	EmployeeBean addEmployee(EmployeeBean bean)throws Exception;

	EmployeeBean getEmployeeDetails(Integer id)throws Exception;

	List<EmployeeBean> getAllEmployeeDetails()throws Exception;

	void deleteEmployee(EmployeeBean bean)throws Exception;

}
