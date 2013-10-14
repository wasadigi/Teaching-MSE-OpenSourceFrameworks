package ch.heigvd.skeleton.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * This class is an example for a simple JPA entity. Notice that there is a
 * 'salary' property, which is sensitive and which we do not want to expose to
 * everyone. That is one reason why we do not want to use this class directly
 * from the REST tier (and instead use specific Transfer Objects).
 *
 * @author Olivier Liechti
 */
@NamedQueries(
				@NamedQuery(
								name = "findAllEmployees",
								query = "SELECT e FROM Employee e"
				)
)

@Entity
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String firstName;
	private String lastName;
	private String email;
	private double salary;

	public Employee() {
		firstName = "UNDEF";
		lastName = "UNDEF";
		email = "UNDEF";
		salary = -1;
	}

	public Employee(Employee employeeData) {
		this.firstName = employeeData.firstName;
		this.lastName = employeeData.lastName;
		this.email = employeeData.email;
		this.salary = employeeData.salary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Employee)) {
			return false;
		}
		Employee other = (Employee) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ch.heigvd.skeleton.model.Employee[ id=" + id + " ]";
	}

}
