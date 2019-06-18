CREATE DATABASE emoteldev CHARACTER SET utf8 COLLATE utf8_general_ci;
use emoteldev;
CREATE USER 'emoteldevuser' IDENTIFIED BY 'emoteldevpass';
GRANT ALL ON emoteldev.* TO 'emoteldevuser'@'%' IDENTIFIED BY 'emoteldevpass';
GRANT ALL ON emoteldev.* TO 'emoteldevuser'@'localhost' IDENTIFIED BY 'emoteldevpass';
FLUSH PRIVILEGES;