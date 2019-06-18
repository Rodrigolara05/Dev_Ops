USE `emoteltest`;

#TABLE provincia
INSERT INTO provincia (nombre) VALUES ("Lima");
INSERT INTO provincia (nombre) VALUES ("Barranca");
INSERT INTO provincia (nombre) VALUES ("Cajatambo");
INSERT INTO provincia (nombre) VALUES ("Canta");
INSERT INTO provincia (nombre) VALUES ("Cañete");
INSERT INTO provincia (nombre) VALUES ("Huaral");
INSERT INTO provincia (nombre) VALUES ("Huarochiri");
INSERT INTO provincia (nombre) VALUES ("Huaura");
INSERT INTO provincia (nombre) VALUES ("Oyón");
INSERT INTO provincia (nombre) VALUES ("Yauyos");



#TABLE distrito
INSERT INTO distrito (nombre, provincia_id) VALUES ("ANCÓN", 1);
INSERT INTO distrito (nombre, provincia_id) VALUES ("BARRANCO", 1);
INSERT INTO distrito (nombre, provincia_id) VALUES ("CHORRILLOS", 1);
INSERT INTO distrito (nombre, provincia_id) VALUES ("EL AGUSTINO", 1);
INSERT INTO distrito (nombre, provincia_id) VALUES ("INDEPENDENCIA", 1);
INSERT INTO distrito (nombre, provincia_id) VALUES ("JESÚS MARÍA", 1);
INSERT INTO distrito (nombre, provincia_id) VALUES ("LIMA", 1);
INSERT INTO distrito (nombre, provincia_id) VALUES ("MIRAFLORES", 1);
INSERT INTO distrito (nombre, provincia_id) VALUES ("PUNTA HERMOSA", 1);
INSERT INTO distrito (nombre, provincia_id) VALUES ("RÍMAC", 1);
INSERT INTO distrito (nombre, provincia_id) VALUES ("SAN ISIDRO", 1);
INSERT INTO distrito (nombre, provincia_id) VALUES ("SAN MIGUEL", 1);
INSERT INTO distrito (nombre, provincia_id) VALUES ("VILLA EL SALVADOR", 1);

INSERT INTO distrito (nombre, provincia_id) VALUES ("BARRANCA", 2);
INSERT INTO distrito (nombre, provincia_id) VALUES ("PATIVILCA", 2);
INSERT INTO distrito (nombre, provincia_id) VALUES ("SUPE", 2);
INSERT INTO distrito (nombre, provincia_id) VALUES ("SUPE PUERTO", 2);

INSERT INTO distrito (nombre, provincia_id) VALUES ("CAJATAMBO", 3);
INSERT INTO distrito (nombre, provincia_id) VALUES ("GORGOR", 3);
INSERT INTO distrito (nombre, provincia_id) VALUES ("HUANCAPON", 3);
INSERT INTO distrito (nombre, provincia_id) VALUES ("MANAS", 3);

INSERT INTO distrito (nombre, provincia_id) VALUES ("ARAHUAY", 4);
INSERT INTO distrito (nombre, provincia_id) VALUES ("CANTA", 4);
INSERT INTO distrito (nombre, provincia_id) VALUES ("HUAROS", 4);
INSERT INTO distrito (nombre, provincia_id) VALUES ("LACHAQUI", 4);

INSERT INTO distrito (nombre, provincia_id) VALUES ("ASIA", 5);
INSERT INTO distrito (nombre, provincia_id) VALUES ("LUNAHUANÁ", 5);
INSERT INTO distrito (nombre, provincia_id) VALUES ("SAN LUIS", 5);
INSERT INTO distrito (nombre, provincia_id) VALUES ("ZUÑIGA", 5);

INSERT INTO distrito (nombre, provincia_id) VALUES ("CHANCAY", 6);
INSERT INTO distrito (nombre, provincia_id) VALUES ("HUARAL", 6);
INSERT INTO distrito (nombre, provincia_id) VALUES ("LAMPIAN", 6);
INSERT INTO distrito (nombre, provincia_id) VALUES ("SUMBILCA", 6);

INSERT INTO distrito (nombre, provincia_id) VALUES ("ANTIOQUIA", 7);
INSERT INTO distrito (nombre, provincia_id) VALUES ("CHICLA", 7);
INSERT INTO distrito (nombre, provincia_id) VALUES ("LARAOS", 7);
INSERT INTO distrito (nombre, provincia_id) VALUES ("SAN MATEO", 7);

