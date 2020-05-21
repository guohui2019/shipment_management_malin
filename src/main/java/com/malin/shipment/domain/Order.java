package com.malin.shipment.domain;

import java.util.List;

public class Order {
	private Order parent;
	private List<Order> child;
	private Integer quantity;

	public Order(List<Order> child, Integer quantity) {
		this.parent = this;
		this.child = child;
		this.quantity = quantity;
	}
	
	public Order(Order parent, Integer quantity) {
		this.parent = parent;
		this.quantity = quantity;
	}
 
	public Order getParent() {
		return parent;
	}

	public void setParent(Order parent) {
		this.parent = parent;
	}

	public List<Order> getChild() {
		return child;
	}

	public void setChild(List<Order> child) {
		this.child = child;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
