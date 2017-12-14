CREATE TABLE `org` (
  `id` varchar(40) NOT NULL COMMENT '组织表主键',
  `name` varchar(80) NOT NULL COMMENT '组织名称',
  `full_name` varchar(400) DEFAULT NULL COMMENT '组织全名',
  `parent_id` varchar(40) DEFAULT NULL COMMENT '父主键',
  `parent_ids` varchar(400) DEFAULT NULL COMMENT '父主健集',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `status` int(2) DEFAULT NULL COMMENT '状态   0.禁用；1.可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8


CREATE TABLE `user_test` (
  `id` int(11) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `status` varchar(2) DEFAULT NULL COMMENT '状态值，用于activiti测试',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8