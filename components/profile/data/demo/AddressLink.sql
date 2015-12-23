--------------------------------------------------------
--  File created - 02-19-2013   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table AddressLink
--------------------------------------------------------

INSERT INTO AddressLink (addressLinkID ,	relatedID ,	addressID ,		typeCode ,		primaryInd ,	startDate ,							endDate ,	recordStatus ,	comments )
				VALUES ( 301,     			101,			201,			'Primary',	  		'True',			to_date('01-jan-13', 'DD-MON-RR'),	null,		'Active',		'comment');

				
INSERT INTO AddressLink (addressLinkID ,	relatedID ,	addressID ,		typeCode ,		primaryInd ,	startDate ,							endDate ,	recordStatus ,	comments )
				VALUES ( 302,     			102,			202,		'Primary',	  		'True',		to_date('01-jan-15', 'DD-MON-RR'),	null,		'Active',		'comment');