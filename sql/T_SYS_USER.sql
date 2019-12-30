/*
SQLyog Ultimate
MySQL - 8.0.18 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `T_SYS_USER` (
	`id` varchar (150),
	`username` varchar (150),
	`password` varchar (150)
); 
insert into `T_SYS_USER` (`id`, `username`, `password`) values('1','admin','1');
