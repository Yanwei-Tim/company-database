set define off
spool 8_3_Υ�����������.log

-- Drop indexes 
drop index IDX_VIO_CREATE_TIME;
-- Create/Recreate indexes 
create index IDX_VIO_DEV_TIME on T_VIO_VIOLATION (device_sys_nbr, violation_time desc);

spool off

exit;