set define off
spool 17_2_Υ�����ɱ���������.log

create index idx_pass2vio_event on t_vehtrack_pass_to_vio (plate_nbr, detection_time);

spool off

exit;