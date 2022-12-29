package com.Store;

import java.util.Scanner;

import com.exception.InvalidChoiceException;

public class Solution {

	public static void displayMenu() {
		System.out.println("1:Add Product\n2:Remove Product\n3:Remove All Products");
		System.out.println("4:Display Product\n5:Display All Products\n6:Update Prodct");
		System.out.println("7:Count Products\n8:Sort Products\n9:EXIT");
	}
	public static void main(String[] args) {
		DepartmentalStore store = new DepartmentalStoreImpl();
		Scanner scan = new Scanner(System.in);
		System.out.println("WELCOME TO MY ORGANIC DEPARTMENTAL STORE");
		System.out.println("----------------------------------------------");
		
		
		while(true) {
			displayMenu();
			
			System.out.println("Enter choice");
			int choice = scan.nextInt();
			
			switch(choice) {
			case 1: 
				store.addProduct();
				break;
				
			case 2: 
				store.removeProduct();
				break;
				
			case 3:
				store.removeAllProduct();
				break;
				
			case 4:
				store.displayProduct();
				break;
				
			case 5:
				store.displayAllProducts();
				break;
				
			case 6:
				store.updateProduct();
				break;
			
			case 7:
				store.countProducts();
				break;
				
			case 8:
				store.sortProducts();
				break;
				
			case 9:
				System.out.println("THANK YOU....Visit Again!");
				System.exit(0);
			default:
				try {
					throw new InvalidChoiceException("Invalid choice please select valid one");
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			
		}
	}
}
