-- 邮件信息主表

drop table if exists tb_stat;

create table if not exists tb_stat
(
    id              varchar(36) primary key not null comment '主键',
    stat_item_name  varchar(80)             not null default '无' comment '统计项目名称',
    stat_item_value varchar(80)           not null default '无' comment '统计结果',
    created_by      varchar(50)             not null default 'unknown' comment '创建人',
    created_time    timestamp               not null default current_timestamp comment '创建时间',
    updated_by      varchar(50)             not null default 'unknown' comment '更新人',
    updated_time    timestamp               not null default current_timestamp on update current_timestamp comment '更新时间'
) engine = InnoDB
  default charset = utf8mb4 comment '邮件信息表';
