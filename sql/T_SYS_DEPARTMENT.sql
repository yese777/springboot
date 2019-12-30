/*
SQLyog Ultimate
MySQL - 8.0.18 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `T_SYS_DEPARTMENT` (
	`id` int (50),
	`departmentName` varchar (150)
); 
insert into `T_SYS_DEPARTMENT` (`id`, `departmentName`) values('1','开发部');
insert into `T_SYS_DEPARTMENT` (`id`, `departmentName`) values('2','销售部');
insert into `T_SYS_DEPARTMENT` (`id`, `departmentName`) values('3','市场部');
