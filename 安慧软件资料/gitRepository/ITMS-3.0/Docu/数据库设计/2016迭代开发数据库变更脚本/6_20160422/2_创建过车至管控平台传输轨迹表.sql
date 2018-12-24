set define off
spool 6_2_�����������ܿ�ƽ̨����켣��.log

-- Create table
create table T_DEVICE_DATA_PATH_ITMS
(
  snap_nbr                    VARCHAR2(32) not null,
  pass_time                   DATE not null,
  server_receiving_time       DATE,
  after_server_receiving_time DATE,
  ice2mq_time                 DATE,
  pre_time                    DATE,
  after_time                  DATE,
  itms_time                   DATE not null,
  total_time                  NUMBER(12,2),
  device_key                  VARCHAR2(64),
  sys_component_id            VARCHAR2(32),
  device_id                   VARCHAR2(32) not null,
  org_privilege_code          VARCHAR2(8) not null,
  device_sys_nbr              VARCHAR2(32),
  site_code                   VARCHAR2(16),
  road_code                   VARCHAR2(6)
);
-- Add comments to the table 
comment on table T_DEVICE_DATA_PATH_ITMS
  is '��¼�������ݲ��������鲼��ϵͳֱ�ӵ��ܿ�ƽ̨����켣';
-- Add comments to the columns 
comment on column T_DEVICE_DATA_PATH_ITMS.snap_nbr
  is 'ץ�ı��';
comment on column T_DEVICE_DATA_PATH_ITMS.pass_time
  is '����ʱ��';
comment on column T_DEVICE_DATA_PATH_ITMS.server_receiving_time
  is '��ط���������ʱ��';  
comment on column T_DEVICE_DATA_PATH_ITMS.after_server_receiving_time
  is '���ü�ط���������ʱ��';
comment on column T_DEVICE_DATA_PATH_ITMS.ice2mq_time
  is 'ICE2MQ����ʱ��';
comment on column T_DEVICE_DATA_PATH_ITMS.pre_time
  is 'ǰ�û�����ʱ��';
comment on column T_DEVICE_DATA_PATH_ITMS.after_time
  is '���û�����ʱ��';
comment on column T_DEVICE_DATA_PATH_ITMS.itms_time
  is '�ܿ�ƽ̨����ʱ��';
comment on column T_DEVICE_DATA_PATH_ITMS.total_time
  is '�ܺ�ʱ����λΪ�롣';
comment on column T_DEVICE_DATA_PATH_ITMS.device_key
  is 'Ψһֵ';
comment on column T_DEVICE_DATA_PATH_ITMS.sys_component_id
  is '���ID';
comment on column T_DEVICE_DATA_PATH_ITMS.device_id
  is '���Ӽ��ϵͳID';
comment on column T_DEVICE_DATA_PATH_ITMS.org_privilege_code
  is '����Ȩ�޹��˴���';
comment on column T_DEVICE_DATA_PATH_ITMS.device_sys_nbr
  is '���Ӽ��ϵͳ���';
comment on column T_DEVICE_DATA_PATH_ITMS.site_code
  is '��λ����';
comment on column T_DEVICE_DATA_PATH_ITMS.road_code
  is '��·����';
-- Create/Recreate indexes 
create index IDX_T_DATA_PATH_ITMS on T_DEVICE_DATA_PATH_ITMS (PASS_TIME, ORG_PRIVILEGE_CODE, DEVICE_SYS_NBR, SITE_CODE, ROAD_CODE);
  
spool off

exit;