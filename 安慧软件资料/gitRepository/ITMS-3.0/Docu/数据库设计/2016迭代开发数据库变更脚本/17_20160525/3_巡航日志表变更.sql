set define off
spool 17_3_Ѳ����־����.log

-- ��־��������ѲԤ�������ֶ�
alter table t_traffic_plan_log add video_plan_name VARCHAR2(256);
comment on column t_traffic_plan_log.video_plan_name
  is '��ѲԤ������';


spool off

exit;