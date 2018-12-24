------------------------------------------------------
-- Export file for user ITMS3                       --
-- Created by Administrator on 2015-12-16, 17:13:14 --
------------------------------------------------------

set define off
spool ����ͳ�Ʊ���������.log

prompt
prompt Creating table X_D_D_DEVICE_STATUS
prompt ==================================
prompt
create table ITMS3.X_D_D_DEVICE_STATUS
(
  device_id     VARCHAR2(32) not null,
  org_id        VARCHAR2(32) not null,
  device_type   VARCHAR2(2) not null,
  contract_id   VARCHAR2(32),
  contractor_id VARCHAR2(32),
  begin_time    DATE,
  end_time      DATE,
  status        VARCHAR2(2),
  stat_online   VARCHAR2(2)
)
tablespace ITMS_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table ITMS3.X_D_D_DEVICE_STATUS
  is '�豸ÿ������״̬ͳ�Ʊ�';
comment on column ITMS3.X_D_D_DEVICE_STATUS.device_id
  is '�豸ID';
comment on column ITMS3.X_D_D_DEVICE_STATUS.org_id
  is '����ID';
comment on column ITMS3.X_D_D_DEVICE_STATUS.device_type
  is '�豸����';
comment on column ITMS3.X_D_D_DEVICE_STATUS.contract_id
  is '��ͬID';
comment on column ITMS3.X_D_D_DEVICE_STATUS.contractor_id
  is '����ID';
comment on column ITMS3.X_D_D_DEVICE_STATUS.begin_time
  is '��ʼʱ��';
comment on column ITMS3.X_D_D_DEVICE_STATUS.end_time
  is '����ʱ��';
comment on column ITMS3.X_D_D_DEVICE_STATUS.status
  is '�豸״̬ (δ���á����� ��ͣ�� ������)';
comment on column ITMS3.X_D_D_DEVICE_STATUS.stat_online
  is '�Ƿ�ͳ�������ʣ���ʶ��';

prompt
prompt Creating table X_D_D_STATUS_LOG
prompt ===============================
prompt
create table ITMS3.X_D_D_STATUS_LOG
(
  status_log_id       VARCHAR2(32) not null,
  device_id           VARCHAR2(32),
  org_id              VARCHAR2(32),
  device_type         VARCHAR2(2) not null,
  contract_id         VARCHAR2(32),
  contractor_id       VARCHAR2(32),
  statistics_date     DATE,
  online_status       VARCHAR2(2),
  duration_secs       NUMBER(10),
  fault_secs          NUMBER(10),
  fault_times         NUMBER(10),
  correct_should_secs NUMBER(10),
  stat_online         VARCHAR2(2)
)
tablespace ITMS_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table ITMS3.X_D_D_STATUS_LOG
  is '�豸��������ͳ�Ʊ�';
comment on column ITMS3.X_D_D_STATUS_LOG.status_log_id
  is '�豸��¼ID';
comment on column ITMS3.X_D_D_STATUS_LOG.device_id
  is '�豸ID';
comment on column ITMS3.X_D_D_STATUS_LOG.org_id
  is '����ID';
comment on column ITMS3.X_D_D_STATUS_LOG.device_type
  is '�豸����';
comment on column ITMS3.X_D_D_STATUS_LOG.contract_id
  is '��ͬ���';
comment on column ITMS3.X_D_D_STATUS_LOG.contractor_id
  is '����ID';
comment on column ITMS3.X_D_D_STATUS_LOG.statistics_date
  is 'ͳ������';
comment on column ITMS3.X_D_D_STATUS_LOG.online_status
  is '����״̬��1 �������� 2 �й��ϣ�ȫ����ϻ򲿷�ʱ�ι��ϣ�3 Ӧ���� ȴû�����߼�¼��';
comment on column ITMS3.X_D_D_STATUS_LOG.duration_secs
  is '���߳���ʱ��';
comment on column ITMS3.X_D_D_STATUS_LOG.fault_secs
  is '���ϳ���ʱ��';
comment on column ITMS3.X_D_D_STATUS_LOG.fault_times
  is '���Ϸ�������';
