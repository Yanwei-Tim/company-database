set define off
spool 4_��ƵѲ�����.log

alter table t_traffic_plan add DEFAULT_CRUISE_TIMES number;
comment on column t_traffic_plan.DEFAULT_CRUISE_TIMES is 'Ĭ�ϵ���Ѳ��ʱ��';
 
 
alter table t_traffic_plan add TOTAL_CRUISE_TIMES number;
comment on column t_traffic_plan.TOTAL_CRUISE_TIMES is '����Ѳ��ʱ���ܳ�';
 
alter table t_traffic_plan add PLAN_EXECUTE_TIMES number;
comment on column t_traffic_plan.PLAN_EXECUTE_TIMES is '����ִ��ʱ��';

alter table t_traffic_plan_video modify preset_list null;

alter table t_traffic_plan_video add sys_component_id varchar2(32) null;
comment on column t_traffic_plan_video.sys_component_id is '��������Ƶ���id';
 
update t_sys_menu set target_url='tpls/trafficMonitor/videoMonitor/cruise-plan-config.html' where menu_code='020401';
commit;


spool off

exit;