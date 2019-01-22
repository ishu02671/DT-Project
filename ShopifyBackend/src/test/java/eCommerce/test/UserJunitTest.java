package eCommerce.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import eCommerce.DAO.UserDAO;
import eCommerce.model.UserDetail;

public class UserJunitTest {

	
	static UserDAO userDAO;

	@BeforeClass
	public static void executeFirst() 
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("eCommerce");
		context.refresh();
		
		userDAO = (UserDAO)context.getBean("userDAO");
	}



	@Test
	public void registerUserTest() 
	{
		UserDetail user = new UserDetail();
		user.setUserName("sumit");
		user.setPassword("sumit1234");
		user.setEnabled(true);
		user.setRole("ROLE_USER");
		user.setCustomerName("Sumit");
		user.setCustomerAddr("Mumbai");
		
		assertTrue("Problem in Registering User", userDAO.registerUser(user));
		
		
		
		
	}

}
