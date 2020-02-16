package edu.bh.user.greet.controller;



import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "greet")
public class GreetingsController {

	@RequestMapping(method = RequestMethod.GET)
	public String greet() {
		return "Welcome : User Service is Up and Running ";
	}
	
	@RequestMapping(value="/{name}",method = RequestMethod.GET)
	public String greetWithName(@PathVariable("name") String name) {
		return "User Service is Up and Running, Welcome :  "+name;
	}
	
	@RequestMapping(value= {"/greetings"},method = RequestMethod.GET)
	public String greetWithParam(@RequestParam("name") String name) {
		return "User Service is Up and Running, Welcome - "+name;
	}
	
	@RequestMapping(value= {"/wish","/status"},method = RequestMethod.GET)
	public String greetWithOptionalParam(@RequestParam(value="name",required = false,defaultValue = "USER") String name) {
		return "User Service is Up and Running, Welcome - "+name;
	}
}
