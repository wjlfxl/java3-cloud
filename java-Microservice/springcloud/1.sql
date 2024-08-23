
CREATE DATABASE /*!32312 IF NOT EXISTS*/`market` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `market`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` INT(10) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(15) NOT NULL,
  `password` INT(15) NOT NULL,
  `people` VARCHAR(15) NOT NULL,
  `rank` INT(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

INSERT  INTO `admin`(`id`,`name`,`password`,`people`,`rank`) VALUES (1,'www',123123,'王大',1),(2,'eee',123456,'王二',2),(3,'wjl',123123,'王佳龙',1);

/*Table structure for table `commodity` */

DROP TABLE IF EXISTS `commodity`;

CREATE TABLE `commodity` (
  `id` INT(10) NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `type` VARCHAR(10) NOT NULL,
  `amount` INT(5) NOT NULL,
  `price` DOUBLE NOT NULL,
  `time` VARCHAR(30) NOT NULL,
  `apeople` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `commodity` */

INSERT  INTO `commodity`(`id`,`name`,`type`,`amount`,`price`,`time`,`apeople`) VALUES (1,'蟹味意族','副食',4,160,'2021.10.12晚','www'),(2,'薯条','副食',4,160,'2021.10.12晚','www'),(3,'虾条','副食',4,160,'2021.10.12晚','www'),(4,'可口可乐','饮品',4,144,'2021.10.12晚','www'),(5,'脉动','饮品',4,288,'2021.10.12晚','www'),(6,'好丽友派','副食',2,100,'2021.10.12晚','www'),(7,'好利源软糖','副食',5,100,'2021.10.12晚','www'),(8,'速溶咖啡','冲泡饮品',2,120,'2021.10.12晚','www'),(9,'理肤泉','饮品',2,138,'2021.10.12晚','www'),(10,'北京烤鸭','副食',4,80,'2021.10.12晚','www'),(11,'虎皮鸡爪','副食',4,110,'2021.10.12晚','www'),(12,'方便面','副食',4,140,'2021.10.12晚','www'),(13,'棉花糖','副食',4,40,'2021.10.12晚','www'),(14,'面包','副食',4,120,'2021.10.12晚','www');

/*Table structure for table `merchant` */

DROP TABLE IF EXISTS `merchant`;

CREATE TABLE `merchant` (
  `id` INT(10) NOT NULL,
  `people` VARCHAR(15) NOT NULL,
  `company` VARCHAR(30) NOT NULL,
  `address` VARCHAR(40) NOT NULL,
  `phone` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `merchant` */

INSERT  INTO `merchant`(`id`,`people`,`company`,`address`,`phone`) VALUES (1,'张丹成','上好佳（中国）有限公司','上海市沪青平公路2277号','59898888'),(2,'成可口','湖北太湖可口可乐有限公司','湖北武汉市江汉区香港路218号','4008096868'),(3,'李麦','湖北达能食品有限公司','湖北省武汉市东西湖区走马岭食品一路','4565523334'),(4,'石卡','上海雀巢有限公司','上海松江工业园区俞塘路','15797867764'),(5,'方干','广西广悦食品有限公司','广西容县容州工业大道','07716301245'),(6,'罗红','合肥金悦食品有限公司','合肥经济开发区紫云路','4008096868'),(7,'那元','广东好利源食品有限公司','潮州市潮安区','4008383995'),(8,'张丽','欧贝中国有限公司','上海徐汇区漕溪北路','0440498674'),(9,'蒋科','好丽友食品有限公司','海市闵行区莘庄镇沪闵路','0005656567'),(10,'姜丽','北京好吃货食品有限公司','北京东城区景山街道钱粮胡同','4008096868'),(11,'谭谭','蓝雅上海有限公司','上海市静安区南京西路','456768854'),(12,'张东东','湖北东台有限公司','湖北江夏区黄家湖大道','745464534'),(13,'程海还','湖北三蓝有限公司','湖北洪山区东澜岸','434644456'),(14,'徐载','湖北昌盛有限公司','湖北武昌区中山路','4008087868');

/*Table structure for table `stock` */

DROP TABLE IF EXISTS `stock`;

CREATE TABLE `stock` (
  `id` INT(10) NOT NULL AUTO_INCREMENT,
  `merchantId` INT(10) NOT NULL,
  `commodityId` INT(10) NOT NULL,
  `type` VARCHAR(10) NOT NULL,
  `amount` INT(5) NOT NULL,
  `price` DOUBLE NOT NULL,
  `time` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_stock_mer1` (`merchantId`),
  KEY `fk_stock_com1` (`commodityId`),
  CONSTRAINT `fk_stock_com1` FOREIGN KEY (`commodityId`) REFERENCES `commodity` (`id`),
  CONSTRAINT `fk_stock_mer1` FOREIGN KEY (`merchantId`) REFERENCES `merchant` (`id`)
) ENGINE=INNODB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `stock` */

