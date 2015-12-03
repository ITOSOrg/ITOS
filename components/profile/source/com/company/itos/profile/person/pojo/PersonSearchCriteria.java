package com.company.itos.profile.person.pojo;

import java.sql.Date;

/**
 * @author vaish
 *
 */
public class PersonSearchCriteria {

	private String	firstName;

	private String	middleName;

	private String	lastName;

	private Date	dateOfBirth;

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

	public Date getDateOfBirth() {

		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {

		this.dateOfBirth = dateOfBirth;
	}

}
