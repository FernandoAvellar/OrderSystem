package com.avellar.ordersystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avellar.ordersystem.entities.OrderItem;
import com.avellar.ordersystem.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
