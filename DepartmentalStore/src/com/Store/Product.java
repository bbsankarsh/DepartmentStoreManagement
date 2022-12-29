package com.Store;

public class Product {

	private String id;
	private String name;
	private double cost;
	private int quantity;
	
	private static int count = 100;
	
	public Product(String name, double cost, int quantity) {
		this.id = "PRO"+count;
		this.name=name;
		this.cost= cost;
		this.quantity = quantity;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Product.count = count;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", cost=" + cost + ", quantity=" + quantity + "]";
	}
	
	
}