set define off
spool 24_3_���ܲ˵�.log

prompt Deleting T_SYS_MENU...
delete from T_SYS_MENU;
commit;
prompt Deleting T_SYS_FUNCTION...
delete from T_SYS_FUNCTION;
commit;
prompt Loading T_SYS_FUNCTION...
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('08080101', '080801', '�ڼ�������', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06020502', '060205', '�������ͣ��', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06020503', '060205', '������ٱ���', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06020504', '060205', '�������ɾ��', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('07030101', '070301', '���Ƴ�����', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('07030201', '070302', 'Σ�ռ�ʻ��������', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('07030301', '070303', 'Σ�ռ�ʻ�������', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('07030401', '070304', 'Υ��ʱ�շ���', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('07030501', '070305', '���Ƴ�����', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('07030601', '070306', '���ں���ʶ���ʷ���', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('07030701', '070307', '���򰸼���������', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('07030801', '070308', '���泵������', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('07030901', '070309', '��Σ����������', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('07031201', '070312', '�½����ֳ�������', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06020105', '060201', '�豸�༭', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('07031301', '070313', 'Υ�����ɳ�������', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('08090101', '080901', '���Ź���', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06010101', '060101', '�豸���', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06010102', '060101', '���ϲ�ѯ', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06010103', '060101', 'ά������ѯ', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('07031001', '070310', '�����ӳٷ���', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06020103', '060201', '�豸ͣ��', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06020104', '060201', '�豸����', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06020203', '060202', '����ͣ��', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06020204', '060202', '���ڱ���', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('07020601', '070206', 'ʵʱ��������', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06020300', '060203', '������ٲ鿴', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06020200', '060202', '���ڲ鿴', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06020100', '060201', '�豸�鿴', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06010100', '060101', '���м�ز鿴', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('07020701', '070207', '��λ�������Ʒ���', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('05010202', '050102', '������¼����', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('05010303', '050103', '���ݿ�', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06021901', '060219', '�յ������', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('0001', '00', '֪ͨ����', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('0002', '00', '����ר��', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06020102', '060201', '�豸ɾ��', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('07031101', '070311', '�����ʱ�ι��ɷ���', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06040201', '060402', 'ϵͳ�걨����', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('01010101', '010101', '�豸�ֲ�', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06050301', '060503', '�ճ�ά��', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('01020101', '010201', '��ͨ��̬', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('01030101', '010301', '�켣��ѯ', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('02010101', '020101', '��Ƶ���', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('02020101', '020201', '��Ƶ�ط�', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('02030101', '020301', '��ƵѲ��', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('02040101', '020401', 'Ѳ������', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('02050101', '020501', 'Ѳ����־', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('03010101', '030101', '�������', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('03020101', '030201', '������ѯ', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('03030101', '030301', '���س���', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('03030201', '030302', '�����Ƴ�����', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('03030301', '030303', '�Ʊ공����', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('03030401', '030304', '���ر���', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('04010101', '040101', 'Υ����ѯ', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('04020101', '040201', 'Υ���ϴ�', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('04030101', '040301', '���������', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('05010101', '050101', '��Ϣ����', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06010201', '060102', '���ڴ���켣', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06020101', '060201', '�豸����', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06020201', '060202', '��������', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06020301', '060203', '��Ƶ', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06020401', '060204', '�̶�����', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06020501', '060205', '�����������', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06020601', '060206', '�ƶ�����', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06020701', '060207', '���Ӿ���', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06020801', '060208', '��ͨ�¼����', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06020901', '060209', '������', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06021001', '060210', '�յ���', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06021101', '060211', '�źŻ�', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06021201', '060212', 'Υͣ', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06021301', '060213', '��ռ��', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06021401', '060214', '������', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06021501', '060215', '�ƾ������', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06021601', '060216', '��λ����', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06021701', '060217', '����', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06021801', '060218', '��ͬ', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06030101', '060301', '�춨����', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06040101', '060401', '�豸�걨����', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06050101', '060501', '���ϸ澯����', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06050201', '060502', 'ά��������', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06060101', '060601', '������ķ�����', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06060201', '060602', '����ƽ̨', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06060301', '060603', '����������', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06060401', '060604', '��̨������', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('07010101', '070101', '�豸������', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('07010201', '070102', '�豸������', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('07010301', '070103', '�豸�춨��', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('07010401', '070104', '�豸������', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('07020101', '070201', '�����ڷ���', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('07020201', '070202', '��·���ڷ���', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('07020301', '070203', 'Ͻ�����ڷ���', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('07020401', '070204', '��㿨�ڷ���', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('07020501', '070205', '�ڼ�����������', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('08010101', '080101', '������Ϣ', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('08010201', '080102', '�û���Ϣ', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('08020101', '080201', '��ɫȨ��', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('08030101', '080301', 'ϵͳ����', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('08040101', '080401', '������־', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('08050101', '080501', '��·��Ϣ', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('08050201', '080502', '·����Ϣ', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('08050301', '080503', '·����Ϣ', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('08060101', '080601', '��������', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('08060201', '080602', '������Դ', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('08070101', '080701', '�ļ�����', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('09010101', '090101', '·�����', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('09020101', '090201', '��ͨ���ƵǼ�', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('09020201', '090202', '��ͨ�¼��Ǽ�', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('09020301', '090203', '��ͨ����Ǽ�', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('09030101', '090301', '��ֵ����', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('09040101', '090401', '������ض�', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06030301', '060303', '�豸δ�Ǽ�', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06020202', '060202', '����ɾ��', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('06030201', '060302', '�춨֤��ͬ��', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('0000', '00', '�鿴', '1', null, null);
insert into T_SYS_FUNCTION (function_code, menu_code, function_name, function_flag, function_dependency, service_id)
values ('08000001', '080000', 'ϵͳ������ҳ', '1', null, null);
commit;
prompt 116 records loaded
prompt Loading T_SYS_MENU...
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('070312', '070312', '�½����ֳ�������', 'tpls/passVehicle/strangeVehManager/strange-veh-search.html', '0703', '12', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('070313', '070313', 'Υ�����ɳ�������', 'tpls/passVehicle/suspectedIllegalManager/suspected-illegal-veh-analysis.html', '0703', '13', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('0606', '0606', '�����ع���', null, '06', '6', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('060202', '060202', '���ڱ���', 'tpls/deviceManage/deviceRecord/bayonet-manage-list.html', '0602', '02', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('060213', '060213', '��ռ��', 'test', '0602', '13', '0', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('060218', '060218', '��ͬ��Ϣ', 'tpls/deviceManage/informationManage/contract-manage-list.html', '0602', '16', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('070101', '070101', '�豸������', 'tpls/deviceManage/deviceStatistics/device-access-rate.html', '0701', '1', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('0804', '0804', '������־', null, '08', '4', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('0807', '0807', '�ļ�����', null, '08', '7', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('080301', '080301', 'ϵͳ����', 'tpls/sysManagement/systemCode/sysCode-list.html', '0803', '1', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('0903', '0903', '��ֵ����', null, '09', '3', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('0703', '0703', '�����ݷ���', null, '07', '3', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('070301', '070301', '���Ƴ�����', 'tpls/passVehicle/cloneCarManager/clone-car-analysis-list.html', '0703', '1', '0', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('070302', '070302', 'Σ�ռ�ʻ��������', 'tpls/passVehicle/dangerCarManager/danger-car-query-list.html', '0703', '2', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('070303', '070303', 'Σ�ռ�ʻ�������', 'tpls/passVehicle/dangerCarManager/danger-car-whole-list.html', '0703', '3', '0', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('070304', '070304', 'Υ��ʱ�շ���', 'tpls/passVehicle/highRateSpaceTimeManager/highRate-space-time-anaylsis.html', '0703', '4', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('070305', '070305', '���Ƴ�����', 'tpls/passVehicle/nullPlateManager/nullPlate-car-query-list.html', '0703', '5', '0', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('070306', '070306', '���ں���ʶ���ʷ���', 'tpls/passVehicle/plateRecognitionManagement/plate-recognition-list.html', '0703', '6', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('070307', '070307', '���򰸼���������', 'tpls/passVehicle/collisionManager/case-collision-analyse.html', '0703', '7', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('070308', '070308', '���泵������', 'tpls/passVehicle/accompanyCarManager/accompany-query-all.html', '0703', '8', '0', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('070309', '070309', '��Σ����������', 'tpls/passVehicle/dangerAreaManager/dangerarea-vehicle-analyse.html', '0703', '9', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('070310', '070310', '���������ӳٷ���', 'tpls/passVehicle/dataLatencyManager/data-lantency-anylsis.html', '0703', '10', '0', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('00', '00', '��ҳ', null, 'root', '0', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('060219', '060219', '�յ������', 'tpls/informationDelivery/inducedScreenRelease/specifications-config-list.html', '0602', '19', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('070311', '070311', '�����ʱ�ι��ɷ���', 'tpls/passVehicle/activeRegularManager/veh-active-regular-analysis.html', '0703', '11', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('01', '01', '���ӵ�ͼ', null, 'root', '1', '1', null, 'themes/default/images/dzdt.png');
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('02', '02', '��Ƶ���', null, 'root', '2', '1', null, 'themes/default/images/spjk.png');
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('03', '03', '�������', null, 'root', '4', '1', null, 'themes/default/images/clck.png');
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('04', '04', 'Υ������', null, 'root', '5', '1', null, 'themes/default/images/wfgl.png');
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('05', '05', '��Ϣ����', null, 'root', '6', '1', null, 'themes/default/images/xxfb.png');
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('06', '06', '�豸��ά', null, 'root', '7', '1', null, 'themes/default/images/sbyw.png');
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('07', '07', 'ͳ�Ʒ���', null, 'root', '8', '1', null, 'themes/default/images/tjfx.png');
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('08', '08', 'ϵͳ����', null, 'root', '9', '1', null, 'themes/default/images/xtgl.png');
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('0809', '0809', '���Ź���', null, '08', '9', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('0101', '0101', '�豸�ֲ�', null, '01', '1', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('0102', '0102', '��̬ͨ��', null, '01', '2', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('0103', '0103', '�켣��ѯ', null, '01', '3', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('010101', '010101', '�豸�ֲ�', 'tpls/deviceManage/deviceMonitor/device-moniter-onGIS.html', '0101', '1', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('010201', '010201', '��̬ͨ��', 'tpls/trafficMonitor/trafficState/traffic-situation.html', '0102', '1', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('010301', '010301', '�켣��ѯ', 'tpls/passVehicle/vehicleQuery/vehicle-path-query.html', '0103', '1', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('0201', '0201', '��Ƶ���', null, '02', '1', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('0202', '0202', '��Ƶ�ط�', null, '02', '2', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('0203', '0203', '��ƵѲ��', null, '02', '3', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('0204', '0204', 'Ѳ������', null, '02', '4', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('0205', '0205', 'Ѳ����־', null, '02', '5', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('020101', '020101', '��Ƶ���', 'tpls/trafficMonitor/videoMonitor/realTimeMonitor.html', '0201', '1', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('020201', '020201', '��Ƶ�ط�', 'tpls/trafficMonitor/videoMonitor/playback.html', '0202', '1', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('020301', '020301', '��ƵѲ��', 'tpls/trafficMonitor/videoMonitor/cruise.html', '0203', '1', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('020401', '020401', 'Ѳ������', 'tpls/trafficMonitor/videoMonitor/cruise-plan-config.html', '0204', '1', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('020501', '020501', 'Ѳ����־', 'tpls/trafficMonitor/videoMonitor/cruise-log-list.html', '0205', '1', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('0301', '0301', '�������', null, '03', '1', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('0302', '0302', '������ѯ', null, '03', '2', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('0303', '0303', '��������', null, '03', '3', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('030101', '030101', '�������', 'tpls/passVehicle/passMonitor/pass-vehicle-monitor.html', '0301', '1', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('030201', '030201', '������ѯ', 'tpls/passVehicle/vehicleQuery/vehicle-query-all.html', '0302', '1', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('030301', '030301', '���س���', 'tpls/passVehicle/controlManager/control-uncontrol-manager.html', '0303', '1', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('030302', '030302', '�����Ƴ�����', 'tpls/passVehicle/controlManager/false-deck-manager.html', '0303', '2', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('030303', '030303', '�Ʊ공����', 'tpls/passVehicle/controlManager/yellow-label-car-manager.html', '0303', '3', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('030304', '030304', '���ر���', 'tpls/passVehicle/alarmManager/control-manager-list.html', '0303', '4', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('0401', '0401', 'Υ����ѯ', null, '04', '1', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('0402', '0402', 'Υ���ϴ�', null, '04', '2', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('0403', '0403', '���������', null, '04', '3', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('040101', '040101', 'Υ����ѯ', 'tpls/violationMgr/ViolationManager/ViolationQuery.html', '0401', '1', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('040201', '040201', 'Υ���ϴ�', 'tpls/violationMgr/ViolationManager/UploadQuery.html', '0402', '1', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('040301', '040301', '���������', 'test', '0403', '1', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('0501', '0501', '��Ϣ����', null, '05', '1', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('050101', '050101', '��Ϣ����', 'test', '0501', '1', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('0601', '0601', '�豸���', null, '06', '1', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('0602', '0602', '��������', null, '06', '2', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('0603', '0603', '�춨����', null, '06', '3', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('0604', '0604', '�걨����', null, '06', '4', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('0605', '0605', 'ά������', null, '06', '5', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('060101', '060101', '�豸���м��', 'tpls/deviceManage/deviceMonitor/device-status-monitor.html', '0601', '1', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('060102', '060102', '���ڴ���켣', 'tpls/deviceManage/systemMaintainManage/data-transmission-path-list.html', '0601', '2', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('060201', '060201', '�豸������', 'tpls/deviceManage/deviceConfig/device-sys-list.html', '0602', '01', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('060203', '060203', '��Ƶ', 'test', '0602', '03', '0', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('060204', '060204', '�̶�����', 'test', '0602', '04', '0', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('060205', '060205', '�������', 'tpls/deviceManage/deviceConfig/interval-system-device-list.html', '0602', '05', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('060206', '060206', '�ƶ�����', 'test', '0602', '06', '0', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('060207', '060207', '���Ӿ���', 'test', '0602', '07', '0', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('060208', '060208', '��ͨ�¼����', 'test', '0602', '08', '0', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('060209', '060209', '������', 'test', '0602', '09', '0', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('060210', '060210', '�յ���', 'test', '0602', '10', '0', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('060211', '060211', '�źŻ�', 'test', '0602', '11', '0', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('060212', '060212', 'Υͣ', 'test', '0602', '12', '0', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('060214', '060214', '������', 'test', '0602', '14', '0', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('060215', '060215', '�ƾ������', 'test', '0602', '15', '0', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('060216', '060216', '��λ����', 'tpls/sysManagement/roadNetworkMessage/point-message.html', '0602', '18', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('060217', '060217', '������Ϣ', 'tpls/deviceManage/informationManage/company-manage-list.html', '0602', '17', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('060301', '060301', '�豸�춨����', 'tpls/deviceManage/deviceCertification/certification-info-list.html', '0603', '1', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('060401', '060401', '�豸�걨����', 'tpls/deviceManage/deviceSystemApplicationEndorsement/deviceApplicationEndorsement/device-build-list.html', '0604', '1', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('060402', '060402', 'ϵͳ�걨����', 'tpls/deviceManage/deviceSystemApplicationEndorsement/systemApplicationEndorsement/sys-application-list.html', '0604', '2', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('060501', '060501', '���ϸ澯����', 'tpls/deviceManage/deviceMaintenance/fault-alarm-manager.html', '0605', '1', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('060502', '060502', 'ά��������', 'tpls/deviceManage/deviceMaintenance/maintenance-manage.html', '0605', '2', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('060601', '060601', '������ķ�����', 'tpls/deviceManage/informationManage/monitoring-center-manage-list.html', '0606', '1', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('060602', '060602', '����ƽ̨', 'tpls/deviceManage/accessPlatform/access-platform-list.html', '0606', '2', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('060603', '060603', '����������', 'tpls/deviceManage/informationManage/server-type-manage-list.html', '0606', '3', '0', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('060604', '060604', '��̨������', 'test', '0606', '4', '0', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('0701', '0701', '�豸����', null, '07', '1', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('0702', '0702', '��ͨ����ͳ��', null, '07', '2', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('070102', '070102', '�豸������', 'tpls/deviceManage/deviceStatistics/device-online-rate.html', '0701', '2', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('070103', '070103', '�豸�춨��', 'tpls/deviceManage/deviceStatistics/device-certification-rate.html', '0701', '3', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('070104', '070104', '�豸������', 'tpls/deviceManage/deviceStatistics/device-fault-rate.html', '0701', '4', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('070201', '070201', '�����ڷ���', 'tpls/statisticsAnalysis/flowAnalysis/single-site-flow-analysis.html', '0702', '1', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('070202', '070202', '��·���ڷ���', 'tpls/statisticsAnalysis/flowAnalysis/road-flow-analysis.html', '0702', '2', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('070203', '070203', 'Ͻ�����ڷ���', 'tpls/statisticsAnalysis/flowAnalysis/district-flow-analysis.html', '0702', '3', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('070204', '070204', '��㿨�ڷ���', 'tpls/statisticsAnalysis/flowAnalysis/multi-site-flow-analysis.html', '0702', '4', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('070205', '070205', '�ڼ�����������', 'tpls/statisticsAnalysis/flowAnalysis/holidayflowAnalysis.html', '0702', '5', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('0801', '0801', '�����û�', null, '08', '1', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('0802', '0802', '��ɫȨ��', null, '08', '2', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('0803', '0803', 'ϵͳ����', null, '08', '3', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('0805', '0805', '·����Ϣ', null, '08', '5', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('0806', '0806', '��ͨ������Ϣ', null, '08', '6', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('080101', '080101', '������Ϣ', 'tpls/sysManagement/org/org-list.html', '0801', '1', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('080102', '080102', '�û���Ϣ', 'tpls/sysManagement/user/user-list.html', '0801', '2', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('080201', '080201', '��ɫȨ��', 'tpls/sysManagement/rolePermission/role-permission-message.html', '0802', '1', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('080401', '080401', '������־', 'tpls/sysManagement/operationLog/operation-log-list.html', '0804', '1', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('080501', '080501', '��·��Ϣ', 'tpls/sysManagement/roadNetworkMessage/road-message-list.html', '0805', '1', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('080502', '080502', '·����Ϣ', 'tpls/sysManagement/roadNetworkMessage/road-section-message-list.html', '0805', '2', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('080503', '080503', '·����Ϣ', 'tpls/sysManagement/roadNetworkMessage/crossing-message-list.html', '0805', '3', '0', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('080601', '080601', '��������', 'tpls/sysManagement/traffic/traffic-police.html', '0806', '1', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('080602', '080602', '������Դ', 'test', '0806', '2', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('080701', '080701', '�ļ�����', 'tpls/sysManagement/downLoad/download-file.html', '0807', '1', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('080901', '080901', '���Ź���', 'tpls/sysManagement/msgManage/message-list.html', '0809', '1', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('0902', '0902', '��ͨ�¼�����', null, '09', '2', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('0904', '0904', '������ض�', null, '09', '4', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('090101', '090101', '·�����', 'tpls/trafficMonitor/trafficState/traffic-situation.html', '0901', '1', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('090201', '090201', '��ͨ���ƵǼ�', 'tpls/trafficMonitor/manualEvent/traffic-control.html', '0902', '1', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('090202', '090202', '��ͨ�¼��Ǽ�', 'tpls/trafficMonitor/manualEvent/manual-event.html', '0902', '2', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('090203', '090203', '��ͨ����Ǽ�', 'tpls/trafficMonitor/manualEvent/manual-weather.html', '0902', '3', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('090301', '090301', '��ֵ����', 'tpls/trafficMonitor/trafficWeather/weather-threshold-setting.html', '0903', '1', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('090401', '090401', '������ض�', 'tpls/sysManagement/roadNetworkMessage/region-message-list.html', '0904', '1', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('080801', '080801', '�ڼ�������', 'tpls/sysManagement/festival/festival-setting.html', '0808', '1', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('0808', '0808', '�����趨', null, '08', '8', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('060302', '060302', '�춨֤��ͬ��', 'tpls/deviceManage/deviceCertification/certification-synchronize-list.html', '0603', '2', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('060303', '060303', '�豸δ�Ǽ�', 'tpls/deviceManage/deviceCertification/device-unregistered-list.html', '0603', '3', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('070206', '070206', 'ʵʱ��������', 'tpls/statisticsAnalysis/flowAnalysis/real-time-pass-analysis.html', '0702', '6', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('0800', '0800', 'ϵͳ����ſ�', null, '08', '0', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('080000', '080000', 'ϵͳ������ҳ', 'tpls/sysManagement/home/sys-home.html', '0800', '1', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('070207', '070207', '��λ�������Ʒ���', 'tpls/statisticsAnalysis/sectionflowAnalysis/site-flow-trend-analysis.html', '0702', '7', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('060503', '060503', '�ճ�ά��', 'tpls/deviceManage/deviceMaintenance/manitain-daily-manage.html', '0605', '3', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('050103', '050103', '���ݿ�', 'tpls/informationDelivery/contentLibraryManage/content-library-manage-list.html', '0501', '3', '1', null, null);
insert into T_SYS_MENU (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values ('050102', '050102', '������¼����', 'tpls/informationDelivery/releaseInfoManage/release-info-manage-list.html', '0501', '2', '1', null, null);
commit;
prompt 143 records loaded
prompt Done.

spool off

exit;

