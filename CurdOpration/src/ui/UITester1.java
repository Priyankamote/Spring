package ui;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import business.bean.EmployeeBean;
import service.EmployeeService;

public class UITester1 {

	public static void main(String[] args) {
		
		EmployeeService employeeServiceIMPL=null;
		try{
			
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("resources/cst-main-config.xml");
			employeeServiceIMPL = (EmployeeService) applicationContext.getBean("employeeServiceImpl");
			
		 //1 Add Employee
		//addEmployee(employeeServiceIMPL);
		
		// 2 Get Employee Employee
		//getEmployeeDetails(employeeServiceIMPL);
		
		
		//3 Update Employee
		//updateEmployeeDetails(employeeServiceIMPL);
		
		//4 Delete Employee
		deleteEmployee(employeeServiceIMPL);
				
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	public static void addEmployee(EmployeeService serviceImpl) {

		EmployeeBean bean = new EmployeeBean();
		bean.setInsertTime(new Date());
		bean.setName("New Employee");
		bean.setRole("Sr.Analyst");
		bean.setSalary(10.0);
		
		try {

			int id = serviceImpl.addEmployee(bean).getId();
			System.out.println("Employee Registered Successfully: " + id);
	
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}

	public static void getEmployeeDetails(EmployeeService serviceImpl) {

		try {

			EmployeeBean employeeBean = serviceImpl.getEmployeeDetails(2);

			if (employeeBean == null) 
			{
				System.out.println("Invalid Employee Id");
			} 
			else 
			{
				System.out.println("Employee Details");
				System.out.println("================");
				System.out.println("Name: " + employeeBean.getName());
				System.out.println("Salary: " + employeeBean.getSalary());
				System.out.println("Role: " + employeeBean.getRole());
			}
			
			
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}
	
	public static void updateEmployeeDetails(EmployeeService serviceImpl) {

		try {
			

			EmployeeBean foundEmployeeEntityBean = serviceImpl.getEmployeeDetails(2);

			if (foundEmployeeEntityBean == null) 
			{
				System.out.println("Invalid Employee Id");
			} 
			else 
			{
				foundEmployeeEntityBean.setSalary(1235.4);
				serviceImpl.addEmployee(foundEmployeeEntityBean); //save the updates back
				System.out.println("Updated Employee Details");
				System.out.println("========================");
				System.out.println("Name: " + foundEmployeeEntityBean.getName());
				System.out.println("Salary: " + foundEmployeeEntityBean.getSalary());
				System.out.println("Role: " + foundEmployeeEntityBean.getRole());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	
	public static void deleteEmployee(EmployeeService serviceImpl) {

		try {

			EmployeeBean employeeBean = serviceImpl.getEmployeeDetails(2);

			if (employeeBean == null) 
			{
				System.out.println("Invalid Employee Id");
			} 
			else 
			{
				serviceImpl.deleteEmployee(employeeBean);
				System.out.println("Employee Deleted successfully sith employeeId: "+employeeBean.getId());
			}
			
			 
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
