     -- ############################################################################
-- #
-- # This creates new user in oracle database
-- # Before using this check a few of the settings
-- # - database name
-- # - username
-- # - Default and Temporary Tablespaces
-- #
-- # IMPORTANT: this is processed by ANT, so any ${...} elements will be
-- # replaced with the value of the ANT variable at run time.
-- #
-- ############################################################################

CREATE 
	USER ${db.username} 
	IDENTIFIED BY ${db.password} 
		DEFAULT TABLESPACE ${db.oracle.default.tablespace} 
		TEMPORARY TABLESPACE ${db.oracle.temporary.tablespace}
		QUOTA UNLIMITED ON ${db.oracle.default.tablespace};
		