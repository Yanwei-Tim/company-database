set define off
spool 9_1_Υ�����ɱ���.log

alter table T_VEHTRACK_PASS_TO_VIO modify IDENTIFY_TYPE VARCHAR2(6);
comment on column T_VEHTRACK_PASS_TO_VIO.IDENTIFY_TYPE IS 'Υ����������';



spool off

exit;