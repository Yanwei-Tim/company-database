set define off
spool 22_1_Ԥ��λ����.log

--����Ԥ��λ����ʷ������ȷ����������sql�ܳɹ�ִ��
delete t_traffic_preset p where not exists(select 1 from t_device_sys d 
where p.device_id=d.device_id);

--����t_device_sys����ɾ�����
alter table t_traffic_preset add constraint FK_T_DEVICE_SYS
foreign key(device_id) references t_device_sys(device_id) on delete cascade;

spool off

exit;
