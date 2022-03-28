package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.entities.Employee;
import tn.esprit.spring.service.IEmployeeService;

@RestController

@RequestMapping("/employee")
public class EmployeeRestController {
	@Autowired
	IEmployeeService employeeService;
	// http://localhost:8081/SpringMVC/employee/retrieve-all-employees
		
		@GetMapping("/retrieve-all-employees")
		public List<Employee> getEmployees() {
			List<Employee> listEmployees = employeeService.retrieveAllEmployees();
			return listEmployees;
		}

		// http://localhost:8081/SpringMVC/employee/retrieve-employee/1
		
		@GetMapping("/retrieve-employee/{employee-id}")
		public Employee retrieveEmployee(@PathVariable("employee-id") int employeeId) {
			return employeeService.retrieveEmployee(employeeId);
		}

		// http://localhost:8081/SpringMVC/employee/add-employee/1
		@PostMapping("/add-employee/{identreprise}")
		public Employee addClient(@RequestBody Employee e,@PathVariable("identreprise") int identreprise) {
			return employeeService.addEmployee(e,identreprise);
		}

		// http://localhost:8081/SpringMVC/employee/remove-employee/1
		@DeleteMapping("/remove-employee/{employee-id}")
		public void removeEmployee(@PathVariable("employee-id") int employeeId) {
			employeeService.deleteEmployee(employeeId);
		}

		// http://localhost:8081/SpringMVC/employee/modify-employee/2
		/*@PutMapping("/modify-employee/{idemployee}")
		public Employee modifyEmployee(@RequestBody Employee e,@PathVariable("idemployee") int idemployee) {
			return employeeService.updateEmployee(e, idemployee);
		}*/
		// http://localhost:8081/SpringMVC/employee/modify-employee/2
		@PutMapping("/modify-employee/{identreprise}")
		public Employee modifyEmployee(@RequestBody Employee e,@PathVariable("identreprise") int identreprise) {
			return employeeService.updateEmployee(e, identreprise);
		}
}
