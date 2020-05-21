package com.malin.shipment.web;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.malin.shipment.domain.Order;

@RestController
public class OrderController {

	List<Order> parentOrderList = new ArrayList<>();

	@PostMapping("/split")
	public void split() {
		List<Order> childs = new ArrayList<>();
		Order parentOrder = new Order(childs, 100);
		childs.add(new Order(parentOrder, 20));
		childs.add(new Order(parentOrder, 30));
		childs.add(new Order(parentOrder, 50));
		parentOrderList.add(parentOrder);

	}

	@PostMapping("/merge")
	public void merge() {
		List<Order> childs = new ArrayList<>();
		Order parentOrder = new Order(childs, 80);
		childs.add(new Order(parentOrder, 30));
		childs.add(new Order(parentOrder, 50));
		parentOrderList.add(parentOrder);
	}

	@PutMapping("/increase")
	public void increase(Integer rootQuantity) {
		for (Order parent : parentOrderList) {
			Integer multiple = rootQuantity / parent.getQuantity();
			parent.setQuantity(parent.getQuantity() * multiple);
			for (Order child : parent.getChild()) {
				child.setQuantity(child.getQuantity() * multiple);
			}
		}
	}

	@PutMapping("/decrease")
	public void decrease(Integer rootQuantity) {
		for (Order parent : parentOrderList) {
			Integer multiple = rootQuantity / parent.getQuantity();
			parent.setQuantity(parent.getQuantity() / multiple);
			for (Order child : parent.getChild()) {
				child.setQuantity(child.getQuantity() / multiple);
			}
		}
	}
}
