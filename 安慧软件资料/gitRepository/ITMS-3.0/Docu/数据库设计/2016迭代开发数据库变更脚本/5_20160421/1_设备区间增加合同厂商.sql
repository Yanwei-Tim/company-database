set define off
spool 5_1_�豸�������Ӻ�ͬ����.log

alter table t_device_region add(contract_id VARCHAR2(32), contractor_id VARCHAR2(32));

spool off

exit;