comment on column ITMS3.X_D_D_STATUS_LOG.correct_should_secs
  is 'Ӧ����ʱ����һ��ʱ���۳�����ʱ����';
comment on column ITMS3.X_D_D_STATUS_LOG.stat_online
  is '�Ƿ�ͳ�������� ��Ϊ�豸����ʱ��ҲҪ��¼���豸ʱ�������ȫ�������豸��';

prompt
prompt Creating table X_D_D_UNUSUAL_TIME
prompt =================================
prompt
create table ITMS3.X_D_D_UNUSUAL_TIME
(
  log_id        VARCHAR2(32) not null,
  device_id     VARCHAR2(32),
  start_time    DATE,
  end_time      DATE,
  duration_secs NUMBER(10)
)
tablespace ITMS_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table ITMS3.X_D_D_UNUSUAL_TIME
  is '�豸���ϻ��������Сʱ��';
comment on column ITMS3.X_D_D_UNUSUAL_TIME.device_id
  is '�豸ID';
comment on column ITMS3.X_D_D_UNUSUAL_TIME.start_time
  is '��ʼʱ��';
comment on column ITMS3.X_D_D_UNUSUAL_TIME.end_time
  is '����ʱ��';
comment on column ITMS3.X_D_D_UNUSUAL_TIME.duration_secs
  is '���ϡ����߳���ʱ������λ���룩';

prompt
prompt Creating table X_D_M_STATUS_LOG
prompt ===============================
prompt
create table ITMS3.X_D_M_STATUS_LOG
(
  status_log_id    VARCHAR2(32) not null,
  device_id        VARCHAR2(32),
  org_id           VARCHAR2(32),
  device_type      VARCHAR2(2) not null,
  contract_id      VARCHAR2(32),
  contractor_id    VARCHAR2(32),
  statistics_month DATE,
  primary_online   NUMBER(5,4),
  correct_online   NUMBER(5,4),
  stat_online      VARCHAR2(2)
)
tablespace ITMS_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on column ITMS3.X_D_M_STATUS_LOG.device_id
  is '�豸ID';
comment on column ITMS3.X_D_M_STATUS_LOG.org_id
  is '����ID';
comment on column ITMS3.X_D_M_STATUS_LOG.device_type
  is '�豸����';
comment on column ITMS3.X_D_M_STATUS_LOG.contract_id
  is '��ͬID';
comment on column ITMS3.X_D_M_STATUS_LOG.contractor_id
  is '����ID';
comment on column ITMS3.X_D_M_STATUS_LOG.statistics_month
  is 'ͳ���·�';
comment on column ITMS3.X_D_M_STATUS_LOG.primary_online
  is 'ԭʼ������';
comment on column ITMS3.X_D_M_STATUS_LOG.correct_online
  is '����������';
comment on column ITMS3.X_D_M_STATUS_LOG.stat_online
  is '�Ƿ�ͳ��������';

prompt
prompt Creating table X_D_M_UNUSUAL_TIME
prompt =================================
prompt
create table ITMS3.X_D_M_UNUSUAL_TIME
(
  log_id        VARCHAR2(32) not null,
  device_id     VARCHAR2(32),
  start_time    DATE,
  end_time      DATE,
  duration_secs NUMBER(10)
)
tablespace ITMS_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table ITMS3.X_D_M_UNUSUAL_TIME
  is '�豸���ϻ���������ձ�';
comment on column ITMS3.X_D_M_UNUSUAL_TIME.device_id
  is '�豸ID';
comment on column ITMS3.X_D_M_UNUSUAL_TIME.start_time
  is '��ʼʱ��';
comment on column ITMS3.X_D_M_UNUSUAL_TIME.end_time
  is '����ʱ��';
comment on column ITMS3.X_D_M_UNUSUAL_TIME.duration_secs
  is '���߻���ϳ���ʱ��';

