--------------------------------------------------------
--  File created - 02-19-2013   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table ROLE
--------------------------------------------------------

INSERT INTO Role(roleID,   roleType,     workspace,        recordStatus, 	createdBy, 		createdOn, 							lastModifiedBy, 	lastModifiedOn,  versionNo)
          VALUES(9001,		'Admin',   'Admin_Workspace',  'Active',		 'Rahul',  		to_date('01-Jan-15', 'DD-MON-RR'),	  'Rahul',				null,				 1);
 
         
INSERT INTO Role(roleID,   roleType,         workspace,   			recordStatus, 		createdBy, 		createdOn, 								lastModifiedBy, lastModifiedOn,  versionNo)
          VALUES(9002,	   'Employee',	'Employee_Workspace',			'Active',		'Rahul',		to_date('01-Jan-15', 'DD-MON-RR'),		'Rahul',	   		null,				 1);

          
INSERT INTO Role(roleID,    roleType, 		workspace,   			recordStatus,		 createdBy, 	createdOn, 								lastModifiedBy, lastModifiedOn,  versionNo)
          VALUES(9003,		'Devloper',		'Devloper_Workspace',	'Active',			 'Rahul',		to_date('01-Jan-15', 'DD-MON-RR'),			'Rahul',   			null,			 1);
          