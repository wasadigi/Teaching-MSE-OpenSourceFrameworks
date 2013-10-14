/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.heigvd.skeleton.services.crud;

import ch.heigvd.skeleton.exceptions.EntityNotFoundException;
import ch.heigvd.skeleton.model.Employee;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author admin
 */
@Local
public interface EmployeesManagerLocal {

	long create(Employee employeeData);

	void update(Employee newState) throws EntityNotFoundException;

	void delete(long id) throws EntityNotFoundException;

	Employee findById(long id) throws EntityNotFoundException;

	List<Employee> findAll();

	
}
