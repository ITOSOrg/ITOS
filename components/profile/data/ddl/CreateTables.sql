CREATE TABLE Person ( 
	personID NUMBER(19,0) NOT NULL,
	title VARCHAR2(30),
	firstName VARCHAR2(15),
	middleName VARCHAR2(30),
	lastName VARCHAR2(15), 
	fullName VARCHAR2(60),
	gender VARCHAR2(50),
	dateOfBirth DATE, 
	comments VARCHAR2(500),
	registrationDate DATE,
	refrenceNumber varchar2(15),
	userName VARCHAR2(15), --NOT NULL,
	primaryAddressID NUMBER(10),
	primaryEmailAddressID NUMBER(10),
	primaryAlternateID NUMBER(10),
	primaryPhoneNumberID NUMBER(15),
	recordStatus VARCHAR2(30),	
	versionNo NUMBER(20)
   ); 
   
CREATE TABLE Address
 ( addressId NUMBER(19,0) NOT NULL,
   streetOne VARCHAR2(30),
   streetTwo VARCHAR2(30),
   aptUnit VARCHAR2(30),
   city VARCHAR2(30),
   county VARCHAR2(30),
   state VARCHAR2(30),
   country VARCHAR2(30),
   zipCode NUMBER(10),
   versionNo NUMBER(20)
   ); 
   
   
CREATE TABLE AddressLink
  ( addressLinkID NUMBER(19,0) NOT NULL,  
	relatedID NUMBER(19,0),
	addressID NUMBER(19,0),
	typeCode VARCHAR2(30),
	primaryInd VARCHAR2(5),
	startDate DATE,
	endDate DATE,
	recordStatus VARCHAR2(30),
	comments VARCHAR2(30),
	versionNo NUMBER(20)
	); 
   
   
CREATE TABLE EmailAddress
 ( emailAddressID NUMBER(19,0) NOT NULL,
   emailAddress VARCHAR2(300),
   recordStatus VARCHAR2(30),
   versionNo NUMBER(10)
   ); 

   
CREATE TABLE EmailAddressLink
( emailAddressLinkID NUMBER(19,0) NOT NULL,
  relatedID NUMBER(19,0),
  emailAddressID NUMBER(19,0),
  typeCode VARCHAR2(30),
  primaryInd VARCHAR2(20),
  startDate DATE,
  endDate DATE,
  comments VARCHAR2(30),
  recordStatus VARCHAR2(30),
  versionNo NUMBER(20)
  ); 
  
  
CREATE TABLE PhoneNumber
( phoneNumberID NUMBER(19,0) NOT NULL,
  countryCode VARCHAR2(30),
  areaCode VARCHAR2(30),
  phoneNumber VARCHAR2(30),
  extension VARCHAR2(30),
  recordStatus VARCHAR2(30),
  versionNo NUMBER(10)
  );
  
  
CREATE TABLE PhoneNumberLink
( phoneNumberLinkID NUMBER(19,0),
  relatedID NUMBER(19,0),
  phoneNumberID NUMBER(19,0),
  typeCode VARCHAR2(30),
  primaryInd VARCHAR2(20),
  startDate DATE,
  endDate DATE,
  comments VARCHAR2(30),
  recordStatus VARCHAR2(30),
  versionNo NUMBER(20)
  );
  
CREATE TABLE PersonIdentity
( personIdentityID NUMBER(19,0) NOT NULL,
  personID Number(19,0),
  alternateID VARCHAR2(30),
  primaryInd VARCHAR2(30),
  typeCode VARCHAR2(30),
  startDate DATE,
  endDate DATE,
  comments VARCHAR2(30),
  recordStatus VARCHAR2(30),
  versionNo NUMBER(20)
);
  
CREATE TABLE Users
( userName VARCHAR2(15) NOT NULL,
  relatedID NUMBER(19,0),
  password VARCHAR2(80),
  accountEnabled VARCHAR2(30),
  loginFailureCount NUMBER(20),
  creationDate DATE,
  passwordExpiryDate DATE,
  userWorkspace VARCHAR2(30),
  recordStatus VARCHAR2(30),
  versionNo NUMBER(20)
  );

CREATE TABLE UserRoleLink
( userRoleLinkID NUMBER(19,0) NOT NULL,
  username VARCHAR2(30),
  roleID NUMBER(10),
  startDate timestamp(6),
  endDate DATE,
  comments VARCHAR2(30),
  recordStatus VARCHAR2(30),
  versionNo NUMBER(20)
  );  
  
  
    

   
CREATE TABLE AuthenticationLog
   (
   authenticationLogID NUMBER(19,0) NOT NULL,
   username VARCHAR2(30),
   timeEntered DATE,
   loginStatus VARCHAR2(30),
   versionNo NUMBER(10)
   );
   
CREATE TABLE SecurityQuestion
   (
   securityQuestionID NUMBER(19,0) NOT NULL,
   question VARCHAR2(300),
   type VARCHAR2(30),
   recordStatus VARCHAR2(30),
   versionNo NUMBER(10)
   );
   
CREATE TABLE UserSecurityQuestion
   (
   userSecurityQuestionID NUMBER(19,0) NOT NULL,
   securityQuestionID NUMBER(10),
   userName VARCHAR2(30),
   startDate DATE,
   endDate DATE,
   recordStatus VARCHAR2(30),
   versionNo NUMBER(10)
   );
   

   
