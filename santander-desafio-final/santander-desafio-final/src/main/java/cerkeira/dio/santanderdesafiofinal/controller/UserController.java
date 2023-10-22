package cerkeira.dio.santanderdesafiofinal.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import cerkeira.dio.santanderdesafiofinal.domain.model.User;
import cerkeira.dio.santanderdesafiofinal.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}

	/*
	 * abaixo no lugar de "user" é uma boa prática colocar um DTO, ja que com ele
	 * expomos apenas os dados que julgamos necessarios
	 */
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		var user = userService.findById(id);
		return ResponseEntity.ok(user);
	}

	@PostMapping
	public ResponseEntity<User> create(@RequestBody User user) {
		userService.create(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(user.getId()).toUri();
				
		return ResponseEntity.created(location).body(user);
	}
}
