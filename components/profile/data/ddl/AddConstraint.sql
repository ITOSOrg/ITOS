--          forein key range= FK__2001 to FK_2030

-- Define Table Primary Key, Foreign Key, Indexes etc.
-- Person Table
ALTER TABLE Person ADD CONSTRAINT Person PRIMARY KEY(personID);


-- Address Table
ALTER TABLE Address ADD CONSTRAINT Address PRIMARY KEY(addressID);
--ALTER TABLE Address ADD CONSTRAINT FK__2001 FOREIGN KEY (personID) REFERENCES Person(personID);
--CREATE INDEX FKccity ON Address(ccity);


-- AddressLink Table
ALTER TABLE AddressLink ADD CONSTRAINT AddressLink PRIMARY KEY(addressLinkID);
--ALTER TABLE AddressLink ADD CONSTRAINT FK__2002 FOREIGN KEY (relatedID) REFERENCES Person(personID);


-- EmailAddress Table
ALTER TABLE EmailAddress ADD CONSTRAINT  EmailAddress PRIMARY KEY(emailAddressID);


-- EmailAddressLink Table
ALTER TABLE EmailAddressLink ADD CONSTRAINT  EmailAddressLink PRIMARY KEY(EmailAddressLinkID);
--ALTER TABLE EmailAddressLink ADD CONSTRAINT FK__2003 FOREIGN KEY (relatedID) REFERENCES Person(personID);
ALTER TABLE EmailAddressLink ADD CONSTRAINT FK__2004 FOREIGN KEY (emailAddressID) REFERENCES EmailAddress(emailAddressID);


--PhoneNumber Table
ALTER TABLE PhoneNumber ADD CONSTRAINT  PhoneNumber PRIMARY KEY(phoneNumberID);


-- PhoneNumberLink Table
ALTER TABLE PhoneNumberLink ADD CONSTRAINT  PhoneNumberLink PRIMARY KEY(phoneNumberLinkID);
--ALTER TABLE PhoneNumberLink ADD CONSTRAINT FK__2005 FOREIGN KEY (relatedID) REFERENCES Person(personID);
ALTER TABLE PhoneNumberLink ADD CONSTRAINT FK__2006 FOREIGN KEY (phoneNumberID) REFERENCES PhoneNumber(phoneNumberID);


-- PersonIdentity Table
ALTER TABLE PersonIdentity ADD CONSTRAINT  PersonIdentity PRIMARY KEY(PersonIdentityID);
ALTER TABLE PersonIdentity ADD CONSTRAINT FK__2007 FOREIGN KEY (personID) REFERENCES Person(personID);


-- Users Table
ALTER TABLE Users ADD CONSTRAINT  Users PRIMARY KEY(userName);
--ALTER TABLE Users ADD CONSTRAINT FK__2008 FOREIGN KEY (relatedID) REFERENCES Person(personID);




-- UserRoleLink Table
ALTER TABLE UserRoleLink ADD CONSTRAINT  UserRoleLink PRIMARY KEY(UserRoleLinkID);
ALTER TABLE UserRoleLink ADD CONSTRAINT FK__2009 FOREIGN KEY (username) REFERENCES Users(username);
ALTER TABLE UserRoleLink ADD CONSTRAINT FK__2010 FOREIGN KEY (roleID) REFERENCES Role(roleID);


--AuthenticationLog Table
ALTER TABLE AuthenticationLog  ADD CONSTRAINT  AuthenticationLog  PRIMARY KEY(authenticationLogID);
ALTER TABLE AuthenticationLog ADD CONSTRAINT FK__2011 FOREIGN KEY (username) REFERENCES Users(username);

--SecurityQuestion Table
ALTER TABLE SecurityQuestion  ADD CONSTRAINT  SecurityQuestion  PRIMARY KEY(SecurityQuestionID);

--UserSecurityQuestion TABLE
ALTER TABLE UserSecurityQuestion  ADD CONSTRAINT  UserSecurityQuestion PRIMARY KEY(userSecurityQuestionID);
ALTER TABLE UserSecurityQuestion ADD CONSTRAINT FK__2012 FOREIGN KEY (securityQuestionID) REFERENCES SecurityQuestion(securityQuestionID);
ALTER TABLE UserSecurityQuestion ADD CONSTRAINT FK__2013 FOREIGN KEY (username) REFERENCES Users(username);

