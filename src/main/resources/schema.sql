DROP TABLE IF EXISTS TBL_DEVICES;
 
CREATE TABLE TBL_DEVICES (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  device_name VARCHAR(250) NOT NULL,
  location VARCHAR(250) DEFAULT NULL
);