set define off
spool 13_3_�豸״̬ͳ���м����.log

alter table x_d_d_device_status rename column stat_online to ownership;
alter table x_d_d_status_log rename column stat_online to ownership;
alter table x_d_m_status_log rename column stat_online to ownership;




spool off

exit;
