--------------------------------------------------------
--  File created - Friday-February-15-2013   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table PERSON
--------------------------------------------------------


INSERT INTO Person (personID, title,  firstName,  middleName,	    lastName,    fullName,                     gender,   dateOfBirth,                        comments,  registrationDate,  					refrenceNumber,  userName, primaryAddressID, primaryEmailAddressID, primaryAlternateID, primaryPhoneNumberID, 		recordStatus, 	createdBy, 		createdOn,  							modifiedBy, 	 modifiedOn,							versionNo) 
			 VALUES(	 101, 'Mr',	   'Rahul',   'Vinayakrao', 	'Khandekar', 'Rahul Vinayakrao Khandekar',  'Male',   to_date('26-Jun-90', 'DD-MON-RR'), 'comment',  to_date('01-Jan-15', 'DD-MON-RR'), 			1,	 'rahulk',				0,               0,					0,				0,	               		'Active', 		'Rahul',     	to_date('01-Jan-15', 'DD-MON-RR'),		'Rahul',		 to_date('01-Jan-15', 'DD-MON-RR'),				1);


INSERT INTO Person (personID, title,  firstName,  middleName,	    lastName,    fullName,                     gender,   dateOfBirth,                        comments,  registrationDate,    				refrenceNumber,  userName, 	primaryAddressID, primaryEmailAddressID, primaryAlternateID, primaryPhoneNumberID, 		recordStatus,  	createdBy, 		createdOn,  							modifiedBy, 	 modifiedOn,							versionNo) 
			 VALUES(	 102, 'Mr',	   'Amar',   'B', 				'Bose', 	'Amar B Bose',  				'Male',   to_date('01-Jun-80', 'DD-MON-RR'), 'comment',  to_date('01-Jan-15', 'DD-MON-RR'), 			2,		'amarb',		0,               0,					0,					0,	           			 'Active',		'Rahul',    	to_date('01-Jan-15', 'DD-MON-RR'),			'Rahul',	 to_date('01-Jan-15', 'DD-MON-RR'),				1);

INSERT INTO Person (personID, title,  firstName,  middleName,	    lastName,    fullName,                     gender,   dateOfBirth,                        comments,  registrationDate,                   refrenceNumber,  userName,		primaryAddressID, primaryEmailAddressID, primaryAlternateID, primaryPhoneNumberID, 	recordStatus, 	createdBy, 		createdOn,  							modifiedBy, 	 modifiedOn,							versionNo) 
			 VALUES(	 103, 'Mr',	   'James',   'B', 				'Bond', 	'James B Bond',  				'Male',   to_date('01-Jun-80', 'DD-MON-RR'), 'comment',  to_date('01-Jan-15', 'DD-MON-RR'), 			3,		'jamesb',			0,               0,					0,					0,	           		 'Active',		'Rahul',     	to_date('01-Jan-15', 'DD-MON-RR'),			'Rahul',	 to_date('01-Jan-15', 'DD-MON-RR'),				1);

