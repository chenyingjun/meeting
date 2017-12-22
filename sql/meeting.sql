CREATE TABLE `mt_meeting` (
  `id` varchar(40) NOT NULL,
  `meeting_name` varchar(400) DEFAULT NULL COMMENT '会议名称',
  `meeting_status` int(2) DEFAULT '1' COMMENT '会议状态',
  `meeting_room_id` varchar(40) NOT NULL COMMENT '会议室主键',
  `orgs` text COMMENT '参与部门，用英文,号隔开',
  `start_time` datetime NOT NULL COMMENT '开始时间',
  `end_time` datetime NOT NULL COMMENT '结束时间',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` int(1) NOT NULL DEFAULT '0' COMMENT '是否删除   0.已删除；1.可用',
  PRIMARY KEY (`id`),
  KEY `mt_delFlag` (`del_flag`),
  KEY `fk_meetingRoomId` (`meeting_room_id`),
  CONSTRAINT `fk_meetingRoomId` FOREIGN KEY (`meeting_room_id`) REFERENCES `mt_meeting_room` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8


CREATE TABLE `mt_meeting_room` (
  `id` varchar(40) NOT NULL COMMENT '会议室主健',
  `name` varchar(400) DEFAULT NULL COMMENT '会议室名称',
  `seat_number` int(11) NOT NULL COMMENT '会议室座位数',
  `del_flag` int(1) NOT NULL DEFAULT '0',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8


CREATE TABLE `mt_meeting_user` (
  `id` varchar(40) NOT NULL,
  `meeting_id` varchar(40) NOT NULL,
  `user_id` varchar(40) NOT NULL,
  `status` int(1) DEFAULT '1' COMMENT '状态  1.已邀请；2.已签到；3.请假；',
  PRIMARY KEY (`id`),
  KEY `fk_meetingUser_meetingId` (`meeting_id`),
  KEY `fk_meetingUser_userId` (`user_id`),
  KEY `index_meetingUser_status` (`status`),
  CONSTRAINT `fk_meetingUser_meetingId` FOREIGN KEY (`meeting_id`) REFERENCES `mt_meeting` (`id`),
  CONSTRAINT `fk_meetingUser_userId` FOREIGN KEY (`user_id`) REFERENCES `mt_meeting` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8