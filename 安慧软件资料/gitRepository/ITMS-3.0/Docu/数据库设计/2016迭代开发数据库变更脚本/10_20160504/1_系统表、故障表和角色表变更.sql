set define off
spool 10_1_ϵͳ�����ϱ�ͽ�ɫ����.log

alter table T_DEVICE_SYS modify status_type null;

-- Add/modify columns 
alter table T_DEVICE_FAULT modify is_validity default 3;
-- Add comments to the columns 
comment on column T_DEVICE_FAULT.is_validity
  is '����/������Ч�ԡ�1-��Ч��2-��Ч��3-δȷ��';
  
alter table T_SYS_ROLE ADD ORG_CODE VARCHAR2(32) ;
comment on column T_SYS_ROLE.ORG_CODE is '��������';

spool off

exit;