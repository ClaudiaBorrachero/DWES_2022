package org.alixar.servidor.model;

import java.io.Serializable;

public class OrderDetails implements Serializable {
	private Products product;
	private int quantityOrdered;
	private double priceEach;
	private int orderLineNumber;
	
	public OrderDetails() {
		// TODO Auto-generated constructor stub
	}

	public OrderDetails(Products product, int quantityOrdered, double priceEach, int orderLineNumber) {
		super();
		this.product = product;
		this.quantityOrdered = quantityOrdered;
		this.priceEach = priceEach;
		this.orderLineNumber = orderLineNumber;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public int getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	public double getPriceEach() {
		return priceEach;
	}

	public void setPriceEach(double priceEach) {
		this.priceEach = priceEach;
	}

	public int getOrderLineNumber() {
		return orderLineNumber;
	}

	public void setOrderLineNumber(int orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
	}
	
}
