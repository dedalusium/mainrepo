CREATE TABLE FILES(
    ID int(10) unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(128),
    PATH VARCHAR(128) NOT NULL,
    UPDATE_DATE TIMESTAMP
)ENGINE=InnoDB DEFAULT CHARSET=utf8;