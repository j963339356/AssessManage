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
   level                varchar(50) comment '1��2��3��4
            A��B��C��D',
   countyScore          int,
   cityScore            int,
   provinceScore        int,
   status               int comment '1.���м���ʾ
            2.�м��ѹ�ʾ
            3.��ʡ����ʾ
            4.ʡ���ѹ�ʾ
            5.�м��˶�
            6.ʡ���˶�
            7,���˻���
            8.ʡ�˻���',
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
   sysStatus            int not null default 1 comment '1.����
            2.ɾ��',
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
   sysStatus            int not null default 1 comment '1.����
            2.ɾ��',
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
   valueType            varchar(50) comment '1.�ٷֱ�
            2.����
            3.С��',
   remark               varchar(500),
   dimension            varchar(500),
   orgCode              int,
   ogrName              varchar(50),
   isStart              bool comment 'true.����
            false.ͣ��',
   sysCreateName        varchar(50),
   sysCreateCode        varchar(50),
   sysCreateTime        datetime,
   sysUpdateName        varchar(50),
   sysUpdateCode        varchar(50),
   sysUpdateTime        datetime,
   sysStatus            int not null default 1 comment '1.����
            2.ɾ��',
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
   sysStatus            int not null default 1 comment '1.����
            2.ɾ��',
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
   sex                  int comment '1.��
            2.Ů',
   orgName              varchar(50),
   orgCode              int comment '1.ʡ
            2.��
            3.��',
   sysCreateName        varchar(50),
   sysCreateCode        varchar(50),
   sysCreateTime        datetime,
   sysUpdateName        varchar(50),
   sysUpdateCode        varchar(50),
   sysUpdateTime        datetime,
   sysStatus            int not null default 1 comment '1.����
            2.ɾ��',
   primary key (id)
);

/*==============================================================*/
/* Index: Index_1                                               */
/*==============================================================*/
create unique index Index_1 on user
(
   username
);

