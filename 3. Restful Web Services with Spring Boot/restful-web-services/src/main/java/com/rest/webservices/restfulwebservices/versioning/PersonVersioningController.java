package com.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
	
	@GetMapping(path="v1/person")
	public Personv1 personv1() {
		return new Personv1("Bob Charlie");
	}
	
	@GetMapping(path="v2/person")
	public Personv2 personv2() {
		return new Personv2(new Name("Bob","Charlie"));
	}
}
