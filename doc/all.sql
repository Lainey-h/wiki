drop table if exists `test`;
create table `test`(
 `id` bigint not null comment 'id',
 `name` varchar(50) comment '名称',
 `password` varchar(50) comment '密码',
 primary key (`id`)
 ) engine =innodb default  charset=utf8mb4
   comment='测试';

insert into `test`(id,name,password)value(1,'测试','password');


drop table if exists `demo`;
create table `demo`(
                       `id` bigint not null comment 'id',
                       `name` varchar(50) comment '名称',
                       primary key (`id`)
) engine =innodb default  charset=utf8mb4
    comment='测试';

insert into `demo`(id,name)value(1,'测试');

drop table if exists `ebook`;
create table `ebook`(
    `id` bigint not null comment 'id',
    `name` varchar(50) comment '名称',
    `category1_id` bigint comment '分类1',
    `category2_id` bigint comment '分类2',
    `description` varchar(200) comment '描述',
    `cover` varchar(200) comment '封面',
    `doc_count` int comment '文档数',
    `view_count` int comment '阅读数',
    `vote_count` int comment '点赞数',
    primary key (`id`)

)engine =innodb default character set =utf8mb4 comment ='电子书';

insert into `ebook`(id,name,description) value (1,'Spring boot 入门教程零基础入门Java开发','企业级应用开发最佳首选方案');
insert into `ebook`(id,name,description) value (2,'Vue 入门教程零基础入门Vue开发','企业级应用开发最佳首选框架');
insert into `ebook`(id,name,description) value (3,'Python入门教程,零基础入门开发','企业级应用开发最佳首选方案');
insert into `ebook`(id,name,description) value (4,'Mysql入门教程,零基础入门开发','企业级应用开发最佳首选方案');
insert into `ebook`(id,name,description) value (5,'Oracle入门教程,零基础入门开发','企业级应用开发最佳首选框架');


-- 用户表
drop table if exists `user`;
create table `user`(
    `id` bigint auto_increment not null comment 'ID',
    `login_name` varchar(50) not null comment'登录名',
    `name` varchar(50) comment '昵称',
    `password` char(32) not null comment '密码',
    primary key (`id`),
    unique key `login_name_unique` (`login_name`)
) engine=innodb default charset=utf8mb4 comment='用户';

insert into `user`(id,`login_name`,`name`,`password`) value (1,'test','测试','test');
