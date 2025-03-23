package sta.stockpricing;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import sta.stockpricing.loader.PriceLoader;

public class LoadStockPricing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Manually instantiate DAO and Service (since we are not using component scanning)
		context.getBean(PriceLoader.class).load();
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl(jdbcTemplate);
        EmployeeService employeeService = new EmployeeServiceImpl(employeeDAO);

        // Fetch and display all employees
        employeeService.getAllEmployees().forEach(System.out::println);

        context.close();
	}

}
