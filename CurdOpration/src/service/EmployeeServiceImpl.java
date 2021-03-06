package service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import business.bean.EmployeeBean;
import dao.EmployeeDAOWrapper;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private  EmployeeDAOWrapper employeeDAOWrapper;

		public  EmployeeBean addEmployee(EmployeeBean bean)throws Exception{
			return employeeDAOWrapper.addEmployee(bean);
		}
		public EmployeeBean getEmployeeDetails(Integer id)throws Exception{
			return employeeDAOWrapper.getEmployeeDetails(id);
		}
		public List<EmployeeBean> getAllEmployeeDetails()throws Exception{
			return employeeDAOWrapper.getAllEmployeeDetails();
		}
		public void deleteEmployee(EmployeeBean bean)throws Exception{
			employeeDAOWrapper.deleteEmployee(bean);
		}
	
	
	
}
