package service;
import model.Sweet;
import java.util.*;

//operation related to sweet shop
public class SweetShopInventory {
	private final Map<Integer,Sweet> sweets = new HashMap<>();
	
	//Add sweet
	public boolean addSweet(Sweet sweet) {
		if(sweets.containsKey(sweet.getId()))return false;
		sweets.put(sweet.getId(),sweet);
		return true;
	}
	
	//View All sweet
	public List<Sweet> getAllSweets(){
		return new ArrayList<>(sweets.values());
	}
	
	//Delete sweet
	public boolean deleteSweet(int id) {
		return sweets.remove(id) !=null;
	}
	
	 // Get a sweet by ID
    public Sweet getSweetById(int id) {
        return sweets.get(id);
    }
	
	//Search sweets by name
	public List<Sweet> searchByName(String name){
		List<Sweet> result= new ArrayList<>();
		for(Sweet s: sweets.values()) {
			if(s.getName().equalsIgnoreCase(name))result.add(s);
			
		}
		return result;
	}
	//search by category
	public List<Sweet> searchByCategory(String category) {
	    List<Sweet> result = new ArrayList<>();
	    for (Sweet s : sweets.values()) {
	        if (s.getCategory().equalsIgnoreCase(category)) result.add(s);
	    }
	    return result;
	}
 
	//search by price range
	public List<Sweet> searchByPriceRange(double min, double max) {
	    List<Sweet> result = new ArrayList<>();
	    for (Sweet s : sweets.values()) {
	        if (s.getPrice() >= min && s.getPrice() <= max) result.add(s);
	    }
	    return result;
	}
	//sort sweets by price
	public List<Sweet> sortByPrice(){
		List<Sweet> list = getAllSweets();
		list.sort(Comparator.comparingDouble(Sweet::getPrice));
		return list;
	}
	
	//sort sweets by name
		public List<Sweet> sortByName(){
			List<Sweet> list = getAllSweets();
			list.sort(Comparator.comparing(Sweet::getName));
			return list;
		}
		
		//purchase Sweets and decrease quantity
	 public boolean purchaseSweet(int id ,int quantity) {
		 Sweet s = sweets.get(id);
		 if(s == null || s.getQuantity() < quantity) return false;
		 s.setQuantity(s.getQuantity() - quantity);
		 return true;
	 }
	 
	 //Restock sweet and increase quantity
	    public boolean restockSweet(int id, int quantity) {
	        Sweet s = sweets.get(id);
	        if (s == null) return false;
	        s.setQuantity(s.getQuantity() + quantity);
	        return true;
	    }
}
