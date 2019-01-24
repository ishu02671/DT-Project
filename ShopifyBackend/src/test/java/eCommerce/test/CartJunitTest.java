package eCommerce.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import eCommerce.DAO.CartDAO;
import eCommerce.model.CartItem;

public class CartJunitTest 
{
	static CartDAO cartDAO;

	@BeforeClass
	public static void executeFirst() 
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("eCommerce");
		context.refresh();
		
		cartDAO = (CartDAO)context.getBean("cartDAO");
	}
    
    @Ignore
	@Test
	public void addCartItemTest() 
	{
		CartItem cartItem = new CartItem();
		cartItem.setProductId(73);
		cartItem.setProductName("Puma Jackets");
		cartItem.setQuantity(2);
		cartItem.setPrice(2400);
		cartItem.setPaymentStatus("NP");
		cartItem.setUsername("sumit");
		
		assertTrue("Problem in Adding into Cart", cartDAO.addCartItem(cartItem));
		
	}
	
	@Test
	public void displayCartItems()
	{
		List<CartItem> listCartItems = cartDAO.listCartItems("sumit");
		
		assertTrue("Problem in Displaying Cart Items", listCartItems.size()>0);
		
		for(CartItem cartItem:listCartItems)
		{
			System.out.print(cartItem.getProductId() + "\t");
			System.out.print(cartItem.getProductName() + "\t");
			System.out.println(cartItem.getPrice() + "\t");
			
		}
		
		
	}
}
