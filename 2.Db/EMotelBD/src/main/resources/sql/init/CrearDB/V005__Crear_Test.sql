CREATE DATABASE emoteltest CHARACTER SET utf8 COLLATE utf8_general_ci;
use emoteltest;
CREATE USER 'emoteltestuser' IDENTIFIED BY 'emoteltestpass';
GRANT ALL ON emoteltest.* TO 'emoteltestuser'@'%' IDENTIFIED BY 'emoteltestpass';
GRANT ALL ON emoteltest.* TO 'emoteltestuser'@'localhost' IDENTIFIED BY 'emoteltestpass';
FLUSH PRIVILEGES;