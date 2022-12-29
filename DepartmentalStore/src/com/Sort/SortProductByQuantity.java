package com.Sort;

import java.util.Comparator;

import com.Store.Product;

public class SortProductByQuantity implements Comparator<Product>{

	@Override
	public int compare(Product x, Product y) {
		return x.getQuantity()-y.getQuantity();
	}
}
