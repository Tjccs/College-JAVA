package startup;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import presentation.AddCustomerService;
import presentation.ProcessSaleService;
import presentation.AddEmployeeService;
import presentation.RemoveEmployeeService;
import presentation.ShowAllEmployeesService;
import presentation.AddDepartmentService;
import business.SaleSys;
import client.SimpleClient;

/**
 * Implements the startup use case. It creates the application, 
 * a simple client that interacts with the application, passing
 * it the application handlers. 
 * 
 * @author fmartins
 * @version 1.0 (08/03/2015)
 *
 */
public class Startup {

	public static void main(String[] args) {
		// Creates the entity manager factory that will assist in persisting entities
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("domain-model-jpa");
			
		// Creates the application main object
		SaleSys app = new SaleSys (emf);

		// Creates the application services
		AddCustomerService cs = new AddCustomerService(app.getAddCustomerHandler());
		ProcessSaleService ss = new ProcessSaleService(app.getProcessSaleHandler());
		AddEmployeeService es = new AddEmployeeService(app.getAddEmployeeHandler());
		AddDepartmentService ad = new AddDepartmentService(app.getAddDepartmentHandler());
		RemoveEmployeeService re = new RemoveEmployeeService(app.getRemoveEmployeeHandler());
		ShowAllEmployeesService sa = new ShowAllEmployeesService(app.getShowAllEmployeesHandler());
		
		
		// Creates the simple interaction client and
		// passes it the application handlers
		SimpleClient simpleClient = new SimpleClient(cs, ss, es, ad, re, sa);
		simpleClient.createASale();

		emf.close();
	}
}
