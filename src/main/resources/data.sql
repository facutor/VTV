use pruebatecnica;
INSERT INTO `pruebatecnica`.`duenios` VALUES(1, 'Torrez',sysdate(),35855188,'Facundo',0,sysdate());
INSERT INTO `pruebatecnica`.`duenios` VALUES(2,'Rivera',sysdate(),41667739,'Tomas',1,sysdate());
INSERT INTO `pruebatecnica`.`duenios` VALUES(3,'Zorrilla',sysdate(),44568979,'Hectot',0,sysdate());
INSERT INTO `pruebatecnica`.`duenios` VALUES(4,'Medrano',sysdate(),45855188,'Elias',0,sysdate());
INSERT INTO `pruebatecnica`.`duenios` VALUES(5,'Torrez',sysdate(),35551188,'Camila',0,sysdate());
INSERT INTO `pruebatecnica`.`duenios` VALUES(6,'Rodriguez',sysdate(),28552188,'Luis',0,sysdate());
INSERT INTO `pruebatecnica`.`duenios` VALUES(7,'Perez',sysdate(),35875188,'Luciano',0,sysdate());
INSERT INTO `pruebatecnica`.`duenios` VALUES(8,'Soler',sysdate(),25955188,'Fernando',0,sysdate());

INSERT INTO `pruebatecnica`.`vehiculos` VALUES(1,sysdate(),'RES543','Toyota','Corolla',sysdate(),1);
INSERT INTO `pruebatecnica`.`vehiculos` VALUES(2,sysdate(),'AES563','Toyota','Etios',sysdate(),2);
INSERT INTO `pruebatecnica`.`vehiculos` VALUES(3,sysdate(),'BE2543','Fiat','Uno',sysdate(),3);
INSERT INTO `pruebatecnica`.`vehiculos` VALUES(4,sysdate(),'TES541','Peugeot','308',sysdate(),4);
INSERT INTO `pruebatecnica`.`vehiculos` VALUES(5,sysdate(),'DET543','Renault','Duster',sysdate(),5);
INSERT INTO `pruebatecnica`.`vehiculos` VALUES(6,sysdate(),'PES542','Volkswagen','Gol',sysdate(),6);
INSERT INTO `pruebatecnica`.`vehiculos` VALUES(7,sysdate(),'PES512','Frod','Fiesta',sysdate(),6);
INSERT INTO `pruebatecnica`.`vehiculos` VALUES(8,sysdate(),'YES592','Honda','Civic',sysdate(),2);
INSERT INTO `pruebatecnica`.`vehiculos` VALUES(9,sysdate(),'PEST92','Hyundai','Creta',sysdate(),3);
INSERT INTO `pruebatecnica`.`vehiculos` VALUES(10,sysdate(),'UES542','Citroen','Berlingo',sysdate(),4);
INSERT INTO `pruebatecnica`.`vehiculos` VALUES(11,sysdate(),'JPS591','Peugeot','408',sysdate(),1);

INSERT INTO `pruebatecnica`.`inspectors` VALUES(1, 'Carniglia',sysdate(),51287971,'Nicolas',sysdate());
INSERT INTO `pruebatecnica`.`inspectors` VALUES(2, 'Perez',sysdate(),61287971,'Daniel',sysdate());
INSERT INTO `pruebatecnica`.`inspectors` VALUES(3, 'Roldan',sysdate(),41247971,'Ernesto',sysdate());
INSERT INTO `pruebatecnica`.`inspectors` VALUES(4, 'Salvatierra',sysdate(),41187971,'Maria',sysdate());
INSERT INTO `pruebatecnica`.`inspectors` VALUES(5, 'Gonzales',sysdate(),41287871,'Marcelo',sysdate());

INSERT INTO `pruebatecnica`.`vehiculos_inspectores` VALUES(1,sysdate(),2,2,2,sysdate(),100,1,1);
INSERT INTO `pruebatecnica`.`vehiculos_inspectores` VALUES(2,sysdate(),0,0,0,sysdate(),100,3,1);
INSERT INTO `pruebatecnica`.`vehiculos_inspectores` VALUES(3,sysdate(),0,0,0,sysdate(),100,3,2);
INSERT INTO `pruebatecnica`.`vehiculos_inspectores` VALUES(4,sysdate(),0,0,0,sysdate(),100,1,3);
INSERT INTO `pruebatecnica`.`vehiculos_inspectores` VALUES(5,sysdate(),2,2,0,sysdate(),100,1,4);
INSERT INTO `pruebatecnica`.`vehiculos_inspectores` VALUES(6,sysdate(),0,0,0,sysdate(),100,2,4);
INSERT INTO `pruebatecnica`.`vehiculos_inspectores` VALUES(7,sysdate(),2,2,2,sysdate(),100,2,5);
INSERT INTO `pruebatecnica`.`vehiculos_inspectores` VALUES(8,sysdate(),0,0,0,sysdate(),100,3,5);
INSERT INTO `pruebatecnica`.`vehiculos_inspectores` VALUES(9,sysdate(),2,0,2,sysdate(),100,3,6);
INSERT INTO `pruebatecnica`.`vehiculos_inspectores` VALUES(10,sysdate(),0,0,0,sysdate(),100,4,6);
INSERT INTO `pruebatecnica`.`vehiculos_inspectores` VALUES(11,sysdate(),2,2,2,sysdate(),100,4,7);
INSERT INTO `pruebatecnica`.`vehiculos_inspectores` VALUES(12,sysdate(),0,0,0,sysdate(),100,4,7);
INSERT INTO `pruebatecnica`.`vehiculos_inspectores` VALUES(13,sysdate(),1,1,0,sysdate(),100,5,8);
INSERT INTO `pruebatecnica`.`vehiculos_inspectores` VALUES(14,sysdate(),0,0,0,sysdate(),100,5,9);
INSERT INTO `pruebatecnica`.`vehiculos_inspectores` VALUES(15,sysdate(),1,0,1,sysdate(),100,1,10);
INSERT INTO `pruebatecnica`.`vehiculos_inspectores` VALUES(16,sysdate(),0,0,0,sysdate(),100,5,11);