prompt
prompt Creating table X_P_H_PASS
prompt =========================
prompt
create table ITMS3.X_P_H_PASS
(
  vehicle_seq_id     NUMBER(10),
  org_code           VARCHAR2(32),
  org_authority_code VARCHAR2(32),
  district_code      VARCHAR2(6),
  road_code          VARCHAR2(6),
  site_code          VARCHAR2(16),
  direction_type     VARCHAR2(16),
  pass_time          DATE not null,
  vehicle_type       VARCHAR2(4),
  num_flow           NUMBER(5) not null,
  place_local_city   NUMBER(5),
  place_local_pr     NUMBER(5),
  place_other_pr     NUMBER(5),
  place_military     NUMBER(5),
  place_unknown      NUMBER(5),
  avg_speed          NUMBER(6,2),
  create_date        DATE
)
tablespace ITMS_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 16K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table ITMS3.X_P_H_PASS
  is 'Сʱ����������';
comment on column ITMS3.X_P_H_PASS.org_code
  is '��������';
comment on column ITMS3.X_P_H_PASS.org_authority_code
  is '����Ȩ�޹��˱���';
comment on column ITMS3.X_P_H_PASS.district_code
  is '��������';
comment on column ITMS3.X_P_H_PASS.road_code
  is '��·����';
comment on column ITMS3.X_P_H_PASS.site_code
  is '��λ����';
comment on column ITMS3.X_P_H_PASS.direction_type
  is '��������';
comment on column ITMS3.X_P_H_PASS.pass_time
  is '����ʱ��';
comment on column ITMS3.X_P_H_PASS.vehicle_type
  is '��������';
comment on column ITMS3.X_P_H_PASS.num_flow
  is '��������';
comment on column ITMS3.X_P_H_PASS.place_local_city
  is '���س�';
comment on column ITMS3.X_P_H_PASS.place_local_pr
  is '��ʡ��';
comment on column ITMS3.X_P_H_PASS.place_other_pr
  is '��ʡ��';
comment on column ITMS3.X_P_H_PASS.place_military
  is '������';
comment on column ITMS3.X_P_H_PASS.place_unknown
  is '����δ֪';
comment on column ITMS3.X_P_H_PASS.avg_speed
  is 'ƽ���ٶ�';
comment on column ITMS3.X_P_H_PASS.create_date
  is '������ڻ��������';

prompt
prompt Creating table X_P_H_PASS_QTR
prompt =============================
prompt
create table ITMS3.X_P_H_PASS_QTR
(
  vehicle_seq_id     NUMBER(10),
  org_code           VARCHAR2(32),
  org_authority_code VARCHAR2(32),
  district_code      VARCHAR2(6),
  road_code          VARCHAR2(6),
  site_code          VARCHAR2(16),
  direction_type     VARCHAR2(16),
  pass_time          DATE,
  vehicle_type       VARCHAR2(4),
  pass_num           NUMBER(5) not null,
  place_local_city   NUMBER(5),
  place_local_pr     NUMBER(5),
  place_other_pr     NUMBER(5),
  place_military     NUMBER(5),
  place_unknown      NUMBER(5),
  avg_speed          NUMBER(6,2),
  create_date        DATE
)
tablespace ITMS_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 16K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table ITMS3.X_P_H_PASS_QTR
  is '15���ӹ���������';
comment on column ITMS3.X_P_H_PASS_QTR.org_code
  is '��������';
comment on column ITMS3.X_P_H_PASS_QTR.org_authority_code
  is '����Ȩ�޹��˱���';
comment on column ITMS3.X_P_H_PASS_QTR.district_code
  is '��������';
comment on column ITMS3.X_P_H_PASS_QTR.road_code
  is '��·����';
comment on column ITMS3.X_P_H_PASS_QTR.site_code
  is '��λ����';
comment on column ITMS3.X_P_H_PASS_QTR.direction_type
  is '��������';
comment on column ITMS3.X_P_H_PASS_QTR.pass_time
  is '����ʱ��';
comment on column ITMS3.X_P_H_PASS_QTR.vehicle_type
  is '��������';
comment on column ITMS3.X_P_H_PASS_QTR.pass_num
  is '������';
comment on column ITMS3.X_P_H_PASS_QTR.place_local_city
  is '���س�';
comment on column ITMS3.X_P_H_PASS_QTR.place_local_pr
  is '��ʡ��';
comment on column ITMS3.X_P_H_PASS_QTR.place_other_pr
  is '��ʡ��';
