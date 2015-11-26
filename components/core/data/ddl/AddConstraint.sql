--          forein key range= FK__2101 to FK_2150

-- Define Table Primary Key, Foreign Key, Indexes etc.
-- PROPERTIES Table
ALTER TABLE PROPERTIES ADD CONSTRAINT PROPERTIES PRIMARY KEY(propertyID);

ALTER TABLE CodeTableHeader ADD CONSTRAINT CodeTableHeader PRIMARY KEY(tableName);

ALTER TABLE CodeTableItem ADD CONSTRAINT CodeTableItem PRIMARY KEY(tableName,code);