package ch.heigvd.skeleton.services.crud;

import ch.heigvd.skeleton.exceptions.EntityNotFoundException;
import ch.heigvd.skeleton.model.Employee;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * This is an example for a CRUD service, which uses the JPA entity manager to
 * interact with the DB. It returns JPA entities to its clients.
 * 
 * @author Olivier Liechti
 */
@Stateless
public class EmployeesManager implements EmployeesManagerLocal {

	@PersistenceContext
	private EntityManager em;

	@Override
	public long create(Employee employeeData) {
		Employee newEmployee = new Employee(employeeData);
		em.persist(newEmployee);
		return newEmployee.getId();
	}

	
	@Override
	public void update(Employee newState) throws EntityNotFoundException {
		Employee employeeToUpdate = findById(newState.getId());
		em.merge(newState);
	}

	@Override
	public void delete(long id) throws EntityNotFoundException {
		Employee employeeToDelete = findById(id);
		em.remove(employeeToDelete);
	}

	@Override
	public Employee findById(long id) throws EntityNotFoundException {
		Employee existingEmployee = em.find(Employee.class, id);
		if (existingEmployee == null) {
			throw new EntityNotFoundException();
		}
		return existingEmployee;
	}

	@Override
	public List<Employee> findAll() {
		List employees = em.createNamedQuery("findAllEmployees").getResultList();
		return employees;
	}
	




}
