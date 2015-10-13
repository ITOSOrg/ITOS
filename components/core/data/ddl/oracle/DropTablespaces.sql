-- ############################################################################
-- #
-- # This file drops default tablespace including contents from oracle database
-- # Before using this check a few of the settings
-- # - database default tablespace name
-- # - 
-- #
-- # IMPORTANT: this is processed by ANT, so any ${...} elements will be
-- # replaced with the value of the ANT variable at run time.
-- #
-- ############################################################################

DROP 
	TABLESPACE ${db.oracle.default.tablespace} 
	INCLUDING CONTENTS;