INSERT INTO distrito (nombre, provincia_id) VALUES ("AMBAR", 8);
INSERT INTO distrito (nombre, provincia_id) VALUES ("HUACHO", 8);
INSERT INTO distrito (nombre, provincia_id) VALUES ("HUAURA", 8);
INSERT INTO distrito (nombre, provincia_id) VALUES ("VÉGUETA", 8);

INSERT INTO distrito (nombre, provincia_id) VALUES ("ANDAJES", 9);
INSERT INTO distrito (nombre, provincia_id) VALUES ("CAUJUL", 9);
INSERT INTO distrito (nombre, provincia_id) VALUES ("NAVAN", 9);
INSERT INTO distrito (nombre, provincia_id) VALUES ("OYON", 9);

INSERT INTO distrito (nombre, provincia_id) VALUES ("CATAHUASI", 10);
INSERT INTO distrito (nombre, provincia_id) VALUES ("HONGOS", 10);
INSERT INTO distrito (nombre, provincia_id) VALUES ("MADEAN", 10);
INSERT INTO distrito (nombre, provincia_id) VALUES ("YAUYOS", 10);



#TABLE rol
INSERT INTO rol (nombre) VALUES ("admin");
INSERT INTO rol (nombre) VALUES ("usuario");



#TABLE usuario
INSERT INTO usuario (nombre, apellido, correo, fecha, password, rol_id) VALUES ("Admin", "Admin", "admin@gmail.com", '1990/06/15', "password", 1);
INSERT INTO usuario (nombre, apellido, correo, fecha, password, rol_id) VALUES ("test", "test", "test@gmail.com", '2000/01/15', "test", 2);



#TABLE tipohotel
INSERT INTO tipohotel (nombre, descripcion) VALUES ("ECONOMICO", "Hoteles comodos a precios bajos");
INSERT INTO tipohotel (nombre, descripcion) VALUES ("VIP", "Hoteles de lujo para tu comodidad");



#TABLE hotel
INSERT INTO hotel (nombre, precio, ubicacion, tipohotel_id, distritos_id) VALUES ("MIRAMAR", 50.00, "Nueva 760", 1, 1);
INSERT INTO hotel (nombre, precio, ubicacion, tipohotel_id, distritos_id) VALUES ("WARI HOTEL", 114.00, "Av. Miguel Grau 723", 2, 2);
INSERT INTO hotel (nombre, precio, ubicacion, tipohotel_id, distritos_id) VALUES ("UNSHA HOSTEL", 56.00, "Montero Rosas 176", 1, 3);
INSERT INTO hotel (nombre, precio, ubicacion, tipohotel_id, distritos_id) VALUES ("HOTEL LBARON", 126.00, "Campanillas 130", 2, 4);
INSERT INTO hotel (nombre, precio, ubicacion, tipohotel_id, distritos_id) VALUES ("GINEBRA HOTEL", 178.00, "Calle B", 2, 5);
INSERT INTO hotel (nombre, precio, ubicacion, tipohotel_id, distritos_id) VALUES ("MELIÁ LIMA", 364.00, "Av. Gral. Salaverry 2599", 2, 6);
INSERT INTO hotel (nombre, precio, ubicacion, tipohotel_id, distritos_id) VALUES ("HOLIDAY INN LIMA", 448.00, "Av. Tomas Valle", 2, 7);
INSERT INTO hotel (nombre, precio, ubicacion, tipohotel_id, distritos_id) VALUES ("CASA ANDINA", 456.00, "Av. la Paz 463", 2, 8);



#TABLE restaurante
INSERT INTO restaurante (nombre, precio, descripcion, ubicacion, distrito_id) VALUES ("La Quinta 615", 40.00, "Buenos Cocteles", "Av. Los hungaros 175", 1);
INSERT INTO restaurante (nombre, precio, descripcion, ubicacion, distrito_id) VALUES ("CALA", 60.00, "Asientos al aire libre", "Circuito de playas", 2);
INSERT INTO restaurante (nombre, precio, descripcion, ubicacion, distrito_id) VALUES ("Puerto Velero", 30.00, "Recomendable con niños", "Alameda los horizontes", 3);



#TABLE reserva
#### Lo pone el usuario