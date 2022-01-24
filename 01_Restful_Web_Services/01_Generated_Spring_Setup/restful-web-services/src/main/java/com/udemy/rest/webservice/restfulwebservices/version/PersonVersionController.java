package com.udemy.rest.webservice.restfulwebservices.version;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController 
public class PersonVersionController {

	//versioning using URI
	
	@GetMapping("/person/v1")
	public PersonV1 getPersonV1() {
		return new PersonV1("Rajesh Vaishnav");
	}
	
	@GetMapping("/person/v2")
	public PersonV2 getPersonV2() {
		return new PersonV2(new Name("Rajesh", "Vaishnav"));
	}
	
	//versioning using params
	
	@GetMapping(value = "/person/param", params="version=1")
	public PersonV1 paramV1() {
		return new PersonV1("Rajesh Vaishnav");
	}

	@GetMapping(value = "/person/param", params="version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("Rajesh", "Vaishnav"));
	}
	
	//versioning using headers
	
	@GetMapping(value = "/person/header", headers="X-API-Version=1")
	public PersonV1 headerV1() {
		return new PersonV1("Rajesh Vaishnav");
	}

	@GetMapping(value = "/person/header", headers="X-API-Version=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("Rajesh", "Vaishnav"));
	}
	
	//versioning using Accept Header
	
	@GetMapping(value="/person/produces", produces="application/vnd.company.app-v1+json")
	public PersonV1 producesV1() {
		return new PersonV1("Rajesh Vaishnav");
	}

	@GetMapping(value="/person/produces", produces="application/vnd.company.app-v2+json")
	public PersonV2 producesV2() {
		return new PersonV2(new Name("Rajesh", "Vaishnav"));
	}
}
