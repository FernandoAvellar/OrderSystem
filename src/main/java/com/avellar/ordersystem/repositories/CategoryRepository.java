package com.avellar.ordersystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avellar.ordersystem.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
