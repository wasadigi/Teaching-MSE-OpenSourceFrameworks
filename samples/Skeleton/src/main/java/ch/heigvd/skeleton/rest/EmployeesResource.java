package ch.heigvd.skeleton.rest;

import ch.heigvd.skeleton.exceptions.EntityNotFoundException;
import ch.heigvd.skeleton.model.Employee;
import ch.heigvd.skeleton.services.crud.EmployeesManagerLocal;
import ch.heigvd.skeleton.services.to.EmployeesTOServiceLocal;
import ch.heigvd.skeleton.to.PublicEmployeeTO;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

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

	/**
	 * Creates a new Employee resource from the provided representation
	 * @return an instance of PublicEmployeeTO
	 */
	@POST
	@Consumes({"application/json"})
	public Response createResource(PublicEmployeeTO newEmployeeTO) {
			Employee newEmployee = new Employee();
			employeesTOService.updateEmployeeEntity(newEmployee,newEmployeeTO);
			long newEmployeeId = employeesManager.create(newEmployee);
			URI createdURI = context.getAbsolutePathBuilder().path(Long.toString(newEmployeeId)).build();
			return Response.created(createdURI).build();
	}

	/**
	 * Retrieves a representation of a list of Employee resources
	 * @return an instance of PublicEmployeeTO
	 */
	@GET
  @Produces({"application/json", "application/xml"})
	public List<PublicEmployeeTO> getResourceList() {
		List<Employee> employees = employeesManager.findAll();
		List<PublicEmployeeTO> result = new LinkedList<PublicEmployeeTO>();
		for(Employee employee : employees) {
			result.add(employeesTOService.buildPublicEmployeeTO(employee));
		}
		return result;
	}
	
	/**
	 * Retrieves representation of an Employee resource
	 * @return an instance of PublicEmployeeTO
	 */
	@GET
	@Path("{id}")
  @Produces({"application/json", "application/xml"})
	public PublicEmployeeTO getResource(@PathParam("id") long id) throws EntityNotFoundException {
		Employee employee = employeesManager.findById(id);
		PublicEmployeeTO employeeTO = employeesTOService.buildPublicEmployeeTO(employee);
		return employeeTO;
	}

	/**
	 * Updates an Employee resource
	 * @return an instance of PublicEmployeeTO
	 */
	@PUT
	@Path("{id}")
	@Consumes({"application/json"})
	public Response Resource(PublicEmployeeTO updatedEmployeeTO, @PathParam("id") long id) throws EntityNotFoundException {
		Employee employeeToUpdate = employeesManager.findById(id);
		employeesTOService.updateEmployeeEntity(employeeToUpdate, updatedEmployeeTO);
		employeesManager.update(employeeToUpdate);
		return Response.ok().build();
	}

	
		/**
	 * Deletes an Employee resource
	 * @return an instance of PublicEmployeeTO
	 */
	@DELETE
	@Path("{id}")
	public Response deleteResource(@PathParam("id") long id) throws EntityNotFoundException {
		employeesManager.delete(id);
		return Response.ok().build();
	}

}
