set define off
spool 8_1_�����ֶ�.log

alter table T_VEHTRACK_PASS_TO_VIO add VIO_SUSPECTED_DESC CLOB;
comment on column T_VEHTRACK_PASS_TO_VIO.VIO_SUSPECTED_DESC IS 'Υ����������';


spool off

exit;