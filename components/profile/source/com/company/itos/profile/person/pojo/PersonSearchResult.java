package com.company.itos.profile.person.pojo;

import java.util.ArrayList;
import java.util.List;

import com.company.itos.profile.person.pojo.PersonDetail;

public class PersonSearchResult {

	List<PersonDetail>	PersonDetailList	= new ArrayList<PersonDetail>();

	Long				numberOfPerson;

	public List<PersonDetail> getPersonDetailList() {

		return PersonDetailList;
	}

	public void setPersonDetailList(List<PersonDetail> personDetailList) {

		PersonDetailList = personDetailList;
	}

	public Long getNumberOfPerson() {

		return numberOfPerson;
	}

	public void setNumberOfPerson(Long numberOfPerson) {

		this.numberOfPerson = numberOfPerson;
	}

}
