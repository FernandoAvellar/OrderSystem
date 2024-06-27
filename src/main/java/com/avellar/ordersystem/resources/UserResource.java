package com.avellar.ordersystem.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avellar.ordersystem.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll() {
		User user1 = new User(1L, "Maria de Lourdes", "maria@yahoo.com.br", "35998771212", "1234..@@6");
		return ResponseEntity.ok().body(user1);
	}
	

}
