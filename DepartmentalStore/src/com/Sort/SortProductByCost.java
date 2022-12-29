package com.Sort;

import java.util.Comparator;

import com.Store.Product;

public class SortProductByCost implements Comparator<Product>{
	
	@Override
	public int compare(Product x, Product y) {
		Double a = x.getCost();
		Double b = y.getCost();
		return a.compareTo(b);
		
	}

}
