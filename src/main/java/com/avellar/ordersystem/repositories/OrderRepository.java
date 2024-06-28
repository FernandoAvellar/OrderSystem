package com.avellar.ordersystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avellar.ordersystem.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
