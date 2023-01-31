package com.paygateway.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.paygateway.entities.Order;
import com.paygateway.repo.OrderDao;
import com.paygateway.service.OrderService;

public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDao orderDao;
	
	@Override
	public Optional<Order> findById(Long orderId) {
		return orderDao.findById(orderId);
	}

}
