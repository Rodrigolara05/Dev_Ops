CREATE DATABASE emotelprod CHARACTER SET utf8 COLLATE utf8_general_ci;
use emotelprod;
CREATE USER 'emotelproduser' IDENTIFIED BY 'emotelprodpass';
GRANT ALL ON emotelprod.* TO 'emotelproduser'@'%' IDENTIFIED BY 'emotelprodpass';
GRANT ALL ON emotelprod.* TO 'emotelproduser'@'localhost' IDENTIFIED BY 'emotelprodpass';
FLUSH PRIVILEGES;
