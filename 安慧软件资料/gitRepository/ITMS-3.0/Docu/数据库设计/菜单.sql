--t_sys_role��
--ɾ��������:
delete from t_sys_role;

--��ӽ�ɫȨ����Ϣ
insert into t_sys_role (role_id,role_name,role_enable_flag,role_remark,data_access_type) 
values ('9a86c55384ac4f4eb0e848a28d6ea8d6','����Ա','1','ά����Ա','0');


--t_sys_user��
--ɾ��������:
delete from t_sys_user ;


--����û���Ϣ
insert into T_SYS_USER (user_id, other_org_id, org_id, police_id, login_name, login_password, permission_ip_list, is_online, latest_login_time, total_login_counts, name, valid_date)
values ('355e8f04ce7447929dde896e289c84ef', null, '53000000', '26ad6bde49b643e5b24086a751c8e257', 'ADMIN', 'e10adb3949ba59abbe56e057f20f883e', null, '2', to_date('14-03-2016 11:14:40', 'dd-mm-yyyy hh24:mi:ss'), 0, '����Ա', null);



--���ò˵�
--t_sys_menu��,  t_sys_function��:

--ɾ�������ݣ�
delete from t_sys_menu;

--(һ���˵�)
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('01','01','���ӵ�ͼ','','root',1,1,null,'themes/default/images/dzdt.png');
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('02','02','��Ƶ���','','root',2,1,null,'themes/default/images/spjk.png');
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('03','03','�������','','root',4,1,null,'themes/default/images/clck.png');
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('04','04','Υ������','','root',5,1,null,'themes/default/images/wfgl.png');
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('05','05','��Ϣ����','','root',6,1,null,'themes/default/images/xxfb.png');
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('06','06','�豸��ά','','root',7,1,null,'themes/default/images/sbyw.png');
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('07','07','ͳ�Ʒ���','','root',8,1,null,'themes/default/images/tjfx.png');
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('08','08','ϵͳ����','','root',9,1,null,'themes/default/images/xtgl.png');
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('09','09','·�����','','root',3,1,null,'themes/default/images/lkjk.png');
--�����ӵ�ͼ��
--�������˵���
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('0101','0101','�豸�ֲ�','','01',1,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('0102','0102','��̬ͨ��','','01',2,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('0103','0103','�켣��ѯ','','01',3,1);
--�������˵���
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('010101','010101','�豸�ֲ�','tpls/deviceManage/deviceMonitor/device-moniter-onGIS.html','0101',1,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('010201','010201','��̬ͨ��','tpls/trafficMonitor/trafficState/traffic-state.html','0102',1,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('010301','010301','�켣��ѯ','tpls/passVehicle/vehicleQuery/vehicle-path-query.html','0103',1,1);

--����Ƶ��أ�
--�������˵���
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('0201','0201','��Ƶ���','','02',1,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('0202','0202','��Ƶ�ط�','','02',2,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('0203','0203','��ƵѲ��','','02',3,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('0204','0204','Ѳ������','','02',4,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('0205','0205','Ѳ����־','','02',5,1);
--�������˵���
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('020101','020101','��Ƶ���','tpls/trafficMonitor/videoMonitor/realTimeMonitor.html','0201',1,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('020201','020201','��Ƶ�ط�','tpls/trafficMonitor/videoMonitor/playback.html','0202',1,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('020301','020301','��ƵѲ��','tpls/trafficMonitor/videoMonitor/cruise.html','0203',1,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('020401','020401','Ѳ������','tpls/trafficMonitor/videoMonitor/cruisePlanConfig.html','0204',1,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('020501','020501','Ѳ����־','tpls/trafficMonitor/videoMonitor/cruise-log-list.html','0205',1,1);

--��������أ�
--�������˵���
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('0301','0301','�������','','03',1,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('0302','0302','������ѯ','','03',2,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('0303','0303','��������','','03',3,1);
--�������˵���
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('030101','030101','�������','tpls/passVehicle/passMonitor/pass-vehicle-monitor.html','0301',1,1);

insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('030201','030201','������ѯ','tpls/passVehicle/vehicleQuery/vehicle-query-all.html','0302',1,1);

insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('030301','030301','���س���','tpls/passVehicle/controlManager/control-uncontrol-manager.html','0303',1,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('030302','030302','�����Ƴ�����','tpls/passVehicle/controlManager/false-deck-manager.html','0303',2,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('030303','030303','�Ʊ공����','tpls/passVehicle/controlManager/yellow-label-car-manager.html','0303',3,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('030304','030304','���ر���','tpls/passVehicle/alarmManager/control-manager-list.html','0303',4,1);

--��Υ������
--�������˵���
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('0401','0401','Υ����ѯ','','04',1,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('0402','0402','Υ���ϴ�','','04',2,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('0403','0403','���������','','04',3,1);
--�������˵���
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('040101','040101','Υ����ѯ','tpls/violationMgr/ViolationManager/ViolationQuery.html','0401',1,1);

insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('040201','040201','Υ���ϴ�','tpls/violationMgr/ViolationManager/UploadQuery.html','0402',1,1);

insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('040301','040301','���������','test','0403',1,1);
--����Ϣ������
--�������˵���
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('0501','0501','��Ϣ����','','05',1,1);
--�������˵���
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('050101','050101','��Ϣ����','test','0501',1,1);

--���豸��ά��
--�������˵���
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('0601','0601','�豸���','','06',1,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('0602','0602','��������','','06',2,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('0603','0603','�춨����','','06',3,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('0604','0604','�걨����','','06',4,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('0605','0605','ά������','','06',5,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('0606','0606','�����ع���','','06',6,1);
--�������˵���
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('060101','060101','�豸���м��','tpls/deviceManage/deviceMonitor/device-status-monitor.html','0601',1,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('060102','060102','���ڴ���켣','tpls/deviceManage/systemMaintainManage/data-transmission-path-list.html','0601',2,1);

insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('060201','060201','�豸��������','tpls/deviceManage/deviceConfig/device-sys-list.html','0602',01,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('060202','060202','���ڱ���','tpls/deviceManage/deviceRecord/bayonet-manage-list.html','0602',02,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('060203','060203','��Ƶ','test','0602',03,0);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('060204','060204','�̶�����','test','0602',04,0);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('060205','060205','�������','tpls/deviceManage/deviceConfig/interval-system-device-list.html','0602',05,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('060206','060206','�ƶ�����','test','0602',06,0);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('060207','060207','���Ӿ���','test','0602',07,0);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('060208','060208','��ͨ�¼����','test','0602',08,0);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('060209','060209','������','test','0602',09,0);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('060210','060210','�յ���','test','0602',10,0);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('060211','060211','�źŻ�','test','0602',11,0);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('060212','060212','Υͣ','test','0602',12,0);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('060213','060213','��ռ��','test','0602',13,0);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('060214','060214','������','test','0602',14,0);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('060215','060215','�ƾ������','test','0602',15,0);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('060216','060216','��λ����','tpls/sysManagement/roadNetworkMessage/point-message.html','0602',18,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('060217','060217','������Ϣ','tpls/deviceManage/informationManage/company-manage-list.html','0602',17,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('060218','060218','��ͬ��Ϣ','tpls/deviceManage/informationManage/contract-manage-list.html','0602',16,1);

insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('060301','060301','�춨����','test','0603',1,1);

insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('060401','060401','�豸�걨����','tpls/deviceManage/deviceSystemApplicationEndorsement/deviceApplicationEndorsement/device-build-list.html','0604',1,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('060402','060402','ϵͳ�걨����','tpls/deviceManage/deviceSystemApplicationEndorsement/systemApplicationEndorsement/sys-application-list.html','0604',2,1);

insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('060501','060501','���ϸ澯����','tpls/deviceManage/deviceMaintenance/fault-alarm-manager.html','0605',1,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('060502','060502','ά��������','tpls/deviceManage/deviceMaintenance/maintenance-manage.html','0605',2,1);

insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('060601','060601','������ķ�����','tpls/deviceManage/informationManage/monitoring-center-manage-list.html','0606',1,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('060602','060602','����ƽ̨','tpls/deviceManage/accessPlatform/access-platform-list.html','0606',2,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('060603','060603','����������','tpls/deviceManage/informationManage/server-type-manage-list.html','0606',3,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('060604','060604','��̨������','test','0606',4,1);

--��ͳ�Ʒ�����
--�������˵���
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('0701','0701','�豸����','','07',1,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('0702','0702','��ͨ����ͳ��','','07',2,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('0703','0703','�����ݷ���','','07',3,1);
--�������˵���
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('070101','070101','�豸������','tpls/deviceManage/deviceStatistics/device-access-rate.html','0701',1,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('070102','070102','�豸������','tpls/deviceManage/deviceStatistics/device-online-rate.html','0701',2,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('070103','070103','�豸�춨��','tpls/deviceManage/deviceStatistics/device-certification-rate.html','0701',3,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('070104','070104','�豸������','tpls/deviceManage/deviceStatistics/device-fault-rate.html','0701',4,1);

insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('070201','070201','�����ڷ���','tpls/statisticsAnalysis/flowAnalysis/single-site-flow-analysis.html','0702',1,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('070202','070202','��·���ڷ���','tpls/statisticsAnalysis/flowAnalysis/road-flow-analysis.html','0702',2,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('070203','070203','Ͻ�����ڷ���','tpls/statisticsAnalysis/flowAnalysis/district-flow-analysis.html','0702',3,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('070204','070204','��㿨�ڷ���','tpls/statisticsAnalysis/flowAnalysis/multi-site-flow-analysis.html','0702',4,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('070205','070205','�ڼ�����������','tpls/statisticsAnalysis/flowAnalysis/holidayflowAnalysis.html','0702',5,1);

insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('070301','070301','���Ƴ�����','tpls/passVehicle/cloneCarManager/clone-car-analysis-list.html','0703',1,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('070302','070302','Σ�ռ�ʻTopN����','tpls/passVehicle/dangerCarManager/danger-car-query-list.html','0703',2,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('070303','070303','Σ�ռ�ʻ�������','tpls/passVehicle/dangerCarManager/danger-car-whole-list.html','0703',3,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('070304','070304','Σ�ռ�ʻ�������','tpls/passVehicle/collisionManager/case-collision-analyse.html','0703',4,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('070305','070305','���Ƴ�����','tpls/passVehicle/nullPlateManager/nullPlate-car-query-list.html','0703',5,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('070306','070306','����ʶ����','tpls/passVehicle/plateRecognitionManagement/plate-recognition-list.html','0703',6,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('070307','070307','���򰸼���������','tpls/passVehicle/collisionManager/case-collision-analyse.html','0703',7,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('070308','070308','���泵������','tpls/passVehicle/accompanyCarManager/accompany-query-all.html','0703',8,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('070309','070309','��Σ����������','tpls/passVehicle/dangerAreaManager/dangerarea-vehicle-analyse.html','0703',9,1);

--��ϵͳ����
--�������˵���
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('0801','0801','�����û�','','08',1,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('0802','0802','��ɫȨ��','','08',2,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('0803','0803','ϵͳ����','','08',3,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('0804','0804','������־','','08',4,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('0805','0805','·����Ϣ','','08',5,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('0806','0806','��ͨ������Ϣ','','08',6,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('0807','0807','�ļ�����','','08',7,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('0808','0808','�����趨','','08',8,1);
--�������˵���
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('080101','080101','������Ϣ','tpls/sysManagement/org/org-list.html','0801',1,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('080102','080102','�û���Ϣ','tpls/sysManagement/user/user-list.html','0801',2,1);

insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('080201','080201','��ɫȨ��','tpls/sysManagement/rolePermission/role-permission-message.html','0802',1,1);

insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('080301','080301','ϵͳ����','tpls/sysManagement/systemCode/sysCode-list.html','0803',1,1);

insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('080401','080401','������־','tpls/sysManagement/operationLog/operation-log-list.html','0804',1,1);

insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('080501','080501','��·��Ϣ','tpls/sysManagement/roadNetworkMessage/road-message-list.html','0805',1,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('080502','080502','·����Ϣ','tpls/sysManagement/roadNetworkMessage/road-section-message-list.html','0805',2,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('080503','080503','·����Ϣ','tpls/sysManagement/roadNetworkMessage/crossing-message-list.html','0805',3,1);

insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('080601','080601','��������','tpls/sysManagement/traffic/traffic-police.html','0806',1,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('080602','080602','������Դ','test','0806',2,1);

insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('080701','080701','�ļ�����','tpls/sysManagement/downLoad/download-file.html','0807',1,1);

insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('080801','080801','�ڼ�������','tpls/sysManagement/festival/festival-setting.html','0808',1,1);

--��·����أ�
--�������˵���
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('0901','0901','·�����','','09',1,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('0902','0902','��ͨ�¼�����','','09',2,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('0903','0903','��ֵ����','','09',3,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('0904','0904','������ض�','','09',4,1);
--�������˵���
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('090101','090101','·�����','tpls/trafficMonitor/trafficState/traffic-state.html','0901',1,1);

insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('090201','090201','��ͨ���ƵǼ�','tpls/trafficMonitor/manualEvent/traffic-control.html','0902',1,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('090202','090202','��ͨ�¼��Ǽ�','tpls/trafficMonitor/manualEvent/manual-event.html','0902',2,1);
insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('090203','090203','��ͨ����Ǽ�','tpls/trafficMonitor/manualEvent/manual-weather.html','0902',3,1);

insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('090301','090301','��ֵ����','tpls/trafficMonitor/trafficWeather/weather-threshold-setting.html','0903',1,1);

insert into t_sys_menu (menu_code,sys_config_id,menu_name,target_url,parent_code,sort_index,menu_enable_flag)
values('090401','090401','������ض�','tpls/sysManagement/roadNetworkMessage/region-message-list.html','0904',1,1);


--��������
delete from t_sys_function;

--�����ӵ�ͼ��
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('01010101','010101','�豸�ֲ�','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('01020101','010201','��ͨ��̬','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('01030101','010301','�켣��ѯ','1');

--����Ƶ��أ�
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('02010101','020101','��Ƶ���','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('02020101','020201','��Ƶ�ط�','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('02030101','020301','��ƵѲ��','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('02040101','020401','Ѳ������','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('02050101','020501','Ѳ����־','1');

--��������أ�
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('03010101','030101','�������','1');

insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('03020101','030201','������ѯ','1');

insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('03030101','030301','���س���','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('03030201','030302','�����Ƴ�����','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('03030301','030303','�Ʊ공����','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('03030401','030304','���ر���','1');

insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('03040101','030401','���䳵����','1');


insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('03050101','030501','Σ�ռ�ʻTopN����','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('03050201','030502','Σ�ռ�ʻ�������','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('03050301','030503','Σ�ռ�ʻ�������','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('03050401','030504','���Ƴ�����','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('03050501','030505','����ʶ����','1');

--��Υ������
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('04010101','040101','Υ����ѯ','1');

insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('04020101','040201','Υ���ϴ�','1');

insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('04030101','040301','���������','1');

--����Ϣ������
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('05010101','050101','��Ϣ����','1');

--���豸��ά��
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('06010101','060101','�豸���','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('06010102','060101','���ϲ�ѯ','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('06010103','060101','ά������ѯ','1');


insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('06010201','060102','���ڴ���켣','1');

insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('06020101','060201','�豸��������','1');

insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('06020201','060202','��������','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('06020202','060202','����ɾ��','1');

insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('06020301','060203','��Ƶ','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('06020401','060204','�̶�����','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('06020501','060205','�������','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('06020601','060206','�ƶ�����','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('06020701','060207','���Ӿ���','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('06020801','060208','��ͨ�¼����','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('06020901','060209','������','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('06021001','060210','�յ���','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('06021101','060211','�źŻ�','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('06021201','060212','Υͣ','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('06021301','060213','��ռ��','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('06021401','060214','������','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('06021501','060215','�ƾ������','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('06021601','060216','��λ����','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('06021701','060217','����','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('06021801','060218','��ͬ','1');

insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('06030101','060301','�춨����','1');

insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('06040101','060401','�豸�걨����','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('06040201','060402','ϵͳ�걨����','1');

insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('06050101','060501','���ϸ澯����','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('06050201','060502','ά��������','1');

insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('06060101','060601','������ķ�����','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('06060201','060602','����ƽ̨','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('06060301','060603','����������','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('06060401','060604','��̨������','1');

--��ͳ�Ʒ�����
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('07010101','070101','�豸������','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('07010201','070102','�豸������','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('07010301','070103','�豸�춨��','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('07010401','070104','�豸������','1');

insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('07020101','070201','�����ڷ���','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('07020201','070202','��·���ڷ���','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('07020301','070203','Ͻ�����ڷ���','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('07020401','070204','��㿨�ڷ���','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('07020501','070205','�ڼ�����������','1');

insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('07030101','070301','���Ƴ�����','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('07030201','070302','Σ�ռ�ʻTopN����','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('07030301','070303','Σ�ռ�ʻ�������','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('07030401','070304','Σ�ռ�ʻ�������','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('07030501','070305','���Ƴ�����','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('07030601','070306','����ʶ����','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('07030701','070307','���򰸼���������','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('07030801','070308','���泵������','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('07030901','070309','��Σ����������','1');

--��ϵͳ����
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('08010101','080101','������Ϣ','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('08010201','080102','�û���Ϣ','1');

insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('08020101','080201','��ɫȨ��','1');

insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('08030101','080301','ϵͳ����','1');

insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('08040101','080401','������־','1');

insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('08050101','080501','��·��Ϣ','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('08050201','080502','·����Ϣ','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('08050301','080503','·����Ϣ','1');

insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('08060101','080601','��������','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('08060201','080602','������Դ','1');

insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('08070101','080701','�ļ�����','1');

insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('08080101','080801','�ڼ�������','1');

--��·����أ�
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('09010101','090101','·�����','1');

insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('09020101','090201','��ͨ���ƵǼ�','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('09020201','090202','��ͨ�¼��Ǽ�','1');
insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('09020301','090203','��ͨ����Ǽ�','1');

insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('09030101','090301','��ֵ����','1');

insert into t_sys_function(function_code,menu_code,function_name,function_flag)
values('09040101','090401','������ض�','1');



--t_sys_role_permission��:
--ɾ�������ݣ�
delete from t_sys_role_permission;

insert into t_sys_role_permission(role_id,function_code) select '9a86c55384ac4f4eb0e848a28d6ea8d6',function_code from t_sys_function


