package com.rest.webservices.restfulwebservices.versioning;

import org.springframework.beans.factory.annotation.Autowired;

public class Personv2 {
	
	@Autowired
	private Name name;
	
	public Personv2(Name name) {
		super();
		this.name = name;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Personv2 [name=" + name + "]";
	}
	
}
