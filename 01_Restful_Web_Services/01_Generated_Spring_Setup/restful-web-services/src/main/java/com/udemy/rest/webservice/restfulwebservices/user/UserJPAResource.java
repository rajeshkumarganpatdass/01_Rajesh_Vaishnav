package com.udemy.rest.webservice.restfulwebservices.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
public class UserJPAResource {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PostRepository postRepository;
	
	@GetMapping("/jpa/users")
	public List<User> retreiveAllUsers()
	{
		return userRepository.findAll();
	}
	
	/*@GetMapping("/jpa/users/{id}")
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
	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) 
	{
		Optional<User> user = userRepository.findById(id);
		
		if(!user.isPresent())
			throw new UserNotFoundException("id-"+ id);
		
		
		//"all-users", SERVER_PATH + "/users"
		//retrieveAllUsers
		EntityModel<User> model = EntityModel.of(user.get());
		WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).retreiveAllUsers());
		
		model.add(linkToUsers.withRel("all-users"));
		
		
		//HATEOAS
		
		return model;
	}
	
	/*@PostMapping("/jpa/users")
	public User createUser(@RequestBody User user)
	{
		return userDaoService.save(user);
	}*/
	
	
	//return created status 201 with URI
	/*@PostMapping("/jpa/users")
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
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user)
	{
		User savedUser = userRepository.save(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest() // "/users"
				.path("/{id}") // append path variable "/10004"
				.buildAndExpand(savedUser.getId())
				.toUri();
		
		return  ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
	}
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrieveAllPostUsingUserId(@PathVariable int id) {
		Optional<User> userOptional = userRepository.findById(id);
		
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}
		
		return userOptional.get().getPosts();
	}


	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Post post) {
		
		Optional<User> userOptional = userRepository.findById(id);
		
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}

		User user = userOptional.get();
		
		post.setUser(user);
		
		postRepository.save(post);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}
	
}
