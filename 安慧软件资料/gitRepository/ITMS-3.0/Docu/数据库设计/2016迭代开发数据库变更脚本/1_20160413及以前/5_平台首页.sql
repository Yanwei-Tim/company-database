set define off
spool 5_ƽ̨��ҳ.log

create table T_SYS_NOTICE 
(
   NOTICE_ID            VARCHAR2(32)         not null,
   USER_ID              VARCHAR2(32)         not null,
   NOTICE_TITLE         VARCHAR2(256)        not null,
   NOTICE_CONTENT       VARCHAR2(512),
   CREATE_TIME          DATE                 not null,
   UPDATE_TIME          DATE,
   constraint PK_T_SYS_NOTICE primary key (NOTICE_ID)
);

COMMENT ON TABLE T_SYS_NOTICE IS '֪ͨ�����';
comment on column T_SYS_NOTICE.NOTICE_ID is '����ID';
comment on column T_SYS_NOTICE.USER_ID is '������';
comment on column T_SYS_NOTICE.NOTICE_TITLE is '�������';
comment on column T_SYS_NOTICE.NOTICE_CONTENT is '��������';
comment on column T_SYS_NOTICE.CREATE_TIME is '����ʱ��';
comment on column T_SYS_NOTICE.UPDATE_TIME is '����ʱ��';

alter table T_SYS_NOTICE add constraint FK_NOTICE_TO_USER foreign key (USER_ID)
      references T_SYS_USER (USER_ID) on delete cascade;


create table T_SYS_SITE_LINK 
(
   LINK_ID              VARCHAR2(32)         not null,
   LINK_NAME            VARCHAR2(256)        not null,
   LINK_ICON            VARCHAR2(128),
   LINK_URL             VARCHAR2(128)        not null,
   constraint PK_T_SYS_SITE_LINK primary key (LINK_ID)
);

COMMENT ON TABLE T_SYS_SITE_LINK IS '�������ӱ�';
comment on column T_SYS_SITE_LINK.LINK_ID is '����ID';
comment on column T_SYS_SITE_LINK.LINK_NAME is '��������';
comment on column T_SYS_SITE_LINK.LINK_ICON is '��־ͼ��';
comment on column T_SYS_SITE_LINK.LINK_URL is 'URL��ַ';

create table T_SYS_DOWNLOAD 
(
   DOWNLOAD_ID          VARCHAR2(32)         not null,
   DOWNLOAD_TITLE       VARCHAR2(256)        not null,
   DOWNLOAD_CONTENT     VARCHAR2(256),
   DOWNLOAD_URL         VARCHAR2(128)        not null,
   CREATE_TIME          DATE                 not null,
   UPDATE_TIME          DATE,
   constraint PK_T_SYS_DOWNLOAD primary key (DOWNLOAD_ID)
);


COMMENT ON TABLE T_SYS_DOWNLOAD IS '�������ݱ�';
comment on column T_SYS_DOWNLOAD.DOWNLOAD_ID IS '��������ID';
comment on column T_SYS_DOWNLOAD.DOWNLOAD_TITLE IS '����';
comment on column T_SYS_DOWNLOAD.DOWNLOAD_CONTENT IS '����';
comment on column T_SYS_DOWNLOAD.DOWNLOAD_URL IS '���ص�ַ';
comment on column T_SYS_DOWNLOAD.CREATE_TIME IS '����ʱ��';
comment on column T_SYS_DOWNLOAD.UPDATE_TIME IS '����ʱ��';



spool off

exit;