comment on column ITMS3.X_P_H_PASS_QTR.place_military
  is '������';
comment on column ITMS3.X_P_H_PASS_QTR.place_unknown
  is '����δ֪';
comment on column ITMS3.X_P_H_PASS_QTR.avg_speed
  is 'ƽ���ٶ�';
comment on column ITMS3.X_P_H_PASS_QTR.create_date
  is '������ڻ��������';

prompt
prompt Creating table X_P_IO_PASS
prompt ==========================
prompt
create table ITMS3.X_P_IO_PASS
(
  vehicle_seq_id     NUMBER(10),
  org_code           VARCHAR2(32) not null,
  org_authority_code VARCHAR2(32),
  district_code      VARCHAR2(6) not null,
  site_code          VARCHAR2(16) not null,
  direction_type     VARCHAR2(2) not null,
  enter_or_exit_city CHAR(1),
  vehicle_type       VARCHAR2(3),
  pass_date          DATE not null,
  num_flow           NUMBER(5) not null,
  place_local_city   NUMBER(5),
  place_local_pr     NUMBER(5),
  place_other_pr     NUMBER(5),
  place_military     NUMBER(5),
  place_unknown      NUMBER(5),
  avr_speed          NUMBER(6,2),
  create_date        DATE not null
)
tablespace ITMS_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 16K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table ITMS3.X_P_IO_PASS
  is '�����ǿ������ݱ�';
comment on column ITMS3.X_P_IO_PASS.org_code
  is '��������';
comment on column ITMS3.X_P_IO_PASS.org_authority_code
  is '����Ȩ�ޱ���';
comment on column ITMS3.X_P_IO_PASS.district_code
  is '��������';
comment on column ITMS3.X_P_IO_PASS.site_code
  is '��λ����';
comment on column ITMS3.X_P_IO_PASS.direction_type
  is '��������';
comment on column ITMS3.X_P_IO_PASS.enter_or_exit_city
  is '�����Ǳ��';
comment on column ITMS3.X_P_IO_PASS.vehicle_type
  is '��������';
comment on column ITMS3.X_P_IO_PASS.pass_date
  is '��������';
comment on column ITMS3.X_P_IO_PASS.num_flow
  is '������';
comment on column ITMS3.X_P_IO_PASS.place_local_city
  is '���س�';
comment on column ITMS3.X_P_IO_PASS.place_local_pr
  is '��ʡ��';
comment on column ITMS3.X_P_IO_PASS.place_other_pr
  is '��ʡ��';
comment on column ITMS3.X_P_IO_PASS.place_military
  is '������';
comment on column ITMS3.X_P_IO_PASS.place_unknown
  is '����δ֪';
comment on column ITMS3.X_P_IO_PASS.avr_speed
  is 'ƽ���ٶ�';
comment on column ITMS3.X_P_IO_PASS.create_date
  is '���ʱ������ʱ��';

prompt
prompt Creating table X_P_M_PASS
prompt =========================
prompt
create table ITMS3.X_P_M_PASS
(
  vehicle_seq_id     NUMBER(10),
  org_code           VARCHAR2(32),
  org_authority_code VARCHAR2(32),
  district_code      VARCHAR2(6),
  road_code          VARCHAR2(6),
  site_code          VARCHAR2(16) not null,
  direction_type     VARCHAR2(16),
  lane               VARCHAR2(2),
  vehicle_type       VARCHAR2(4),
  veh_localization   VARCHAR2(2),
  pass_month         CHAR(6) not null,
  avr_flow           NUMBER(10) not null,
  avr_flow_lm        NUMBER(10),
  avr_flow_ly        NUMBER(10),
  create_date        DATE
)
tablespace ITMS_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 16K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table ITMS3.X_P_M_PASS
  is '�¹���������';
comment on column ITMS3.X_P_M_PASS.org_code
  is '��������';
comment on column ITMS3.X_P_M_PASS.org_authority_code
  is '����Ȩ�ޱ���';
comment on column ITMS3.X_P_M_PASS.district_code
  is '��������';
comment on column ITMS3.X_P_M_PASS.road_code
  is '��·����';
