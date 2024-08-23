
CREATE TABLE `shop`.`shop_product`(  
  `pid` INT(10) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `pname` VARCHAR(20) NOT NULL COMMENT '商品名称',
  `pprice` DOUBLE(20) NOT NULL COMMENT '商品价格',
  `stock` INT(5) NOT NULL COMMENT '库存',
  PRIMARY KEY (`pid`)
) ENGINE=INNODB CHARSET=utf8;
