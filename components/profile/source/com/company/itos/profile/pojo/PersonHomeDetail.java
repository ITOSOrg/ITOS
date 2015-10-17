
 

package com.company.itos.profile.pojo;


/**
 * @author vaish
 *
 */
public class PersonHomeDetail {
	private String street1;
	private String street2;
	private String city;
	private String state;
	private String country;
	private int zipCode;
	private String type;
	private String email;
	private int countryCode;
	private int areaCode;
	private int extension;
	private PersonDetail personDetail=null;
	
	public String getStreet1() {
	
		return street1;
	}
	
	public void setStreet1(String street1) {
	
		this.street1 = street1;
	}
	
	public String getStreet2() {
	
		return street2;
	}
	
	public void setStreet2(String street2) {
	
		this.street2 = street2;
	}
	
	public String getCity() {
	
		return city;
	}
	
	public void setCity(String city) {
	
		this.city = city;
	}
	
	public String getState() {
	
		return state;
	}
	
	public void setState(String state) {
	
		this.state = state;
	}
	
	public String getCountry() {
	
		return country;
	}
	
	public void setCountry(String country) {
	
		this.country = country;
	}
	
	public int getZipCode() {
	
		return zipCode;
	}
	
	public void setZipCode(int zipCode) {
	
		this.zipCode = zipCode;
	}
	
	public String getType() {
	
		return type;
	}
	
	public void setType(String type) {
	
		this.type = type;
	}
	
	public String getEmail() {
	
		return email;
	}
	
	public void setEmail(String email) {
	
		this.email = email;
	}
	
	public int getCountryCode() {
	
		return countryCode;
	}
	
	public void setCountryCode(int countryCode) {
	
		this.countryCode = countryCode;
	}
	
	public int getAreaCode() {
	
		return areaCode;
	}
	
	public void setAreaCode(int areaCode) {
	
		this.areaCode = areaCode;
	}
	
	public int getExtension() {
	
		return extension;
	}
	
	public void setExtension(int extension) {
	
		this.extension = extension;
	}

	
	public PersonDetail getPersonDetail() {
	
		return personDetail;
	}

	
	public void setPersonDetail(PersonDetail personDetail) {
	
		this.personDetail = personDetail;
	}
	

}
