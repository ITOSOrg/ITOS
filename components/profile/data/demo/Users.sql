--------------------------------------------------------
--  File created - 02-19-2013   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table Users
--------------------------------------------------------

INSERT INTO Users( userName,    relatedID,  password,  							accountEnabled,	loginFailureCount,		 creationDate,						passwordExpiryDate, userWorkspace,	recordStatus,	versionNo	)
           VALUES( 'rahulk',	101,		'W6ph5Mm5Pz8GgiULbPgzG37mj9g=', 	'1',		    	0,					 to_date('01-Jan-15', 'DD-MON-RR'),	NULL,               'Admin',		'Active',		1			);

INSERT INTO Users( userName,    relatedID,  password,  							accountEnabled, loginFailureCount,		creationDate,						passwordExpiryDate, userWorkspace,	recordStatus,	versionNo	)
           VALUES( 'amarb',	    102,	    'W6ph5Mm5Pz8GgiULbPgzG37mj9g=', 	'1',		    	0,					to_date('01-Jan-15', 'DD-MON-RR'),	NULL,               'User',			'Active',		1			);

INSERT INTO Users( userName,    relatedID,  	password,  							accountEnabled, loginFailureCount,		creationDate,						passwordExpiryDate, userWorkspace,	recordStatus,	versionNo	)
           VALUES( 'jamesb',	    103,	    'W6ph5Mm5Pz8GgiULbPgzG37mj9g=', 	'1',		    	0,					to_date('01-Jan-15', 'DD-MON-RR'),	NULL,               'User',			'Active',		1			);