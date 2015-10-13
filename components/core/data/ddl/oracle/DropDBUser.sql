-- ############################################################################
-- # 
-- # This drops user in database
-- # Before using this check a few of the settings
-- # - database name
-- # - username
-- #
-- # IMPORTANT: this is processed by ANT, so any ${...} elements will 
-- # be replaced with the value of the ANT variable at run time. 
-- #  
-- ############################################################################

DROP 
	USER ${db.username} CASCADE;
