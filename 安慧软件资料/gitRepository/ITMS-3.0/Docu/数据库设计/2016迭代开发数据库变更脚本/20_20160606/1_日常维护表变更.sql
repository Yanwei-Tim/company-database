set define off
spool 20_1_�ճ�ά������.log

ALTER TABLE t_device_daily_maintain MODIFY DEVICE_ID VARCHAR2(32);
ALTER TABLE t_device_daily_maintain ADD (TRAFFIC_DATA_FLOW CHAR(1));

spool off

exit;
