drop table if exists t_order_1;
CREATE TABLE `t_order_1`(
  `order_id` BIGINT(20) NOT NULL COMMENT '订单id',
  `price` DECIMAL(10,2) NOT NULL COMMENT '订单价格',
  `user_id` BIGINT(20) NOT NULL COMMENT '下单用户id',
  `status` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单状态',
PRIMARY KEY (`order_id`) USING BTREE
)ENGINE = INNODB DEFAULT CHARSET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

drop table if exists t_order_2;
CREATE TABLE `t_order_2`(
  `order_id` BIGINT(20) NOT NULL COMMENT '订单id',
  `price` DECIMAL(10,2) NOT NULL COMMENT '订单价格',
  `user_id` BIGINT(20) NOT NULL COMMENT '下单用户id',
  `status` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单状态',
PRIMARY KEY (order_id) USING BTREE
)ENGINE = INNODB DEFAULT CHARSET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

CREATE DATABASE order_db_1 CHARACTER SET utf8 COLLATE utf8_general_ci;
CREATE DATABASE order_db_2 CHARACTER SET utf8 COLLATE utf8_general_ci;
