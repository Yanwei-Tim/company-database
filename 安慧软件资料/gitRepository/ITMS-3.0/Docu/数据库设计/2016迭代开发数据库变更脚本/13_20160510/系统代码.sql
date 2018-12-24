set define off
spool 13_ϵͳ����.log

prompt Deleting T_SYS_CODE...
delete from T_SYS_CODE;
commit;
prompt Deleting T_SYS_CODE_TYPE...
delete from T_SYS_CODE_TYPE;
commit;
prompt Loading T_SYS_CODE_TYPE...
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('230', '�⴦�����', '1', null, '1', 'NO_PUNISH_FLAG');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('231', '�鳵�������', '1', null, '1', 'QUERY_PROTECT_FLAG');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('232', 'ȷ�ϱ��', '1', null, '1', 'CONFIRM_FLAG');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('233', '�Ƿ���ת��Υ��', '1', null, '1', 'IS_CHANGE_VIO');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('234', '���Ʊ��', '1', null, '1', 'CLONE_FLAG');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('235', '���Ʊ��', '1', null, '1', 'FAKE_FLAG');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('236', '���ƻ�����', '1', null, '1', 'FAKE_OR_CLONE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('237', '���ر��', '1', null, '1', 'TRACK_FLAG');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('510', '����ԭ��', '1', null, '1', 'CONTROL_REASON');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('513', '���ȼ�', '1', null, '1', 'CLEAN_DEGRE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('514', '��������', '1', null, '1', 'WATER_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('163', '����״̬', '1', null, '1', 'status');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('072', '��·����', '1', null, '1', 'ROAD_DIRECTION_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('400', '�豸����', '1', null, '1', 'DEVICE_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('139', '�����˫��', '1', null, '1', 'IS_ONE_WAY');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('140', '·������', '1', null, '1', 'CANALIZATION');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('141', '��������', '1', null, '1', 'LANE_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('142', '�Ƿ�����', '1', null, '1', 'IS_RESTRICT');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('143', '����Ӧ������', '1', null, '1', 'HAS_EMERGENCY_LANE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('144', '���޷ǻ�������', '1', null, '1', 'HAS_BICYCLE_LANE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('145', '�������е�', '1', null, '1', 'HAS_PAVEMENT');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('146', '����·�ڱ�ʶ', '1', null, '1', 'ENTER_OR_EXIT');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('147', '·������', '1', null, '1', 'CROSS_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('148', '·������', '1', null, '1', 'ROAD_SECTION_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('149', '�Ƿ���ͨ��', '1', null, '1', 'IS_ONE_DIRECTION');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('150', '��λ����', '1', null, '1', 'SITE_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('151', '��λ����', '1', null, '1', 'SITE_LANDSCAPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('152', '������Դ����', '1', null, '1', 'SERVICE_RESOURCE_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('153', '����·������', '1', null, '1', 'SPECIAL_SECTION_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('154', '����������', '1', null, '1', 'SERVICE_AREA_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('155', '������������ʽ', '1', null, '1', 'ENTRANCE_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('156', '�������ȼ�', '1', null, '1', 'SERVICE_AREA_GRADE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('157', '�Ƿ��м���վ', '1', null, '1', 'HAS_GAS_STATION');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('158', '��Ʒ����', '1', null, '1', 'OIL_TYPE_LIST');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('159', '��ͨ����', '1', null, '1', 'INTERFLOW_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('160', '���ڻ����', '1', null, '1', 'ENTRANCE_OR_EXIT');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('161', '����ִ������վ', '1', null, '1', 'HAS_LAW_SERVICE_STATION');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('162', 'բ������', '1', null, '1', 'RAMP_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('402', 'ǰ���豸��������', '1', null, '1', 'NETWORK_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('403', '��ȫ���뷽ʽ', '1', null, '1', 'SAFE_CONNECT_MEANS');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('404', '��װ��ʽ', '1', null, '1', 'MOUNTING_FACILITY_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('405', 'ʹ��״̬��ʶ', '1', null, '1', 'USE_STATUS_FLAG');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('406', 'ͬ����ʶ', '1', null, '1', 'SYNC_STATUS');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('407', 'ͳ�Ƽ춨�ʱ�ʶ', '1', null, '1', 'STAT_CERT_RATE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('408', 'ͳ�������ʱ�ʶ', '1', null, '1', 'STAT_ONLINE_RATE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('409', '��ⷽ���ʶ', '1', null, '1', 'DIRECTION_FLAG');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('410', '�����Ƿ�����', '1', null, '1', 'ERTRANCE_OR_EXIT');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('411', '����״̬', '1', null, '1', 'ONLINE_STATUS');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('412', '�豸״̬', '1', null, '1', 'STATUS_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('413', '�����ǹ��', '1', null, '1', 'DOME_GUNLOCK');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('414', '��Ƶ�ֱ���', '1', null, '1', 'VIDEO_RESOLUTION');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('418', '�Ƿ���Ҫ��̨���ƻָ�Ԥ��λ', '1', null, '1', 'IS_BACKSTAGE_RECOVERY');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('419', '�������', '1', null, '1', 'OWNERSHIP');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('420', '�Ƿ������鲼��ϵͳ', '1', null, '1', 'IS_CONNECT_TRACK_SYS');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('421', '��������', '1', null, '1', 'TOLLGATE_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('422', '��������', '1', null, '1', 'INTERCEPT_CONDITIONS');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('434', '�¼�����', '1', null, '1', 'EVENT_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('436', '�������������', '1', null, '1', 'COMPONENT_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('437', '��ͬ����', '1', null, '1', 'CONTRACT_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('438', 'ϵͳ���������������', '1', null, '1', 'SYS_COMPONENT_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('439', 'ͼƬ����', '1', null, '1', 'SYS_COMPONENT_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('441', '�춨���', '1', null, '1', 'CERTIFICATED_RESULT');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('442', '��������', '1', null, '1', 'FAULT_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('443', 'ά������', '1', null, '1', 'MAINTENANCE_LEVEL');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('001', '��������', '1', null, '1', 'VEHTYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('002', '��������', '1', null, '1', 'PLATETYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('003', '������ɫ', '1', null, '1', 'PLATECOLOR');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('004', '��������', '1', null, '1', 'APPEARANCE_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('005', '������״̬', '1', null, '1', 'VEHICLE_STATUS');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('006', '������ɫ', '1', null, '1', 'VEHCOLOR');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('008', '��֤����', '1', null, '1', 'ISSUEORG');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('009', '֤������', '1', null, '1', 'ID_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('010', '����ʹ������', '1', null, '1', 'VEHCHARCTER');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('011', 'Υ������', '1', null, '1', 'VIOLATION_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('012', '����Ʒ��', '1', null, '1', 'VEHBRAND');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('013', '�ɼ���ʽ', '1', null, '1', 'VIOLATION_SOURCE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('444', '�豸���', '1', null, '1', 'DEVICE_APPEARANCE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('445', '�豸�˼�', '1', null, '1', 'DEVICE_BAR');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('016', '��·����', '1', null, '1', 'ROAD_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('017', '��·����', '1', null, '1', 'ROAD_LEVEL');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('200', 'ֵ��ģʽ', '1', null, '1', 'DUTY_MODEL');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('201', '�Ƿ���빫����', '1', null, '1', 'IS_CONNECT_POLICE_NET');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('202', '������Դ', '1', null, '1', 'DATA_SOURCE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('203', '�������', '1', null, '1', 'EVALUATE_RESULT');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('204', 'ʶ������', '1', null, '1', 'IDENTIFY_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('205', '���Ƴ��϶���ʽ', '1', null, '1', 'COUNT_FORM');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('206', '����ԭ��', '1', null, '1', 'TRACK_REASON');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('207', '����ԭ��������', '1', null, '1', 'TRACK_SUB_REASON');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('208', '��������', '1', null, '1', 'TRACK_CHARACTER');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('209', '���صȼ�', '1', null, '1', 'TRACK_LEVEL');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('210', '��Σ���', '1', null, '1', 'IS_DANGEROUS');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('211', '�Ƿ����ܳ���', '1', null, '1', 'IS_SECRET_VEHICLE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('212', '���ؾ���', '1', null, '1', 'TRACK_POLICE_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('213', '����������Դ', '1', null, '1', 'TRACK_DATA_RESOURCE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('214', '���ط�Χ����', '1', null, '1', 'TRACK_SCOPE_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('215', '��ش�ʩ', '1', null, '1', 'TRACK_ACTION');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('216', '�Ƿ����֪ͨ', '1', null, '1', 'IS_SEND_MESSAGE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('217', '�Ƿ����ӱ���������', '1', null, '1', 'HAS_ADD_ALARM_PERSON');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('218', '����״̬', '1', null, '1', 'TRACK_STATUS');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('219', '��˱��', '1', null, '1', 'AUDIT_FLAG');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('220', '����ԭ�����', '1', null, '1', 'REVOKE_REASON_CODE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('221', '����ģʽ', '1', null, '1', 'ALARM_MODEL');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('222', '�Ƿ��ܿصı���', '1', null, '1', 'TRACK_SECRET_FLAG');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('223', '������Դ', '1', null, '1', 'ALARM_RESOURCE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('224', 'ǩ�ս��', '1', null, '1', 'SIGN_RESULT');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('225', '����״̬', '1', null, '1', 'INTERCEPT_STATUS');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('226', '�Ƿ������', '1', null, '1', 'IS_DISPOSED');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('227', '�Ƿ��ѽ�����', '1', null, '1', 'IS_PAYED');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('301', '��¼״̬', '1', null, '1', 'STATUS');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('302', 'ȡ���ϴ�����', '1', null, '1', 'CANCEL_UPLOAD_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('303', 'ִ������', '1', null, '1', 'ENFORCE_CATEGORY');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('304', 'Υ������', '1', null, '1', 'VIO_CHARACTER');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('305', '�ϴ�״̬', '1', null, '1', 'UPLOAD_STATUS');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('306', '�������', '1', null, '1', 'DISCARD_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('307', '��������', '1', null, '1', 'PENALTY_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('308', '�ּ��ʶ', '1', null, '1', 'COLLATE_FLAG');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('446', '��������', '1', null, '1', 'PROTECTION_COMPONENTS');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('447', '��Դ', '1', null, '1', 'POWER');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('448', '����', '1', null, '1', 'CABLE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('449', '������ʩ', '1', null, '1', 'LIGHTING_PROTECTION');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('450', '�ӵ�', '1', null, '1', 'GROUND_CONNECTION');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('451', 'ͨ���豸', '1', null, '1', 'COMMUNICATION_DEVICE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('452', 'У׼ʱ��', '1', null, '1', 'DEVICE_TIME');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('453', '���������', '1', null, '1', 'CLEAN_PROTECTIVE_COVER');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('454', '����ͷ����', '1', null, '1', 'CLEAN_CAMERA_ASH');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('455', '��װ���', '1', null, '1', 'INSTALLATION');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('456', '��־����', '1', null, '1', 'TRAFFIC_SIGN');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('457', '����ͨ����Ϣ', '1', null, '1', 'VEHICLE_PASS_INFO');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('458', '����Υ����¼��Ϣ', '1', null, '1', 'VEHICLE_VIOLATION');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('459', '��������', '1', null, '1', 'METEOROLOGY_DATA');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('460', '��Ƶ����', '1', null, '1', 'VIDEO_QUALITY');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('461', '��Ƶ��̨����', '1', null, '1', 'PTZ_CONTROL');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('462', 'LED�Լ����', '1', null, '1', 'SELF_CHECK');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('463', '�źŵƹ������', '1', null, '1', 'TRAFFIC_LIGHT');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('464', '�źŻ��������', '1', null, '1', 'SIGNAL_DEVICE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('465', '����/������Ч��', '1', null, '1', 'IS_VALIDITY');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('466', '����״̬', '1', null, '1', 'PROCESS_STATE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('467', '�ɼ���ʽ', '1', null, '1', 'COLLECT_METHOD');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('468', 'ά����״̬', '1', null, '1', 'MAINTENANCE_STATUS');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('469', 'ά�޽���', '1', null, '1', 'MAINTENDANCE_RESULT');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('470', '�������ٹ�·���ڱ�ʶ', '1', null, '1', 'HIGHWAY_ENTRANCE_EXIT');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('471', '�������������ڱ�ʶ', '1', null, '1', 'SERVICE_ENTRANCE_EXIT');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('472', 'ͣ�ñ�ʶ', '1', null, '1', 'DISABLE_FLAG');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('473', '��������', '1', null, '1', 'POWER_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('474', '���䷽ʽ', '1', null, '1', 'TRANSMISSION_MODE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('475', '��Ƶ�������', '1', null, '1', 'VIDEO_SUPERVISE_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('487', '����״̬', '1', null, '1', 'processStatus');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('477', '���ϻ򱨾�', '1', null, '1', 'FAULT_ALARM');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('478', '����������', '1', null, '1', 'FAULT_SUB_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('479', '���Ͻ����ʶ', '1', null, '1', 'RESOLVE_FLAG');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('480', '������ʶ', '1', null, '1', 'RESTART_FLAG');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('481', '����״̬', '1', null, '1', 'RUNNING_STATE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('511', '·��Ԥ���¼����', '1', null, '1', 'ALARM_EVENT_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('512', 'Ԥ���¼�������', '1', null, '1', 'SUB_ALARM_EVENT');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('427', 'ץ��ģʽ', '1', null, '1', 'PHOTO_MODEL');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('228', '������', '1', null, '1', 'VEH_LOCALIZATION');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('229', '��������', '1', null, '1', 'VEH_CATEGORY');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('018', '���ñ�ʶ', '1', null, '1', 'ENABLE_FLAG');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('019', '�༭��ʶ', '1', null, '1', 'EDITABLE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('239', '���ر�ʶ', '1', null, '1', 'REVOKE_FLAG');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('240', 'ִ������վ�ȼ�', '1', null, '1', 'STATION_RATING');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('483', 'ά������', '1', null, '1', 'MAINTENANCE_CYCLE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('484', 'װ������', '1', null, '1', 'EQUIPMENT_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('485', '��Ƶ���뷽ʽ', '1', null, '1', 'ACCESS_MODE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('491', '�豸������', '1', null, '1', 'DEVICE_OR_REGION');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('130', '������Ϊ�϶���ʽ', '1', null, '1', 'VIO_CONFIRM_MODEL');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('501', 'ͨ��״̬', '1', null, '1', 'TRAFFIC_STATE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('050', 'ͨ�з�ʽ', '1', null, '1', 'DRIVE_MODE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('070', '��������', '1', null, '1', 'DIRECTION_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('131', '�Ƿ���ͨ��', '1', null, '1', 'IS_ONE_DIRECTION');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('132', '·��ṹ', '1', null, '1', 'ROAD_STRUCTURE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('133', '·�����', '1', null, '1', 'ROAD_LANDSCAPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('134', '��·����', '1', null, '1', 'ROAD_LINEAR');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('135', '��·���������ʩ', '1', null, '1', 'ROAD_ISOLATION');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('136', '���������ʩ', '1', null, '1', 'CENTRAL_ISOLATION');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('137', '������ʩ����', '1', null, '1', 'PROTECT_FACILITIES');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('138', '��·���¼״̬', '1', null, '1', 'ROAD_RECORD_STATUS');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('500', '��¼����', '1', null, '1', 'REPORT_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('502', '����Ԥ������', '1', null, '1', 'METEOROLOGY_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('503', '�¼������ʶ', '1', null, '1', 'EVENT_RELEASE_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('504', '��Ч����Ч', '1', null, '1', 'VALIDITY');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('505', '�¼�����״̬', '1', null, '1', 'PROCESS_STATUS');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('506', '����Ԥ������', '1', null, '1', 'FLOW_ALARM_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('507', 'Ԥ������', '1', null, '1', 'ALARM_GRADE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('508', '��ֵ����', '1', null, '1', 'ALARM_VALUE_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('509', '·��״������', '1', null, '1', 'ROAD_CONDITION_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('020', '�ڼ�������', '1', null, '1', 'FESTIVAL_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('482', '��ⷽʽ', '1', null, '1', 'DETECTION_MODE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('515', '���Ʒ���', '1', null, '1', 'DIRECTION_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('401', '�豸������', '1', null, '1', 'DEVICE_TYPE_SUB');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('238', '��¼��Դ', '1', null, '1', 'RECORD_ORGIN');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('309', '�������', '1', null, '1', 'SPEEDING_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('310', '�쳣��������', '1', null, '1', 'BNORMAL_DATA_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('311', '���⳵������', '1', null, '1', 'SPECIAL_VEH_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('312', '����ԭ��', '1', null, '1', 'DISCARDED_REASON');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('313', '���ش������', '1', null, '1', 'LOCAL_PUNISH_FLAG');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('314', '�������', '1', null, '1', 'EXPORT_FLAG');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('315', '������ʶ', '1', null, '1', 'LOCK_FLAG');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('316', 'Υ������', '1', null, '1', 'VIO_PRIOR_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('317', '������', '1', null, '1', 'FLAG_WARN');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('318', '������', '1', null, '1', 'FLAG_FINE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('319', '�ݿ۱��', '1', null, '1', 'FLAG_SUSPEND');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('320', '�������', '1', null, '1', 'FLAG_CANCEL');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('321', '�������', '1', null, '1', 'FLAG_DETAIN');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('322', '������ʻ֤���', '1', null, '1', 'FLAG_REVOKE_VEHICLE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('323', '������ʻ֤���', '1', null, '1', 'FLAG_REVOKE_DRIVER');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('324', '�Ƿ����', '1', null, '1', 'IS_GB');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('325', '�Ƿ���', '1', null, '1', 'IS_COMMON_USED');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('326', 'ǿ�ƴ�ʩ����', '1', null, '1', 'FORCE_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('100', '��Ա����', '1', null, '1', 'POLICE_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('101', '��������', '1', null, '1', 'AUTHORIZED_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('102', 'ҵ���λ', '1', null, '1', 'BUSINESS_POST');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('103', '�¹ʴ���ȼ�', '1', null, '1', 'EVENT_LEVEL');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('104', '�쵼����', '1', null, '1', 'LEADER_LEVEL');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('105', '�Ա�', '1', null, '1', 'SEX');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('106', '����', '1', null, '1', 'POLICE_RANK');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('107', 'ִ���ʸ�ȼ�', '1', null, '1', 'QUALIFICATION_GRADE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('108', '��Ա���¼״̬', '1', null, '1', 'P_RECORD_STATUS');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('071', '�������ͣ����У�', '1', null, '1', 'DIRECTION_TYPE_CITY');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('110', 'SSO�û����', '1', null, '1', 'SSO_FLAG');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('111', '��������', '1', null, '1', 'ORG_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('112', '�Ƿ��Ƕ�������', '1', null, '1', 'IS_DEPARTMENT');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('113', '�Ƿ��Ǹ��ٹ�����', '1', null, '1', 'IS_HIGHWAY_ORG');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('114', '��������', '1', null, '1', 'ORG_LEVEL');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('115', '������������', '1', null, '1', 'DISTRICT_GRADE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('116', '�������', '1', null, '1', 'CANCEL_FLAG');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('117', '��½״̬', '1', null, '1', 'IS_ONLINE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('486', 'Уʱ״̬', '1', null, '1', 'timeResult');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('119', '����Ȩ������', '1', null, '1', 'DATA_ACCESS_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('488', '��춨����', '1', null, '1', 'CERTIFICATED_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('489', '�춨״̬', '1', null, '1', 'CERTIFICATED_DATE_STATUS');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('122', 'ֵ������', '1', null, '1', 'VALUE_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('123', '�Ƿ�֧�ֻع�', '1', null, '1', 'REBACKABLE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('124', '�������', '1', null, '1', 'OPERATE_RESULT');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('125', '��������', '1', null, '1', 'OPERATE_TYPE');
insert into T_SYS_CODE_TYPE (code_type, code_type_name, editable, regex, enable_flag, english_name)
values ('490', '������', '1', null, '1', 'IMPORT_MARK');
commit;
prompt 236 records loaded
prompt Loading T_SYS_CODE...
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125663', '239', '0', 'δ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125664', '239', '1', '�ѳ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125224', '138', '0', 'ɾ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125225', '138', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125772', '163', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125773', '163', '2', '�Ŷ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125774', '163', '3', '���ڵ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125775', '163', '4', '�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125776', '071', '3', '�ɶ�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125777', '071', '4', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125778', '071', '5', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125779', '071', '6', '�ɱ�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125780', '071', '7', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125781', '071', '8', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125782', '071', '9', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125783', '071', '10', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124760', '301', '0', '�¼�¼', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124761', '301', '1', '��ɸѡ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124762', '301', '2', '��¼��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124763', '303', '1', '�ϴ���������', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124764', '303', '2', '��������', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124765', '303', '3', 'ũ�ó���', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124766', '303', '4', '���Ƴ���', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124767', '303', '5', '���Ƴ���', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124768', '303', '6', '����������', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124769', '303', '7', '���ش���', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124770', '304', '1', '���⳵��', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124771', '304', '2', '�ֳ�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124772', '304', '3', '�Ʊ공��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124773', '304', '4', '�ش�Υ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124774', '305', '0', 'δ�ϴ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124775', '305', '1', '���ϴ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124776', '305', '2', '���ϴ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124777', '305', '3', '�ϴ�ʧ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124778', '305', '4', 'ȡ���ϴ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124779', '312', '01', '�쳣����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124780', '312', '21', '���Ƴ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124781', '312', '22', '���Ƴ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124782', '312', '23', '��������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124783', '312', '24', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124784', '312', '25', 'ũ�ó�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124785', '312', '26', 'Ħ�г�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124786', '312', '03', '�ظ���¼', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124787', '312', '04', '��Чͼ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124788', '312', '05', '���Ʋ�ȫ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124789', '312', '06', '�޺��� ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124790', '307', '0', 'δ����', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124791', '307', '1', '�Ѵ���', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124792', '307', '2', '���ڴ���', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124793', '307', '3', '��ʱ����', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124794', '308', '1', '�¼�¼', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124795', '308', '2', '�ѷּ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124796', '308', '3', '�ѷ���', '2', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124941', '312', '07', '��ʱ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124943', '306', '1', '���ŷ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124944', '306', '2', '�Զ�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124945', '306', '3', '��������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124946', '309', '1', '�ƶ�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124947', '309', '2', '�������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124948', '309', '3', '�̶������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124949', '309', '4', '������Ȧ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124950', '309', '5', '�����״����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124951', '310', '1', '�����쳣', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124952', '310', '2', '��������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124953', '311', '1', '���Ƴ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124954', '311', '2', '���Ƴ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124955', '311', '3', '��������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124956', '311', '4', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124957', '311', '5', 'ũ�ó�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124958', '311', '6', 'Ħ�г�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124959', '313', '0', 'δ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124960', '313', '1', '�Ѵ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124961', '314', '0', 'δ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124962', '314', '1', '�ѵ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124963', '315', '0', 'δ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124964', '315', '1', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124965', '316', '01', '������Υ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124966', '316', '02', '�ǻ�����Υ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124967', '316', '03', '���˳˳���Υ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124968', '316', '04', '��·', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124969', '316', '05', '����Υ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124970', '316', '06', '��Υ������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124971', '316', '07', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124972', '316', '09', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124973', '317', '0', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124974', '317', '1', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124975', '318', '0', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124976', '318', '1', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124977', '319', '0', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124978', '319', '1', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124979', '320', '0', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124980', '320', '1', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124981', '321', '0', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124982', '321', '1', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124983', '322', '0', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124984', '322', '1', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124985', '323', '0', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124986', '323', '1', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124987', '324', '0', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124988', '324', '1', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124989', '325', '0', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124990', '325', '1', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124991', '326', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124992', '326', '2', '�ս�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124993', '326', '3', '���ƻ�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124994', '326', '4', '����ѪҺ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124995', '326', '5', '�ų��ϰ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126272', '478', '11000', '�����쳣', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126273', '478', '11001', '�������ϵ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126274', '478', '11002', '�����ͼƬ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126275', '478', '11003', 'û��ͼ���ź�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126276', '478', '11004', '������ݴ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126277', '478', '12000', '���״��ź�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126278', '478', '12001', '�״�����ϵ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126279', '478', '12002', '�״��޲���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126280', '478', '12003', '�״����ݴ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126281', '478', '12004', '��Ƶ�ʷֻ�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126282', '478', '12005', '�Ŵ��·����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126283', '478', '12006', 'CPU����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126284', '478', '13000', '���������ж�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126285', '478', '13001', 'ups��ص�ѹƫ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126286', '478', '13002', 'upsʧЧ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126287', '478', '13003', 'û��ups�ź�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126288', '478', '14000', '��Ȧ����ϵ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126289', '478', '14001', 'û����Ȧ�ź�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126290', '478', '14002', '��Ȧ���ݹ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126291', '478', '15000', '�޷�������������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126292', '478', '15001', '�޷����ӷ�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126293', '478', '15002', '���ܷ����������쳣', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126294', '478', '16000', '�޷���GPSģ��˿�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126295', '478', '16001', '�޷�����GPS����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126296', '478', '16002', 'GPS���ݽ�������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126297', '478', '16003', 'GPSУʱ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126298', '478', '17000', '�ܼ������޴�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126299', '478', '17001', '�ض���Ⱦ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126300', '478', '17002', 'USBȱʧ�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126301', '478', '17003', '�˿ڴ򿪹���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126302', '478', '17004', 'ʱ���쳣', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126303', '478', '18000', 'LED�˿ڴ򿪹���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126304', '478', '18001', 'LED������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126305', '478', '99999', '�����ӹ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124819', '210', '3', '���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124820', '210', '4', '��綾Σ��Ʒ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124821', '211', '0', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124822', '211', '1', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124823', '212', '01', '���ڰ�ȫ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124824', '212', '02', '���÷������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124825', '212', '03', '�ΰ�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124826', '212', '04', '�߷�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124827', '212', '05', '�������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124828', '212', '06', '���뾳����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124829', '212', '07', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124830', '212', '08', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124831', '212', '09', '�а쾯��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124832', '212', '10', '��������ҵ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124833', '212', '11', '������Ϣ���簲ȫ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124834', '212', '12', '�ж�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124835', '212', '13', '��������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124836', '212', '14', '��ͨ����ҵ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124837', '212', '15', '�񺽣���ҵ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124838', '212', '16', '��ҵ����ҵ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124839', '212', '17', '��ͨ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124840', '212', '18', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124841', '212', '19', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124842', '212', '20', 'װ������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124843', '212', '21', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124844', '212', '22', '�Ƽ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124845', '212', '23', '��Ϣͨ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124846', '213', '1', '����¼��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124847', '213', '2', '�ܶ�ת��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124848', '213', '3', '����ת��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124849', '213', '4', 'Э���ת��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124850', '214', '1', 'ȫ�ֲ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124851', '214', '2', '��������������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124852', '214', '3', '�����ڲ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124853', '214', '4', '����·����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124854', '215', '0', '���س���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124855', '215', '1', '����̲�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124856', '215', '2', '�۲����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124857', '215', '3', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124858', '216', '0', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124859', '216', '1', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124860', '217', '0', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124861', '217', '1', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124862', '218', '1', 'δ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124863', '218', '2', '�Ѳ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124864', '218', '3', '�ѳ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124865', '219', '0', 'δ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124866', '219', '1', 'ͨ�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124867', '219', '2', 'δͨ�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124868', '219', '3', '�������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124869', '220', '01', '�ѹ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124870', '220', '02', '�Ѵ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124871', '220', '03', '��Ч��Ϣ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124872', '220', '04', '������Ϣ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124873', '220', '05', 'δͨ�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124874', '220', '99', '����ԭ�򳷿�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124875', '221', '1', '����Ԥ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124876', '221', '2', '����Ԥ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124877', '221', '3', 'ǰ��Ԥ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125897', '072', '1', '��������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125898', '072', '2', '�ϱ�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125899', '072', '3', '����-���Ϸ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125900', '072', '4', '����-��������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125680', '240', '1', 'һ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125681', '240', '2', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125682', '240', '3', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125530', '479', '0', 'δ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125531', '479', '1', '�ѽ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125532', '480', '0', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125533', '480', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125534', '481', '1', '��������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125535', '481', '2', '���н���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125563', '481', '1', '��������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125564', '481', '2', '���н���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125080', '108', '0', 'ɾ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125081', '108', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125089', '112', '1', '�Ƕ�������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125090', '112', '2', '���Ƕ�������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125911', '484', '2', 'ִ����¼��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125912', '484', '3', 'GPS', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125756', '513', '0', '���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125757', '513', '1', '�����Ⱦ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125758', '513', '2', '�ض���Ⱦ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125759', '514', '0', '�޽�ˮ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125760', '514', '1', 'δ֪��ˮ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125761', '514', '2', 'Һ̬��ˮ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125910', '484', '1', '�Ƽ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125053', '103', '0', '�޵ȼ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125054', '103', '1', '�߼�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125055', '103', '2', '�м�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125056', '103', '3', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125057', '104', 'D0', '�ܶ��쵼', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125058', '104', 'D1', '֧���쵼', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125059', '104', 'D2', '����쵼', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125060', '104', 'D3', '�ж��쵼', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125061', '104', 'ZZ', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125084', '110', '0', '���������¼', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125085', '110', '1', '�������¼', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125086', '111', '1', '���С�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125087', '111', '2', '���л�·', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125088', '111', '3', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125091', '113', '0', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125092', '113', '1', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125093', '114', '1', '��ʡ�����ܶ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125094', '114', '2', '���о֣�֧��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125095', '114', '3', '���ؾ֣����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125096', '114', '4', '���ɳ������ж�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125097', '115', '1', 'ʡ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125098', '115', '2', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125099', '115', '3', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125102', '117', '0', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125103', '117', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125106', '119', '0', '����������������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125107', '119', '1', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125108', '119', '2', '��������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125109', '119', '3', '�Զ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125114', '122', '0', 'ö��ֵ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125115', '122', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125116', '122', '2', 'С��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125117', '123', '0', '��֧��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125118', '123', '1', '֧��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125121', '125', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125122', '125', '2', '�޸�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125123', '125', '3', 'ɾ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125124', '125', '4', '��ѯ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125795', '405', '0', 'δ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125796', '405', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125797', '405', '2', 'ͣ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125798', '405', '3', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126217', '489', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126218', '489', '2', '�����º���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126219', '489', '3', 'һ���º���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126220', '489', '4', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126221', '490', '1', '����ɹ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126222', '490', '2', 'δ�Ǽ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126223', '490', '3', '�ǽ����豸', '1', null, '����,��Ѳ��,��ͨ����,�ܶ�,֧��,���,�ж�', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126224', '490', '4', '����ԭ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125000', '207', '0601', '���Υ��δ�����س���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125001', '207', '0602', 'Υ��δ������ʡ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125002', '207', '0603', 'Υ��δ�����ص㳵��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125003', '207', '0401', '����δ����ص㳵��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125004', '207', '0402', '����δ�����ͨ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125005', '207', '0501', '����δ�����ص㳵��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125006', '207', '0502', '����δ������ͨ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125007', '207', '3301', '��·���˳���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125008', '207', '3302', '���ο��˳���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125009', '207', '5101', '��֤ע����������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125010', '207', '5102', '��֤�ݿ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125011', '207', '5103', '��ʻ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125012', '207', '0604', 'ʵʱΥ��δ������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125310', '400', '11', 'Υͣ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125311', '400', '12', '��ռ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125312', '400', '13', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125313', '400', '14', '�źŻ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125314', '400', '15', '�ѵ����źŻ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125315', '400', '16', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125771', '436', '11', '������ͼƬ�洢������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124747', '427', '1', '��ͷץ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124748', '427', '2', '��βץ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124749', '427', '3', '��ͷ��β��ץ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125708', '511', '506', '����Ԥ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125709', '511', '502', '����Ԥ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125710', '511', '434', '��ͨ�¼�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125711', '511', '500', '�˹���¼�¼�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125871', '050', '1', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125872', '050', '2', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125873', '050', '3', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125874', '050', '4', '��������ͨ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125875', '050', '5', '��ת', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125876', '050', '6', '��ת', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125877', '050', '7', '��ͷ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125878', '050', '8', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125879', '050', '9', '����ͨ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125880', '050', '100', '����ͨ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125881', '050', '101', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125870', '050', '0', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124879', '222', '0', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124880', '222', '1', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124881', '223', '1', '���Ƴ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124882', '223', '2', '�˹�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124883', '223', '3', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124884', '223', '4', '���鲼�ر���ϵͳ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124885', '224', '0', 'δǩ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124886', '224', '1', '��ǩ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124887', '225', '0', 'δ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124888', '225', '1', '�����ص����س���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124889', '225', '2', '�����ص������ǲ��س���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124890', '225', '3', 'δ���ص�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124891', '226', '0', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124892', '226', '1', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124893', '227', '0', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124894', '227', '1', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125600', '500', '1', '��·״��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125601', '500', '2', '�����¼�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125602', '500', '3', '��ͨ�¼�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125603', '501', '3', 'ӵ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125604', '501', '2', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125605', '501', '1', '��ͨ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125606', '502', '1', '�ܼ���Ԥ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125607', '502', '2', '·���¶�Ԥ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125608', '502', '3', '·���ˮԤ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125609', '502', '4', '����Ԥ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125610', '502', '5', '·����Ԥ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125611', '503', '0', 'δ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125612', '503', '1', '�ѽ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125613', '504', '0', '��Ч', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125614', '504', '1', '��Ч', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125615', '505', '1', 'δ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125616', '505', '2', '���ڴ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125617', '505', '3', '�Ѵ�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125618', '506', '01', '����ͻ��Ԥ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125619', '506', '02', '����Ԥ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125620', '506', '03', '���泵�ٲ�Ԥ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125621', '506', '04', '��������ʱ�䳬��Ԥ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125622', '506', '05', '���䱥��Ԥ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125623', '506', '06', '������ͳ���ռ�ȳ���Ԥ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125624', '507', '1', 'һ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125625', '507', '2', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125626', '507', '3', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125627', '507', '4', '�ļ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125628', '508', '01', '����Сʱ������������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125629', '508', '02', '���泵�ٲ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125630', '508', '03', '�����������ʱ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125631', '508', '04', 'ƽ������ʱ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125632', '508', '05', '���䱥�Ͷ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125633', '508', '06', '���ͳ���ռ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125634', '508', '31', '�ܼ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125635', '508', '32', '·���¶�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125636', '508', '33', 'ˮĤ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125637', '508', '34', '·��״��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125638', '509', '0', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125639', '509', '1', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125640', '509', '2', 'ʪ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125641', '509', '3', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125642', '509', '4', 'ѩ/��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125643', '509', '5', 'ʪ����ѩ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125644', '509', '6', '��ˮ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125645', '509', '7', 'ѩ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125262', '148', '24', 'խ·', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125044', '102', '01', '��������ִ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125045', '102', '02', '��ʡ��ִ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125046', '102', '03', '����ִ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125047', '102', '04', '����ִ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125048', '102', '05', '�¹ʴ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125049', '102', '06', '���ݹ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125050', '102', '07', '��·����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125051', '102', '08', '�Ƽ�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125052', '102', '09', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125261', '148', '23', '��խ·��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125263', '148', '25', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125264', '148', '26', '���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125265', '148', '27', '·�ν�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125266', '148', '28', '·����Ҫ·��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125267', '148', '29', '��������·��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125268', '149', '0', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125269', '149', '1', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125270', '150', '1', '·�ڵ�λ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125271', '150', '2', '·�ε�λ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125272', '150', '3', '��·��λ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125273', '151', '1', 'ƽԭ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125274', '151', '2', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125275', '151', '3', 'ɽ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125276', '152', '1', '110', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125277', '152', '2', '120', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125278', '153', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125279', '153', '2', '���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125280', '153', '3', '�µ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125281', '153', '4', '���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125282', '153', '5', '�¹��׷���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125901', '483', '1', 'һ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125902', '483', '2', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125903', '483', '3', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125904', '483', '4', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125905', '483', '5', 'һ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125890', '020', '1', 'Ԫ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125891', '020', '2', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125892', '020', '3', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125893', '020', '4', '�Ͷ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125894', '020', '5', '�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125895', '020', '6', '�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125896', '020', '7', '�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124798', '400', '01', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124799', '400', '02', '�羯', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124800', '400', '03', '��Ƶ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124801', '400', '04', '�̶������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124802', '400', '05', '�����豸', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124803', '400', '06', '�ɱ�������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124804', '400', '07', '�յ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124805', '400', '08', '�¼����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124806', '400', '09', '�������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124807', '400', '10', '���Ż�վ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124808', '401', '0401', '�̶���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124809', '401', '0402', '�ƶ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124810', '401', '0201', '��ͨ�羯', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124811', '401', '0202', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125790', '011', 'e', 'δϵ��ȫ��1', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125907', '001', 'k11', 'С�� ', '0', null, '��ɫ', '0');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125039', '100', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125040', '100', '2', '��������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125041', '101', '1', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125042', '101', '2', '��ҵ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125043', '101', '3', '�ط���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125283', '154', '1', '˫�����ʽ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125284', '154', '2', '���༯��ʽ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125285', '154', '3', '�����´�ʽ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125286', '155', '1', '˫�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125287', '155', '2', '���з������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125288', '155', '3', '���з������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125289', '156', '1', 'һ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125290', '156', '2', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125291', '156', '3', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125292', '157', '0', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125293', '157', '1', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125294', '158', '1', '90#��������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125295', '158', '2', '93#��������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125296', '158', '3', '97#��������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125297', '158', '4', '0#�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125298', '158', '5', '10#�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125299', '158', '6', '20#�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125300', '159', '1', '���ٹ�·����ͨ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125301', '159', '2', '���ٹ�·��Ŧ��ͨ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125302', '159', '3', '����·��ͨ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125303', '160', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125304', '160', '2', '���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125305', '161', '0', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125306', '161', '1', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125307', '162', '1', '���ٹ�·������ѵ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125308', '162', '2', '��ͨ��Ŧ�ѵ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125309', '162', '3', '����·�ѵ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125316', '401', '0101', '�ΰ�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125317', '401', '0102', '·�ο���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125318', '401', '0103', '�շ�վ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125319', '401', '0104', '����·�ڿ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125320', '401', '0105', 'ͣ��������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125321', '401', '0301', '���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125322', '401', '0302', 'ǹ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125323', '401', '0501', '·��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125324', '401', '0502', '�ܼ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125325', '401', '0503', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125326', '401', '0701', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125327', '401', '0702', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125328', '401', '0703', '�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125329', '402', '1', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125330', '402', '2', 'ר��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125331', '402', '3', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125332', '403', '1', '��ȫ����ƽ̨', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125333', '403', '2', 'һ������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125334', '403', '3', 'ֱ�ӽ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125335', '404', '1', 'L��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125336', '404', '2', 'M�����ż�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125337', '404', '3', 'N�����ż�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125338', '404', '4', 'F��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125339', '404', '5', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125343', '406', '0', 'δͬ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125344', '406', '1', '��ͬ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125345', '407', '0', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125346', '407', '1', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125347', '408', '0', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125348', '408', '1', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125349', '409', '0', '�޷���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125350', '409', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125351', '409', '2', '˫��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125352', '410', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125353', '410', '0', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125354', '411', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125355', '411', '2', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125356', '412', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125358', '412', '2', '�ѻ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125360', '412', '3', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125361', '413', '1', '���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125362', '413', '2', 'ǹ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125363', '414', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125364', '414', '2', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125365', '418', '0', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125366', '418', '1', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125367', '419', '1', '�����Խ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125368', '419', '2', '��������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125369', '419', '3', '��Ὠ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125370', '420', '0', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125371', '420', '1', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125372', '421', '01', '���翨��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125373', '421', '02', 'ʡ�ʿ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125374', '421', '03', '�мʿ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125375', '421', '04', '�ؼʿ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125376', '421', '05', '��·���߿���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125377', '421', '06', '��·�շ�վ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125378', '421', '07', '������·����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125379', '421', '08', '����·�ڿ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125380', '421', '09', '���Ӿ��쿨��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125381', '421', '10', '����������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125382', '421', '99', '��������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125383', '422', '0', '���߱�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125384', '422', '1', '�߱�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125397', '436', '0', '��ƵCms������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125398', '436', '1', 'ͨ�ŷ�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125399', '436', '2', '���ķ�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125400', '436', '3', 'FTP������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125401', '436', '4', 'ͼƬ�洢������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125402', '436', '5', '��ƵPag������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125403', '436', '6', '��Ƶ�û��������������ý�壩', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125404', '436', '7', '��Ƶ�洢���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125405', '436', '8', '��ƵWeb������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125406', '436', '9', '�ȶԱ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125407', '436', '10', '��̨���Ʒ�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125408', '437', '1', '��ǩ��ͬ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125409', '437', '2', '��ǩ��ͬ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125410', '438', '01', '��Ƶ�ɼ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125411', '438', '02', 'ץ�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125412', '438', '03', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125413', '438', '04', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125414', '438', '05', '���ݴ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125415', '438', '06', '���紫��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125416', '438', '07', '�洢', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125417', '439', '1', '�豸ͼƬ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125418', '439', '2', '����ͼƬ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125419', '439', '3', '��װͼƬ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125420', '441', '1', '�ϸ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125421', '441', '2', '���ϸ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125430', '443', '1', 'һ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125431', '443', '2', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125432', '443', '3', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125433', '444', '0', '���ϸ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125434', '444', '1', '�ϸ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125435', '445', '0', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125436', '445', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125437', '446', '0', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125438', '446', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125439', '447', '0', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125440', '447', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125441', '448', '0', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125442', '448', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125443', '449', '0', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125444', '449', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125445', '450', '0', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125446', '450', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125447', '451', '0', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125448', '451', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125449', '452', '0', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125450', '452', '1', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125451', '453', '0', 'δ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125452', '453', '1', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125453', '454', '0', 'δ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125454', '454', '1', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125455', '455', '0', '���ϸ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125456', '455', '1', '�ϸ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125457', '456', '0', '���ϸ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125458', '456', '1', '�ϸ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125459', '457', '0', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125460', '457', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125461', '458', '0', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125462', '458', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125463', '459', '0', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125464', '459', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125465', '460', '0', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125466', '460', '1', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125467', '461', '0', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125468', '461', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125469', '462', '0', 'ʧ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125470', '462', '1', '�ɹ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125471', '463', '0', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125472', '463', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125473', '464', '0', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125474', '464', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125475', '465', '1', '��Ч', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125476', '465', '2', '��Ч', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125479', '467', '1', 'ǰ���豸�ϴ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125480', '467', '2', 'ϵͳ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125481', '467', '3', '�˹����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125482', '468', '0', 'δ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125483', '468', '1', '�ѷ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125484', '469', '1', 'ȫ��δά�޺�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125485', '469', '2', '����δά�޺�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125486', '469', '3', '��ȫ�޺�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125487', '470', '0', '�ǽ������ٹ�·����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125488', '470', '1', '�����ٹ�·����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125489', '470', '2', '�����ٹ�·����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125490', '471', '0', '�ǽ�������������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125491', '471', '1', '������������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125492', '471', '2', '������������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125493', '472', '0', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125494', '472', '1', 'ͣ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125495', '473', '1', 'ũ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125496', '473', '2', '�е�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125497', '473', '3', '̫����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125498', '473', '4', 'UPS', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125499', '474', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125500', '474', '2', '4G', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125501', '475', '1', '��ͨ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125502', '475', '2', '�ΰ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125505', '477', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125506', '477', '2', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125566', '301', '9', '�ѷ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125567', '301', '3', '����¼', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125180', '130', '1', '���ٹ�·�϶���ʽ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125181', '130', '2', '��ʡ���϶���ʽ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125182', '131', '0', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125183', '131', '1', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125184', '132', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125185', '132', '2', 'ˮ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125186', '132', '3', 'ɰʯ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125187', '132', '4', '��·', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125188', '132', '9', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125189', '133', '1', 'ƽԭ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125190', '133', '2', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125191', '133', '3', 'ɽ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125192', '134', '01', 'ƽֱ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125193', '134', '02', 'һ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125194', '134', '03', 'һ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125195', '134', '04', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125196', '134', '05', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125197', '134', '06', '��������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125198', '134', '07', 'һ������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125199', '134', '08', '���䶸��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125200', '134', '09', 'һ���¼���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125201', '134', '10', 'һ���䶸��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125202', '135', '1', '�޸���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125203', '135', '2', '���ĸ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125204', '135', '3', '���Ǹ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125205', '135', '4', '���ĸ���ӻ��Ǹ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125206', '136', '1', '�̻���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125207', '136', '2', '����������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125208', '136', '3', '���λ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125209', '136', '4', '��������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125210', '136', '5', '���Ի���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125211', '136', '6', '�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125212', '136', '7', '�����(��)', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125213', '137', '01', '�޷���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125214', '137', '02', '�е���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125215', '137', '03', '�̻���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125216', '137', '04', '����������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125217', '137', '05', '������(��)', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125218', '137', '06', '���λ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125219', '137', '07', '��������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125220', '137', '08', '���Ի���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125221', '137', '09', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125222', '137', '10', '���ճ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125223', '137', '19', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125226', '139', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125227', '139', '2', '˫��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125228', '140', '0', 'δ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125229', '140', '1', '�Ѹ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125230', '141', '01', '��ͨ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125231', '141', '02', 'С����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125232', '141', '03', '��ͳ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125233', '141', '04', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125234', '141', '05', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125235', '141', '06', '�г���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125236', '141', '07', '����ר�ó���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125237', '141', '08', 'Ӧ������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125238', '141', '09', '�ǻ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125239', '141', '11', '������ת����ͷ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125240', '141', '12', '������ת����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125241', '141', '13', '����ֱ�г���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125242', '141', '14', '������ת����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125243', '141', '15', '������ת��ֱ�г���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125244', '142', '0', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125245', '142', '1', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125246', '143', '0', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125247', '143', '1', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125248', '144', '0', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125249', '144', '1', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125250', '145', '0', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125251', '145', '1', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125252', '146', '1', '��·��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125253', '146', '2', '��·��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125254', '147', '1', '��֦�ֲ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125255', '147', '2', '��֦�ֲ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125256', '147', '3', '��֦�ֲ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125257', '147', '4', '���ν����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125258', '147', '5', '�ѵ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125259', '148', '21', '��ͨ·��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125260', '148', '22', '�߼�·��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125730', '504', '2', 'δȷ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124895', '230', '0', '���⴦��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124896', '230', '1', '�⴦��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124897', '231', '0', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124898', '231', '1', '����kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124899', '232', '0', 'δȷ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124900', '232', '1', '��ȷ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124901', '233', '0', 'δת��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124902', '233', '1', '��ת��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125666', '234', '1', '��ȷ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125667', '234', '2', '֤�ݲ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125668', '234', '3', 'ʶ�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124906', '235', '0', '���Ǽ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124907', '235', '1', '�Ǽ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124908', '235', '2', '��ȷ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124909', '236', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124910', '236', '2', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124911', '237', '0', 'δ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124912', '237', '1', '�Ѳ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124942', '312', '08', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125013', '212', '00', '������/��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125014', '212', '24', '���أ���ҵ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125015', '212', '26', '��а��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125016', '212', '27', '���ֲ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125017', '212', '31', '�칫�����ң�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125018', '212', '32', '��ί', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125019', '212', '33', '���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125020', '212', '34', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125021', '212', '35', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125022', '212', '36', '����ѵ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125023', '212', '38', '���ص�ί', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125024', '212', '39', '�����ݸɲ�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125025', '212', '40', '���ط�������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125026', '212', '41', '���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125027', '212', '89', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125028', '212', '90', 'ԺУ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125029', '212', '91', '�о���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125030', '212', '92', 'ҽԺ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125031', '212', '93', 'ѵ������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125032', '212', '94', '�߼�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125033', '212', '95', 'Ѳ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125034', '212', '96', '�ɳ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125035', '212', '97', '��ܰ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125036', '212', '98', '�Ƽ�ί', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125665', '234', '0', 'δȷ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125160', '070', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125161', '070', '2', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125750', '508', '41', '��·ͨ��״̬', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125660', '482', '1', '��Ƶ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125661', '482', '2', '��Ȧ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125662', '482', '3', '�״�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('42cfbdbe1d794e20bfb7c05311e2807e', '001', '��AAAAAA', '���� ', '0', null, '��ɫ��  ', '0');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124812', '228', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124813', '228', '2', '��ʡ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124814', '228', '3', '��ʡ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124815', '228', '4', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124816', '228', '5', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124817', '229', '1', '����������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124818', '229', '2', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120000', '001', 'K11', '������ͨ�ͳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120001', '001', 'K12', '����˫��ͳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120002', '001', 'K13', '�������̿ͳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120003', '001', 'K14', '���ͽ½ӿͳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120004', '001', 'K15', '����ԽҰ�ͳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120005', '001', 'K21', '������ͨ�ͳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120006', '001', 'K22', '����˫��ͳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120007', '001', 'K23', '�������̿ͳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120008', '001', 'K24', '���ͽ½ӿͳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120009', '001', 'K25', '����ԽҰ�ͳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120010', '001', 'K31', 'С����ͨ�ͳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120011', '001', 'K32', 'С��ԽҰ�ͳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120012', '001', 'K33', '�γ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120013', '001', 'K41', '΢����ͨ�ͳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120014', '001', 'K42', '΢��ԽҰ�ͳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120015', '001', 'K43', '΢�ͽγ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120016', '001', 'H11', '������ͨ����', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120017', '001', 'H12', '������ʽ����', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120018', '001', 'H13', '���ͷ�ջ���', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120019', '001', 'H14', '���͹�ʽ����', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120020', '001', 'H15', '����ƽ�����', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120021', '001', 'H16', '���ͼ�װ�ᳵ', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120022', '001', 'H17', '������ж����', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120023', '001', 'H18', '��������ṹ����', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120024', '001', 'H21', '������ͨ����', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120025', '001', 'H22', '������ʽ����', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120026', '001', 'H23', '���ͷ�ջ���', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120027', '001', 'H24', '���͹�ʽ����', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120028', '001', 'H25', '����ƽ�����', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120029', '001', 'H26', '���ͼ�װ�ᳵ', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120030', '001', 'H27', '������ж����', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120031', '001', 'H28', '��������ṹ����', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120032', '001', 'H31', '������ͨ����', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120033', '001', 'H32', '������ʽ����', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120034', '001', 'H33', '���ͷ�ջ���', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120035', '001', 'H34', '���͹�ʽ����', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120036', '001', 'H35', '����ƽ�����', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120037', '001', 'H37', '������ж����', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120038', '001', 'H38', '��������ṹ����', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120039', '001', 'H41', '΢����ͨ����', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120040', '001', 'H42', '΢����ʽ����', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120041', '001', 'H43', '΢�ͷ�ջ���', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120042', '001', 'H44', '΢�͹�ʽ����', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120043', '001', 'H45', '΢����ж����', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120044', '001', 'H46', '΢������ṹ����', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120045', '001', 'H51', '������ͨ����', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120046', '001', 'H52', '������ʽ����', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120047', '001', 'H53', '���ٹ�ʽ����', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120048', '001', 'H54', '������ж����', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120049', '001', 'Q11', '���Ͱ��ǣ����', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120050', '001', 'Q21', '���Ͱ��ǣ����', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120051', '001', 'Q31', '���Ͱ��ǣ����', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120052', '001', 'Z', 'ר����ҵ��', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120053', '001', 'Z11', '����ר����ҵ��', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120054', '001', 'Z21', '����ר����ҵ��', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120055', '001', 'Z31', 'С��ר����ҵ��', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120056', '001', 'Z41', '΢��ר����ҵ��', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120057', '001', 'Z51', '����ר����ҵ��', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120058', '001', 'Z71', '����ר����ҵ��', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120059', '001', 'D11', '�޹�糵', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120060', '001', 'D12', '�й�糵', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120061', '001', 'M11', '��ͨ������Ħ�г�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120062', '001', 'M12', '���������Ħ�г�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120063', '001', 'M13', '�������ؿ�Ħ�г�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120064', '001', 'M14', '�������ػ�Ħ�г�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120065', '001', 'M15', '������Ħ�г�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120066', '001', 'M21', '��ͨ����Ħ�г�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120067', '001', 'M22', '������Ħ�г�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120068', '001', 'N11', '��������', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120069', '001', 'T11', '������ʽ������', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120070', '001', 'T21', 'С����ʽ������', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120071', '001', 'T22', '�ַ�������', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120072', '001', 'T23', '�ַ����������', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120073', '001', 'J11', '��ʽװ�ػ�е', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120074', '001', 'J12', '��ʽ�ھ��е', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120075', '001', 'J13', '��ʽƽ�ػ�е', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120076', '001', 'G11', '������ͨȫ�ҳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120077', '001', 'G12', '������ʽȫ�ҳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120078', '001', 'G13', '���͹�ʽȫ�ҳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120079', '001', 'G14', '����ƽ��ȫ�ҳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120080', '001', 'G15', '���ͼ�װ��ȫ�ҳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120081', '001', 'G16', '������жȫ�ҳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120082', '001', 'G21', '������ͨȫ�ҳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120083', '001', 'G22', '������ʽȫ�ҳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120084', '001', 'G23', '���͹�ʽȫ�ҳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120085', '001', 'G24', '����ƽ��ȫ�ҳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120086', '001', 'G25', '���ͼ�װ��ȫ�ҳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120087', '001', 'G26', '������жȫ�ҳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120088', '001', 'G31', '������ͨȫ�ҳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120089', '001', 'G32', '������ʽȫ�ҳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120090', '001', 'G33', '���͹�ʽȫ�ҳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120091', '001', 'G34', '����ƽ��ȫ�ҳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120092', '001', 'G35', '������жȫ�ҳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120093', '001', 'B11', '������ͨ��ҳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120094', '001', 'B12', '������ʽ��ҳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120095', '001', 'B13', '���͹�ʽ��ҳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120096', '001', 'B14', '����ƽ���ҳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120097', '001', 'B15', '���ͼ�װ���ҳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120098', '001', 'B16', '������ж��ҳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120099', '001', 'B17', '��������ṹ��ҳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120100', '001', 'B21', '������ͨ��ҳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120101', '001', 'B22', '������ʽ��ҳ�', '0', null, null, '0');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125700', '510', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125701', '510', '2', '�¹�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125702', '510', '3', 'ʩ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125703', '510', '4', '���ڱ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125810', '412', '4', '�쳣', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125841', '434', '0', 'ӵ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125842', '434', '1', 'ͣ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125843', '434', '2', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125844', '434', '3', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125845', '434', '4', '�������������Ƭ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125846', '434', '5', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125847', '434', '6', 'ѹ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125848', '434', '7', '����������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125849', '434', '8', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125850', '434', '9', '���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125851', '434', '10', '��ͷ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125037', '238', '1', '���ݹ�ͬ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125038', '238', '2', 'ִ������վ�Ǽ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126172', '485', '1', '����ƽ̨', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126173', '485', '2', '����ֱ���豸', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126174', '485', '3', '��ƽ̨', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126175', '485', '4', '��ֱ���豸', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126176', '485', '5', '��Զƽ̨', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125477', '465', '3', 'δȷ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126193', '487', '0', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126194', '487', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126195', '487', '2', '�쳣', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126210', '228', '0', 'δ֪', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120920', '001', 'B23', '���͹�ʽ��ҳ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120921', '001', 'B24', '����ƽ���ҳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120922', '001', 'B25', '���ͼ�װ���ҳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120923', '001', 'B26', '������ж��ҳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120924', '001', 'B27', '��������ṹ��ҳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120925', '001', 'B31', '������ͨ��ҳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120926', '001', 'B32', '������ʽ��ҳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120928', '001', 'B34', '����ƽ���ҳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120929', '001', 'B35', '������ж��ҳ�', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120930', '001', 'X99', '����', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120931', '002', '01', '��������', '0', '1', '�Ƶ׺���(��02ʽ���Ʋ���)', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120932', '002', '02', 'С������', '0', '2', '���װ���(��02ʽ���Ʋ���)', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120933', '002', '03', 'ʹ������', '0', '9', '�ڵװ��֡��조ʹ����', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120934', '002', '04', '�������', '0', '9', '�ڵװ��֡��조�족��', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120935', '002', '05', '��������', '0', '9', '�ڵװ�/����', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120936', '002', '06', '�⼮����', '0', '3', '�ڵװ���', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120937', '002', '07', '��������Ħ�г�', '0', '9', '�Ƶ׺���', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120938', '002', '08', '���Ħ�г�', '0', '9', '���װ���', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120939', '002', '09', 'ʹ��Ħ�г�', '0', '9', '�ڵװ��֡��조ʹ����', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120940', '002', '10', '���Ħ�г�', '0', '9', '�ڵװ��֡��조�족��', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120941', '002', '11', '����Ħ�г�', '0', '9', '�ڵװ���', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120942', '002', '12', '�⼮Ħ�г�', '0', '9', '�ڵװ���', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120943', '002', '13', 'ũ�����䳵', '0', '9', '�Ƶ׺��ֺڿ��ߣ��Ѱ�����·��ͨ��ȫ����ȡ��ũ�����䳵�����ٷ���', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120944', '002', '14', '������', '0', '9', '�Ƶ׺���', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120945', '002', '15', '�ҳ�', '0', '4', '�Ƶ׺��ֺڿ���', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120946', '002', '16', '��������', '0', '5', '�Ƶ׺��ֺڿ���', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120947', '002', '17', '����Ħ�г�', '0', '9', '�Ƶ׺��ֺڿ���', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120948', '002', '18', '��������', '0', '9', null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120949', '002', '19', '����Ħ�г�', '0', '9', null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120950', '002', '20', '��ʱ�뾳����', '0', '9', '�׵׺��ֺڡ���ʱ�뾳��', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120951', '002', '21', '��ʱ�뾳Ħ�г�', '0', '9', '�׵׺��ֺڡ���ʱ�뾳��', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120952', '002', '22', '��ʱ��ʻ��', '0', '9', '�׵׺��ֺڿ���', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120953', '002', '23', '��������', '0', '9', null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120954', '002', '24', '����Ħ��', '0', '9', null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120955', '002', '99', '����', '0', '9', null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120956', '003', '0', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120957', '003', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120958', '003', '2', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120959', '003', '3', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120960', '003', '4', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120962', '004', '01', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120963', '004', '02', 'С��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120964', '004', '03', '���ͳ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120965', '004', '05', 'Ħ�г�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120966', '004', '06', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120967', '006', 'A', '��', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120968', '006', 'B', '��', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120969', '006', 'C', '��', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120970', '006', 'D', '��', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120971', '006', 'E', '��', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120972', '006', 'F', '��', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120973', '006', 'G', '��', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120974', '006', 'H', '��', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120975', '006', 'I', '��', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120976', '006', 'J', '��', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('120977', '006', 'Z', '����', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122337', '008', '��H', '�Ϻ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122338', '008', '��I', '�Ϻ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122339', '008', '��J', '�Ϻ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122340', '008', '��K', '�Ϻ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122341', '008', '��L', '�Ϻ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122342', '008', '��M', '�Ϻ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122343', '008', '��N', '�Ϻ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122344', '008', '��O', '�Ϻ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122345', '008', '��P', '�Ϻ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122346', '008', '��Q', '�Ϻ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122347', '008', '��R', '�Ϻ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122348', '008', '��S', '�Ϻ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122349', '008', '��T', '�Ϻ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122350', '008', '��U', '�Ϻ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122351', '008', '��V', '�Ϻ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122352', '008', '��W', '�Ϻ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122353', '008', '��X', '�Ϻ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122354', '008', '��Y', '�Ϻ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122355', '008', '��Z', '�Ϻ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122356', '008', '��A', '�Ͼ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122357', '008', '��B', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122358', '008', '��C', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122359', '008', '��D', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122360', '008', '��E', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122361', '008', '��F', '��ͨ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122362', '008', '��G', '���Ƹ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122363', '008', '��H', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122364', '008', '��J', '�γ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122365', '008', '��K', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122366', '008', '��L', '���й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122367', '008', '��M', '̩���й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122368', '008', '��N', '��Ǩ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122369', '008', '��O', '����ʡ����������������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122370', '008', '��A', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122371', '008', '��B', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122372', '008', '��C', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122373', '008', '��D', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122374', '008', '��E', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122375', '008', '��F', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122376', '008', '��G', '���й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122377', '008', '��H', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122378', '008', '��J', '̨���й����ֳ���������', '1', null, null, '1');
commit;
prompt 1000 records committed...
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122379', '008', '��K', '��ˮ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122380', '008', '��L', '��ɽ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122381', '008', '��O', '�㽭ʡ����������������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122382', '008', '��A', '�Ϸ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122383', '008', '��B', '�ߺ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122384', '008', '��C', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122385', '008', '��D', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122386', '008', '��E', '��ɽ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122387', '008', '��F', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122388', '008', '��G', 'ͭ���й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122389', '008', '��H', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122390', '008', '��J', '��ɽ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122391', '008', '��K', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122392', '008', '��L', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122393', '008', '��M', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122394', '008', '��N', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122395', '008', '��O', '����ʡ����������������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122396', '008', '��P', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122397', '008', '��Q', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122398', '008', '��R', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122399', '008', '��S', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122400', '008', '��A', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122401', '008', '��B', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122402', '008', '��C', 'Ȫ���й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122403', '008', '��D', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122404', '008', '��E', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122405', '008', '��F', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122406', '008', '��G', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122407', '008', '��H', '��ƽ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122408', '008', '��J', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122409', '008', '��K', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122410', '008', '��O', '����ʡ����������������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122411', '008', '��A', '�ϲ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122412', '008', '��B', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122413', '008', '��C', '�˴��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122414', '008', '��D', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122415', '008', '��E', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122416', '008', '��F', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122417', '008', '��G', '�Ž��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122418', '008', '��H', '�������й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122419', '008', '��J', 'Ƽ���й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122420', '008', '��K', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122421', '008', '��L', 'ӥ̶�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122422', '008', '��M', '�ϲ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122423', '008', '��O', '����ʡ����������������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122424', '008', '³A', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122425', '008', '³B', '�ൺ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122426', '008', '³C', '�Ͳ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122427', '008', '³D', '��ׯ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122428', '008', '³E', '��Ӫ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122429', '008', '³F', '��̨�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122430', '008', '³G', 'Ϋ���й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122431', '008', '³H', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122432', '008', '³J', '̩���й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122433', '008', '³K', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122434', '008', '³L', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122435', '008', '³M', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122436', '008', '³N', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122437', '008', '³O', 'ɽ��ʡ����������������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122438', '008', '³P', '�ĳ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122439', '008', '³Q', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122440', '008', '³R', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122441', '008', '³S', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122442', '008', '³U', '�ൺ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122443', '008', '³V', 'Ϋ���й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122444', '008', '³Y', '��̨�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122445', '008', 'ԥA', '֣���й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122446', '008', 'ԥB', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122447', '008', 'ԥC', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122448', '008', 'ԥD', 'ƽ��ɽ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122449', '008', 'ԥE', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122450', '008', 'ԥF', '�ױ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122451', '008', 'ԥG', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122452', '008', 'ԥH', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122453', '008', 'ԥJ', '����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122454', '008', 'ԥK', '����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122455', '008', 'ԥL', '����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122456', '008', 'ԥM', '����Ͽ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122457', '008', 'ԥN', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122458', '008', 'ԥO', '����ʡ����������������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122459', '008', 'ԥP', '�ܿ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122460', '008', 'ԥQ', 'פ����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122461', '008', 'ԥR', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122462', '008', 'ԥS', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122463', '008', 'ԥU', '��Դ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122464', '008', '��A', '�人�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122465', '008', '��D', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122466', '008', '��E', '�������������ݹ����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122467', '008', '��F', '��Ϫ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122468', '008', '��G', '��ӹ��������������ݹ����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122469', '008', '��H', '��ɽ׳�����������ݹ����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122470', '008', '��J', '�ն��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122471', '008', '��K', '��˫���ɴ��������ݹ����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122472', '008', '��L', '������������ݹ����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122473', '008', '��M', '��ɽ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122474', '008', '��N', '�º���徰���������ݹ����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122475', '008', '��O', '����ʡ����������������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122938', '008', '��B', '��ʯ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122939', '008', '��C', 'ʮ���й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122940', '008', '��D', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122941', '008', '��E', '�˲��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122942', '008', '��F', '�差�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122943', '008', '��G', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122944', '008', '��H', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122945', '008', '��J', '�Ƹ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122946', '008', '��K', 'Т���й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122947', '008', '��L', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122948', '008', '��M', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122949', '008', '��N', 'Ǳ���й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122950', '008', '��O', '����ʡ����������������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122951', '008', '��P', '��ũ�����������ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122952', '008', '��Q', '��ʩ���������������ݹ����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122953', '008', '��R', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122954', '008', '��S', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122955', '008', '��A', '��ɳ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122956', '008', '��B', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122957', '008', '��C', '��̶�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122958', '008', '��D', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122959', '008', '��E', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122960', '008', '��F', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122961', '008', '��G', '�żҽ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122962', '008', '��H', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122963', '008', '��J', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122964', '008', '��K', '¦���й���������������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122965', '008', '��L', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122966', '008', '��M', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122967', '008', '��N', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122968', '008', '��O', '����ʡ����������������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122969', '008', '��S', '��ɳ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122970', '008', '��U', '�������������������ݹ����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122971', '008', '��A', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122972', '008', '��B', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122973', '008', '��C', '�麣�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122974', '008', '��D', '��ͷ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122975', '008', '��E', '��ɽ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122976', '008', '��F', '�ع��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122977', '008', '��G', 'տ���й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122978', '008', '��H', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122979', '008', '��J', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122980', '008', '��K', 'ï���й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122981', '008', '��L', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122982', '008', '��M', '÷���й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122983', '008', '��N', '��β�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122984', '008', '��O', '�㶫ʡ����������������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122985', '008', '��P', '��Դ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122986', '008', '��Q', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122987', '008', '��R', '��Զ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122988', '008', '��S', '��ݸ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122989', '008', '��T', '��ɽ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122990', '008', '��U', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122991', '008', '��V', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122992', '008', '��W', '�Ƹ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122993', '008', '��X', '��ɽ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122994', '008', '��Y', '��ɽ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122995', '008', '��Z', '�㶫ʡ��������ͨ����ֳ���������', '1', null, '�۰������������', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122996', '008', '��A', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122997', '008', '��B', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122998', '008', '��C', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122999', '008', '��D', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123000', '008', '��E', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123001', '008', '��F', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123002', '008', '��G', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123003', '008', '��H', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123004', '008', '��J', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123005', '008', '��K', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123006', '008', '��L', '��ɫ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123007', '008', '��M', '�ӳ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123008', '008', '��N', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123009', '008', '��O', '����׳������������������������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123010', '008', '��P', '���Ǹ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123011', '008', '��R', '����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123012', '008', '��A', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123013', '008', '��B', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123014', '008', '��C', '����ʡ��������ͨ�����ܶ�������������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123015', '008', '��D', '����ʡ��������ͨ�����ܶ����ϳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123016', '008', '��E', '���־��ÿ����������ֽ�ͨ����֧�ӳ���������������ʡ��������ͨ�����ܶӳ������������ܣ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123017', '008', '��O', '����ʡ����������������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123018', '008', '��A', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123019', '008', '��B', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123020', '008', '��C', '�����н������������ϴ��������ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123021', '008', '��F', '�����������������ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123022', '008', '��G', '�����и����������ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123023', '008', '��H', '������ǭ���������ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123024', '008', '��A', '�ɶ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123025', '008', '��B', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123026', '008', '��C', '�Թ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123027', '008', '��D', '��֦���й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123028', '008', '��E', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123029', '008', '��F', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123030', '008', '��H', '��Ԫ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123031', '008', '��J', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123032', '008', '��K', '�ڽ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123033', '008', '��L', '��ɽ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123034', '008', '��M', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123035', '008', '��O', '�Ĵ�ʡ����������������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123036', '008', '��Q', '�˱��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123037', '008', '��R', '�ϳ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123038', '008', '��S', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123039', '008', '��T', '�Ű��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123040', '008', '��U', '���Ӳ���Ǽ�������ݹ����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123041', '008', '��V', '���β��������ݹ����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123042', '008', '��W', '��ɽ���������ݹ����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123043', '008', '��X', '�㰲�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123044', '008', '��Y', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123045', '008', '��Z', 'üɽ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123046', '008', '��A', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123047', '008', '��B', '����ˮ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123048', '008', '��C', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123049', '008', '��D', 'ͭ�ʵ�������������������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123050', '008', '��E', 'ǭ���ϲ��������������ݹ����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123051', '008', '��F', '�Ͻڵ�������������������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123052', '008', '��G', '��˳�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123053', '008', '��H', 'ǭ�������嶱�������ݹ����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123054', '008', '��J', 'ǭ�ϲ��������������ݹ����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123055', '008', '��O', '����ʡ����������������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123056', '008', '��A', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123057', '008', '��C', '��ͨ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122476', '008', '��P', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122477', '008', '��Q', 'ŭ�������������ݹ����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122478', '008', '��R', '������������ݹ����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122479', '008', '��S', '�ٲ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122480', '008', '��A', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122481', '008', '��B', '�������������ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122482', '008', '��C', 'ɽ�ϵ��������ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122483', '008', '��D', '�տ�����������ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122484', '008', '��E', '�������������ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122485', '008', '��F', '������������ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122486', '008', '��G', '��֥���������ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122487', '008', '��H', '����������������פ�Ĵ�˫������������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122488', '008', '��J', '����������������פ�ຣ���ľ��ͨ����֧�ӳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122489', '008', '��O', '��������������������������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122490', '008', '��A', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122491', '008', '��B', 'ͭ���й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122492', '008', '��C', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122493', '008', '��D', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122494', '008', '��E', 'μ���й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122495', '008', '��F', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122496', '008', '��G', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122497', '008', '��H', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122498', '008', '��J', '�Ӱ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122499', '008', '��K', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122500', '008', '��O', '����ʡ����������������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122501', '008', '��V', '����ʡ�����������������������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122502', '008', '��A', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122503', '008', '��B', '�������й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122504', '008', '��C', '����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122505', '008', '��D', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122506', '008', '��E', '��ˮ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122507', '008', '��F', '��Ȫ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122508', '008', '��G', '��Ҵ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122509', '008', '��H', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122510', '008', '��J', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122511', '008', '��K', '¤���й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122512', '008', '��L', 'ƽ���й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122513', '008', '��M', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122514', '008', '��N', '���Ļ��������ݹ����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122515', '008', '��O', '����ʡ����������������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122516', '008', '��P', '���ϲ��������ݹ����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122517', '008', '��A', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122518', '008', '��B', '�������������ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122519', '008', '��C', '�������������ݹ����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122520', '008', '��D', '���ϲ��������ݹ����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122521', '008', '��E', '���ϲ��������ݹ����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122522', '008', '��F', '������������ݹ����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122523', '008', '��G', '�������������ݹ����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122524', '008', '��H', '�����ɹ�����������ݹ����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122525', '008', '��O', '�ຣʡ����������������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122526', '008', '��A', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122527', '008', '��B', 'ʯ��ɽ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122528', '008', '��C', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122529', '008', '��D', '��ԭ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122530', '008', '��E', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122531', '008', '��O', '���Ļ�������������������������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122532', '008', '��A', '��³ľ���й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122533', '008', '��B', '�������������ݹ����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122534', '008', '��C', 'ʯ�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122535', '008', '��D', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122536', '008', '��E', '���������ɹ������ݹ����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122537', '008', '��F', '��������������ݹ����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122538', '008', '��G', '���ǵ��������ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122539', '008', '��H', '����̩���������ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122540', '008', '��J', '���������й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122541', '008', '��K', '��³�����������ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122542', '008', '��L', '���ܵ��������ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122543', '008', '��M', '���������ɹ������ݹ����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122544', '008', '��N', '�����յ��������ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122545', '008', '��O', '�½�ά�������������������������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122546', '008', '��P', '�������ն����������ݹ����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122547', '008', '��Q', '��ʲ���������ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122548', '008', '��R', '������������ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122549', '009', 'A', '�������֤', '0', null, '�л����񹲺͹��������֤', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122550', '009', 'B', '��֯��������֤��', '0', null, '���ء���ҵ����ҵ��λ��������塢�����ڻ�������ҵ������פ�����������֤��', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122551', '009', 'C', '����֤', '0', null, '���۾������֤���;���֤����ְ֤', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122552', '009', 'D', 'ʿ��֤', '0', null, '����ʿ�����֤��', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122553', '009', 'E', '����������֤', '0', null, '���ݾ������֤��', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122554', '009', 'F', '������Ա���֤', '0', null, 'ָ��ۡ������ر���������̨����������������뾳�����֤��', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122555', '009', 'G', '�⽻��Ա���֤��', '0', null, 'ָ���פ��ʹ�ݡ������Ա��������֯פ�����������Ա�����֤�������⽻���˷�����Ч���֤��', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122556', '009', 'H', '���񻧿ڲ�', '0', null, '�л����񹲺͹����񻧿ڲ�', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122557', '009', 'K', '��ס��ס֤��', '0', null, 'ָ����ס�ؾ�ס���ڵؾ����ɹ������غ˷��ľ�ס��ס֤��', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122558', '009', 'L', 'פ������֤��', '0', null, '����פ��ʹ��ݺ����פ�����»��������֤��', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('122559', '009', 'Z', '����֤��', '0', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126331', '491', '2', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126330', '491', '1', '�豸', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123886', '010', 'D', '�������', '1', null, '����ʻ��̺�ʱ��Ʒѣ����˿���������ָ���ص�ġ��Ի�ȡ����ΪĿ�ĵĻ�����', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123887', '010', 'E', '���ο���', '1', null, 'ר�������ο͵ġ��Ի�ȡ����ΪĿ�ĵĻ�����', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123888', '010', 'F', '����', '1', null, 'ר�Ŵ��»�������ġ��Ի�ȡ����ΪĿ�ĵĻ�����', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123889', '010', 'G', '����', '1', null, 'ר�����޸�������λ���߸���ʹ�ã�������ʱ�����������̼Ʒѵġ��Ի�ȡ����ΪĿ�ĵĻ�����', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123890', '010', 'H', '����', '1', null, '"a)�������س���b)���Ұ�ȫ������c)������Ժ����d)����Ժ�������̳�ָ�ӳ�������ִ�г�����ҽ���쳵��ǿ��ִ���ó������������ó�e)˾��������������ר�ó�����׷���ӷ��ĳ���"', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123891', '010', 'I', '����', '1', null, '�����������Ӻ���������������������ר�û��������ֳ�ָ�ӻ�����', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123892', '010', 'J', '�Ȼ�', '1', null, '���ȡ�ҽ�ƻ������������߲�����������Σ�ز��˻�����������ר�û�����;���������¼��������ֳ�ҽ�ƾ�Ԯ�͸����ֳ�ҽ�ƾ�Ԯ��ר�ó���', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123893', '010', 'K', '�������ճ�', '1', null, '��Ѵ��ˮ������������ɽ���ǽ�����ͨ�������Ȳ����������޹�����ʩ���������������Ʋ���ר�û��������ֳ�ָ�ӻ�����', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123894', '010', 'L', 'Ӫת��', '1', null, 'ԭΪӪ�˳������ָ�Ϊ��Ӫ�˳���', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123895', '010', 'M', '����ת��', '1', null, 'ԭΪ���⳵���ָ�Ϊ��Ӫ�˳���', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123896', '010', 'N', '���д�ͳ�', '1', null, '���д�ͳ�', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123897', '010', 'O', 'Ӫ�˳���', '1', null, 'Ӫ�˳���', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123898', '010', 'Z', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123899', '011', '0', '��ռ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123900', '011', '1', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123901', '011', '2', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123902', '011', '3', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123903', '011', '4', '�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123904', '011', '5', 'ѹ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123905', '011', '6', 'Υ��ͣ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123906', '011', '7', '���䳬��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123907', '011', '8', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123908', '011', '9', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123909', '011', 'c', '����������ʻ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123910', '011', 'd', 'ѹ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123911', '011', 'a', 'Υ��ռ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123912', '011', 'b', '�ڵ�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123913', '012', '48,2', '����-��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123914', '012', '48,3', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123915', '012', '48,4', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123916', '012', '48,5', '����-����������ȫ˳', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123917', '012', '48,6', '����-˳��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123918', '012', '48,7', '����-Ԧʤ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123919', '012', '21,0', '�ֶ���-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123920', '012', '21,1', '�ֶ���-C30', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123921', '012', '21,2', '�ֶ���-S40', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123922', '012', '21,3', '�ֶ���-S60', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123923', '012', '21,4', '�ֶ���-S80L', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123924', '012', '21,5', '�ֶ���-XC60', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123925', '012', '21,6', '�ֶ���-XC90', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123926', '012', '56,0', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123927', '012', '56,1', '����-H8', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123928', '012', '56,2', '����-H92', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123929', '012', '56,3', '����-V7V8', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123930', '012', '56,4', '����-�ͳ�����5', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123931', '012', '56,5', '����-����H7V', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123932', '012', '56,6', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123933', '012', '70,1', '�����Ա�-CS7', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123934', '012', '70,2', '�����Ա�-���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123935', '012', '70,3', '�����Ա�-�Ա�CS6', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123936', '012', '70,4', '�����Ա�-����Ƥ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123937', '012', '70,5', '�����Ա�-����Ƥ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123938', '012', '70,6', '�����Ա�-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123939', '012', '70,7', '�����Ա�-�ڽ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123940', '012', '89,0', '½��-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123941', '012', '89,1', '½��-X6', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123942', '012', '89,2', '½��-½��X5', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123943', '012', '89,3', '½��-½��X8', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123944', '012', '89,4', '½��-�绪', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123945', '012', '89,5', '½��-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123946', '012', '75,0', '�����ؿ�-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123947', '012', '75,1', '�����ؿ�-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123948', '012', '75,2', '�����ؿ�-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123949', '012', '47,0', '��ŵ-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123950', '012', '47,1', '��ŵ-���ƿ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123951', '012', '47,2', '��ŵ-÷����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123952', '012', '47,3', '��ŵ-���װ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123953', '012', '47,4', '��ŵ-�羰', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123954', '012', '47,5', '��ŵ-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123955', '012', '62,0', '�ƺ�-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123956', '012', '62,1', '�ƺ�-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123957', '012', '62,2', '�ƺ�-�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123958', '012', '62,3', '�ƺ�-�ͳ�����4', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123959', '012', '62,4', '�ƺ�-��ս��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123960', '012', '48,1', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123961', '012', '62,5', '�ƺ�-��ʤV3', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123962', '012', '62,6', '�ƺ�-����CUV', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123963', '012', '62,7', '�ƺ�-�캽��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123964', '012', '62,8', '�ƺ�-���-A��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123965', '012', '33,0', '����Ӣ��-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123966', '012', '33,1', '����Ӣ��-SC3', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123967', '012', '33,2', '����Ӣ��-SC5', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123968', '012', '33,3', '����Ӣ��-SC6-2012', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123969', '012', '33,4', '����Ӣ��-SC7', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123970', '012', '33,5', '����Ӣ��-SX7', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123971', '012', '33,6', '����Ӣ��-���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123972', '012', '33,7', '����Ӣ��-��ӥ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123973', '012', '24,0', '�����ۺ�-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123974', '012', '24,1', '�����ۺ�-EC7', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123975', '012', '31,0', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123976', '012', '31,1', '����-ͬ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123977', '012', '31,2', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123978', '012', '31,3', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123979', '012', '31,4', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123980', '012', '31,5', '����-�ͳ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123981', '012', '31,6', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123982', '012', '31,7', '����-˧��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123983', '012', '31,8', '����-����-', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123984', '012', '31,9', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123985', '012', '31,10', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123986', '012', '31,11', '����-�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123987', '012', '31,12', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123988', '012', '31,13', '����-���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123989', '012', '31,14', '����-��ӥ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123990', '012', '31,15', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123991', '012', '48,0', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123992', '012', '81,1', '�����ͳ�-�ͳ�����4', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123993', '012', '114,0', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123994', '012', '114,1', '����-G3', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123995', '012', '114,2', '����-G5', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123996', '012', '114,3', '����-M1', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123997', '012', '114,4', '����-X1', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123998', '012', '81,0', '�����ͳ�-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123999', '012', '39,0', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124000', '012', '39,1', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124001', '012', '39,2', '����-ŷ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124002', '012', '39,3', '����-ŷ�Կͳ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124003', '012', '39,4', '����-ŷ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124004', '012', '39,5', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124005', '012', '39,6', '����-���ɿ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124006', '012', '39,7', '����-�Ե�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124007', '012', '39,8', '����-�羰ϵ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124008', '012', '120,0', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124009', '012', '120,1', '����-С����Ƥ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124010', '012', '120,2', '����-̽����6', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124011', '012', '120,3', '����-��ʨF16Ƥ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124012', '012', '229,0', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124013', '012', '229,1', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124014', '012', '107,0', '���ǽ�-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124015', '012', '107,1', '���ǽ�-��7-SUV', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124016', '012', '139,0', '����(����)-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124017', '012', '139,1', '����(����)-���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124018', '012', '200,0', '��ۿͳ�-�ͳ�-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124019', '012', '200,1', '��ۿͳ�-�ͳ�-A��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124020', '012', '65,0', 'Ӣ�����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124021', '012', '65,1', 'Ӣ�����-EX', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124022', '012', '65,2', 'Ӣ�����-FX', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124023', '012', '65,3', 'Ӣ�����-G', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124024', '012', '65,4', 'Ӣ�����-JX', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124025', '012', '16,0', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124026', '012', '16,1', '����-350', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124027', '012', '16,2', '����-550', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124028', '012', '16,3', '����-750', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124029', '012', '16,4', '����-950', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124030', '012', '24,2', '�����ۺ�-EC8', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124031', '012', '66,0', '����ȫ��ӥ-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124032', '012', '66,1', '����ȫ��ӥ-GC7', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124033', '012', '66,2', '����ȫ��ӥ-GX2', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124034', '012', '66,3', '����ȫ��ӥ-GX7', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124035', '012', '66,4', '����ȫ��ӥ-��è', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124036', '012', '66,5', '����ȫ��ӥ-���ɽ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124037', '012', '66,6', '����ȫ��ӥ-Զ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124038', '012', '135,0', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124039', '012', '135,1', '����-����TT', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124040', '012', '127,0', '��Դ-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124041', '012', '127,1', '��Դ-A380', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124042', '012', '52,0', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124043', '012', '52,1', '����-CH6321', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124044', '012', '52,2', '����-�����µ�˫��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124045', '012', '52,3', '����-���϶�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124046', '012', '52,4', '����-����������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124047', '012', '32,0', '˹��³-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124048', '012', '32,1', '˹��³-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124049', '012', '32,2', '˹��³-��ʨ�γ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124050', '012', '32,3', '˹��³-˹��³XV', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124051', '012', '32,4', '˹��³-ɭ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124052', '012', '116,0', '�ݱ�-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124053', '012', '116,1', '�ݱ�-XF', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124054', '012', '116,2', '�ݱ�-XJ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124055', '012', '36,0', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124056', '012', '36,1', '����-�������ó�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124057', '012', '36,2', '����-��ʮ��Ƥ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124058', '012', '36,3', '����-������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124059', '012', '112,0', '��������-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124060', '012', '112,1', '��������-G3', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124061', '012', '112,2', '��������-G5', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124062', '012', '112,3', '��������-˧��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124063', '012', '112,4', '��������-����M1', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124064', '012', '112,5', '��������-����500', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124065', '012', '88,0', '��������-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124066', '012', '88,1', '��������-GA5', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124067', '012', '88,2', '��������-GS5', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124068', '012', '190,0', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124069', '012', '190,1', '����-ŷ½', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124070', '012', '86,0', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124071', '012', '86,1', '����-����630', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124072', '012', '80,0', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124073', '012', '80,1', '����-�ͳ�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124074', '012', '72,0', 'ʱ������-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124075', '012', '72,1', 'ʱ������-С��֮��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124076', '012', '72,2', 'ʱ������-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124077', '012', '72,3', 'ʱ������-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124078', '012', '72,4', 'ʱ������-���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124079', '012', '72,5', 'ʱ������-�캽', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124080', '012', '72,6', 'ʱ������-Ԧ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124081', '012', '12,0', 'ѩ����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124082', '012', '12,1', 'ѩ����-C2', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124083', '012', '12,10', 'ѩ����-����-�ϼ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124084', '012', '12,2', 'ѩ����-C4L', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124085', '012', '12,3', 'ѩ����-C4�ϼ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124086', '012', '12,4', 'ѩ����-C5', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124087', '012', '12,5', 'ѩ����-��������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124088', '012', '12,6', 'ѩ����-��������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124089', '012', '12,7', 'ѩ����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124090', '012', '12,8', 'ѩ����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124091', '012', '12,9', 'ѩ����-����������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124092', '012', '49,0', 'MG-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124093', '012', '49,1', 'MG-MG-3SW', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124094', '012', '49,2', 'MG-MG3', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124095', '012', '49,3', 'MG-MG5', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124096', '012', '49,4', 'MG-MG6', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124097', '012', '49,5', 'MG-MG7', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124098', '012', '87,0', '��������-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124099', '012', '87,1', '��������-205', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124100', '012', '87,2', '��������-306', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124101', '012', '41,0', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124102', '012', '41,1', '����-A��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124103', '012', '41,2', '����-B��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124104', '012', '41,3', '����-C��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124105', '012', '41,4', '����-E��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124106', '012', '41,5', '����-GLK��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124107', '012', '41,6', '����-GL��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124108', '012', '41,7', '����-G��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124109', '012', '41,8', '����-MB100', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124110', '012', '41,9', '����-ML��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124111', '012', '41,10', '����-R��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124112', '012', '41,11', '����-SLK��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124113', '012', '41,12', '����-S��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124114', '012', '41,13', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124115', '012', '41,14', '����-Ψ��ŵ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124116', '012', '41,15', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124117', '012', '41,16', '����-�ͳ�����1', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124118', '012', '26,0', '���ǵ�-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124119', '012', '26,1', '���ǵ�-F0', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124120', '012', '26,2', '���ǵ�-F3R', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124121', '012', '26,3', '���ǵ�-F6', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124122', '012', '26,4', '���ǵ�-G3R', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124123', '012', '26,5', '���ǵ�-G6', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124124', '012', '26,6', '���ǵ�-L3-', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124125', '012', '26,7', '���ǵ�-M6', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124126', '012', '26,8', '���ǵ�-S6', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124127', '012', '26,9', '���ǵ�-������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124128', '012', '26,10', '���ǵ�-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124129', '012', '91,0', '��������-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124130', '012', '91,1', '��������-Eϵ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124131', '012', '59,0', '��������-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124132', '012', '59,1', '��������-NG80', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124133', '012', '59,2', '��������-����V3', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124134', '012', '63,0', '��ʱ��-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124135', '012', '63,1', '��ʱ��-panamera', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124136', '012', '63,2', '��ʱ��-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124137', '012', '143,0', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124138', '012', '143,1', '����-�Ძ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124139', '012', '143,2', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124140', '012', '25,0', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124141', '012', '25,1', '����-C35', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124142', '012', '25,2', '����-K07', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124143', '012', '25,3', '����-V21', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124144', '012', '25,4', '����-�������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124145', '012', '25,5', '����-����С�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124146', '012', '25,6', '����-����CV03', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124147', '012', '25,7', '����-������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124148', '012', '25,8', '����-������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124149', '012', '25,9', '����-���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124150', '012', '25,10', '����-С����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124151', '012', '25,11', '����-�ο�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124152', '012', '25,12', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124153', '012', '25,13', '����-����Ƥ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124154', '012', '25,14', '�������-A60', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124155', '012', '25,15', '�������-H30', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124156', '012', '25,16', '�������-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124157', '012', '25,17', '�������-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124158', '012', '37,0', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124159', '012', '37,1', '����-V3����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124160', '012', '37,2', '����-V5����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124161', '012', '37,3', '����-ϣ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124162', '012', '37,4', '����-������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124163', '012', '37,5', '����-��˧', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124164', '012', '37,6', '����-������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124165', '012', '35,0', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124166', '012', '35,1', '����-���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124167', '012', '35,2', '����-�������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124168', '012', '35,3', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124169', '012', '35,4', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124170', '012', '35,5', '����-·��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124171', '012', '35,6', '����-·��С����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124172', '012', '35,7', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124173', '012', '35,8', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124174', '012', '29,0', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124175', '012', '29,1', '����-�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124176', '012', '29,2', '����-������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124177', '012', '29,3', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124178', '012', '29,4', '����-������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124179', '012', '29,5', '����-����3', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124180', '012', '29,6', '����-������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124181', '012', '29,7', '����-��ʿ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124182', '012', '29,8', '�������ó�-�º��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124183', '012', '29,9', '�������ó�-��������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124184', '012', '29,10', '�������ó�-�ٴ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124185', '012', '60,0', '��������-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124186', '012', '60,1', '��������-�ǿ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124187', '012', '96,0', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124188', '012', '96,1', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124189', '012', '96,2', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124190', '012', '96,3', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124191', '012', '96,4', '����-��Ѹ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124192', '012', '28,0', '��-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124193', '012', '28,1', '��-����S30', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124194', '012', '28,2', '��-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124195', '012', '28,3', '��-��ʨ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124196', '012', '28,4', '��-���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124197', '012', '28,5', '��-����˹MPV', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124198', '012', '28,6', '��-�Ե�SUV', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124199', '012', '64,0', '��������-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124200', '012', '64,1', '��������-ATS', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124201', '012', '64,2', '��������-CTS', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124202', '012', '64,3', '��������-SLS����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124203', '012', '64,4', '��������-SRX', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124204', '012', '64,5', '��������-���׵�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124205', '012', '50,0', '����KAMA-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124206', '012', '50,1', '����KAMA-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124207', '012', '50,2', '����KAMA-������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124208', '012', '50,3', '����KAMA-���˿�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124209', '012', '50,4', '����KAMA-��������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124210', '012', '111,0', '����˹��-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124211', '012', '111,1', '����˹��-300C', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124212', '012', '111,2', '����˹��-PT������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124213', '012', '22,0', '�׿���˹-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124214', '012', '22,1', '�׿���˹-CT', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124215', '012', '22,2', '�׿���˹-ES', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124216', '012', '22,3', '�׿���˹-GS', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124217', '012', '22,4', '�׿���˹-GX', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124218', '012', '22,5', '�׿���˹-IS', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124219', '012', '22,6', '�׿���˹-LS', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124220', '012', '22,7', '�׿���˹-LX', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124221', '012', '22,8', '�׿���˹-RX', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124222', '012', '44,0', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124223', '012', '44,1', '����-320', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124224', '012', '44,2', '����-520', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124225', '012', '44,3', '����-620', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124226', '012', '44,4', '����-X60', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124227', '012', '44,5', '����-��˳', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124228', '012', '27,0', '��ľ-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124229', '012', '27,1', '��ľ-����������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124230', '012', '27,2', '��ľ-������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124231', '012', '27,3', '��ľ-��ķ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124232', '012', '27,4', '��ľ-����SX4����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124233', '012', '27,5', '��ľ-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124234', '012', '27,6', '��ľ-��ϲ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124235', '012', '27,7', '��ľ-�˵�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124236', '012', '27,8', '��ľ-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124237', '012', '27,9', '��ľ-����ά����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124238', '012', '27,10', '��ľ-��Ԧ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124239', '012', '27,11', '��ľ-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124240', '012', '27,12', '��ľ-������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124241', '012', '68,0', '·��-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124242', '012', '68,1', '·��-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124243', '012', '68,2', '·��-��ʤ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124244', '012', '68,3', '·��-������2��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124245', '012', '51,0', '��̩-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124246', '012', '51,1', '��̩-2008', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124247', '012', '51,2', '��̩-5008', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124248', '012', '51,3', '��̩-Z300', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124249', '012', '109,0', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124250', '012', '109,1', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124251', '012', '11,0', 'ѩ����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124252', '012', '11,1', 'ѩ����-�ַ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124253', '012', '11,10', 'ѩ����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124254', '012', '11,2', 'ѩ����-�ֳ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124255', '012', '11,3', 'ѩ����-�ֳ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124256', '012', '11,4', 'ѩ����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124257', '012', '11,5', 'ѩ����-��Ψŷ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124258', '012', '11,6', 'ѩ����-������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124259', '012', '11,7', 'ѩ����-������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124260', '012', '11,8', 'ѩ����-��³��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124261', '012', '11,9', 'ѩ����-��ŷ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124262', '012', '13,0', '�ִ�-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124263', '012', '13,1', '�ִ�-i30', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124264', '012', '13,10', '�ִ�-�ʶ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124265', '012', '13,11', '�ִ�-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124266', '012', '13,12', '�ִ�-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124267', '012', '13,13', '�ִ�-��������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124268', '012', '13,14', '�ִ�-���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124269', '012', '13,15', '�ִ�-������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124270', '012', '13,16', '�ִ�-ά����˹', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124271', '012', '13,17', '�ִ�-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124272', '012', '13,18', '�ִ�-���ڻ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124273', '012', '13,19', '�ִ�-;ʤ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124274', '012', '13,2', '�ִ�-ix35', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124275', '012', '13,20', '�ִ�-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124276', '012', '13,21', '�ִ�-������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124277', '012', '13,22', '�ִ�-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124278', '012', '13,23', '�ִ�-��˼', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124279', '012', '13,3', '�ִ�-������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124280', '012', '13,4', '�ִ�-��ͼ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124281', '012', '13,5', '�ִ�-��Ԧ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124282', '012', '13,6', '�ִ�-ʥ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124283', '012', '13,7', '�ִ�-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124284', '012', '13,8', '�ִ�-�ö�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124285', '012', '13,9', '�ִ�-��ʤ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124286', '012', '8,0', '�ղ�-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124287', '012', '8,1', '�ղ�-NV200', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124288', '012', '8,10', '�ղ�-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124289', '012', '8,11', '�ղ�-�ô�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124290', '012', '8,12', '�ղ�-���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124291', '012', '8,13', '�ղ�-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124292', '012', '8,14', '�ղ�-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124293', '012', '8,15', '�ղ�-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124294', '012', '8,16', '�ղ�-���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124295', '012', '8,17', '�ղ�-����Ƥ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124296', '012', '8,2', '�ղ�-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124297', '012', '8,3', '�ղ�-�濥', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124298', '012', '8,4', '�ղ�-������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124299', '012', '8,5', '�ղ�-¥��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124300', '012', '8,6', '�ղ�-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124301', '012', '8,7', '�ղ�-��ʿ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124302', '012', '8,8', '�ղ�-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124303', '012', '8,9', '�ղ�-�п�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124304', '012', '10,0', '���Դ�-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124305', '012', '10,1', '���Դ�-CX-5', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124306', '012', '10,2', '���Դ�-CX-7', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124307', '012', '10,3', '���Դ�-Mazda2����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124308', '012', '10,4', '���Դ�-Mazda3����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124309', '012', '10,5', '���Դ�-Mazda5', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124310', '012', '10,6', '���Դ�-Mazda6', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124311', '012', '10,7', '���Դ�-Mazda8', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124312', '012', '10,8', '���Դ�-������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124313', '012', '10,9', '���Դ�-���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124314', '012', '7,0', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124315', '012', '7,1', '����-ȫ˳', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124316', '012', '7,2', '����-���껪', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124317', '012', '7,3', '����-̽����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124318', '012', '7,4', '����-����˹', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124319', '012', '7,5', '����-��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124320', '012', '7,6', '����-��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124321', '012', '7,7', '����-�ɵ�ŷ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124322', '012', '7,8', '����-���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124323', '012', '7,9', '����-���˹', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124324', '012', '6,0', '����-������Ʒ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124325', '012', '6,1', '����-RAV4-2012�ֶ������,2011,2010,2009', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124326', '012', '6,10', '����-����ά��-2004', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124327', '012', '6,11', '����-��˹��-2007', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124328', '012', '6,12', '����-������-2011,2009', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124329', '012', '6,13', '����-��ʨ-2001', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124330', '012', '6,14', '����-�ʹ�-1999', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124331', '012', '6,15', '����-��ɼ-δ֪', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124332', '012', '6,16', '����-����-2006,2005,2004', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124333', '012', '6,17', '����-����-2014,2012,2011', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124334', '012', '6,18', '����-��־-2006,2005', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124335', '012', '6,19', '����-½��Ѳ��-δ֪', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124336', '012', '6,2', '����-����86-δ֪', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124337', '012', '6,20', '����-����ʿ-2009,2008,2007', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124338', '012', '6,21', '����-YARiS-L', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124339', '012', '6,22', '����-PLATZ-1999', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124340', '012', '6,3', '����-����-2001,2000,1999,1998', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124341', '012', '6,4', '����-���¿�·��-2011�ж���,2010,2007', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124342', '012', '6,5', '����-������-2008,2007,2006', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124343', '012', '6,6', '����-������-2010,2009,2008,2007,2006', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124344', '012', '6,7', '����-������-2011,2010', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124345', '012', '6,8', '����-����-2004,2003', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124346', '012', '6,9', '����-������-2007,2006,2005,2004', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124347', '012', '2,0', '���������Ʒ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124348', '012', '2,1', '���-GL8', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124349', '012', '2,10', '���-Ӣ��XT', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124350', '012', '2,11', '���-������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124351', '012', '2,12', '���-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124352', '012', '2,2', '���-������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124353', '012', '2,3', '���-������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124354', '012', '2,4', '���-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124355', '012', '2,5', '���-��Խ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124356', '012', '2,6', '���-��Խ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124357', '012', '2,7', '���-������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124358', '012', '2,8', '���-��ŷ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124359', '012', '2,9', '���-Ӣ��GT', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124360', '012', '5,0', '����������Ʒ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124361', '012', '5,1', '����-206', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124362', '012', '5,2', '����-207����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124363', '012', '5,3', '����-3008-2014,2013', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124364', '012', '5,4', '����-301-δ֪', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124365', '012', '5,5', '����-307����-2007,2006,2005,2004', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124366', '012', '5,6', '����-308-2014,2013,2012', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124367', '012', '5,7', '����-407-δ֪', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124368', '012', '5,8', '����-408-2012,2011,2010', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124369', '012', '5,9', '����-508-2014,2013,2012,2011', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124370', '012', '4,0', '����������Ʒ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124371', '012', '4,1', '����-CR-V', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124372', '012', '4,10', '����-������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124373', '012', '4,11', '����-�淶', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124374', '012', '4,12', '����-�Ÿ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124375', '012', '4,13', '����-�ɶ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124376', '012', '4,2', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124377', '012', '4,3', '����-�µ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124378', '012', '4,4', '����-˼��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124379', '012', '4,5', '����-˼��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124380', '012', '4,6', '����-˼���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124381', '012', '4,7', '����-˼��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124382', '012', '4,8', '����-�ܵ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124383', '012', '4,9', '����-��ʫͼ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124384', '012', '3,0', '����������Ʒ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124385', '012', '3,1', '����-1ϵ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124386', '012', '3,10', '����-Z4', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124387', '012', '3,2', '����-3ϵ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124388', '012', '3,3', '����-5ϵ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124389', '012', '3,4', '����-6ϵ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124390', '012', '3,5', '����-7ϵ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124391', '012', '3,6', '����-X1', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124392', '012', '3,7', '����-X3', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124393', '012', '3,8', '����-X5', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124394', '012', '3,9', '����-X6', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124395', '012', '9,0', '�µ�-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124396', '012', '9,1', '�µ�-100', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124397', '012', '9,10', '�µ�-A7', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124398', '012', '9,11', '�µ�-A8L', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124399', '012', '9,12', '�µ�-Q3', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124400', '012', '9,13', '�µ�-Q5', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124401', '012', '9,14', '�µ�-Q7', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124402', '012', '9,15', '�µ�-S7', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124403', '012', '9,16', '�µ�-S8', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124404', '012', '9,17', '�µ�-TT', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124405', '012', '9,2', '�µ�-200', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124406', '012', '9,3', '�µ�-A1', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124407', '012', '9,4', '�µ�-A3', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124408', '012', '9,5', '�µ�-A4', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124409', '012', '9,6', '�µ�-A4L', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124410', '012', '9,7', '�µ�-A5', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124411', '012', '9,8', '�µ�-A6', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124412', '012', '9,9', '�µ�-A6L', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124413', '012', '109,2', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124414', '012', '85,0', '��ͨ�ͳ�-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124415', '012', '85,1', '��ͨ�ͳ�-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124416', '012', '85,2', '��ͨ�ͳ�-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124417', '012', '85,3', '��ͨ�ͳ�-����A', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124418', '012', '85,4', '��ͨ�ͳ�-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124419', '012', '85,5', '��ͨ�ͳ�-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124420', '012', '85,6', '��ͨ�ͳ�-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124421', '012', '85,7', '��ͨ�ͳ�-�캽', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124422', '012', '85,8', '��ͨ�ͳ�-����A', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123323', '008', '��Y', '����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123324', '008', '��Z', '����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123325', '008', '��A', 'ʯ��ׯ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123326', '008', '��B', '��ɽ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123327', '008', '��C', '�ػʵ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123328', '008', '��D', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123329', '008', '��E', '��̨�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123330', '008', '��F', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123331', '008', '��G', '�żҿ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123332', '008', '��H', '�е��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123333', '008', '��J', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123334', '008', '��O', '�ӱ�ʡ����������������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123335', '008', '��R', '�ȷ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123336', '008', '��T', '��ˮ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123337', '008', '��A', '̫ԭ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123338', '008', '��B', '��ͬ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123339', '008', '��C', '��Ȫ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123340', '008', '��D', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123341', '008', '��E', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123342', '008', '��F', '˷���й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123343', '008', '��H', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123344', '008', '��J', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123345', '008', '��K', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123346', '008', '��L', '�ٷ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123347', '008', '��M', '�˳��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123348', '008', '��O', 'ɽ��ʡ����������������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123349', '008', '��A', '���ͺ����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123350', '008', '��B', '��ͷ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123351', '008', '��C', '�ں��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123352', '008', '��D', '����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123353', '008', '��E', '���ױ����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123354', '008', '��F', '�˰��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123355', '008', '��G', 'ͨ���й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123356', '008', '��H', '���ֹ����˹����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123357', '008', '��J', '�����첼�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123358', '008', '��K', '������˹�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123359', '008', '��L', '�����׶��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123360', '008', '��M', '�������˹����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123361', '008', '��O', '���ɹ�����������������������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123362', '008', '��A', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123363', '008', '��B', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123364', '008', '��C', '��ɽ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123365', '008', '��D', '��˳�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123366', '008', '��E', '��Ϫ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123367', '008', '��F', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123368', '008', '��G', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123369', '008', '��H', 'Ӫ���й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123370', '008', '��J', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123371', '008', '��K', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123372', '008', '��L', '�̽��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123373', '008', '��M', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123374', '008', '��N', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123375', '008', '��O', '����ʡ����������������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123376', '008', '��P', '��«���й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123377', '008', '��A', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123378', '008', '��B', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123379', '008', '��C', '��ƽ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123380', '008', '��D', '��Դ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123381', '008', '��E', 'ͨ���й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123382', '008', '��F', '��ɽ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123383', '008', '��G', '�׳��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123384', '008', '��H', '�ӱ��ݹ����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123385', '008', '��J', '��ԭ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123386', '008', '��K', '����ʡ��������ͨ�����ܶӳ���ɽ��������������������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123387', '008', '��O', '����ʡ����������������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123388', '008', '��A', '�������й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123389', '008', '��B', '��������й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123390', '008', '��C', 'ĵ�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123391', '008', '��D', '��ľ˹�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123392', '008', '��E', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123393', '008', '��F', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123394', '008', '��G', '�����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123395', '008', '��H', '�׸��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123396', '008', '��J', '˫Ѽ�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123397', '008', '��K', '��̨���й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123398', '008', '��M', '�绯�й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123399', '008', '��N', '�ں��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123400', '008', '��O', '������ʡ����������������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123401', '008', '��P', '���˰�����������ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123402', '008', '��R', '������ʡ���������ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123403', '008', '��A', '�Ϻ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123404', '008', '��B', '�Ϻ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123405', '008', '��C', '�Ϻ��й����ֳ���������', '1', null, 'Զ����', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123406', '008', '��D', '�Ϻ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123407', '008', '��E', '�Ϻ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123408', '008', '��F', '�Ϻ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123409', '008', '��G', '�Ϻ��й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126191', '486', '1', 'Уʱ�ɹ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126192', '486', '2', 'Уʱʧ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126150', '515', '0', '˫��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126151', '515', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126152', '515', '2', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126190', '486', '0', 'δУʱ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123817', '008', '��A', '�����й�����ͨ����ֳ���������', '1', null, '1996��ǰ', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123818', '008', '��B', '�����й�����ͨ����ֳ���������', '1', null, '���⳵', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123819', '008', '��C', '�����й�����ͨ����ֳ���������', '1', null, '1996��', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123820', '008', '��D', '�����й�����ͨ����ֳ���������', '1', null, '��ʱ', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123821', '008', '��E', '�����й�����ͨ����ֳ���������', '1', null, '1997��', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123822', '008', '��F', '�����й�����ͨ����ֳ���������', '1', null, '2002��', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123823', '008', '��G', '�����й�����ͨ����ֳ���������', '1', null, '��������', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123824', '008', '��H', '�����й�����ͨ����ֳ���������', '1', null, '2004��', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123825', '008', '��I', '�����й�����ͨ����ֳ���������', '1', null, '��δ����', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123826', '008', '��J', '�����й�����ͨ����ֳ���������', '1', null, '2005��', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123827', '008', '��K', '�����й�����ͨ����ֳ���������', '1', null, '2006��', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123828', '008', '��L', '�����й�����ͨ����ֳ���������', '1', null, '2007��', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123829', '008', '��M', '�����й�����ͨ����ֳ���������', '1', null, '2008��', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123830', '008', '��N', '�����й�����ͨ����ֳ���������', '1', null, '2009��', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123831', '008', '��O', '�����й�����ͨ����ֳ���������', '1', null, '������ר��', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123832', '008', '��P', '�����й�����ͨ����ֳ���������', '1', null, '2009��', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123833', '008', '��Q', '�����й�����ͨ����ֳ���������', '1', null, '��δ����', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123834', '008', '��R', '�����й�����ͨ����ֳ���������', '1', null, '��δ����', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123835', '008', '��S', '�����й�����ͨ����ֳ���������', '1', null, '��δ����', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123836', '008', '��T', '�����й�����ͨ����ֳ���������', '1', null, '��δ����', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123837', '008', '��U', '�����й�����ͨ����ֳ���������', '1', null, '��δ����', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123838', '008', '��V', '�����й�����ͨ����ֳ���������', '1', null, '��δ����', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123839', '008', '��W', '�����й�����ͨ����ֳ���������', '1', null, '��δ����', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123840', '008', '��X', '�����й�����ͨ����ֳ���������', '1', null, '��δ����', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123841', '008', '��Y', '�����й�����ͨ����ֳ���������', '1', null, '��������', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123842', '008', '��Z', '�����й�����ͨ����ֳ���������', '1', null, '��δ����', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123843', '008', '��A', '����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123844', '008', '��B', '����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123845', '008', '��C', '����й����ֳ���������', '1', null, '1996��', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123846', '008', '��D', '����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123847', '008', '��E', '����й����ֳ���������', '1', null, '���⳵', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123848', '008', '��F', '����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123849', '008', '��G', '����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123850', '008', '��H', '����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123851', '008', '��I', '����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123852', '008', '��J', '����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123853', '008', '��K', '����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123854', '008', '��L', '����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123855', '008', '��M', '����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123856', '008', '��N', '����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123857', '008', '��O', '����й����ֳ���������', '1', null, '������', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123858', '008', '��P', '����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123859', '008', '��Q', '����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123860', '008', '��R', '����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123861', '008', '��S', '����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123862', '008', '��T', '����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123863', '008', '��U', '����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123864', '008', '��V', '����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123865', '008', '��W', '����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123866', '008', '��X', '����й����ֳ���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123867', '005', 'A', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123868', '005', 'B', 'ת��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123869', '005', 'C', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123870', '005', 'D', 'ͣʻ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123871', '005', 'E', 'ע��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123872', '005', 'G', 'Υ��δ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123873', '005', 'H', '���ؼ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123874', '005', 'I', '�¹�δ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123875', '005', 'J', '���ɳ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123876', '005', 'K', '���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123877', '005', 'L', '�ݿ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123878', '005', 'M', 'ǿ��ע��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123879', '005', 'N', '�¹�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123880', '005', 'O', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123881', '001', 'K39', 'С�������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123882', '001', 'K49', '΢�������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123883', '010', 'A', '��Ӫ��', '1', null, '���˻��ߵ�λ���Ի�ȡ��������ΪĿ�Ķ�ʹ�õĻ�����', '1');
commit;
prompt 2000 records committed...
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123884', '010', 'B', '��·����', '1', null, 'ר�Ŵ��¹�·�ÿ�����ġ��Ի�ȡ����ΪĿ�ĵĻ�����', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('123885', '010', 'C', '��������', '1', null, '������ר�Ŵ��¹�����ͨ���˵ġ��Ի�ȡ����ΪĿ�ĵĻ�����', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125913', '508', '35', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125580', '018', '0', 'δ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125581', '018', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125582', '019', '0', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125583', '019', '1', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125062', '105', '1', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125063', '105', '2', 'Ů', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125100', '116', '0', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125101', '116', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125705', '312', '02', '���ٲ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125119', '124', '0', 'ʧ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125120', '124', '1', '�ɹ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125064', '106', '01', '�ܾ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125065', '106', '02', '���ܾ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125066', '106', '03', 'һ������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125067', '106', '04', '��������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125068', '106', '05', '��������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125069', '106', '06', 'һ������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125070', '106', '07', '��������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125071', '106', '08', '��������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125072', '106', '09', 'һ����˾', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125073', '106', '10', '������˾', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125074', '106', '11', '������˾', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125075', '106', '12', 'һ����Ա', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125076', '106', '13', '������Ա', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125077', '107', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125078', '107', '2', '�м�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125079', '107', '3', '�߼�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126310', '011', 'h', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125707', '410', '2', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126311', '011', 'm', 'Σ��Ʒ���䳵��ʻ��·Υ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126312', '011', 'i', 'ƣ�ͼ�ʻ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126211', '488', '48840001', '����', '1', null, '�����������Զ����ϵͳ(���ڣ�', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126212', '488', '48840002', '�羯', '1', null, '���Ӿ����Զ���¼ϵͳ', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126213', '488', '48840004', '�̶�����', '1', null, '�����������Զ����ϵͳ', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126214', '488', '48840016', '����', '1', null, '�״������', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126215', '488', '4884841', '�Ƽ�', '1', null, '��������ƾ�����̽����', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126216', '488', '48800001', '�������', '1', null, '������������ټ��ϵͳ,������������ټ��ϵͳ', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124423', '012', '20,0', '�л�-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124424', '012', '20,1', '�л�-H230', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124425', '012', '20,2', '�л�-H320', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124426', '012', '20,3', '�л�-H330', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124427', '012', '20,4', '�л�-H530', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124428', '012', '20,5', '�л�-V5', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124429', '012', '20,6', '�л�-���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124430', '012', '20,7', '�л�-�ᱦ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124431', '012', '20,8', '�л�-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124432', '012', '20,9', '�л�-����cross', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124433', '012', '20,10', '�л�-����FRV', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124434', '012', '20,11', '�л�-����FSV', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124435', '012', '58,0', '�й�����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124436', '012', '58,1', '�й�����-HOKA', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124437', '012', '58,2', '�й�����-HOWO', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124438', '012', '58,3', '�й�����-˹̫����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124439', '012', '58,4', '�й�����-���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124440', '012', '58,5', '�й�����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124441', '012', '58,6', '�й�����-�������ؿ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124442', '012', '34,0', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124443', '012', '34,1', '����-���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124444', '012', '34,2', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124445', '012', '34,3', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124446', '012', '34,4', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124447', '012', '34,5', '����-��Ӱ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124448', '012', '34,6', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124449', '012', '34,7', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124450', '012', '34,8', '����-�϶�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124451', '012', '34,9', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124452', '012', 'Unknown', 'δ֪', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124453', '012', 'Audi', '�µ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124454', '012', 'Honda', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124455', '012', 'Buick', '���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124456', '012', 'Toyota', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124457', '012', 'BMW', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124458', '012', 'Peugeot', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124459', '012', 'Ford', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124460', '012', 'Mazda', '���Դ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124461', '012', 'Nissan', '��ɣ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124462', '012', 'Hyundai', '�ִ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124463', '012', 'Suzuki', '��ľ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124464', '012', 'Citroen', 'ѩ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124465', '012', 'Benz', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124466', '012', 'BYD', '���ǵ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124467', '012', 'Geely', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124468', '012', 'Lexus', '�׿���˹', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124469', '012', 'Chery', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124470', '012', 'Kia', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124471', '012', 'Charade', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124472', '012', 'DF', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124473', '012', 'Naveco', '��ά��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124474', '012', 'SGMW', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124475', '012', 'Jinbei', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124476', '012', 'JAC', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124477', '012', 'Emgrand', '�ۺ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124478', '012', 'ChangAn', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124479', '012', 'Skoda', '˹�´�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124480', '012', 'BaoJun', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124481', '012', 'Subaru', '˹��³', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124482', '012', 'LandWind', '½��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124483', '012', 'Luxgen', '���ǽ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124484', '012', 'Renault', '��ŵ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124485', '012', 'Roewe', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124486', '012', 'Cadillac', '��������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124487', '012', 'MG', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124488', '012', 'Zotye', '��̩', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124489', '012', 'ZhongHua', '�л�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124490', '012', 'Foton', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124491', '012', 'Opel', 'ŷ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124492', '012', 'HongQi', 'һ������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124493', '012', 'Fiat', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124494', '012', 'Jaguar', '�ݱ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124495', '012', 'Volvo', '�ֶ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124496', '012', 'Acura', 'ک��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124497', '012', 'Porsche', '��ʱ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124498', '012', 'Jeep', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124499', '012', 'Bentley', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124500', '012', 'Bugatti', '���ӵ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124501', '012', 'ChuanQi', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124502', '012', 'Daewoo', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124503', '012', 'DongNan', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124504', '012', 'Ferrari', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124505', '012', 'Fudi', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124506', '012', 'Huapu', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124507', '012', 'HawTai', '��̩', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124508', '012', 'JMC', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124509', '012', 'JingLong', '�����ͳ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124510', '012', 'JoyLong', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124511', '012', 'Karry', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124512', '012', 'Chrysler', '����˹��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124513', '012', 'Linian', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124514', '012', 'LiFan', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124515', '012', 'LieBao', '�Ա�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124516', '012', 'Lincoln', '�ֿ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124517', '012', 'Lotus', '·��˹', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124518', '012', 'Maserati', '��ɯ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124519', '012', 'Maybach', '���ͺ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124520', '012', 'Mclaren', '������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124521', '012', 'Youngman', '����ͳ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124522', '012', 'Tesla', '��˹��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124523', '012', 'Rely', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124524', '012', 'Lsuzu', '��ʮ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124525', '012', 'Yiqi', 'һ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124526', '012', 'Infiniti', 'Ӣ�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124527', '012', 'YuTong', '��ͨ�ͳ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124528', '012', 'AnKai', '�����ͳ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124529', '012', 'Canghe', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124530', '012', 'HaiMa', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124531', '012', 'Crown', '����ʹ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124532', '012', 'HuangHai', '�ƺ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124533', '012', 'JinLv', '���ÿͳ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124534', '012', 'JinNing', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124535', '012', 'KuBo', '�Ჩ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124536', '012', 'MINI', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124537', '012', 'Gleagle', 'ȫ��ӥ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124538', '012', 'ShiDai', 'ʱ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124539', '012', 'TianYe', '��Ұ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124540', '012', 'WeiZi', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124541', '012', 'Englon', 'Ӣ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124542', '012', 'Changan', '�����γ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124543', '012', 'Yuejin', 'Ծ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124544', '012', 'Taurus', '��ţ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124545', '012', 'Alto', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124546', '012', 'Weiwang', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124547', '012', 'Haige', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124548', '012', 'Shaolin', '���ֿͳ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124549', '012', 'Beifang', '�����ͳ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124550', '012', 'Beijing', '��������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124551', '012', 'Hafu', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124552', '012', '34,10', '����-��϶�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124553', '012', '34,11', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124554', '012', '34,12', '����-�翥', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124555', '012', '57,0', '��ͨ-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124556', '012', '57,1', '��ͨ-8ϵ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124557', '012', '57,2', '��ͨ-�ͳ�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124558', '012', '43,0', '��ά��-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124559', '012', '43,1', '��ά��-Daily', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124560', '012', '43,2', '��ά��-Power', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124561', '012', '43,3', '��ά��-Turbo', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124562', '012', '43,4', '��ά��-Venice', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124563', '012', '43,5', '��ά��-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124564', '012', '43,6', '��ά��-�������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124565', '012', '43,7', '��ά��-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124566', '012', '42,0', 'һ��-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124567', '012', '42,1', 'һ��-501-�Ῠ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124568', '012', '42,2', 'һ��-N3+����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124569', '012', '42,3', 'һ��-�ѱ�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124570', '012', '42,4', 'һ��-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124571', '012', '42,5', 'һ��-����J5P', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124572', '012', '42,6', 'һ��-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124573', '012', '42,7', 'һ��-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124574', '012', '42,8', 'һ��-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124575', '012', '42,9', 'һ��-��־V2', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124576', '012', '42,10', 'һ��-С���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124577', '012', '42,11', 'һ��-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124578', '012', '42,12', 'һ��-�´���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124579', '012', '42,13', 'һ��-�º���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124580', '012', '42,14', 'һ��-ɭ��M80', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124581', '012', '42,15', 'һ��-����L5M', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124582', '012', '42,16', 'һ��-���J4R', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124583', '012', '42,17', 'һ��-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124584', '012', '42,18', 'һ��-����J5K', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124585', '012', '42,19', 'һ��-����B50', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124586', '012', '42,20', 'һ��-����B70', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124587', '012', '42,21', 'һ��-����B90', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124588', '012', '30,0', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124589', '012', '30,1', '����-����֮��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124590', '012', '30,2', '����-���������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124591', '012', '30,3', '����-���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124592', '012', '30,4', '����-С����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124593', '012', '30,5', '����-���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124594', '012', '30,6', '����-�ٹ������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124595', '012', '30,7', '����-��;', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124596', '012', '93,0', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124597', '012', '93,1', '����-H3', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124598', '012', '93,2', '����-V5', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124599', '012', '93,3', '����-X5', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124600', '012', '18,0', '˹�´�-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124601', '012', '18,1', '˹�´�-���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124602', '012', '18,2', '˹�´�-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124603', '012', '18,3', '˹�´�-���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124604', '012', '18,4', '˹�´�-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124605', '012', '18,5', '˹�´�-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124606', '012', '18,6', '˹�´�-Ұ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124607', '012', '123,0', '˫��-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124608', '012', '123,1', '˫��-SCEO', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124609', '012', '17,0', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124610', '012', '17,1', '����-��������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124611', '012', '17,2', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124612', '012', '17,3', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124613', '012', '17,4', '����-������-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124614', '012', '17,5', '����-�����޾���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124615', '012', '17,6', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124616', '012', '17,7', '����-������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124617', '012', '17,8', '����-ŷ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124618', '012', '17,9', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124619', '012', '17,10', '����-��ɪ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124620', '012', '103,0', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124621', '012', '103,1', '����-D50', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124622', '012', '14,0', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124623', '012', '14,1', '����-A1', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124624', '012', '14,2', '����-A3����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124625', '012', '14,3', '����-A5', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124626', '012', '14,4', '����-QQ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124627', '012', '14,5', '����-����֮��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124628', '012', '14,6', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124629', '012', '14,7', '����-����E3', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124630', '012', '14,8', '����-����E5', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124631', '012', '14,9', '����-����1', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124632', '012', '14,10', '����-����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124633', '012', '14,11', '����-����2', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124634', '012', '14,12', '����-����3', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124635', '012', '14,13', '����-��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124636', '012', '14,14', '����-����2����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124637', '012', '14,15', '����-������7', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124638', '013', '1', '������豸', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124639', '013', '2', '��·�����豸', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124640', '013', '3', '�����豸', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124641', '013', '4', '��·����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124642', '013', '5', '�ƶ�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124643', '013', '6', '����ͨ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124644', '013', '7', '�������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124645', '013', '8', '���Ƕ�λװ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124646', '013', '9', '���������豸', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125669', '205', '1', '������Ϣ�뱾ϵͳ�����Ǽ���Ϣ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125670', '205', '2', '������Ϣ�복�ݹ���Ϣ���� ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125671', '205', '3', '��������¼�г�����Ϣ����ͬ ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125672', '205', '4', 'ֱ�߾�����㷽ʽ ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125673', '205', '5', '��λʵ�ʾ��� ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125770', '501', '0', '��״̬', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125791', '466', '0', 'δ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125792', '466', '1', '���账��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125793', '466', '2', 'δ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('125794', '466', '3', '�ѽ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124660', '016', '0', '���ٹ�·', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124661', '016', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124662', '016', '2', 'ʡ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124663', '016', '3', '�ص�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124664', '016', '4', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124665', '016', '5', '���п���·', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124666', '016', '6', '�������ɵ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124667', '016', '7', '���дθɵ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124668', '016', '8', '����֧·', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124669', '016', '9', '������·', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124670', '017', '1', '����', '1', null, '���Ҹ��߹�·', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124671', '017', '2', 'ʡ��', '1', null, 'ʡ����������ֱϽ�и��߹�·', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124672', '017', '3', '�ص�', '1', null, '�ع�·', '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124673', '017', '4', 'ר�ù�·', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124674', '200', '1', '24Сʱֵ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124675', '200', '2', '����ֵ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124676', '200', '3', 'ҹ��ֵ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124677', '201', '0', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124678', '201', '1', '��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124679', '202', '1', '�����豸�ϴ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124680', '202', '2', 'ϵͳ���ݷ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124681', '202', '3', '�������ϵͳ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124682', '202', '4', '�˹��ɼ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124683', '203', '1', '��ȫ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124684', '203', '2', 'δ��������·��ʻ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124685', '203', '3', 'δ��Ԥ��ʱ����ʻ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124686', '203', '4', '������ʻ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124691', '204', '01', '���ۿͳ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124692', '204', '02', 'ƣ�ͼ�ʻ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124693', '204', '03', 'Σ��Ʒ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124694', '204', '31', 'Σ��Ʒ��δ������ʻ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124695', '204', '32', 'Σ��Ʒ��δ��������·��ʻ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124696', '204', '33', 'Σ��Ʒ��δ��Ԥ��ʱ�䷶Χ�ھ���ָ����λ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124697', '204', '04', 'Υ������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124698', '204', '05', 'Υ������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124699', '204', '06', 'δϵ��ȫ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124700', '204', '07', '��ռ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124701', '204', '08', '�Ʊ공', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124702', '204', '09', 'ǰ����Ʋ�һ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124719', '206', '01', '�¹����ݳ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124720', '206', '02', '���Ƴ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124721', '206', '03', '���Ƴ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124722', '206', '04', '����δ��쳵��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124723', '206', '05', '����δ���ϳ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124724', '206', '06', 'Υ��δ������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124725', '206', '08', '�������ɳ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124726', '206', '09', 'δ��װ�ж�װ��Σ��Ʒ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124727', '206', '21', '���°���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124728', '206', '22', '�ش��ΰ�����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124729', '206', '23', 'Υ���������ɽ�ͨ����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124730', '206', '24', '��������������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124731', '206', '25', '�ΰ���̬�ܿ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124732', '206', '31', '���Ƴ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124733', '206', '32', '����ʡ�ݳ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124734', '206', '33', '�賿2-5�������·��ʻ���˳���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124735', '206', '41', '���ó��������ƣ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124736', '206', '42', '���ó��ڳ��������ƣ�', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124737', '206', '51', '��Ч��֤��������', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124738', '208', '1', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124739', '208', '2', '����', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124740', '209', '1', 'һ������ɫ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124741', '209', '2', '��������ɫ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124742', '209', '3', '��������ɫ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124743', '209', '4', '�ļ�����ɫ��', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124744', '209', '9', '��ʹ�ò��ؼ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124745', '210', '1', '��ǹ', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('124746', '210', '2', '�汬', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126263', '442', '11', '����ӹ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126264', '442', '12', '�״��ӹ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126265', '442', '13', '��Դ�ӹ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126266', '442', '14', '��Ȧ�ӹ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126267', '442', '15', '�����ӹ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126268', '442', '16', 'GPS�����ӹ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126269', '442', '17', '�ܼ������ӹ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126270', '442', '18', 'LED�ӹ���', '1', null, null, '1');
insert into T_SYS_CODE (code_id, code_type, code_no, code_name, editable, sort_index, remark, enable_flag)
values ('126271', '442', '99', '��������', '1', null, null, '1');
commit;
prompt 2350 records loaded


spool off

exit;
