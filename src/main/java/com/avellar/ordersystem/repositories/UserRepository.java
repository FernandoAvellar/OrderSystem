package com.avellar.ordersystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avellar.ordersystem.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
