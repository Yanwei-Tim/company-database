set define off
spool 23_1_�������ż�¼��.log

prompt
prompt Creating table T_MSG_INFO
prompt =========================
prompt
create table T_MSG_INFO
(
  id          VARCHAR2(32) not null,
  sender      VARCHAR2(32),
  send_time   DATE not null,
  send_status CHAR(1),
  msg_type    VARCHAR2(2),
  msg_title   VARCHAR2(128),
  msg_content VARCHAR2(2048) not null,
  receiver    VARCHAR2(32) not null,
  remark      VARCHAR2(256)
)
;
comment on table T_MSG_INFO
  is '�û�������Ϣ��';
comment on column T_MSG_INFO.id
  is '������ϢID';
comment on column T_MSG_INFO.sender
  is '������';
comment on column T_MSG_INFO.send_time
  is '����ʱ��';
comment on column T_MSG_INFO.send_status
  is '����״̬';
comment on column T_MSG_INFO.msg_type
  is '��������';
comment on column T_MSG_INFO.msg_title
  is '���ݱ���';
comment on column T_MSG_INFO.msg_content
  is '��������';
comment on column T_MSG_INFO.receiver
  is '������';
comment on column T_MSG_INFO.remark
  is '��ע';
alter table T_MSG_INFO
  add constraint PK_T_MSG_INFO_INDEX primary key (ID);


spool off

exit;
