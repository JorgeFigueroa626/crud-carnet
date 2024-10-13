create database db_crud_carnet;
use db_crud_carnet;

select *from country;
insert into country value(1, 'Bolvia');
insert into country value(2, 'Argentina');
insert into country value(3, 'Uruguay');
insert into country value(4, 'MEXICO');

select * from city;
insert into city value(1, 'Santa Cruz', 1);
insert into city value(2, 'Beni', 1);
insert into city value(3, 'Buenos Aire', 2);
insert into city value(4, 'Cordaba', 2);
insert into city value(5, 'Montevideo', 3);
insert into city value(6, 'Rivera', 3);

select *from user;
insert into user value(1, '2 anillo', 12345678, '2000-10-13', '2024-10-13', 'Rogridez Paz', 'SOLTERO','Lucas Luis', 1, 1);
insert into user value(2, '3 anillo', 12345677, '2000-10-13', '2024-10-13', 'Luna Torrico', 'SOLTERA','Martha', 2, 1);
insert into user value(3, '4 anillo', 12345676, '2000-10-13', '2024-10-13', 'Duran Sandoval', 'CASADO','Lucas Luis', 3, 2);
insert into user value(4, '5 anillo', 12345675, '2000-10-13', '2024-10-13', 'Burgos Mendez', 'CASADO','Lucio Juan', 4, 2);
insert into user value(5, '6 anillo', 12345674, '2000-10-13', '2024-10-13', 'Sianca Colque', 'CASADO','Justo Luis', 5, 3);
insert into user value(6, '7 anillo', 12345673, '2000-10-13', '2024-10-13', 'Rosca Soliz', 'CASADA','Maria', 6, 3);
