package edu.bh.user.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.bh.user.entity.User;
import edu.bh.user.service.UserService;

@RestController
@RequestMapping(value="v2")
public class UserControllerL2 {
	private final Logger logger = LoggerFactory.getLogger(UserControllerL2.class);
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public String service() {
		return "User Serivice Loaded";
	}
	
	@GetMapping(path="/users",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<User>> getUsers() {
		List<User> users = userService.getUsers();
		if(users.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		logger.info("User size >>> "+users.size());
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@PostMapping(value="/adduser", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<String> addUser(@Valid @RequestBody User user) {
		
		String userId = userService.addUser(user);
		if(userId == null) {
			return ResponseEntity.badRequest().build();
		}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(userId)
				.toUri();
		return ResponseEntity.created(uri).body(userId);
		
	}
	
	@PutMapping(value="/update/{userId}")
	public ResponseEntity<User> updateUser(@RequestBody User request,@PathVariable String userId){
		User user = userService.modifyUser(request);
		if(user == null) {
			ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(user);
		
	}
	

}
