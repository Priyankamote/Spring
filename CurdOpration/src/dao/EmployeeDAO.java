package dao;



import org.springframework.data.repository.CrudRepository;

import entity.EmployeeEntity;

public interface EmployeeDAO extends CrudRepository<EmployeeEntity, Integer>{
}	