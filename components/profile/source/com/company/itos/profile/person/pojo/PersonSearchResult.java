package com.company.itos.profile.person.pojo;

import java.util.ArrayList;
import java.util.List;

import com.company.itos.profile.person.pojo.PersonDetail;

public class PersonSearchResult {

	List<PersonDetail>	personDetailList	= new ArrayList<PersonDetail>();

	Long				numberOfPerson;

	public List<PersonDetail> getPersonDetailList() {

		return personDetailList;
	}

	public void setPersonDetailList(List<PersonDetail> personDetailList) {

		this.personDetailList = personDetailList;
	}

	public Long getNumberOfPerson() {

		return numberOfPerson;
	}

	public void setNumberOfPerson(Long numberOfPerson) {

		this.numberOfPerson = numberOfPerson;
	}

}
