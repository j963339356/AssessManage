/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/4/13 19:51:38                           */
/*==============================================================*/


drop table if exists assessmanage;

drop table if exists assessscore;

drop table if exists assesstargetmanage;

drop table if exists evaluatereportmanage;

drop index Index_1 on user;

drop table if exists user;

/*==============================================================*/
/* Table: assessmanage                                          */
/*==============================================================*/
create table assessmanage
(
   id                   varchar(50) not null,
   year                 int,
   city                 varchar(50),
   county               varchar(50),
   province             varchar(50),
   orgCode              varchar(50),
   orgName              varchar(50),
   writerId             varchar(50),
   writerName           varchar(50),
   writerPhone          varchar(50),
   writeDate            datetime,
   level                varchar(50) comment '1、2、3、4
            A、B、C、D',
   countyScore          int,
   cityScore            int,
   provinceScore        int,
   status               int comment '1.待市级公示
            2.市级已公示
            3.待省级公示
            4.省级已公示
            5.市级核定
            6.省级核定
            7,市退回县
            8.省退回市',
   backReson            varchar(500),
   processName          varchar(50),
   noticeStart          datetime,
   noticeEnd            datetime,
   sysCreateName        varchar(50),
   sysCreateCode        varchar(50),
   sysCreateTime        datetime,
   sysUpdateName        varchar(50),
   sysUpdateCode        varchar(50),
   sysUpdateTime        datetime,
   sysStatus            int not null default 1 comment '1.正常
            2.删除',
   primary key (id)
);

/*==============================================================*/
/* Table: assessscore                                           */
/*==============================================================*/
create table assessscore
(
   id                   varchar(50) not null,
   name                 varchar(100),
   meansure             varchar(50),
   p                    varchar(50) comment 'p1~p7',
   targetExplain        varchar(500),
   level                int,
   remark               varchar(500),
   countyScore          int,
   cityScore            int,
   provinceScore        int,
   year                 int,
   city                 varchar(50),
   county               varchar(50),
   province             varchar(50),
   orgCode              int,
   ogrName              varchar(50),
   sysCreateName        varchar(50),
   sysCreateCode        varchar(50),
   sysCreateTime        datetime,
   sysUpdateName        varchar(50),
   sysUpdateCode        varchar(50),
   sysUpdateTime        datetime,
   sysStatus            int not null default 1 comment '1.正常
            2.删除',
   primary key (id)
);

/*==============================================================*/
/* Table: assesstargetmanage                                    */
/*==============================================================*/
create table assesstargetmanage
(
   id                   varchar(50) not null,
   assessId             varchar(50),
   name                 varchar(50),
   meansure             varchar(50),
   p                    varchar(50) comment 'p1~p7',
   targetExplain        varchar(500),
   level                int,
   valueType            varchar(50) comment '1.百分比
            2.整数
            3.小数',
   remark               varchar(500),
   dimension            varchar(500),
   orgCode              int,
   ogrName              varchar(50),
   isStart              bool comment 'true.正常
            false.停用',
   sysCreateName        varchar(50),
   sysCreateCode        varchar(50),
   sysCreateTime        datetime,
   sysUpdateName        varchar(50),
   sysUpdateCode        varchar(50),
   sysUpdateTime        datetime,
   sysStatus            int not null default 1 comment '1.正常
            2.删除',
   primary key (id)
);

/*==============================================================*/
/* Table: evaluatereportmanage                                  */
/*==============================================================*/
create table evaluatereportmanage
(
   id                   varchar(50) not null,
   year                 int,
   reportAddr           varchar(100),
   reportEvaluate       text,
   orgName              varchar(50),
   orgCode              varchar(50),
   sysCreateName        varchar(50),
   sysCreateCode        varchar(50),
   sysCreateTime        datetime,
   sysUpdateName        varchar(50),
   sysUpdateCode        varchar(50),
   sysUpdateTime        datetime,
   sysStatus            int not null default 1 comment '1.正常
            2.删除',
   primary key (id)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   id                   varchar(50) not null,
   countId              varchar(50),
   username             varchar(50),
   password             varchar(50),
   name                 varchar(50),
   email                varchar(50),
   phone                varchar(50),
   city                 varchar(50),
   county               varchar(50),
   province             varchar(50),
   sex                  int comment '1.男
            2.女',
   orgName              varchar(50),
   orgCode              int comment '1.省
            2.市
            3.镇',
   sysCreateName        varchar(50),
   sysCreateCode        varchar(50),
   sysCreateTime        datetime,
   sysUpdateName        varchar(50),
   sysUpdateCode        varchar(50),
   sysUpdateTime        datetime,
   sysStatus            int not null default 1 comment '1.正常
            2.删除',
   primary key (id)
);

/*==============================================================*/
/* Index: Index_1                                               */
/*==============================================================*/
create unique index Index_1 on user
(
   username
);

