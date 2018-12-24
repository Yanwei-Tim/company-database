set define off
spool 24_4_�豸��������.log

prompt Creating T_DEVICE_ALARM...
create table T_DEVICE_ALARM
(
  alarm_id           VARCHAR2(32) not null,
  alarm_type         VARCHAR2(2) not null,
  alarm_sub_type     VARCHAR2(5),
  alarm_device_id    VARCHAR2(32) not null,
  start_time         DATE not null,
  end_time           DATE,
  collect_way        CHAR(1),
  alarm_disc         VARCHAR2(256),
  org_privilege_code VARCHAR2(8) not null,
  create_time        DATE not null
)
;
comment on table T_DEVICE_ALARM
  is '�����豸��صı�����Ϣ';
comment on column T_DEVICE_ALARM.alarm_id
  is 'Ψһ��ʶ';
comment on column T_DEVICE_ALARM.alarm_type
  is '1:�豸���� 2:���������� 3:����';
comment on column T_DEVICE_ALARM.alarm_sub_type
  is '�豸�࣬��Ӧcode:478 ������Ϊ��';
comment on column T_DEVICE_ALARM.alarm_device_id
  is '�����������豸ID���������豸��Ҳ�����Ƿ�������';
comment on column T_DEVICE_ALARM.start_time
  is '������ʼʱ��';
comment on column T_DEVICE_ALARM.end_time
  is '��������ʱ�䣬����Ϊ��';
comment on column T_DEVICE_ALARM.collect_way
  is '1ǰ���豸�ϴ� 2ϵͳ���� 3�˹����';
comment on column T_DEVICE_ALARM.alarm_disc
  is '��������';
comment on column T_DEVICE_ALARM.org_privilege_code
  is '����Ȩ�ޱ��룬����Ȩ�޹���';
comment on column T_DEVICE_ALARM.create_time
  is '����ʱ��';
alter table T_DEVICE_ALARM
  add constraint PK_T_DEVICE_ALARM primary key (ALARM_ID);

prompt Creating T_DEVICE_ALARM_HANDLE...
create table T_DEVICE_ALARM_HANDLE
(
  handle_id     VARCHAR2(32) not null,
  alarm_id      VARCHAR2(32) not null,
  is_validity   VARCHAR2(1) not null,
  handle_disc   VARCHAR2(256),
  handle_time   DATE not null,
  handle_person VARCHAR2(32) not null
)
;
comment on table T_DEVICE_ALARM_HANDLE
  is '�洢����������Ϣ';
comment on column T_DEVICE_ALARM_HANDLE.handle_id
  is 'Ψһ��ʶ';
comment on column T_DEVICE_ALARM_HANDLE.alarm_id
  is '����ID';
comment on column T_DEVICE_ALARM_HANDLE.is_validity
  is '1��Ч0��Ч';
comment on column T_DEVICE_ALARM_HANDLE.handle_person
  is '�����û�ID';
alter table T_DEVICE_ALARM_HANDLE
  add constraint PK_T_DEVICE_ALARM_HANDLE primary key (HANDLE_ID);

prompt Creating T_DEVICE_ALARM_STATUS...
create table T_DEVICE_ALARM_STATUS
(
  alarm_id      VARCHAR2(32) not null,
  is_accept     CHAR(1),
  accept_time   DATE,
  accpet_person VARCHAR2(32),
  is_handle     CHAR(1),
  is_validity   CHAR(1),
  handle_person VARCHAR2(32)
)
;
comment on table T_DEVICE_ALARM_STATUS
  is '��¼������Ϣ״̬';
comment on column T_DEVICE_ALARM_STATUS.is_accept
  is '0��1��';
comment on column T_DEVICE_ALARM_STATUS.is_handle
  is '0��1��';
comment on column T_DEVICE_ALARM_STATUS.is_validity
  is '0��1��';
alter table T_DEVICE_ALARM_STATUS
  add constraint PK_T_DEVICE_ALARM_STATUS primary key (ALARM_ID);



spool off

exit;
