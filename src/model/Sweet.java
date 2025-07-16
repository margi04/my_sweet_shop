package model;//data model class for sweets

public class Sweet {

	private int id;
	private String name;
	private String category;
	private double price;
	private int quantity;
	
	//constructor for initialize all fields
	public Sweet(int id,String name,String category,double price,int quantity){
		this.id= id;
		this.name= name;
		this.category= category;
		this.price= price;
		this.quantity= quantity;
	}
	
	//get method for all feilds
	public int getId(){return id;}
	public String getName(){return name;}
	public String getCategory(){return category;}
	public double getPrice(){return price;}
	public int getQuantity(){return quantity;}
	
	//set method for quantity which used during purchase/restock
	public void setQuantity(int quantity) {this.quantity=quantity;}
	}