comment on column ITMS3.X_P_M_PASS.site_code
  is '��λ����';
comment on column ITMS3.X_P_M_PASS.direction_type
  is '��������';
comment on column ITMS3.X_P_M_PASS.lane
  is '����';
comment on column ITMS3.X_P_M_PASS.vehicle_type
  is '��������';
comment on column ITMS3.X_P_M_PASS.veh_localization
  is '��������';
comment on column ITMS3.X_P_M_PASS.pass_month
  is '�·�';
comment on column ITMS3.X_P_M_PASS.avr_flow
  is 'ƽ������';
comment on column ITMS3.X_P_M_PASS.avr_flow_lm
  is '��������';
comment on column ITMS3.X_P_M_PASS.avr_flow_ly
  is '��������';
comment on column ITMS3.X_P_M_PASS.create_date
  is '������ڻ��������';

prompt
prompt Creating table X_P_S_D_PASS
prompt ===========================
prompt
create table ITMS3.X_P_S_D_PASS
(
  vehicle_seq_id     NUMBER(10),
  org_code           VARCHAR2(32),
  org_authority_code VARCHAR2(32),
  district_code      VARCHAR2(6),
  road_code          VARCHAR2(6) not null,
  site_code          VARCHAR2(16) not null,
  direction_type     VARCHAR2(2) not null,
  lane               VARCHAR2(2),
  vehicle_type       VARCHAR2(3),
  veh_localization   CHAR(1),
  pass_date          DATE,
  pass_num           NUMBER,
  avg_speed          NUMBER,
  create_date        DATE
)
tablespace ITMS_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ITMS3.X_P_S_D_PASS
  is '�չ���������';
comment on column ITMS3.X_P_S_D_PASS.org_code
  is '��������';
comment on column ITMS3.X_P_S_D_PASS.org_authority_code
  is '����Ȩ�ޱ���';
comment on column ITMS3.X_P_S_D_PASS.district_code
  is '��������';
comment on column ITMS3.X_P_S_D_PASS.road_code
  is '��·����';
comment on column ITMS3.X_P_S_D_PASS.site_code
  is '��λ����';
comment on column ITMS3.X_P_S_D_PASS.direction_type
  is '��������';
comment on column ITMS3.X_P_S_D_PASS.lane
  is '����';
comment on column ITMS3.X_P_S_D_PASS.vehicle_type
  is '��������';
comment on column ITMS3.X_P_S_D_PASS.veh_localization
  is '��������';
comment on column ITMS3.X_P_S_D_PASS.pass_date
  is '��������';
comment on column ITMS3.X_P_S_D_PASS.pass_num
  is '������';
comment on column ITMS3.X_P_S_D_PASS.avg_speed
  is 'ƽ���ٶ�';
comment on column ITMS3.X_P_S_D_PASS.create_date
  is '���ʱ������ʱ��';

prompt
prompt Creating sequence SEQ_X_P_H_PASS
prompt ================================
prompt
create sequence ITMS3.SEQ_X_P_H_PASS
minvalue 1
maxvalue 99999999999999999999
start with 5001
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_X_P_H_PASS_QTR
prompt ====================================
prompt
create sequence ITMS3.SEQ_X_P_H_PASS_QTR
minvalue 1
maxvalue 99999999999999999999
start with 1028621
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_X_P_S_D_PASS
prompt ==================================
prompt
create sequence ITMS3.SEQ_X_P_S_D_PASS
minvalue 1
maxvalue 99999999999999999999
start with 64521
increment by 1
cache 20;

prompt
prompt Creating type FAULT_SUB_TIME_OBJ
prompt ================================
prompt
CREATE OR REPLACE TYPE ITMS3."FAULT_SUB_TIME_OBJ" IS OBJECT
(
  DEVICE_ID VARCHAR2(32),
  BEGINTIME date,
  ENDTIME   date,
  DURATION NUMBER
)
/

prompt
prompt Creating type FAULT_SUB_TIME_TABLE
prompt ==================================
prompt
CREATE OR REPLACE TYPE ITMS3.FAULT_SUB_TIME_TABLE IS TABLE OF FAULT_SUB_TIME_OBJ
/


spool off
