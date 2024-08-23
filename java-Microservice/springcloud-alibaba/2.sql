CREATE TABLE `shop_order` (
  `oid` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `uid` INT(10) NOT NULL,
  `pid` INT(10) NOT NULL,
  `username` VARCHAR(20) NOT NULL,
  `pname` VARCHAR(20) NOT NULL,
  `pprice` DOUBLE NOT NULL,
  `number` INT(10) NOT NULL,
  PRIMARY KEY (`oid`),
  KEY `fk_shop_user` (`uid`),
  KEY `fk_shop_product` (`pid`),
  CONSTRAINT `fk_shop_user` FOREIGN KEY (`uid`) REFERENCES `shop_user` (`uid`),
  CONSTRAINT `fk_shop_product` FOREIGN KEY (`pid`) REFERENCES `shop_product` (`pid`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;



CREATE TABLE `shop_product` (
  `pid` INT(10) NOT NULL AUTO_INCREMENT,
  `pname` VARCHAR(10) NOT NULL,
  `pprice` DOUBLE NOT NULL,
  `stock` INT(10) NOT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

