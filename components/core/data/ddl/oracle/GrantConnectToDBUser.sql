-- ############################################################################
-- # This file grant privillages to oracle user role.
-- # Before using this check a few of the settings
-- # - database name
-- # - username
-- # - custom role name
-- #
-- # IMPORTANT: this is processed by ANT, so any ${...} elements will be
-- # replaced with the value of the ANT variable at run time.
-- ############################################################################

DECLARE 

local_var number;

BEGIN
	SELECT 
		count(*) INTO local_var 
	FROM 
		DBA_ROLES 
	WHERE Role = '${db.oracle.custom.role.name}';

IF local_var > 0 THEN
	
	dbms_output.put_line ('Role ${db.oracle.custom.role.name} Already Present');

ELSE
	dbms_output.put_line ('Create New Role ${db.oracle.custom.role.name}');
	
	EXECUTE IMMEDIATE 'CREATE ROLE "${db.oracle.custom.role.name}"';
	
	EXECUTE IMMEDIATE 'GRANT EXECUTE ON DBMS_SYSTEM TO "${db.oracle.custom.role.name}"';
	EXECUTE IMMEDIATE 'GRANT CREATE VIEW  to "${db.oracle.custom.role.name}"';
	EXECUTE IMMEDIATE 'GRANT CREATE TABLE  to "${db.oracle.custom.role.name}"';
	EXECUTE IMMEDIATE 'GRANT ALTER SESSION  to "${db.oracle.custom.role.name}"';
	EXECUTE IMMEDIATE 'GRANT CREATE CLUSTER  to "${db.oracle.custom.role.name}"';
	EXECUTE IMMEDIATE 'GRANT CREATE SESSION  to "${db.oracle.custom.role.name}"';
	EXECUTE IMMEDIATE 'GRANT CREATE SYNONYM  to "${db.oracle.custom.role.name}"';
	EXECUTE IMMEDIATE 'GRANT CREATE SEQUENCE  to "${db.oracle.custom.role.name}"';
	EXECUTE IMMEDIATE 'GRANT CREATE DATABASE LINK  to "${db.oracle.custom.role.name}"';

	EXECUTE IMMEDIATE 'GRANT CONNECT, RESOURCE TO "${db.oracle.custom.role.name}"';

END IF;

END;
/

GRANT "CONNECT", "${db.oracle.custom.role.name}", UNLIMITED TABLESPACE TO ${db.username};
