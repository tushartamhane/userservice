package edu.bh.user.in.controller;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.bh.user.entity.User;
import edu.bh.user.service.UserService;


@RestController
@RequestMapping("/hateos")
public class HateosController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public String service() {
		return "HATEOS User Service Loaded !!! ";
	}
	
	@RequestMapping(value="user/{id}",method=RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE})
	public Resource<User> getUser(@PathVariable("id") @Positive Long id) {
		// Creating links as per the hateoas principle.
        Resource<User> user= new Resource<User>(userService.getUser(id));
        user.add(linkTo(methodOn(HateosController.class).getUser(id)).withRel("_self"));
        user.add(linkTo(methodOn(HateosController.class).getUsers()).withRel("_all"));
		return user;
	}
	
	
	@RequestMapping(value="/users",method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Resource<User>> getUsers() {
		System.out.println("Users >> "+userService.getUsers());
		List<User> userList = userService.getUsers();
		List<Resource<User>> userResources = new ArrayList<Resource<User>>();
		for (User user : userList) {
			userResources.add(getEmployeeResource(user));
        }
		return userResources;
	}
	
	
	 private static Resource<User> getEmployeeResource(User employee) {
	        Resource<User> resource = new Resource<User>(employee);
	        resource.add(linkTo(methodOn(HateosController.class).getUser(employee.getId())).withRel("_self"));
	        return resource;
	    }
}
