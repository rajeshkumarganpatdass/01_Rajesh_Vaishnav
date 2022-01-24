package com.udemy.rest.webservice.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.aspectj.weaver.AjAttribute.MethodDeclarationLineNumberAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.udemy.rest.webservice.restfulwebservices.exception.UserNotFoundException;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService service;
	
	@GetMapping("/users")
	public List<User> retreiveAllUsers()
	{
		return service.findAll();
	}
	
	/*@GetMapping("/users/{id}")
	public User reteriveUser(@PathVariable int id)
	{
		User user = service.findOne(id);
		if(user == null)
		{
			throw new UserNotFoundException("id: "+id);
		}
		return user;
	}*/
	
	//changing to add HATEOAS (Link)
	@GetMapping("/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) 
	{
		User user = service.findOne(id);
		
		if(user==null)
			throw new UserNotFoundException("id-"+ id);
		
		
		//"all-users", SERVER_PATH + "/users"
		//retrieveAllUsers
		EntityModel<User> model = EntityModel.of(user);
		WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).retreiveAllUsers());
		
		model.add(linkToUsers.withRel("all-users"));
		
		
		//HATEOAS
		
		return model;
	}
	
	/*@PostMapping("/users")
	public User createUser(@RequestBody User user)
	{
		return userDaoService.save(user);
	}*/
	
	
	//return created status 201 with URI
	/*@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user)
	{
		User savedUser = service.save(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest() // "/users"
				.path("/{id}") // append path variable "/10004"
				.buildAndExpand(savedUser.getId())
				.toUri();
		
		return  ResponseEntity.created(location).build();
	}*/
	
	//adding validation
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user)
	{
		User savedUser = service.save(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest() // "/users"
				.path("/{id}") // append path variable "/10004"
				.buildAndExpand(savedUser.getId())
				.toUri();
		
		return  ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = service.deleteById(id);
		
		if(user==null)
			throw new UserNotFoundException("id-"+ id);		
	}
	
	//add in pom.xml for XML format
	/*
	<!-- <dependency>
	    <groupId>com.fasterxml.jackson.dataformat</groupId>
	    <artifactId>jackson-dataformat-xml</artifactId>
	</dependency> -->
	*/
	
	//add in pom.xml for swagger
	/*
	<dependency>
      <groupId>org.springdoc</groupId>
      <artifactId>springdoc-openapi-ui</artifactId>
      <version>1.6.4</version>
   	</dependency>
	*/
	
	//add in pom.xml for monitoring
	/*
	<dependency>  
		<groupId>org.springframework.boot</groupId>  
		<artifactId>spring-boot-starter-actuator</artifactId>  
	</dependency>  
	*/
	
	//to monitor completely, add below line in application.properties
	//management.endpoints.web.exposure.include=*
	
	//add in pom.xml for Secuirty
	/*
	<dependency>
		<groupId>org.springframework.boot</groupId>  
		<artifactId>spring-boot-starter-security</artifactId>  
	</dependency>
	*/
}
