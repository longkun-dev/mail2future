-- 邮件信息主表

drop table if exists tb_mail_send_log;

create table if not exists tb_mail_send_log
(
    id               varchar(36) primary key not null comment '主键',
    mail_id          varchar(36)             not null comment '关联tb_mail_info主键',
    send_result      varchar(15)             not null default '未知' comment '发送结果',
    actual_send_time datetime                not null default now() comment '实际发送时间',
    created_by       varchar(50)             not null default 'unknown' comment '创建人',
    created_time     timestamp               not null default current_timestamp comment '创建时间',
    updated_by       varchar(50)             not null default 'unknown' comment '更新人',
    updated_time     timestamp               not null default current_timestamp on update current_timestamp comment '更新时间'
) engine = InnoDB
  default charset = utf8mb4 comment '邮件发送记录表';
