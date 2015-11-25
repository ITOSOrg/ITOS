
-- Application Core Table Create SQL


CREATE TABLE PROPERTIES (	
   	"PROPERTYID" NUMBER(19,0) NOT NULL, 
	"CATEGORY" VARCHAR2(10 BYTE), 
	"NAME" VARCHAR2(254 BYTE), 
	"VALUE" VARCHAR2(100 BYTE), 
	"TYPE" VARCHAR2(10 BYTE), 
	"DEFAULTVALUE" VARCHAR2(100 BYTE), 
	"DYNAMIC" CHAR(1 BYTE) NOT NULL, 
	"VERSIONNO" NUMBER(*,0) NOT NULL
);

CREATE TABLE CodeTableHeader
(	tableName CHARACTER(100) not null,
	defaultCode CHARACTER(40), 
	parentCodeTable CHARACTER(100), 
	comments VARCHAR(100),
	recordStatus VARCHAR2(30),	
	createdBy varchar2(35),
	createdOn timestamp(6),
	lastModifiedBy varchar2(35),
	lastModifiedOn timestamp(6),
	versionNo INT not null 

);




CREATE TABLE CodeTableItem
(	tableName CHARACTER(100) not null, 
	code CHARACTER(40) not null, 
	description VARCHAR(100), 
	annotation VARCHAR(100), 
	isEnabled CHARACTER(1) not null, 
	sortorder INT , 
	parentCode CHARACTER(40), 
	comments VARCHAR(100),
	recordStatus VARCHAR2(30),	
	createdBy varchar2(35),
	createdOn TIMESTAMP,
	lastModifiedBy varchar2(35),
	lastModifiedOn TIMESTAMP, 
	versionNo INT not null
);

CREATE TABLE CodeTableHierarchy
(	
	hierarchyName CHARACTER(100) not null, 
	description VARCHAR(100), 
	CodeTable CHARACTER(100), 
	recordStatus VARCHAR2(30),	
	createdBy varchar2(35),
	createdOn timestamp(6),
	modifiedBy varchar2(35),
	modifiedOn timestamp(6),
	versionNo INT not null
);

	--LOCALEIDENTIFIER CHARACTER(20) not null, 
           
		   
		   --LASTWRITTEN TIMESTAMP

