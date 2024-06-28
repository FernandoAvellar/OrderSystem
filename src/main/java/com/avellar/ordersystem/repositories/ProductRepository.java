package com.avellar.ordersystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avellar.ordersystem.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
