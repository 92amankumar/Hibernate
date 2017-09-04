package com.entities;

import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "PERSON")
@Cacheable
@Cache(region = "personCache", usage = CacheConcurrencyStrategy.READ_ONLY)
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "FIRST_NAME", columnDefinition = "nvarchar2 (255)")
	private String firstName;

	@Column(name = "MIDDLE_NAME", columnDefinition = "nvarchar2 (255)")
	private String middleName;

	@Column(name = "LAST_NAME", columnDefinition = "nvarchar2 (255)")
	private String lastName;

	@Column(name = "DOB", columnDefinition = "date")
	private Date dob;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

}
