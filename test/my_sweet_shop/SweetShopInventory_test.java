package my_sweet_shop;

import model.Sweet;
import service.SweetShopInventory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*; 


public class SweetShopInventory_test {
	SweetShopInventory manager;
	
	@BeforeEach
	public void setup() {
		manager = new SweetShopInventory();
	}
	
	@Test
	public void testAddSweet() {
		 Sweet s = new Sweet(1, "Kaju Katli", "Nut-Based", 50.0, 20);
		 assertTrue(manager.addSweet(s));
	}
	
	    @Test
	    public void testDuplicateSweet() {
	        Sweet s = new Sweet(1, "Kaju Katli", "Nut-Based", 50.0, 20);
	        manager.addSweet(s);
	        assertFalse(manager.addSweet(s));
	        } 

	    @Test
	    public void testDeleteSweet() {
	        Sweet s = new Sweet(2, "Rasgulla", "Milk-Based", 10.0, 50);
	        manager.addSweet(s);
	        assertTrue(manager.deleteSweet(2)); 
	    }

	    @Test
	    public void testPurchaseAndRestock() {
	        Sweet s = new Sweet(3, "Barfi", "Nut-Based", 25.0, 10);
	        manager.addSweet(s);
	        
	        boolean purchased = manager.purchaseSweet(3, 5);
	        assertTrue(purchased);

	        Sweet afterPurchase = manager.getSweetById(3);
	        System.out.println("After purchase quantity: " + afterPurchase.getQuantity());
	        assertEquals(5, afterPurchase.getQuantity());
	        
	        boolean restocked = manager.restockSweet(3, 10);
	        assertTrue(restocked);

	        Sweet afterRestock = manager.getSweetById(3);
	        System.out.println("After restock quantity: " + afterRestock.getQuantity());
	        assertEquals(15, afterRestock.getQuantity());
	    }
	}
	

