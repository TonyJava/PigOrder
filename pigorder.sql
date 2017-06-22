# Host: localhost  (Version 5.5.27)
# Date: 2017-06-22 19:40:34
# Generator: MySQL-Front 6.0  (Build 1.124)


#
# Structure for table "frequency"
#

DROP TABLE IF EXISTS `frequency`;
CREATE TABLE `frequency` (
  `fid` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(30) DEFAULT NULL,
  `faddress` varchar(30) DEFAULT NULL,
  `starttime` varchar(30) DEFAULT NULL,
  `kilometers` double(10,2) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `level` int(2) DEFAULT NULL,
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

#
# Data for table "frequency"
#

INSERT INTO `frequency` VALUES (1,'201','泰安','16:45',3303.00,'火车',3),(2,'177','上海虹桥','6:45',2341.00,'高铁',1),(3,'123','2','3',13432.00,'飞机',4),(5,'期3456','规范规定是否','烦死哒222',234.00,'普快',4),(7,'1234','22','1234',2.00,'123',2);

#
# Structure for table "torder"
#

DROP TABLE IF EXISTS `torder`;
CREATE TABLE `torder` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `finaladdress` varchar(30) DEFAULT NULL,
  `frequencyid` int(11) DEFAULT NULL,
  `price` double(10,1) DEFAULT NULL,
  `state` int(1) DEFAULT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

#
# Data for table "torder"
#

INSERT INTO `torder` VALUES (1,21,'泰安',1,300.0,0),(2,21,'泰安',1,300.0,0),(3,21,'泰安',1,300.0,0),(4,21,'规范规定是否',5,1000.0,0),(5,21,'规范规定是否',5,1000.0,0),(6,21,'上海虹桥',2,50.0,0),(7,21,'规范规定是否',5,1000.0,0),(8,21,'上海虹桥',2,50.0,1),(9,21,'泰安',1,300.0,0),(10,21,'上海虹桥',2,50.0,1),(11,21,'泰安',1,300.0,1),(12,21,'泰安',1,186.6,1),(13,21,'2',3,880.0,0),(14,21,'上海虹桥',2,110.7,1),(15,21,'2',3,880.0,1);

#
# Structure for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(30) DEFAULT NULL,
  `upassword` varchar(30) DEFAULT NULL,
  `idno` varchar(30) DEFAULT NULL,
  `realname` varchar(10) DEFAULT NULL,
  `isadmin` int(1) DEFAULT '0',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

#
# Data for table "user"
#

INSERT INTO `user` VALUES (5,'admin','1','0013','管理员',1),(12,'4','1234','21','1234',0),(13,'陈一发','1234','1','12',0),(19,'你是19','1999','12345','nlooo',0),(20,'我是20号','1234','123456','123456',0),(21,'21','21','214','21',0),(22,'lance','1234','1','1234',0);
