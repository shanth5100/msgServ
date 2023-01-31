package com.paygateway.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.paygateway.entities.Order;

@Service
public interface OrderService {

	Optional<Order> findById(Long orderId);
}
