set define off
spool 1_��������켣�����ű�.log

alter table T_DEVICE_DATA_PATH add device_sys_nbr VARCHAR2(32);
alter table T_DEVICE_DATA_PATH add site_code VARCHAR2(16);
alter table T_DEVICE_DATA_PATH add road_code VARCHAR2(6);
comment on column T_DEVICE_DATA_PATH.device_sys_nbr  is '���Ӽ��ϵͳ���';
comment on column T_DEVICE_DATA_PATH.site_code is '��λ����';
comment on column T_DEVICE_DATA_PATH.road_code is '��·����';

alter table T_DEVICE_DATA_PATH add after_server_receiving_time date;
comment on column T_DEVICE_DATA_PATH.after_server_receiving_time
  is '���ü�ط���������ʱ��';

create index IDX_T_DATA_PATH on T_DEVICE_DATA_PATH (pass_time, org_privilege_code, device_sys_nbr, site_code, road_code);

spool off

exit;