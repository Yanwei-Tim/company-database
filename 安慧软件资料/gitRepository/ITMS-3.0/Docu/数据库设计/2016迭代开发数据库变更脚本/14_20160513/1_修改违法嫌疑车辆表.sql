set define off
spool 14_1_�޸�Υ�����ɳ�����.log

--�޸�Υ�����ɳ�����
alter table t_vehtrack_pass_to_vio drop column IDENTIFY_ACCORDANCE;
alter table t_vehtrack_pass_to_vio add IDENTIFY_ACCORDANCE clob;

alter table t_vehtrack_pass_to_vio drop column VIO_SUSPECTED_DESC;
alter table t_vehtrack_pass_to_vio add  VIO_SUSPECTED_DESC VARCHAR2(1024);
comment on column t_vehtrack_pass_to_vio.VIO_SUSPECTED_DESC is 'Υ���������������糬��20%';



spool off

exit;
