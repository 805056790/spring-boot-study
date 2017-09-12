
DROP TABLE if exists `spring_boot_jdbc_users`;
CREATE TABLE `spring_boot_jdbc_users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL comment 'user name',
  `password` varchar(20) default null comment 'user password',
  PRIMARY KEY (`id`)
) comment = 'user info';


DROP TABLE if exists `spring_boot_jdbc_addresses`;
CREATE TABLE `spring_boot_jdbc_addresses` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pid` bigint(20) DEFAULT NULL comment 'pid',
  `name` varchar(100) DEFAULT NULL comment 'address name',
  `code` varchar(20) default null comment 'address code',
  PRIMARY KEY (`id`)
) comment = 'address';

