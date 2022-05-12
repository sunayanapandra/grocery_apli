package com.groceryapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groceryapp.Exceptions.ValidationException;
import com.groceryapp.dao.OrderRepository;
import com.groceryapp.model.Order;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;

	public void save(Order order) throws ValidationException {
		try {

			orderRepository.save(order);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidationException(e.getMessage());
		}
	}

	public List<Order> findAll() throws ValidationException {
		List<Order> listorder = null;
		try {
			listorder = orderRepository.findAll();

		} catch (Exception e) {
			throw new ValidationException(e.getMessage());
		}
		return listorder;
	}

	public Order findById(Integer id) {

		Optional<Order> order = orderRepository.findById(id);
		if (order.isPresent()) {
			Order orderObj = order.get();
			return orderObj;
		} else {
			return null;
		}
	}

	public Order changeStatus(Integer id, String status) {

		Optional<Order> order = orderRepository.changestatus(id, status);
		if (order.isPresent()) {
			Order orderObj = order.get();
			return orderObj;
		} else {
			return null;
		}
	}
}
