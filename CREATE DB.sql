/*-------Create DataBase------------*/
CREATE DATABASE app_estacionamento;
/*-------------Use DataBase---------*/
USE app_estacionamento;
/*------------Insert Admin------------*/
INSERT INTO `app_estacionamento`.`tbl_usuario` (`name`, `password`, `username`) VALUES ('admin', '123456', 'admin');
/*------------Insert Valor------------*/
INSERT INTO `app_estacionamento`.`tbl_valor` (`valor_demais_hora`, `valor_primeira_hora`) VALUES ('4', '6');



