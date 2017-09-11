
DROP TABLE if exists `spring_boot_jdbc_users`;
CREATE TABLE `spring_boot_jdbc_users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL comment 'user name',
  `password` varchar(20) default null comment 'user password',
  PRIMARY KEY (`id`)
) comment = 'user info';
