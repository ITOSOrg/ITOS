-- ############################################################################
-- #
-- # This creates new user in oracle database
-- # Before using this check a few of the settings
-- # - Tablespace names
-- # - Tablespace datafile path
-- #
-- # IMPORTANT: this is processed by ANT, so any ${...} elements will be
-- #  replaced with the value of the ANT variable at run time.
-- #
-- ############################################################################

CREATE 
	TABLESPACE ${db.oracle.default.tablespace} 
	DATAFILE '${db.oracle.tablespace.datafile.path.name}' size 100M;
