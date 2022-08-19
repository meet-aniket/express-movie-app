package com.movie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "director")
public class Director {
	@Id
	@Column(name = "director_id")
	private Integer director_id;
	private String first_name;
	private String last_name;
	private String address;
	private Long contact_number;
	private String email;
	
	public Director() {}
	
	public Director(Integer directorId, String firstName, String lastName, String address, Long contactNumber, String email) {
		super();
		this.director_id = directorId;
		this.first_name = firstName;
		this.last_name = lastName;
		this.address = address;
		this.contact_number = contactNumber;
		this.email = email;
	}

	public Integer getDirector_id() {
		return director_id;
	}

	public void setDirector_id(Integer director_id) {
		this.director_id = director_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getContact_number() {
		return contact_number;
	}

	public void setContact_number(Long contact_number) {
		this.contact_number = contact_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
