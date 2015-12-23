CREATE TABLE Person ( 
	personID NUMBER(10) NOT NULL,
	title VARCHAR2(30),
	firstName VARCHAR2(15),
	middleName VARCHAR2(30),
	lastName VARCHAR2(15), 
	fullName VARCHAR2(60),
	gender VARCHAR2(10),
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
	createdBy varchar2(35),
	createdOn timestamp(6),
	modifiedBy varchar2(35),
	modifiedOn timestamp(6),	
	versionNo NUMBER(20)
   ); 
   
CREATE TABLE Address
 ( addressId NUMBER(10) NOT NULL,
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
  ( addressLinkID NUMBER(10) NOT NULL,  
	relatedID NUMBER(10),
	addressID NUMBER(10),
	typeCode VARCHAR2(30),
	primaryInd VARCHAR2(5),
	startDate DATE,
	endDate DATE,
	recordStatus VARCHAR2(30),
	comments VARCHAR2(30),
	versionNo NUMBER(20)
	); 
   
   
CREATE TABLE EmailAddress
 ( emailAddressID NUMBER(10) NOT NULL,
   emailAddress VARCHAR2(300),
   recordStatus VARCHAR2(30),
   versionNo NUMBER(10)
   ); 

   
CREATE TABLE EmailAddressLink
( emailAddressLinkID NUMBER(10) NOT NULL,
  relatedID NUMBER(10),
  emailAddressID NUMBER(10),
  typeCode VARCHAR2(30),
  primaryInd VARCHAR2(20),
  startDate DATE,
  endDate DATE,
  comments VARCHAR2(30),
  recordStatus VARCHAR2(30),
  versionNo NUMBER(20)
  ); 
  
  
CREATE TABLE PhoneNumber
( phoneNumberID NUMBER(10) NOT NULL,
  countryCode VARCHAR2(30),
  areaCode VARCHAR2(30),
  phoneNumber VARCHAR2(30),
  extension VARCHAR2(30),
  recordStatus VARCHAR2(30),
  versionNo NUMBER(10)
  );
  
  
CREATE TABLE PhoneNumberLink
( phoneNumberLinkID NUMBER(10),
  relatedID NUMBER(10),
  phoneNumberID NUMBER(10),
  typeCode VARCHAR2(30),
  primaryInd VARCHAR2(20),
  startDate DATE,
  endDate DATE,
  comments VARCHAR2(30),
  recordStatus VARCHAR2(30),
  versionNo NUMBER(20)
  );
  
CREATE TABLE PersonIdentity
( personIdentityID NUMBER(10) NOT NULL,
  personID Number(10),
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
  relatedID NUMBER(10),
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
( userRoleLinkID NUMBER(10) NOT NULL,
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
   authenticationLogID NUMBER(10) NOT NULL,
   username VARCHAR2(30),
   timeEntered DATE,
   loginStatus VARCHAR2(30),
   versionNo NUMBER(10)
   );
   
CREATE TABLE SecurityQuestion
   (
   securityQuestionID NUMBER(10) NOT NULL,
   question VARCHAR2(300),
   type VARCHAR2(30),
   recordStatus VARCHAR2(30),
   versionNo NUMBER(10)
   );
   
CREATE TABLE UserSecurityQuestion
   (
   userSecurityQuestionID NUMBER(10) NOT NULL,
   securityQuestionID NUMBER(10),
   userName VARCHAR2(30),
   startDate DATE,
   endDate DATE,
   recordStatus VARCHAR2(30),
   versionNo NUMBER(10)
   );
   

   
