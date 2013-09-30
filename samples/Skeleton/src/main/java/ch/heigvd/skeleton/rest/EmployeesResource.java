package ch.heigvd.skeleton.rest;

import ch.heigvd.skeleton.model.Employee;
import ch.heigvd.skeleton.services.crud.EmployeesManagerLocal;
import ch.heigvd.skeleton.services.to.EmployeesTOServiceLocal;
import ch.heigvd.skeleton.to.PublicEmployeeTO;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 *
 * @author Olivier Liechti
 */
@Stateless
@Path("employees")
public class EmployeesResource {

	@Context
	private UriInfo context;
	
	@EJB
	EmployeesManagerLocal employeesManager;
	
	@EJB
	EmployeesTOServiceLocal employeesTOService;

	/**
	 * Creates a new instance of EmployeesResource
	 */
	public EmployeesResource() {
	}

	@GET
  @Produces({"application/json", "application/xml"})
	public List<PublicEmployeeTO> getResourceList() {
		System.out.println("GET /employees called");
		List<Employee> employees = employeesManager.findAll();
		List<PublicEmployeeTO> result = new LinkedList<PublicEmployeeTO>();
		for(Employee employee : employees) {
			result.add(employeesTOService.buildPublicEmployeeTO(employee));
		}
		return result;
	}
	
	/**
	 * Retrieves representation of an instance of ch.heigvd.skeleton.rest.EmployeesResource
	 * @return an instance of PublicEmployeeTO
	 */
	@GET
	@Path("{id}")
  @Produces({"application/json", "application/xml"})
	public PublicEmployeeTO getResource(@PathParam("id") long id) {
		Employee employee = employeesManager.findById(id);
		PublicEmployeeTO employeeTO = employeesTOService.buildPublicEmployeeTO(employee);
		return employeeTO;
	}

}
