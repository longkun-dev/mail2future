-- 邮件信息主表

drop table if exists tb_mail_info;

create table if not exists tb_mail_info
(
    id               varchar(36) primary key not null comment '主键',
    subject          varchar(80)             not null default '无主题' comment '邮件主题',
    mail_content     text                    not null comment '邮件内容',
    receiver         varchar(60)             not null default '' comment '收件人，目前只支持一个收件人',
    public_scope     varchar(10)             not null default '公开' comment '是否公开，公开 不公开 匿名公开',
    plan_send_time   datetime                not null comment '预约发送时间',
    actual_send_time datetime                not null comment '实际发送时间',
    verify_code      varchar(36)             not null comment '验证码',
    mail_status      varchar(10)             not null default '邮件状态' comment '邮件发送状态',
    created_by       varchar(50)             not null default 'unknown' comment '创建人',
    created_time     timestamp               not null default current_timestamp comment '创建时间',
    updated_by       varchar(50)             not null default 'unknown' comment '更新人',
    updated_time     timestamp               not null default current_timestamp on update current_timestamp comment '更新时间'
) engine = InnoDB
  default charset = utf8mb4 comment '邮件信息表';
