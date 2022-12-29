package com.Store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.Sort.SortProductByCost;
import com.Sort.SortProductById;
import com.Sort.SortProductByName;
import com.Sort.SortProductByQuantity;
import com.exception.InvalidChoiceException;
import com.exception.ProductNotFoundException;

public class DepartmentalStoreImpl implements DepartmentalStore {

	Scanner scan = new Scanner(System.in);
	Map<String,Product> db = new LinkedHashMap<String, Product>();

	@Override
	public void addProduct() {
		System.out.println("Enter Name");
		String name= scan.next();
		System.out.println("Enter Cost");
		double cost = scan.nextDouble();
		System.out.println("Enter Quantity");
		int quantity = scan.nextInt();

		Product p = new Product(name, cost, quantity);
		db.put(p.getId(), p);
		System.out.println("Product Inserted Successfully");
	}

	@Override
	public void removeProduct() {
		System.out.println("Enter id");
		String id = scan.next().toUpperCase();

		if(db.containsKey(id)) {
			db.remove(id);
			System.out.println(id+ "Deleted Successfully");
		}
		else {
			try {
				throw new ProductNotFoundException("Product Not Present");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void removeAllProduct() {
		System.out.println(db.size()+" Products Available");
		db.clear();
		System.out.println("All Products Are Deleted Successfully");
	}

	@Override
	public void displayProduct() {
		System.out.println("Enter id");
		String id = scan.next().toUpperCase();

		if(db.containsKey(id)) {
			Product p = db.get(id);
			System.out.println(p);
		}
		else {
			try {
				throw new ProductNotFoundException("Product Not Found");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void displayAllProducts() {
		System.out.println("Product List");
		System.out.println("_________________");
		Set<String> keys = db.keySet();

		for(String id: keys) {
			Product p = db.get(id);
			System.out.println(p);
		}

	}
	@Override
	public void updateProduct() {
		System.out.println("Enter id");
		String id = scan.next().toUpperCase();

		if(db.containsKey(id)) {
			Product p = db.get(id);

			System.out.println("1:Update Name\n2:Update Cost\n3:Update Quantity");
			System.out.println("Enter Choice");
			int choice = scan.nextInt();

			switch(choice) {

			case 1: System.out.println("Enter Product Name");
			String name = scan.next();
			p.setName(name);
			System.out.println("Name successfully Updated");
			break;

			case 2: System.out.println("Enter Product Cost");
			double cost = scan.nextDouble();
			p.setCost(cost);
			System.out.println("Cost Updated successfully");
			break;

			case 3: System.out.println("Enter Product Quantity");
			int quantity = scan.nextInt();
			p.setQuantity(quantity);
			System.out.println("Updated Successfully");
			break;

			default:
				try {
					throw new InvalidChoiceException("Invalid Choice");
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}

		else {
			try {
				throw new ProductNotFoundException("Product Not Exist");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void countProducts() {
		System.out.println(db.size()+" Available Products");
	}

	@Override
	public void sortProducts() {
		System.out.println("1:Sort By ID \n2:Sort By Name \n3:Sort By Cost \n4:Sort By Quantity");
		System.out.println("Enter Your Choice");
		int choice= scan.nextInt();

		Set<String> keys = db.keySet();

		List<Product> list = new ArrayList<Product>();
		for(String key: keys) {
			list.add(db.get(key));
		}

		System.out.println("1:Sort in Ascending Order \n2:Sort in Descending Order");
		System.out.println("Enter Your Choice");
		int n = scan.nextInt();

		switch (choice) {

		case 1: Collections.sort(list, new SortProductById());
		if(n==2) 
			Collections.reverse(list);	
		display(list);
		break;

		case 2: Collections.sort(list, new SortProductByName());
		if(n==2) {
			Collections.reverse(list);
		}
		display(list);
		break;

		case 3:Collections.sort(list, new SortProductByCost());
		if(n==2) {
			Collections.reverse(list);
		}
		display(list);
		break;

		case 4:Collections.sort(list, new SortProductByQuantity());
		if(n==2) {
			Collections.reverse(list);
		}
		display(list);
		break;

		default:
			try {
				throw new InvalidChoiceException("Invalid Choice");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private void display(List<Product> list) {
		for(Product p: list) {
			System.out.println(p);
		}
	}
}