INSERT  INTO `stock`(`id`,`merchantId`,`commodityId`,`type`,`amount`,`price`,`time`) VALUES (1,1,6,'副食',2,100,'2021.10.12晚'),(2,1,2,'副食',4,160,'2021.10.12晚'),(3,1,3,'副食',4,160,'2021.10.12晚'),(4,2,4,'副食',4,144,'2021.10.12晚'),(5,3,5,'饮品',4,288,'2021.10.12晚'),(6,6,6,'饮品',2,100,'2021.10.12晚'),(7,7,7,'副食',5,100,'2021.10.12晚'),(8,8,13,'副食',4,40,'2021.10.12晚'),(9,9,14,'副食',4,120,'2021.10.12晚'),(10,10,9,'饮品',2,138,'2021.10.12晚'),(11,11,10,'副食',4,80,'2021.10.12晚'),(12,12,11,'副食',2,110,'2021.10.12晚'),(13,4,8,'冲泡饮品',2,120,'2021.10.12晚');

/*Table structure for table `supply` */

DROP TABLE IF EXISTS `supply`;

CREATE TABLE `supply` (
  `id` INT(10) NOT NULL AUTO_INCREMENT,
  `merchantId` INT(10) NOT NULL,
  `commodityId` INT(10) NOT NULL,
  `type` VARCHAR(10) NOT NULL,
  `amount` INT(5) NOT NULL,
  `price` DOUBLE NOT NULL,
  `time` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_supply_mer1` (`merchantId`),
  KEY `fk_supply_com1` (`commodityId`),
  CONSTRAINT `fk_supply_com1` FOREIGN KEY (`commodityId`) REFERENCES `commodity` (`id`),
  CONSTRAINT `fk_supply_mer1` FOREIGN KEY (`merchantId`) REFERENCES `merchant` (`id`)
) ENGINE=INNODB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `supply` */

INSERT  INTO `supply`(`id`,`merchantId`,`commodityId`,`type`,`amount`,`price`,`time`) VALUES (1,1,1,'副食',1,40,'2021.12.10午'),(2,1,2,'副食',2,80,'2021.12.10午'),(3,1,3,'副食',1,40,'2021.12.10午'),(4,2,4,'副食',2,72,'2021.12.10午');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` INT(10) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(15) NOT NULL,
  `password` INT(15) NOT NULL,
  `people` VARCHAR(15) NOT NULL,
  `phone` VARCHAR(20) NOT NULL,
  `address` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=597274629 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

INSERT  INTO `user`(`id`,`name`,`password`,`people`,`phone`,`address`) VALUES (-1151860735,'采购18',123456,'www','123434536','湖北'),(1,'采购1',123123,'蔡大','13505550550','湖北省某某市江某区某某大道1号'),(2,'采购2',123456,'蔡二','13505550551','湖北省某某市江某区某某大道3号'),(3,'采购3',321,'蔡三','13505550551','湖北省某某市江某区某某大道5号'),(4,'采购4',231,'蔡四','13505550551','湖北省某某市江某区某某大道8号'),(5,'采购5',13452,'蔡五','13505550551','湖北省某某市江某区某某大道15号'),(6,'采购6',1234,'蔡六','13505550551','湖北省某某市江某区某某大道13号'),(7,'采购7',75684,'蔡七77','13505550551','湖北省某某市江某区某某大道17号'),(8,'采购8',2345,'蔡八','13505550551','湖北省某某市江某区某某大道42号'),(9,'采购9',23456,'蔡九','13505550551','湖北省某某市江某区某某大道31号'),(10,'采购10',23466,'蔡十','13505550551','湖北省某某市江某区某某大道46号'),(11,'采购11',234526,'蔡十一','13505550551','湖北省某某市江某区某某大道74号'),(12,'采购12',23425877,'蔡十二','13505550551','湖北省某某市江某区某某大道23号'),(13,'采购13',234346,'蔡十三','13505550551','湖北省某某市江某区某某大道49号'),(14,'采购14',23466,'蔡十四','13505550551','湖北省某某市江某区某某大道39号'),(16,'选美中国',123,'张三','12354678769','湖北省东西湖区某某大道1号'),(17,'选美中国',123123,'张三','12354678769','湖北省东西湖区某某大道1号'),(18,'采购111',123456,'www','123434536','湖北'),(597274626,'采购18',123456,'www','123434536','湖北'),(597274627,'采购18',123456,'www','123434536','湖北'),(597274628,'采购18',123456,'www','123434536','湖北');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
