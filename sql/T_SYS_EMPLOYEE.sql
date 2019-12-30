/*
SQLyog Ultimate
MySQL - 8.0.18 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `T_SYS_EMPLOYEE` (
	`id` int (50),
	`lastName` varchar (150),
	`email` varchar (150),
	`gender` int (50),
	`birth` date ,
	`deptId` int (50)
); 
insert into `T_SYS_EMPLOYEE` (`id`, `lastName`, `email`, `gender`, `birth`, `deptId`) values('1','张三1','132@qq.com','1','2019-10-15','1');
insert into `T_SYS_EMPLOYEE` (`id`, `lastName`, `email`, `gender`, `birth`, `deptId`) values('2','张三2','132@qq.com','0','2019-12-03','1');
insert into `T_SYS_EMPLOYEE` (`id`, `lastName`, `email`, `gender`, `birth`, `deptId`) values('3','张三3','132@qq.com','1','2019-12-18','1');
insert into `T_SYS_EMPLOYEE` (`id`, `lastName`, `email`, `gender`, `birth`, `deptId`) values('4','张三4','132@qq.com','0','2019-12-04','2');
insert into `T_SYS_EMPLOYEE` (`id`, `lastName`, `email`, `gender`, `birth`, `deptId`) values('5','张三5','132@qq.com','1','2019-12-17','2');
insert into `T_SYS_EMPLOYEE` (`id`, `lastName`, `email`, `gender`, `birth`, `deptId`) values('6','张三6','132@qq.com','1','2019-12-31','3');
insert into `T_SYS_EMPLOYEE` (`id`, `lastName`, `email`, `gender`, `birth`, `deptId`) values('7','张三7','1321810135@qq.com','1','2019-12-02','1');
insert into `T_SYS_EMPLOYEE` (`id`, `lastName`, `email`, `gender`, `birth`, `deptId`) values('8','张三8','1565565@163.com','1','2019-12-02','2');
insert into `T_SYS_EMPLOYEE` (`id`, `lastName`, `email`, `gender`, `birth`, `deptId`) values('10','张三9','1321810135@qq.com','1','2019-12-19','3');
insert into `T_SYS_EMPLOYEE` (`id`, `lastName`, `email`, `gender`, `birth`, `deptId`) values('11','张三10','1565565@163.com','0','2019-12-08','1');
insert into `T_SYS_EMPLOYEE` (`id`, `lastName`, `email`, `gender`, `birth`, `deptId`) values('12','张三11','1565565@163.com','0','2019-12-16','2');
insert into `T_SYS_EMPLOYEE` (`id`, `lastName`, `email`, `gender`, `birth`, `deptId`) values('14','张三100','1321810135@qq.com','0','2020-01-01','2');
insert into `T_SYS_EMPLOYEE` (`id`, `lastName`, `email`, `gender`, `birth`, `deptId`) values('17','张三9','1321810135@qq.com','0','2019-12-29','3');
