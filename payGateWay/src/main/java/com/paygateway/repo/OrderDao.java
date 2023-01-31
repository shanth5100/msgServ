package com.paygateway.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paygateway.entities.Order;

@Repository
public interface OrderDao extends JpaRepository<Order, Long>{
	
	Optional<Order> findById(Long orderId);

}
