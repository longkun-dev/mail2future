-- 去掉实际发送时间的非空限制

alter table tb_mail_info
    modify actual_send_time datetime collate utf8mb4_bin comment '实际发送时间';
