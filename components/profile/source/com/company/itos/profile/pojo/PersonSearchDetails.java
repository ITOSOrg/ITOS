package com.company.itos.profile.pojo;

public class PersonSearchDetails {

	private PersonSearchCriteria	personSearchCriteria	= null;

	private PersonSearchResult		personSearchResult		= null;
	
	private String errorMessage;

	public PersonSearchCriteria getPersonSearchCriteria() {

		return personSearchCriteria;
	}

	public void setPersonSearchCriteria(PersonSearchCriteria personSearchCriteria) {

		this.personSearchCriteria = personSearchCriteria;
	}

	public PersonSearchResult getPersonSearchResult() {

		return personSearchResult;
	}

	public void setPersonSearchResult(PersonSearchResult personSearchResult) {

		this.personSearchResult = personSearchResult;
	}

	
	public String getErrorMessage() {
	
		return errorMessage;
	}

	
	public void setErrorMessage(String errorMessage) {
	
		this.errorMessage = errorMessage;
	}

	
	

}
