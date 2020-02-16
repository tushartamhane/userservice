package edu.bh.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.bh.user.entity.User;
import edu.bh.user.service.UserService;

@RestController
@Validated
public class UserController {
	

	@Autowired
	private UserService userService;
	
	@GetMapping
	public String service() {
		return "User Service Loaded !!! ";
	}
	
	
	@RequestMapping(value="/users",method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<User> getUsers() {
		System.out.println("Users >> "+userService.getUsers());
		
		return userService.getUsers();
	}
	
	@RequestMapping(value="user/{id}",method=RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE})
	public User getUser(@PathVariable("id") @Positive Long id) {
		return userService.getUser(id);
	}
	
	@RequestMapping(value="/adduser", method = RequestMethod.POST)
	public String addUser(@Valid @RequestBody User user) {
		
		String userId = userService.addUser(user);
		return "User Created with Id "+userId;
	}
	
	@DeleteMapping(value="/remove-user/{id}")
	public String removeUser(@PathVariable Long id) {
		return userService.remove(id);
		
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({MethodArgumentNotValidException.class})
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
			    Map<String, String> errors = new HashMap<>();
			    ex.getBindingResult().getAllErrors().forEach((error) -> {
			        String fieldName = ((FieldError) error).getField();
			        String errorMessage = error.getDefaultMessage();
			        errors.put(fieldName, errorMessage);
			    });
			    return errors;
			}


	
}
