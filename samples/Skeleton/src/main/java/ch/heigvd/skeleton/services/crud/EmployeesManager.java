package ch.heigvd.skeleton.services.crud;

import ch.heigvd.skeleton.model.Employee;
import ch.heigvd.skeleton.util.TestDataGenerator;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;

/**
 * This is an example for a CRUD service, which uses the JPA entity manager to
 * interact with the DB. It returns JPA entities to its clients.
 * 
 * @author Olivier Liechti
 */
@Stateless
public class EmployeesManager implements EmployeesManagerLocal {

	private TestDataGenerator testDataGenerator = new TestDataGenerator();
	
	
	@Override
	public long create() {
		//TODO: this is where we would use the JPA Entity Manager to insert a record in the DB
		long idGeneratedByDb = testDataGenerator.getRandomLong(1000000, 9000000);
		return idGeneratedByDb;
	}

	@Override
	public void update(Employee newState) {
		//TODO: this is where we would use the JPA Entity Manager to update a record in the DB
	}

	@Override
	public void delete(long id) {
		//TODO: this is where we would use the JPA Entity Manager to delete a record in the DB
	}

	@Override
	public Employee findById(long id) {
		//TODO: this is where we would use the JPA Entity Manager to find a record in the DB
		Employee existingEmployee = generateFakeEmployee();
		return existingEmployee;
	}

	@Override
	public List<Employee> findAll() {
		//TODO: this is where we would use the JPA Entity Manager to find all records in the DB
		int numberOfEmployees = (int)(testDataGenerator.getRandomLong(5, 20));
		List<Employee> result = new LinkedList<Employee>();
		for (int i=0; i<numberOfEmployees; i++) {
			result.add(generateFakeEmployee());
		}
		return result;
	}
	
	/*
	This is a temporary test method, that we will get rid off when we introduce the JPA
	entity manager
	*/
	private Employee generateFakeEmployee() {
		Employee fakeEmployee = new Employee();
		fakeEmployee.setId(testDataGenerator.getRandomLong(1000000, 9000000));
		fakeEmployee.setFirstName(testDataGenerator.getRandomFirstName());
		fakeEmployee.setLastName(testDataGenerator.getRandomLastName());
		fakeEmployee.setEmail(fakeEmployee.getFirstName() + "." + fakeEmployee.getLastName() + "@example.com");
		fakeEmployee.setSalary(testDataGenerator.getRandomLong(60000, 250000));
		return fakeEmployee;
	}

}
